package javaguide.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxyHandler implements InvocationHandler {
    private Object target;
    public JdkProxyHandler(Object object){
        this.target = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk proxy before send");
        Object result = method.invoke(target,args);
        System.out.println("jdk proxy after send");
        return result;
    }
}
