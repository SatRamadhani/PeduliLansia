package edu.upi.cs.mobileapp.techi.pedulilansia;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GeneralUserViewModel extends ViewModel
{
    public MutableLiveData<String> status;

    public GeneralUserViewModel()
    {
        status = new MutableLiveData<>();
        status.setValue("safe");
    }

    public void setStatus(String status)
    {
        this.status.setValue(status);
    }
}
