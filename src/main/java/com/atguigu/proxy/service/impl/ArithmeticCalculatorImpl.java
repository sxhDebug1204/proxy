package com.atguigu.proxy.service.impl;

        import com.atguigu.proxy.service.ArithmeticCalculator;
        import org.springframework.stereotype.Service;

/**
 * @author shkstart
 * @create 2020-03-30 13:24
 */
@Service
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    @Override
    public double add(double i, double j) {

        double  result  = i + j;
        return  result;
    }

    @Override
    public double sub(double i, double j) {

        double  result  = i - j;
        return result;
    }

    @Override
    public double mul(double i, double j) {

        double  result  = i * j;
        return result;
    }

    @Override
    public double div(double i, double j) {

        double  result  = i/j;
        return result;
    }
}
