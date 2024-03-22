package weijunli.com.ui.slideshow;
import android.util.Log;
import android.widget.Toast;
import android.content.Context;
import weijunli.com.solcontract.weijunli.com.solcontract.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import java.math.BigInteger;
import android.widget.CompoundButton;
import weijunli.com.R;
import weijunli.com.databinding.FragmentSlideshowBinding;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.w3c.dom.Text;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import weijunli.com.databinding.FragmentHomeBinding;
import weijunli.com.ui.home.HomeViewModel;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private SlideshowViewModel  viewModel;
    private TextView Final_result;
    private TextView message;
    private TextView remove_message;
    private TextView sourceinfo;
    private boolean login_state;
    private static final String username1 = "1234567890";
    private static final String  password1= "1234567890";
    private  TextView Amount;
    private double money1;
    private String[] whitelist;
    private String[] blacklist;
    private Web3j web3;
    private static final String PRIVATE_KEY = "2fef86803ccff8a535c98b5540239d48eade281bcbdff051b8f6d6dd16226a6c";
    private static final String CONTRACT_ADDRESS = "0xde4f7367f524c1bB6dc41BC740cc470e3900E121";
    private static final BigInteger GAS_PRICE = BigInteger.valueOf(20_000_000_000L);
    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(4_300_000);

