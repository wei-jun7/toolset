package weijunli.com.ui.slideshow;
import android.widget.Toast;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
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
    private boolean login_state;
    private static final String username1 = "1234567890";
    private static final String  password1= "1234567890";
    private  TextView Amount;
    private double money;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel viewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Amount = binding.Amount;
        TextView Final_result= binding.finalResult;
        TextView message = binding.message;
        TextView remove_message= binding.removeMessage;
        login_state =false;
        money = 100.00;



        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginDialog();
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (message.getText().length() > 0 && login_state) {
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

                } else {
                    showErrorMessage("请输入message");
                }
            }
        });


        return root;
    }



    private void showErrorMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("错误");
        builder.setMessage(message);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
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
                                Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
                                Amount.setText("Amount:"+money);
                            } else {
                                login_state = false;
                                showErrorMessage("用户名或密码错误");
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