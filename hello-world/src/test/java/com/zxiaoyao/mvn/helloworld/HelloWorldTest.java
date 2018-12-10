package com.zxiaoyao.mvn.helloworld;

import org.junit.Assert;
import org.junit.Test;

/**
 * <br>
 * Version: V1.0 <br>
 * Author: hlantian <br>
 * Date: 2018/12/7 17:23
 */
public class HelloWorldTest {

    @Test
    public void testSayHello() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        System.out.println(result);
        Assert.assertEquals("Hello Maven", result);
    }
}
