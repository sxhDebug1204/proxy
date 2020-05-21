package com.atguigu.proxy;

import com.atguigu.proxy.proxyImpl.CalculatorProxyHandler;
import com.atguigu.proxy.service.ArithmeticCalculator;
import com.atguigu.proxy.service.impl.ArithmeticCalculatorImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.applet.Main;

@SpringBootTest
class ProxyApplicationTests {

    @Test
    void contextLoads() {
        ArithmeticCalculatorImpl arithmeticCalculator = new ArithmeticCalculatorImpl();//arithmeticCalculator : 目标对象
        CalculatorProxyHandler cdi = new CalculatorProxyHandler(arithmeticCalculator); //将目标对象传给代理对象

        Object proxy = cdi.createProxy(); //proxy 代理对象
        System.out.println(proxy.getClass().getName()); //com.sun.proxy.$Proxy92

        ArithmeticCalculator  ac = (ArithmeticCalculator)proxy;
        ac.add(10,5);
    }



}
