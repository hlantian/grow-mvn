package com.zxiaoyao.mvn.helloworld;

import java.math.BigInteger;

/**
 * <br>
 * Version: V1.0 <br>
 * Author: hlantian <br>
 * Date: 2018/12/7 17:05
 */
public class HelloWorld {
    public String sayHello(){
        return "Hello Maven";
    }

    public static void main(String[] args) {
        System.out.println(new HelloWorld().sayHello());
    }
}
