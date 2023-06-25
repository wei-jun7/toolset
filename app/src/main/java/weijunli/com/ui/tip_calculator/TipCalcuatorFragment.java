package weijunli.com.ui.tip_calculator;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.text.NumberFormat;

import weijunli.com.R;
import weijunli.com.databinding.TipCalcuatorBinding;

public class TipCalcuatorFragment extends Fragment {

    private TipCalcuatorBinding binding;
    private TipCalculatorViewModel viewModel;
    private EditText costOfServiceEditText;
    private TextView tipAmountTextView;

    private RadioGroup tipOptionsRadioGroup;
    private Switch roundUpSwitch;
    private Button calculateButton;
    private TextView tipResultTextView;


    //private boolean  roundup;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = TipCalcuatorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        costOfServiceEditText = binding.costOfService;  // 根据布局文件中的ID找到EditText

        tipOptionsRadioGroup = binding.tipOptions;
        roundUpSwitch = binding.roundUpSwitch;
        calculateButton = binding.calculateButton;
        tipResultTextView = binding.tipResult;
        tipAmountTextView = binding.tipAmount;

        viewModel = new ViewModelProvider(this).get(TipCalculatorViewModel.class);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calculateTip();
                } catch (Exception e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("错误");
                    builder.setMessage("请输入正确的数字");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tipAmountTextView = view.findViewById(R.id.tip_amount); // 初始化tipAmountTextView
        tipResultTextView= view.findViewById(R.id.tip_result);

        viewModel.getTipAmountLiveData().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double tipAmount) {
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
                String formattedTipAmount = currencyFormat.format(tipAmount);

                tipAmountTextView.setText("小费金额"+formattedTipAmount);

            }
        });

        viewModel.getTotalAmountLiveData().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double tipResult) {
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
                String formattedTipAmount = currencyFormat.format(tipResult);

                tipResultTextView.setText("总共应付金额"+formattedTipAmount);
            }
        });

    }

    private void calculateTip() {
        double cost = Double.parseDouble(costOfServiceEditText.getText().toString());
        double  tipPercentage =  0.0;  // 设置默认的tip百分比
        int checkedRadioButtonId = tipOptionsRadioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.option_twenty_percent) {
            tipPercentage = 0.20;
        } else if (checkedRadioButtonId == R.id.option_eighteen_percent) {
            tipPercentage = 0.18;
        } else if (checkedRadioButtonId == R.id.option_ten_percent) {
            tipPercentage = 0.10;
        } else {
            tipPercentage = 0.15;
        }
        boolean roundUp = roundUpSwitch.isChecked() ;  // 设置默认的roundUp状态
        viewModel.calculateTip(cost, tipPercentage, roundUp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
