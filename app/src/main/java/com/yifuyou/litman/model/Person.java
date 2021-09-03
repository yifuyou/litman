package com.yifuyou.litman.model;



import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

public  class Person {
    public ObservableField<String> name;
    public ObservableField<String> address;

    public Person(String name,String address){
        this.name=new ObservableField<>();
        this.address=new ObservableField<>();

        this.name.set(name);
        this.address.set(address);
    }

    @NonNull
    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", address=" + address +
                '}';
    }
}
