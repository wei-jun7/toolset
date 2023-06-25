package weijunli.com.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<String> totalUSDAmount;
    private final MutableLiveData<String> totalCNYAmount;
    private final MutableLiveData<String> totalEURAmount;
    private final MutableLiveData<String> totalJPYAmount;
    private final MutableLiveData<String> totalHDKAmount;
    private final MutableLiveData<String> totalARSAmount;
    private final MutableLiveData<String> totalTRYAmount;

    public HomeViewModel() {
        totalUSDAmount = new MutableLiveData<>();
        totalCNYAmount = new MutableLiveData<>();
        totalEURAmount = new MutableLiveData<>();
        totalARSAmount = new MutableLiveData<>();
        totalHDKAmount = new MutableLiveData<>();
        totalTRYAmount = new MutableLiveData<>();
        totalJPYAmount = new MutableLiveData<>();
    }

    public LiveData<String> getCNYText() {
        return totalCNYAmount;
    }

    public LiveData<String> getEURText() {
        return totalCNYAmount;
    }

    public LiveData<String> getARSText() {
        return totalCNYAmount;
    }
    public LiveData<String> getHDKText() {
        return totalCNYAmount;
    }
    public LiveData<String> getJPYText() {
        return totalCNYAmount;
    }
    public LiveData<String> getUSDText() {return  totalUSDAmount;}
}