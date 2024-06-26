package weijunli.com.ui.slideshow;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import weijunli.com.R;
import weijunli.com.databinding.FragmentSlideshowBinding;
import weijunli.com.solcontract.weijunli.com.solcontract.Blacklist_sol_EmailBlacklistVoting;
import weijunli.com.solcontract.weijunli.com.solcontract.SpamDectetor_sol_AIContract;
import weijunli.com.solcontract.weijunli.com.solcontract.TransferToken2_sol_transferToken;


public class SlideshowFragment extends Fragment {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
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
    private static final  String PRIVATE_KEY_LIN="b86b4e07800868d04de104582677760fcbffe8461e6481968c3b60ef802620a1";
    private static final String PRIVATE_KEY_WJL = "2fef86803ccff8a535c98b5540239d48eade281bcbdff051b8f6d6dd16226a6c";
    private static final String PRIVATE_KEY_BL = "393bd1213bc36f917e9619f4cd4d7b3c39e97e4c0bdb9cfc21115007b8587b78";
    private static final String PRIVATE_KEY_TS = "a4cbaa3c72aa4a01701abd3ee9b6debd5f80447328fe460849c011694ace194c";
    private static final String BLACKLIST_ADDRESS = "0x4cAd379DC50dA5Ea71b99DfEa925A8564852ef2E";
    private static final String CONTRACT_ADDRESS = "0x105b1D2dBb00E2b9C9CDfAD8510c09F3Ca091570";
    private static final String CONTRACT_ADDRESS2 = "0x0ef3865c16896dab110fee47f44ee0d692898d00";
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

            binding.button6.setEnabled(false);