//address；https://sepolia.infura.io/v3/93c82ee662ce4f11b02edb3a42087f4a
    //key;XbV6HwxCYy+RbH/A/866+5/Z10IF9rUo+crvaKx55YeHKbKcEP4TpQ  0x7247662eA1658a7bEBb29Ea701076A6cfaC8cA36
    //contract addresss；0xde4f7367f524c1bB6dc41BC740cc470e3900E121

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel viewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Amount = binding.Amount;
        Final_result= binding.finalResult;
        message = binding.message2;
        sourceinfo = binding.message3;
        remove_message= binding.removeMessage;
        login_state =false;
        money1 = 100.00;
        whitelist = new String[]{"user1", "user2"};
        blacklist = new String[]{"user3", "user4"};
        System.out.print("get into initial");
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 使用后台线程来处理网络请求
                Executors.newSingleThreadExecutor().submit(() -> {
                    try {
                        Log.d("Web3", "Starting Web3 interaction");
                        Web3j web3 = Web3j.build(new HttpService("https://sepolia.infura.io/v3/93c82ee662ce4f11b02edb3a42087f4a"));

                        // 加载智能合约
                        Credentials credentials = Credentials.create(PRIVATE_KEY);
                        ContractGasProvider gasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
                        SpamDectetor_sol_AIContract contract = SpamDectetor_sol_AIContract.load(CONTRACT_ADDRESS, web3, credentials, gasProvider);

                        // 发送交易和获取结果
                        Log.d("Web3", "sending hello to contract ");
                        TransactionReceipt transactionReceipt = contract.setInputData("hello").send();
                        Log.d("Web3", "sended hello to contract ");
                        Log.d("Web3", "getting hello to contract ");
                        String Input = contract.getInputData().send();
                        Log.d("Web3", "get hello to contract ");
                        // 回到主线程更新UI
                        getActivity().runOnUiThread(() -> {
                            Log.d("Web3", "Attempting to update UI");
                            if (getActivity() == null) {
                                Log.e("Web3", "getActivity() returned null");
                            } else if (remove_message == null) {
                                Log.e("Web3", "remove_message is null");
                            } else {
                                Log.d("Web3", "Updating remove_message TextView");
                                remove_message.setText(String.format("Transaction complete: %s\nOutput value: %s", transactionReceipt.getTransactionHash(), Input));
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.d("Web3", "get error for  textlive ");
                        getActivity().runOnUiThread(() -> showDialog(new String[]{"error"}, "Transaction Error"));
                    }
                });

            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(whitelist, "whitelist");
            }
        });

        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(blacklist,"Blacklist");
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginDialog();
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!login_state) {
                    showErrorMessage("please login ");

                }
                else if (message.getText().length() > 0 && login_state) {
                    StringBuilder extractedInfo = new StringBuilder("Extracted Info:");
                    String cleanMessage = message.getText().toString();

                    // URL匹配并移除
                    Pattern urlPattern = Pattern.compile(
                            "(https?://[\\w\\.-]+(\\.[\\w\\.-]+)+([\\w\\-\\._\\/?=&]+)?)", Pattern.CASE_INSENSITIVE);
                    Matcher urlMatcher = urlPattern.matcher(cleanMessage);

                    while (urlMatcher.find()) {
                        extractedInfo.append("\nURL: ").append(urlMatcher.group());
                        // 使用replace方法移除找到的URL
                        cleanMessage = cleanMessage.replace(urlMatcher.group(), "");
                    }

                    // 日期匹配并移除
                    Pattern datePattern = Pattern.compile("\\b\\d{4}-\\d{2}-\\d{2}\\b");
                    Matcher dateMatcher = datePattern.matcher(cleanMessage);

                    while (dateMatcher.find()) {
                        extractedInfo.append("\nDate: ").append(dateMatcher.group());
                        // 移除找到的日期
                        cleanMessage = cleanMessage.replace(dateMatcher.group(), "");
                    }

                    // 姓名匹配并替换
                    Pattern namePattern = Pattern.compile("\\b[A-Z][a-z]+\\s[A-Z][a-z]+\\b");
                    Matcher nameMatcher = namePattern.matcher(cleanMessage);

                    while (nameMatcher.find()) {
                        extractedInfo.append("\nName: ").append(nameMatcher.group());
                        // 假定替换所有找到的姓名为"David"
                        cleanMessage = cleanMessage.replace(nameMatcher.group(), "David");
                    }

                    // 电话号码匹配并移除
                    Pattern phonePattern = Pattern.compile(
                            "(\\+\\d{1,3}\\s?)?(\\d{3}[-.\\s]??\\d{3}[-.\\s]??\\d{4}|\\d{8}|\\d{2,3}[-.\\s]??\\d{2,3}[-.\\s]??\\d{2,4})",
                            Pattern.CASE_INSENSITIVE);
                    Matcher phoneMatcher = phonePattern.matcher(cleanMessage);

                    while (phoneMatcher.find()) {
                        extractedInfo.append("\nPhone: ").append(phoneMatcher.group());
                        // 移除找到的电话号码
                        cleanMessage = cleanMessage.replace(phoneMatcher.group(), "");
                    }

                    // 设置处理后的文本
                    Final_result.setText("Final Message:\n" + cleanMessage);
                    // 显示提取的信息
                    remove_message.setText(extractedInfo.toString());
                    money1 -= 1;
                    Amount.setText("Amount:"+money1);

                } else {
                    showErrorMessage("please enter message or login ");
                }
            }
        });


        return root;
    }

    private void showDialog(String[] list, String name) {
        // 假设这是你的白名单条目数组
        // 使用StringBuilder来构建显示内容
        StringBuilder whitelistStringBuilder = new StringBuilder();
        for (String item : list) {
            whitelistStringBuilder.append(item).append("\n");
        }

        // 创建并显示AlertDialog
        new AlertDialog.Builder(getContext())
                .setTitle(name)
                .setMessage(whitelistStringBuilder.toString())
                .setPositiveButton("确定", null)
                .create()
                .show();
    }



    private void showErrorMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Error");
        builder.setMessage(message);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showLoginDialog() {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_login, null);

        final EditText usernameEditText = view.findViewById(R.id.dialog_username);
        final EditText passwordEditText = view.findViewById(R.id.dialog_password);

        // 确保usernameEditText和passwordEditText不为null
        if (usernameEditText != null && passwordEditText != null) {
            AlertDialog dialog = new AlertDialog.Builder(getActivity())
                    .setTitle("Login")
                    .setView(view)
                    .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            String inputUsername = usernameEditText.getText().toString();
                            String inputPassword = passwordEditText.getText().toString();
                            // 使用equals方法比较字符串
                            if (username1.equals(inputUsername) && password1.equals(inputPassword)) {
                                login_state = true;
                                Toast.makeText(getActivity(), "login successful", Toast.LENGTH_SHORT).show();
                                Amount.setText("Amount:"+money1);
                            } else {
                                login_state = false;
                                showErrorMessage("User password or the username error");
                            }
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .create();

            dialog.show();
        } else {
            // 如果usernameEditText或passwordEditText为null，则显示错误消息
            showErrorMessage("发生错误，请稍后再试。");
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}