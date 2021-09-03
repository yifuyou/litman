package com.yifuyou.litman.vm;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.yifuyou.litman.R;
import com.yifuyou.litman.databinding.VmLayoutBinding;
import com.yifuyou.litman.model.ActionClick;
import com.yifuyou.litman.model.Person;

public class BaseViewModel extends ViewModel {

    private MutableLiveData<Person> currentPerson;
    private VmLayoutBinding binding;

    public BaseViewModel init( Activity owner){
        binding = DataBindingUtil.setContentView(owner, R.layout.vm_layout) ;
        binding.setItem(new Person("lisx","xxxx.xxx") );
        binding.setAction(new Action());
        
        return this;
    }


    public MutableLiveData<Person> getNames(){
        if(currentPerson==null){
            currentPerson=new MutableLiveData<>();
        }

        return currentPerson;

    }

     class Action extends ActionClick{

        @Override
        public void click(View view) {
            EditText editText=binding.getRoot().findViewById(R.id.edit_text);
            Person value = currentPerson.getValue();
            if(value==null){
                value=new Person("n","n");
            }
            value.name.set(editText.getText().toString());
            binding.setItem(value);
            currentPerson.setValue(value);
        }
    }

}