            // 使用后台线程来处理网络请求
            Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    performWeb3Interaction();
                } catch (Exception e) {
                    Log.e("Web3", "Error during Web3 interaction", e);
                    getActivity().runOnUiThread(this::showErrorDialog);
                }

                // 延时30秒后执行HTTP POST请求
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                executeHttpPost();

                // 延时再次执行HTTP GET请求，这里可以调整为更合理的时间，如立即执行或者根据业务需要延迟
                try {
                    Thread.sleep(20000); // 可以根据需要调整这个延时
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }

                executeHttpGet();
                getActivity().runOnUiThread(() -> binding.button6.setEnabled(true));
            });
        });




        // Test the adding process. It will be combined with the view result button and add black list automatically.
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 示例：获取用户输入的电子邮件地址
                String email = sourceinfo.getText().toString(); // getEmailInput();这应该是一个函数，从用户输入获取电子邮件地址

                final String[] ipfsHash = new String[1];
                // 在后台线程中处理网络请求，避免阻塞UI线程
                new Thread(() -> {
                    try {
                        ipfsHash[0] = uploadToIPFS(email);
                        if (ipfsHash[0] != null) {
                            saveCid(ipfsHash[0]);
                            getActivity().runOnUiThread(() -> {
                                Toast.makeText(getActivity(), "IPFS Hash: " + ipfsHash[0], Toast.LENGTH_LONG).show();
                            });
                        } else {
                            getActivity().runOnUiThread(() -> {
                                Toast.makeText(getActivity(), "Failed to upload to IPFS.", Toast.LENGTH_LONG).show();
                            });
                        }
                    } catch (IOException | JSONException e) {
                        Log.e("UploadError", "Error uploading file", e);
                        getActivity().runOnUiThread(() -> {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Error")
                                    .setMessage("Error uploading file: " + e.toString())
                                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                                    .show();
                        });
                    }
                }).start();
            }



            private void updateContractWithNewCid(String newCid) {
                Executors.newSingleThreadExecutor().submit(() -> {
                    try {

                        Web3j web3j = Web3j.build(new HttpService("https://sepolia.infura.io/v3/9fa6abac55ae44fda12e3eae5e769bb9"));
                        Credentials credentials = Credentials.create(PRIVATE_KEY_BL);
                        if (web3j != null) {
                            EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(
                                    credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                            BigInteger nonce = ethGetTransactionCount.getTransactionCount();

                            ContractGasProvider gasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
                            Blacklist_sol_EmailBlacklistVoting contract = Blacklist_sol_EmailBlacklistVoting.load(BLACKLIST_ADDRESS, web3, credentials, gasProvider);

                            // 更新合约中的 CID
                            TransactionReceipt transactionReceipt = contract.updateBlacklistCid(newCid).send();
                            getActivity().runOnUiThread(() -> {
                                Toast.makeText(getActivity(), "Contract CID updated: " + transactionReceipt.getTransactionHash(), Toast.LENGTH_LONG).show();
                            });
                        } else {
                            // web3j 实例为 null，处理错误
                            getActivity().runOnUiThread(() -> {
                                Toast.makeText(getActivity(), "Web3j instance is null.", Toast.LENGTH_LONG).show();
                            });
                        }


                    } catch (Exception e) {
                        getActivity().runOnUiThread(() -> {
                            // 创建 AlertDialog.Builder 实例
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("Error");
                            builder.setMessage("Error updating contract: " + e.getMessage());

                            builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

                            builder.create().show();
                        });
                    }
                });
            }

            // Helper method to convert InputStream to String
            private String convertStreamToString(InputStream is) throws IOException {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
                reader.close();
                return sb.toString();
            }

            // 显示Toast消息的帮助方法
            private void showToast(String message) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });




        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 获取存储在本地的 CID
                String cid = getCid();

                // 检查 CID 是否存在
                if (cid.equals("defaultCid")) {
                    showToast("No CID found. Please upload the blacklist first.");
                    return;
                }

                // 获取 IPFS 上的黑名单 JSON
                String ipfsUrl = "https://ipfs.io/ipfs/" + cid;

                // 在后台线程中执行网络请求
                Executors.newSingleThreadExecutor().submit(() -> {
                    try {
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder().url(ipfsUrl).build();
                        Response response = client.newCall(request).execute();

                        if (response.isSuccessful() && response.body() != null) {
                            String blacklistContent = response.body().string();
                            saveFileContent(blacklistContent);
                            // 解析黑名单内容
                            JSONArray jsonArray = new JSONArray(blacklistContent);

                            StringBuilder builder = new StringBuilder();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                builder.append("Email: ").append(jsonObject.getString("email"))
                                        .append("\nReason: ").append(jsonObject.getString("reason"))
                                        .append("\nAdded by: ").append(jsonObject.getString("addedBy"))
                                        .append("\nDate added: ").append(jsonObject.getString("dateAdded"))
                                        .append("\nActive: ").append(jsonObject.getBoolean("active") ? "Yes" : "No")
                                        .append("\nVotes to remove: ").append(jsonObject.getJSONObject("votes").getInt("toRemove"))
                                        .append("\nVotes to keep: ").append(jsonObject.getJSONObject("votes").getInt("toKeep"))
                                        .append("\n\n");
                            }

                            final String displayText = builder.toString();

                            // 更新 UI 显示黑名单
                            getActivity().runOnUiThread(() -> showDialog(displayText, "Blacklist"));

                        } else {
                            getActivity().runOnUiThread(() -> showToast("Failed to fetch the blacklist."));
                        }
                    } catch (IOException | JSONException e) {
                        getActivity().runOnUiThread(() -> showToast("Error: " + e.getMessage()));
                    }
                });
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
                    String emailAddress = sourceinfo.getText().toString();
                    sendMessageToContract(emailAddress);

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

        binding.reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!login_state) {
                    showErrorMessage("please login ");

                } else {
                    String emailAddress = sourceinfo.getText().toString();
                    String accountAddress = message.getText().toString();
                    addVoterToContract(accountAddress, emailAddress);
                    //sendMessageToContract(HARD_CODED_EMAIL);
                }
            }
        });

        binding.sendmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!login_state) {
                    showErrorMessage("please login ");

                } else {
                    String emailAddress = sourceinfo.getText().toString();
                    shareEtherWithVoters(emailAddress);
                }
            }
        });
        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailToVote = sourceinfo.getText().toString();
                // Assume getEmailInput() is a method that gets the user's input email
                String emailAddress = sourceinfo.getText().toString();
                sendMessageToContract(emailAddress);


                // Execute network request in a new thread
                new Thread(() -> {
                    try {
                        String newIpfsHash = voteToWhite(emailToVote);
                        // Optionally, save the new CID to SharedPreferences
                    } catch (Exception e) {
                        getActivity().runOnUiThread(() -> {
                            // Display the error in a dialog
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("Error")
                                    .setMessage("Error processing vote: " + e.getMessage())
                                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                                    .show();
                        });
                    }
                }).start();
            }
        });
        return root;
    }
    private void sendMessageToContract(String email) {
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                Web3j web3 = Web3j.build(new HttpService("https://sepolia.infura.io/v3/692e5b6388004a65b334d8fae8ff5b51"));
                Credentials credentials = Credentials.create(PRIVATE_KEY_WJL);
                EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(
                        credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                BigInteger nonce = ethGetTransactionCount.getTransactionCount();

                ContractGasProvider gasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
                TransferToken2_sol_transferToken contract = TransferToken2_sol_transferToken.load(CONTRACT_ADDRESS2, web3, credentials, gasProvider);

                // Define the amount of Ether to send, adjust according to your function's requirements
                BigInteger amountToSend = BigInteger.valueOf(1_000_000_000_000_000L); // For example, 0.001 Ether

                // Calling the sendMessage function on the smart contract, passing Ether value
                TransactionReceipt transactionReceipt = contract.sendMessage(email, amountToSend).send();

                getActivity().runOnUiThread(() -> {
                    //Toast.makeText(getActivity(), "Message sent with transaction: " + transactionReceipt.getTransactionHash(), Toast.LENGTH_LONG).show();
                    Final_result.setText("Message sent with transaction: " + transactionReceipt.getTransactionHash());
                });
            } catch (Exception e) {
                Log.e("Web3Error", "Error interacting with smart contract", e);
                getActivity().runOnUiThread(() -> {
                    //Toast.makeText(getActivity(), "Failed to send message: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    Final_result.setText("Failed to send message: " + e.getMessage());

                });
            }
        });
    }

    private void addVoterToContract(String voterAddress, String email) {
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                Web3j web3 = Web3j.build(new HttpService("https://sepolia.infura.io/v3/692e5b6388004a65b334d8fae8ff5b51"));
                Credentials credentials = Credentials.create(PRIVATE_KEY_WJL);
                EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(
                        credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                BigInteger nonce = ethGetTransactionCount.getTransactionCount();

                ContractGasProvider gasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
                TransferToken2_sol_transferToken contract = TransferToken2_sol_transferToken.load(CONTRACT_ADDRESS2, web3, credentials, gasProvider);

                // Calling the addVoter function on the smart contract
                TransactionReceipt transactionReceipt = contract.addVoter(voterAddress, email).send();

                getActivity().runOnUiThread(() -> {
                    //Toast.makeText(getActivity(), "Voter added successfully: " + transactionReceipt.getTransactionHash(), Toast.LENGTH_LONG).show();
                    Final_result.setText("Add Voter: " + transactionReceipt.getTransactionHash());

                });
            } catch (Exception e) {
                Log.e("Web3Error", "Error interacting with smart contract", e);
                getActivity().runOnUiThread(() -> {
                    //Toast.makeText(getActivity(), "Failed to add voter: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    Final_result.setText("Failed to send message: " + e.getMessage());

                });
            }
        });
    }

    private void shareEtherWithVoters(String email) {
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                Web3j web3 = Web3j.build(new HttpService("https://sepolia.infura.io/v3/692e5b6388004a65b334d8fae8ff5b51"));
                Credentials credentials = Credentials.create(PRIVATE_KEY_WJL);
                EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(
                        credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                BigInteger nonce = ethGetTransactionCount.getTransactionCount();

                ContractGasProvider gasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
                TransferToken2_sol_transferToken contract = TransferToken2_sol_transferToken.load(CONTRACT_ADDRESS2, web3, credentials, gasProvider);

                // Calling the shareEther function on the smart contract
                TransactionReceipt transactionReceipt = contract.shareEther(email).send();

                getActivity().runOnUiThread(() -> {
                    //Toast.makeText(getActivity(), "Ether shared successfully: " + transactionReceipt.getTransactionHash(), Toast.LENGTH_LONG).show();
                    Final_result.setText("Share Ether: " + transactionReceipt.getTransactionHash());

                });
            } catch (Exception e) {
                Log.e("Web3Error", "Error interacting with smart contract", e);
                getActivity().runOnUiThread(() -> {
                    //Toast.makeText(getActivity(), "Failed to share Ether: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    Final_result.setText("Failed to send message: " + e.getMessage());

                });
            }
        });
    }
    public void saveCid(String cid) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("AppPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("BlacklistCid", cid);
        editor.apply(); // 或者 editor.commit(); 以同步方式保存
    }

    public String getCid() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("AppPreferences", Context.MODE_PRIVATE);
        return sharedPreferences.getString("BlacklistCid", "defaultCid");
    }

    public void saveFileContent(String fileContent) {
        // 获取SharedPreferences对象
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // 将文件内容保存为字符串
        editor.putString("FileContent", fileContent);
        // 提交更改
        editor.apply();
    }

    public String loadFileContent() {
        // 获取SharedPreferences对象
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE);
        // 从SharedPreferences获取文件内容
        return sharedPreferences.getString("FileContent", "DefaultContent");
    }
    String get(OkHttpClient client,String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    String post(OkHttpClient client,String url, String json) throws Exception {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private String fetchBlacklistFromIPFS() throws IOException {
        // 替换成实际的IPFS CID获取URL
        String ipfsGatewayUrl = "https://gateway.ipfs.io/ipfs/YOUR_IPFS_CID_HERE";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ipfsGatewayUrl)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            // 返回黑名单的内容
            return response.body().string();
        }
    }

    private String[] parseBlacklist(String content) {
        // 根据黑名单的具体格式来解析内容，这里只是一个例子
        List<String> itemsList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                itemsList.add(jsonObject.getString("email")); // 或者更详细的信息
            }
        } catch (JSONException e) {
            Log.e("ParseBlacklist", "Error parsing blacklist JSON", e);
        }
        // 将List转换为String数组以便显示
        String[] itemsArray = new String[itemsList.size()];
        itemsArray = itemsList.toArray(itemsArray);
        return itemsArray;
    }

    // 显示Toast消息的帮助方法
    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
    private String uploadToIPFS(String emailToAdd) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();
        MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

        // Read the existing blacklist JSON
       /*  AssetManager assetManager = getActivity().getAssets();
        InputStream inputStream = assetManager.open("blacklist.json");
        String jsonContent = convertStreamToString(inputStream);
        inputStream.close();     */
        String cid = getCid();
        if (cid.equals("defaultCid")) {
            cid = "QmSYtZ1L9fKogrAyMD9oGrx6edxuoZTEUkahcsEd3iB9Kj";
        }
        String ipfsUrl = "https://ipfs.io/ipfs/" + cid;
        Request fetchRequest = new Request.Builder().url(ipfsUrl).build();
        Response fetchResponse = client.newCall(fetchRequest).execute();

        if (!fetchResponse.isSuccessful()) {
            throw new IOException("Failed to fetch existing blacklist from IPFS.");
        }
        String jsonContent = fetchResponse.body().string();
        JSONArray blacklist = new JSONArray(jsonContent);
        // Check if the email already exists and update the votes or add a new entry
        boolean emailExists = false;
        for (int i = 0; i < blacklist.length(); i++) {
            JSONObject entry = blacklist.getJSONObject(i);
            if (entry.getString("email").equals(emailToAdd)) {
                JSONObject votes = entry.getJSONObject("votes");
                votes.put("toKeep", votes.getInt("toKeep") + 1);  // Increment the "toKeep" vote count
                emailExists = true;
                break;
            }
        }

        if (!emailExists) {
            // Create a new entry if the email does not exist
            JSONObject newEntry = new JSONObject();
            newEntry.put("email", emailToAdd);
            newEntry.put("reason", "Test entry");
            newEntry.put("addedBy", "admin");
            newEntry.put("dateAdded", new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));
            newEntry.put("active", true);
            newEntry.put("votes", new JSONObject().put("toRemove", 0).put("toKeep", 0));
            blacklist.put(newEntry);
        }
        // Append the new entry to the blacklist

        // Convert the updated blacklist back to a byte array
        byte[] fileBytes = blacklist.toString().getBytes();

        // Upload the updated blacklist to IPFS
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", "blacklist.json",
                        RequestBody.create(MEDIA_TYPE_JSON, fileBytes))
                .build();

        Request request = new Request.Builder()
                .url("https://api.pinata.cloud/pinning/pinFileToIPFS")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySW5mb3JtYXRpb24iOnsiaWQiOiJlZTE2ZGFkOC03MmUzLTQ0MTUtYjA5ZC1lYzYxNWZhZTVkN2UiLCJlbWFpbCI6ImppbmdodWF6aHUxQDE2My5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicGluX3BvbGljeSI6eyJyZWdpb25zIjpbeyJpZCI6IkZSQTEiLCJkZXNpcmVkUmVwbGljYXRpb25Db3VudCI6MX0seyJpZCI6Ik5ZQzEiLCJkZXNpcmVkUmVwbGljYXRpb25Db3VudCI6MX1dLCJ2ZXJzaW9uIjoxfSwibWZhX2VuYWJsZWQiOmZhbHNlLCJzdGF0dXMiOiJBQ1RJVkUifSwiYXV0aGVudGljYXRpb25UeXBlIjoic2NvcGVkS2V5Iiwic2NvcGVkS2V5S2V5IjoiZTNlZjIxMjEyNmQyOWY3YWZkNjUiLCJzY29wZWRLZXlTZWNyZXQiOiI1NzBhYTU1OTliMmM2ODQ2MmQ1ODQ5MzQxMTZjZWJmODdmMDE3NWZhN2E1M2NmNTUzZDc3NDUyZjA0MjQ0OGNhIiwiaWF0IjoxNzEzMDY4Njc2fQ.X98QI1EoA0uiMvj8cZxl4SbteqyXwlDTvrSA7O64qCo") // Use your actual JWT
                .post(requestBody)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response + " with body " + response.body().string());
            }

            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            String newCid = jsonObject.getString("IpfsHash");
            saveCid(newCid);
            return newCid;

        } finally {
            if (response.body() != null) {
                response.body().close();
            }
        }






    }

    private void showDialog(String displayText, String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);

        final TextView textView = new TextView(getContext());
        textView.setText(displayText);
        textView.setPadding(20, 20, 20, 20);
        textView.setMovementMethod(new ScrollingMovementMethod());

        builder.setView(textView);
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
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
            showDialog(Arrays.toString(new String[]{"error"}), "Transaction Error");
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
        binding.button5.setOnClickListener(view -> showDialog(Arrays.toString(blacklist), "Blacklist"));
    }

    private void initializeBlacklist() {
        blacklist = new String[50];  // 假设我们有1000个邮箱地址
        for (int i = 0; i < 50; i++) {
            blacklist[i] = "user" + (i + 1) + "@example.com";
        }
    }
    private void performWeb3Interaction() {
        try{
            Log.d("Web3", "Starting Web3 interaction");
            Web3j web3 = Web3j.build(new HttpService("https://sepolia.infura.io/v3/93c82ee662ce4f11b02edb3a42087f4a"));
            Credentials credentials = Credentials.create(PRIVATE_KEY_WJL);
            // 获取nonce
            EthGetTransactionCount ethGetTransactionCount = web3.ethGetTransactionCount(
                    credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
            BigInteger nonce = ethGetTransactionCount.getTransactionCount();
            Log.d("Web3", "Current nonce: " + nonce);

            ContractGasProvider gasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);
            SpamDectetor_sol_AIContract contract = SpamDectetor_sol_AIContract.load(CONTRACT_ADDRESS, web3, credentials, gasProvider);

            // 发送数据到智能合约
            Log.d("Web3", "sending hello to contract");
            String user_input= message.getText().toString();
            TransactionReceipt transactionReceipt = contract.setInputData(user_input).send();
            Log.d("Web3", "sented hello to contract");
            String transactionHash = transactionReceipt.getTransactionHash();
            // 回到主线程更新UI
            getActivity().runOnUiThread(() -> {
                updateUI(transactionHash, "inputdata 1 is"+user_input);
            });
            Log.d("Web3", "retrieving data from contract");
            String output_data = contract.getInputData().encodeFunctionCall();
            Log.d("Web3", "retrieved data from contract: " + output_data);
            EthGetTransactionCount ethGetTransactionCount2 = web3.ethGetTransactionCount(
                    credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
            BigInteger nonce2 = ethGetTransactionCount.getTransactionCount();
            Log.d("Web3", "Current nonce: " + nonce2);
            // 回到主线程更新UI
            getActivity().runOnUiThread(() -> {
                updateUI(transactionHash, "output data 2: " + output_data);
            });
        }
        catch (Exception e) {
            Log.e("Web3", "Error during Web3 interaction", e);
            getActivity().runOnUiThread(() -> showErrorDialog());
        }

    }

    private void executeHttpPost() {
        OkHttpClient client = new OkHttpClient();
        String urlPost = "http://129.161.87.114:5000/api/start_transaction";
        String json = null;
        try {
//            String inputFromUser = message.getText().toString();
            json = String.format("{\"message\":\"%s\"}", "hello server");
            // 在这里可以使用 json 字符串，比如打印输出或者发送到服务器
            System.out.println(json);
        } catch (NullPointerException e) {
            // 处理 message 或 getText() 返回 null 的情况
            System.out.println("TextView 'message' 是 null 或未包含任何文本");
        }
        
        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(urlPost)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                getActivity().runOnUiThread(() -> updateUI("Response body: ", responseBody));
            } else {
                String responseBody = response.body().string();
                getActivity().runOnUiThread(() -> updateUI("Failed to connect: ", responseBody));
            }
        } catch (Exception e) {
            Log.e("https", "Error during HTTP interaction", e);
            getActivity().runOnUiThread(this::showErrorDialog);
        }
    }

    private void executeHttpGet() {
        OkHttpClient client = new OkHttpClient();
        String urlGet = "http://129.161.87.114:5000/api/output";
        Request request = new Request.Builder()
                .url(urlGet)
                .build();
        try (Response response = client.newCall(request).execute()) {

            if (response.isSuccessful()) {
                String responseBody= response.body().string();
                getActivity().runOnUiThread(() -> updateUI("GET Response body: ", responseBody));
                if(responseBody.equals("spam")){
                    String email = sourceinfo.getText().toString(); // getEmailInput();这应该是一个函数，从用户输入获取电子邮件地址
                    final String[] ipfsHash = new String[1];
                    // 在后台线程中处理网络请求，避免阻塞UI线程
                    new Thread(() -> {
                        try {
                            ipfsHash[0] = uploadToIPFS(email);
                            if (ipfsHash[0] != null) {
                                saveCid(ipfsHash[0]);
                                getActivity().runOnUiThread(() -> {
                                    Toast.makeText(getActivity(), "IPFS Hash: " + ipfsHash[0], Toast.LENGTH_LONG).show();
                                });
                            } else {
                                getActivity().runOnUiThread(() -> {
                                    Toast.makeText(getActivity(), "Failed to upload to IPFS.", Toast.LENGTH_LONG).show();
                                });
                            }
                        } catch (IOException | JSONException e) {
                            Log.e("UploadError", "Error uploading file", e);
                            getActivity().runOnUiThread(() -> {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Error")
                                        .setMessage("Error uploading file: " + e.toString())
                                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                                        .show();
                            });
                        }
                    }).start();
                }

            } else {
                String responseBody = response.body().string();
                getActivity().runOnUiThread(() -> updateUI("GET Failed to connect: ", responseBody));
            }

        } catch (Exception e) {
            Log.e("https", "Error during GET HTTP interaction", e);
            getActivity().runOnUiThread(this::showErrorDialog);
        }
    }
    private String voteToWhite(String emailToAdd) throws IOException, JSONException{
        OkHttpClient client = new OkHttpClient();
        MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

        // Read the existing blacklist JSON
                /*AssetManager assetManager = getActivity().getAssets();
                InputStream inputStream = assetManager.open("blacklist.json");
                String jsonContent = convertStreamToString(inputStream);
                inputStream.close();*/
        String cid = getCid();
        if (cid.equals("defaultCid")) {
            cid = "QmSYtZ1L9fKogrAyMD9oGrx6edxuoZTEUkahcsEd3iB9Kj";
        }
        String ipfsUrl = "https://ipfs.io/ipfs/" + cid;
        Request fetchRequest = new Request.Builder().url(ipfsUrl).build();
        Response fetchResponse = client.newCall(fetchRequest).execute();

        if (!fetchResponse.isSuccessful()) {
            throw new IOException("Failed to fetch existing blacklist from IPFS.");
        }
        String jsonContent = fetchResponse.body().string();
        JSONArray blacklist = new JSONArray(jsonContent);
        boolean emailExists = false;
        for (int i = 0; i < blacklist.length(); i++) {
            JSONObject entry = blacklist.getJSONObject(i);
            if (entry.getString("email").equals(emailToAdd)) {
                JSONObject votes = entry.getJSONObject("votes");
                int currentToRemove = votes.getInt("toRemove")+1;
                int currentToKeep = votes.getInt("toKeep");
                votes.put("toRemove", votes.getInt("toRemove") + 1);  // Increment the "toKeep" vote count
                emailExists = true;

                if (currentToRemove >= 3 && currentToRemove > currentToKeep) {
                    // If conditions are met, remove the entry from the blacklist
                    blacklist.remove(i);
                    notifyUser(emailToAdd, true);  // A method to show dialog notification
                } else {
                    // Otherwise, just update the count and notify the user
                    notifyUser(emailToAdd, false, currentToRemove, currentToKeep);  // A method to show dialog notification
                }
                emailExists = true;
                break;
            }

        }

        if (!emailExists) {
            // Create a new entry if the email does not exist
            JSONObject newEntry = new JSONObject();
            newEntry.put("email", emailToAdd);
            newEntry.put("reason", "Test entry");
            newEntry.put("addedBy", "admin");
            newEntry.put("dateAdded", new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));
            newEntry.put("active", true);
            newEntry.put("votes", new JSONObject().put("toRemove", 1).put("toKeep", 0));
            blacklist.put(newEntry);
        }
        // Append the new entry to the blacklist

        // Convert the updated blacklist back to a byte array
        byte[] fileBytes = blacklist.toString().getBytes();

        // Upload the updated blacklist to IPFS
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", "blacklist.json",
                        RequestBody.create(MEDIA_TYPE_JSON, fileBytes))
                .build();

        Request request = new Request.Builder()
                .url("https://api.pinata.cloud/pinning/pinFileToIPFS")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySW5mb3JtYXRpb24iOnsiaWQiOiJlZTE2ZGFkOC03MmUzLTQ0MTUtYjA5ZC1lYzYxNWZhZTVkN2UiLCJlbWFpbCI6ImppbmdodWF6aHUxQDE2My5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicGluX3BvbGljeSI6eyJyZWdpb25zIjpbeyJpZCI6IkZSQTEiLCJkZXNpcmVkUmVwbGljYXRpb25Db3VudCI6MX0seyJpZCI6Ik5ZQzEiLCJkZXNpcmVkUmVwbGljYXRpb25Db3VudCI6MX1dLCJ2ZXJzaW9uIjoxfSwibWZhX2VuYWJsZWQiOmZhbHNlLCJzdGF0dXMiOiJBQ1RJVkUifSwiYXV0aGVudGljYXRpb25UeXBlIjoic2NvcGVkS2V5Iiwic2NvcGVkS2V5S2V5IjoiZTNlZjIxMjEyNmQyOWY3YWZkNjUiLCJzY29wZWRLZXlTZWNyZXQiOiI1NzBhYTU1OTliMmM2ODQ2MmQ1ODQ5MzQxMTZjZWJmODdmMDE3NWZhN2E1M2NmNTUzZDc3NDUyZjA0MjQ0OGNhIiwiaWF0IjoxNzEzMDY4Njc2fQ.X98QI1EoA0uiMvj8cZxl4SbteqyXwlDTvrSA7O64qCo") // Use your actual JWT
                .post(requestBody)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response + " with body " + response.body().string());
            }

            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            String newCid = jsonObject.getString("IpfsHash");
            saveCid(newCid);
            return newCid;

        } finally {
            if (response.body() != null) {
                response.body().close();
            }
        }
    }
    private void notifyUser(String email, boolean isRemoved) {
        String message = isRemoved ?
                "Email " + email + " has been successfully removed from the blacklist." :
                "Not enough votes to remove email " + email + ".";

        getActivity().runOnUiThread(() -> {
            new AlertDialog.Builder(getActivity())
                    .setTitle("Blacklist Update")
                    .setMessage(message)
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }
    private void notifyUser(String email, boolean isRemoved, int toRemoveVotes, int toKeepVotes) {
        String message = isRemoved ?
                "Email " + email + " has been successfully removed from the blacklist." :
                "Current votes for " + email + ":\nTo Remove: " + toRemoveVotes + "\nTo Keep: " + toKeepVotes;

        getActivity().runOnUiThread(() -> {
            new AlertDialog.Builder(getActivity())
                    .setTitle("Blacklist Update")
                    .setMessage(message)
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }
}