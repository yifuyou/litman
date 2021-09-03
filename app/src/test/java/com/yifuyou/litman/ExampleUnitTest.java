package com.yifuyou.litman;

import org.junit.Test;

import static org.junit.Assert.*;

import com.yifuyou.litman.annotation.Antest;
import com.yifuyou.litman.annotation.TempAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void test(){
        chackAnno().print();
    }


    Antest chackAnno(){

        try {

            Class<?> aClass =Antest.class;
            Antest o =Antest.newInstance();
            System.out.println("======chackAnno -start======");
            for(Field field : aClass.getFields()) {
            System.out.println(field.getName());

            if(!field.isAnnotationPresent(TempAnnotation.class)){
                System.out.println(" "+field.getName()+" no TempAnnotation");
                break;
            }
            TempAnnotation todoAnnotation = (TempAnnotation)field.getAnnotation(TempAnnotation.class);
            if(todoAnnotation != null) {
                System.out.println(" Field Name : " + field.getName());
                System.out.println(" Value : " + todoAnnotation.value());
                String name = field.getName();
                String concatS = String.valueOf(name.charAt(0)).toUpperCase().concat(name.substring(1));

                Method method = aClass.getMethod("set".concat(concatS),String.class);
                method.invoke(o,todoAnnotation.value());
            }
        }
            return (Antest) o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("======chackAnno -end======");

        return null;
    }



}