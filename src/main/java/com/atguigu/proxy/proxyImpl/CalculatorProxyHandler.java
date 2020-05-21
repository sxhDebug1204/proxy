package com.atguigu.proxy.proxyImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shkstart
 * @create 2020-03-30 13:34
 * 创建代理类的工具类
 */
public class CalculatorProxyHandler {

    /*
     *  public static Object newProxyInstance(ClassLoader loader,
     *                                           Class<?>[] interfaces,
     *                                           InvocationHandler h)  创建代理对象
     *
     *  public Object invoke(Object proxy, Method method, Object[] args)throws Throwable;   调用目标方法

     */

    private Object target;//目标对象

    //通过构造方法接收参数来传递到创建代理对象工具类
    public CalculatorProxyHandler(Object target){
        this.target = target;
    }



    /**
     * 创建代理类
     * @return
     */
    public  Object createProxy(){
        Object proxy = null ; //代理对象
        /**
         * loader:通过反射获取类加载器
         * interfaces:
         */
        ClassLoader loader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        proxy = Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {

            /**
             * 调用目标对象中的目标所有方法
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                LogCalculotor.beforeLog(method.getName(),args); //目标方法执行前执行日志工具类的方法

                Object result = method.invoke(target, args);//调用目标对象中的目标所有方法

                LogCalculotor.afterLog(method.getName(),result);//目标方法执行后执行日志工具类的方法
                return result;
            }
        });


        return  proxy;

    }



}
