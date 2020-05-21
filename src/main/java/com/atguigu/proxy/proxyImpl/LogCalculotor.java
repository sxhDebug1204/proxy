package com.atguigu.proxy.proxyImpl;

import java.util.Arrays;

/**
 * @author shkstart
 *  * @create 2020-03-30 13:29
 *  * 日志记录的工具类
 */
public class LogCalculotor {

    public static void beforeLog(Object methodName,Object[] args){
        System.out.println("执行:"+methodName +"方法,参数:"+ Arrays.toString(args));
    }

    public static void afterLog(Object methodName,Object result){
        System.out.println("执行:" + methodName+"方法,结果："+ result);
    }
}
