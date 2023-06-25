package weijunli.com.ui.home;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import weijunli.com.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;
    private String website1;
    private String website2;

    private ArrayList<Double> exchangeRateList;
    private ArrayList<String> countryCurrency;

    private EditText totalUSDAmount;
    private TextView totalCNYAmount;
    private TextView totalEURAmount;
    private TextView totalJPYAmount;
    private TextView totalHDKAmount;
    private TextView totalARSAmount;
    private TextView totalTRYAmount;
    private TextView total_USD_Amount;
    private TextView title;
    private Switch currencySwitch;

    private boolean useCNY = false; // 默认使用美元（USD）

    public interface ExchangeRateCallback {
        void onExchangeRateUpdated(ArrayList<Double> exchangeRates);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        website1 = "https://v6.exchangerate-api.com/v6/5c2e47a1bb0fc82852cc1203/latest/USD";
        website2 = "https://v6.exchangerate-api.com/v6/5c2e47a1bb0fc82852cc1203/latest/CNY";
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        totalCNYAmount = binding.totalCNYAmount;
        totalUSDAmount = binding.totalUSDAmount;
        totalEURAmount = binding.totalEURAmount;
        totalHDKAmount = binding.totalHKDAmount;
        totalJPYAmount = binding.totalJPYAmount;
        totalARSAmount = binding.totalARSAmount;
        totalTRYAmount = binding.totalTRYAmount;
        currencySwitch = binding.currencySwitch;
        total_USD_Amount= binding.totalUSDAmountOutput;
        title= binding.title;

        countryCurrency = new ArrayList<>();
        countryCurrency.add("USD");
        countryCurrency.add("CNY");
        countryCurrency.add("EUR");
        countryCurrency.add("JPY");
        countryCurrency.add("HKD");
        countryCurrency.add("ARS");
        countryCurrency.add("TRY");

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (exchangeRateList != null) {
                    String usdAmountStr = totalUSDAmount.getText().toString();
                    if (!usdAmountStr.isEmpty()) {
                        try {
                            double usdAmount = Double.parseDouble(usdAmountStr);
                            if(useCNY){
                                settoCNY(exchangeRateList);
                            }
                            else{setUpExchangeRate(website1);}
                            for (int i = 0; i < exchangeRateList.size(); i++) {
                                double totalAmount = usdAmount * getExchangeRate(i);
                                updateAmountDisplay(i, totalAmount);
                            }
                        } catch (NumberFormatException e) {
                            showErrorMessage("请输入正确的数字");
                        }
                    } else {
                        showErrorMessage("请输入正确的数字");
                    }
                }
            }
        });

        currencySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    settoCNY(exchangeRateList);
                } else {
                    useCNY = false;
                    title.setText("汇率转换(美金换人民币)");
                    setUpExchangeRate(website1);
                }
            }
        });

        return root;
    }

    private void settoCNY(ArrayList<Double> exchangeRateList) {

        useCNY = true; // 设置使用人民币（CNY）
        title.setText("汇率转换(人民币换美金)");
        totalUSDAmount.setHint("请输入金额（人民币）");
        setUpExchangeRate(website2);
    }


    private void updateAmountDisplay(int index, double totalAmount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String formattedTotalAmount = currencyFormat.format(totalAmount);

        switch (countryCurrency.get(index)) {
            case"USD":
                total_USD_Amount.setText("美金"+formattedTotalAmount);
                break;
            case "CNY":
                totalCNYAmount.setText("人民币" + formattedTotalAmount);
                break;
            case "EUR":
                totalEURAmount.setText("欧元" + formattedTotalAmount);
                break;
            case "JPY":
                totalJPYAmount.setText("日元" + formattedTotalAmount);
                break;
            case "HKD":
                totalHDKAmount.setText("港币" + formattedTotalAmount);
                break;
            case "ARS":
                totalARSAmount.setText("阿根廷比索" + formattedTotalAmount);
                break;
            case "TRY":
                totalTRYAmount.setText("土耳其里拉" + formattedTotalAmount);
                break;
        }
    }

    public void setUpExchangeRate(String website) {
        new AsyncTask<Void, Void, ArrayList<Double>>() {
            @SuppressLint("StaticFieldLeak")
            @Override
            protected ArrayList<Double> doInBackground(Void... voids) {
                ArrayList<Double> exchangeRates = new ArrayList<>();
                JsonObject jsonObject = getExchangeRate(website);
                if (jsonObject != null) {
                    JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                    for (String currency : countryCurrency) {
                        if (conversionRates.has(currency)) {
                            double exchangeRate = conversionRates.get(currency).getAsDouble();
                            exchangeRates.add(exchangeRate);
                        }
                    }
                }

                return exchangeRates;
            }

            @Override
            protected void onPostExecute(ArrayList<Double> exchangeRates) {
                if (exchangeRateList == null) {
                    exchangeRateList = new ArrayList<>();
                } else {
                    exchangeRateList.clear();
                }
                exchangeRateList.addAll(exchangeRates);
                onExchangeRateUpdated(exchangeRates);
            }
        }.execute();
    }


    public void onExchangeRateUpdated(ArrayList<Double> exchangeRates) {
        if (exchangeRates != null && !exchangeRates.isEmpty()) {
            String usdAmountStr = totalUSDAmount.getText().toString();
            if (!usdAmountStr.isEmpty()) {
                try {
                    double usdAmount = Double.parseDouble(usdAmountStr);
                    for (int i = 0; i < exchangeRates.size(); i++) {
                        double totalAmount = usdAmount * getExchangeRate(i);
                        updateAmountDisplay(i, totalAmount);
                    }
                } catch (NumberFormatException e) {
                    showErrorMessage("请输入正确的数字");
                }
            }
        } else {
            showErrorMessage("无法获取汇率，请检查网络连接并重试");
        }
    }

    public JsonObject getExchangeRate(String website) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(website).build();
            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                String jsonStr = response.body().string();
                Gson gson = new Gson();
                return gson.fromJson(jsonStr, JsonObject.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private double getExchangeRate(int index) {

        return exchangeRateList.get(index);

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpExchangeRate(website1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
