package javaguide.proxy;

public class SmsServiceImpl implements SmsService{

    @Override
    public String send(String msg) {
        System.out.println("send msg:"+msg );
        return msg;
    }

    public String send2(String msg) {
        System.out.println("send msg:"+msg );
        return msg;
    }
}
