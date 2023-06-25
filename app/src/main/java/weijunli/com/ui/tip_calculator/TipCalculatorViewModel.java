package weijunli.com.ui.tip_calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TipCalculatorViewModel extends ViewModel {
    private MutableLiveData<Double> tipAmountLiveData = new MutableLiveData<>();

    private MutableLiveData<Double> total_Price_Live_Data= new MutableLiveData<>();

    public void calculateTip(double cost, double tipPercentage, boolean roundUp) {
        double tip = tipPercentage * cost;
        if (roundUp) {
            tip = Math.ceil(tip);
        }
        tipAmountLiveData.setValue(tip);
        Double totalAmount = cost + tip;
        totalAmount = Math.floor(totalAmount);
        total_Price_Live_Data.setValue(totalAmount);

    }

    public LiveData<Double> getTipAmountLiveData() {
        return tipAmountLiveData;
    }

    public LiveData<Double> getTotalAmountLiveData(){return  total_Price_Live_Data;}
}
