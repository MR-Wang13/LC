package javaguide.proxy;

public class SmsServiceWithoutInter {
    public String send2(String msg) {
        System.out.println("send msg:"+msg );
        return msg;
    }
}
