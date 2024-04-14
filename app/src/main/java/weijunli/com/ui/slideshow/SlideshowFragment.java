package weijunli.com.ui.slideshow;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONObject;
import org.pytorch.Module;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.MultipartBody;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import weijunli.com.R;
import weijunli.com.databinding.FragmentSlideshowBinding;
import weijunli.com.solcontract.weijunli.BlackList_sol_EmailBlacklistVoting;
import weijunli.com.solcontract.weijunli.com.solcontract.SpamDectetor_sol_AIContract;
import weijunli.com.solcontract.weijunli.com.solcontract.Sol_blacklist_sol_EmailBlacklistVoting;


public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private SlideshowViewModel viewModel;
    private TextView Final_result;
    private TextView message;
    private TextView remove_message;
    private TextView sourceinfo;
    private boolean login_state;

    private static final String username1 = "1234567890";
    private static final String password1 = "1234567890";
    private TextView Amount;
    private double money1;
    private String[] whitelist;
    private String[] blacklist;
    private Web3j web3;
    private static final String PRIVATE_KEY = "2fef86803ccff8a535c98b5540239d48eade281bcbdff051b8f6d6dd16226a6c";
    private static final String PRIVATE_KEY_BL = "393bd1213bc36f917e9619f4cd4d7b3c39e97e4c0bdb9cfc21115007b8587b78";
    private static final String BLACKLIST_ADDRESS = "0xbb37E606A22714E523c6f60aC15150d2AA7c93f5";
    private static final String CONTRACT_ADDRESS = "0xde4f7367f524c1bB6dc41BC740cc470e3900E121";
    private static final BigInteger GAS_PRICE = BigInteger.valueOf(20_000_000_000L);
    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(4_300_000);
    private File filesDir;

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
        Final_result = binding.finalResult;
        message = binding.message2;
        sourceinfo = binding.message3;
        remove_message = binding.removeMessage;
        login_state = false;
        money1 = 100.00;
        whitelist = new String[]{};
        blacklist = new String[]{};
        initializeBlacklist();
        setupButtonListeners();
        System.out.print("get into initial");
        binding.sendmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog("user");
            }
        });
        binding.button6.setOnClickListener(view -> {
            // 使用后台线程来处理网络请求
            Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    Log.d("Web3", "Starting Web3 interaction");
                    Web3j web3 = Web3j.build(new HttpService("https://sepolia.infura.io/v3/93c82ee662ce4f11b02edb3a42087f4a"));
                    Credentials credentials = Credentials.create(PRIVATE_KEY);
                    // 获取nonce
                    EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(
                            credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                    BigInteger nonce = ethGetTransactionCount.getTransactionCount();
                    Log.d("Web3", "Current nonce: " + nonce);

                    ContractGasProvider gasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
                    SpamDectetor_sol_AIContract contract = SpamDectetor_sol_AIContract.load(CONTRACT_ADDRESS, web3, credentials, gasProvider);

                    // 发送数据到智能合约
                    Log.d("Web3", "sending hello to contract");
                    TransactionReceipt transactionReceipt = contract.setInputData("hello").send();
                    Log.d("Web3", "sented hello to contract");
                    String transactionHash = transactionReceipt.getTransactionHash();
                    // 回到主线程更新UI
                    getActivity().runOnUiThread(() -> {
                        updateUI(transactionHash, "input data 1 hello");
                    });
                    EthGetTransactionCount ethGetTransactionCount1 = web3.ethGetTransactionCount(
                            credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                    BigInteger nonce1 = ethGetTransactionCount.getTransactionCount();
                    Log.d("Web3", "Current nonce: " + nonce1);


                    // 获取智能合约中的数据
                    Log.d("Web3", "retrieving data from contract");
                    String input_data = contract.getgetInputData().encodeFunctionCall();
                    Log.d("Web3", "retrieved data from contract: " + input_data);
                    EthGetTransactionCount ethGetTransactionCount2 = web3.ethGetTransactionCount(
                            credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                    BigInteger nonce2 = ethGetTransactionCount.getTransactionCount();
                    Log.d("Web3", "Current nonce: " + nonce2);
                    // 回到主线程更新UI
                    getActivity().runOnUiThread(() -> {
                        updateUI(transactionHash, "input data 2: " + input_data);
                    });
                } catch (Exception e) {
                    Log.e("Web3", "Error during Web3 interaction", e);
                    getActivity().runOnUiThread(() -> showErrorDialog());
                }
            });
        });


        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 示例：获取用户输入的电子邮件地址
                String email = "ipfsexample@example.com"; // getEmailInput();这应该是一个函数，从用户输入获取电子邮件地址
                String filePath = "app/src/main/java/weijunli/com/ui/slideshow/blacklist.txt";
                boolean status = true; // 假设我们总是将其设置为黑名单状态
                final String[] ipfsHash = new String[1];
                // 在后台线程中处理网络请求，避免阻塞UI线程
                new Thread(() -> {
                    // 调用上传到IPFS的方法，上传电子邮件数据

                    try {
                        ipfsHash[0] = uploadToIPFS(filePath);
                    } catch (IOException | JSONException e) {
                        throw new RuntimeException(e);
                    }

                    if (ipfsHash != null) {
                        // 在主线程中运行与用户界面相关的代码
                        getActivity().runOnUiThread(() -> {
                            try {
                                Log.d("Web3", "Starting Web3 interaction");
                                Web3j web3 = Web3j.build(new HttpService("https://sepolia.infura.io/v3/93c82ee662ce4f11b02edb3a42087f4a"));
                                Credentials credentials = Credentials.create(PRIVATE_KEY_BL);
                                // 获取nonce
                                EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(
                                        credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                                BigInteger nonce = ethGetTransactionCount.getTransactionCount();
                                Log.d("Web3", "Current nonce: " + nonce);

                                ContractGasProvider gasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
                                Sol_blacklist_sol_EmailBlacklistVoting contract = Sol_blacklist_sol_EmailBlacklistVoting.load(BLACKLIST_ADDRESS, web3, credentials, gasProvider);

                                // 假设contract是一个全局变量，指向您的智能合约
                                TransactionReceipt transactionReceipt = contract.setBlacklistStatus(email, status, ipfsHash[0]).send();


                                if (transactionReceipt.isStatusOK()) {
                                    showToast("Email has been blacklisted.");
                                } else {
                                    showToast("Failed to blacklist email.");
                                }
                            } catch (Exception e) {
                                showToast("Error: " + e.getMessage());
                            }
                        });
                    } else {
                        getActivity().runOnUiThread(() -> showToast("Failed to upload to IPFS."));
                    }
                }).start();
            }

            // 用于获取电子邮件输入的示例方法
            private String getEmailInput() {
                // 从您的输入字段或界面控件获取电子邮件地址
                return message.getText().toString();
            }

            private String uploadToIPFS(String filePath) throws IOException, JSONException {
                OkHttpClient client = new OkHttpClient();
                MediaType MEDIA_TYPE_OCTET = MediaType.parse("application/octet-stream");

                File file = new File(filePath);
                RequestBody requestBody = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("file", file.getName(),
                                RequestBody.create(file, MEDIA_TYPE_OCTET))
                        .build();

                Request request = new Request.Builder()
                        .url("https://api.pinata.cloud/pinning/pinFileToIPFS") // 确保这是正确的URL
                        .header("Authorization",
                                "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySW5mb3JtYXRpb24iOnsiaWQiOiJlZTE2ZGFkOC03MmUzLTQ0MTUtYjA5ZC1lYzYxNWZhZTVkN2UiLCJlbWFpbCI6ImppbmdodWF6aHUxQDE2My5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicGluX3BvbGljeSI6eyJyZWdpb25zIjpbeyJpZCI6IkZSQTEiLCJkZXNpcmVkUmVwbGljYXRpb25Db3VudCI6MX0seyJpZCI6Ik5ZQzEiLCJkZXNpcmVkUmVwbGljYXRpb25Db3VudCI6MX1dLCJ2ZXJzaW9uIjoxfSwibWZhX2VuYWJsZWQiOmZhbHNlLCJzdGF0dXMiOiJBQ1RJVkUifSwiYXV0aGVudGljYXRpb25UeXBlIjoic2NvcGVkS2V5Iiwic2NvcGVkS2V5S2V5IjoiNjhkNWRkNDBlNDg3NjdhMjhmMDUiLCJzY29wZWRLZXlTZWNyZXQiOiJhZGQ5ZmQ3YjZlOTVmZWU2YjEyNzY1MDg0YzY0YjhmMTVkN2I4M2UzNGEwYjNkMTgyNDE0YWU5ODYxY2M1M2I2IiwiaWF0IjoxNzEyOTQ2OTUxfQ.aE9NL09k1qX_cXaEwZJyPL__kjb5RhNZgUeO2CouRTs")
                        .post(requestBody)
                        .build();
                Response response = client.newCall(request).execute();;
                try {
                    response = client.newCall(request).execute();
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    String jsonData = response.body().string();
                    JSONObject jsonObject = new JSONObject(jsonData);
                    return jsonObject.getString("IpfsHash");
                } finally {
                    if (response != null) {
                        response.close();
                    }
                }
            }

            /*
            // 上传到IPFS的示例方法
            private String uploadToIPFS(String emailData) {
                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .build();

                MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain; charset=utf-8");
                RequestBody body = RequestBody.create(emailData, MEDIA_TYPE_TEXT);

                // 注意：这里的URL是IPFS的HTTP API。根据您所使用的IPFS服务提供商，这个URL可能不同。
                Request request = new Request.Builder()
                        .url("https://ipfs.infura.io:5001/api/v0/add")
                        .post(body)
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful() && response.body() != null) {
                        // 解析返回的JSON以获取IPFS哈希
                        String json = response.body().string();
                        JSONObject jsonObject = new JSONObject(json);
                        return jsonObject.getString("Hash");
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }
*/
            // 显示Toast消息的帮助方法
            private void showToast(String message) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });



        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(blacklist, "Blacklist");
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
                if (!login_state) {
                    showErrorMessage("please login ");

                } else if (message.getText().length() > 0 && login_state) {
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
                    Amount.setText("Amount:" + money1);

                } else {
                    showErrorMessage("please enter message or login ");
                }
            }
        });


        return root;
    }
    private String uploadToIPFS(String data) {
        OkHttpClient client = new OkHttpClient();
        MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain; charset=utf-8");

        RequestBody body = RequestBody.create(data, MEDIA_TYPE_TEXT);
        Request request = new Request.Builder()
                .url("https://ipfs.infura.io:5001/api/v0/add")
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                String json = response.body().string();
                JSONObject jsonObject = new JSONObject(json);
                return jsonObject.getString("Hash");
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void showDialog(String[] list, String name) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(name);

        // 创建滚动视图和文本视图来显示列表
        ScrollView scrollView = new ScrollView(getContext());
        TextView textView = new TextView(getContext());
        textView.setPadding(32, 32, 32, 32); // 设置适当的内边距

        StringBuilder listStringBuilder = new StringBuilder();
        for (String item : list) {
            listStringBuilder.append(item).append("\n");
        }
        textView.setText(listStringBuilder.toString());
        scrollView.addView(textView);

        // 设置滚动视图为对话框内容
        builder.setView(scrollView);
        builder.setPositiveButton("确定", null);
        builder.create().show();
    }

    private void updateUI(String transactionHash, String inputData) {
        getActivity().runOnUiThread(() -> {
            if (remove_message != null) {
                String message = String.format("Transaction complete: %s\nInput value: %s", transactionHash, inputData);
                remove_message.setText(message);
                Log.d("Web3", "UI updated with new data");
            } else {
                Log.e("Web3", "remove_message is null, cannot update UI");
            }
        });
    }

    private void showErrorDialog() {
        getActivity().runOnUiThread(() -> {
            // Assuming showDialog is a method that shows an error dialog
            showDialog(new String[]{"error"}, "Transaction Error");
            Log.d("Web3", "Error dialog shown");
        });
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
                                Amount.setText("Amount:" + money1);
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

    private void showInputDialog(String name) {
        // 创建一个EditText用于输入金额
        final EditText inputAmount = new EditText(getContext());
        inputAmount.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL); // 设置输入类型为数字，支持小数

        // 创建AlertDialog并设置标题、正文（EditText）和按钮
        new AlertDialog.Builder(getContext())
                .setTitle(name)
                .setMessage("please input the value you send ：")
                .setView(inputAmount) // 将EditText设置为对话框内容
                .setPositiveButton("send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String amount = inputAmount.getText().toString();
                        // 处理用户输入的金额，例如发送金额
                        sendAmount(amount);
                    }
                })
                .setNegativeButton("cancel", null) // 点击取消按钮，对话框消失，不做任何处理
                .create()
                .show();
    }

    private void sendAmount(String amount) {
        // 这里是处理发送金额的逻辑
        // 例如，可以打印出来或发送到服务器
        Log.d("Amount", "Sending amount: " + amount);
    }

    public void sendTransactionHash(String transactionHash) {
        Executors.newSingleThreadExecutor().submit(() -> {
            OkHttpClient client = new OkHttpClient();
            MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

            // 构建JSON body
            String jsonBody = "{\"transaction_hash\":\"" + transactionHash + "\"}";
            RequestBody body = RequestBody.create(jsonBody, MEDIA_TYPE_JSON);

            // 构建请求
            Request request = new Request.Builder()
                    .url("http://你的服务器地址/api/endpoint") // 替换为你的API端点
                    .post(body)
                    .build();

            // 发送请求并处理异步响应
            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful() && response.body() != null) {
                    String responseData = response.body().string();
                    boolean serverResponse = Boolean.parseBoolean(responseData.trim());

                    // 使用主线程更新UI
                    getActivity().runOnUiThread(() -> {
                        if (serverResponse) {
                            // 如果服务器返回true
                            Toast.makeText(getContext(), "Server returned true", Toast.LENGTH_LONG).show();
                        } else {
                            // 如果服务器返回false
                            Toast.makeText(getContext(), "Server returned false", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    private void setupButtonListeners() {
        binding.button5.setOnClickListener(view -> showDialog(blacklist, "Blacklist"));
    }

    private void initializeBlacklist() {
        blacklist = new String[50];  // 假设我们有1000个邮箱地址
        for (int i = 0; i < 50; i++) {
            blacklist[i] = "user" + (i + 1) + "@example.com";
        }
    }

}