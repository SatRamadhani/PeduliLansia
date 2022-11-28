package edu.upi.cs.mobileapp.techi.pedulilansia;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GeneralElderViewModel extends ViewModel
{
    public MutableLiveData<String> name;
    public MutableLiveData<String> age;
    public MutableLiveData<String> birthdate;

    public GeneralElderViewModel()
    {
        name = new MutableLiveData<>(); age = new MutableLiveData<>();
        birthdate = new MutableLiveData<>();
    }

    public void setName(String name)
    {
        this.name.setValue(name);
    }

    public void setAge(String age)
    {
        this.age.setValue(age);
    }

    public void setBirthdate(String birthdate)
    {
        this.birthdate.setValue(birthdate);
    }
}
