package com.yifuyou.litman.annotation;

public class Antest{
    private static Antest instance;
    private Antest(){}



    public static Antest newInstance() {
        instance=new Antest();
        return instance;
    }

    @TempAnnotation("pppp")
    public String string;

    public String temp;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }



    public void print(){
        System.out.println("============");
        System.out.println(string);
        System.out.println("============");
    }

}
