package javaguide.proxy;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

       /* SmsService jdkProxy = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        jdkProxy.send("msg1");*/

        SmsServiceWithoutInter smsServiceWithoutInter =(SmsServiceWithoutInter) CglibProxyFactory.getProxy( SmsServiceWithoutInter.class);
        smsServiceWithoutInter.send2("cglib");

    }
}
