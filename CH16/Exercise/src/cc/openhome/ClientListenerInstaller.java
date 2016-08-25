package cc.openhome;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ClientListenerInstaller {
    private ClientQueue queue;
    private Map<String, Method> methods = new HashMap<String, Method>();    
    
    public ClientListenerInstaller(ClientQueue queue) throws Exception {
        this.queue = queue;
    }
    
    public void install(Class<?> clz) throws Exception {
        // 找出標註的方法
        for(Method method : clz.getMethods()) {
            ClientAdded clientAdded = 
            	method.getAnnotation(ClientAdded.class);
            if(clientAdded != null) {
                methods.put("clientAdded", method);
            }
            ClientRemoved clientRemoved = 
            	method.getAnnotation(ClientRemoved.class);
            if(clientRemoved != null) {
                methods.put("clientRemoved", method);
            }
        }
        
        final Object listener = clz.newInstance();
        // 建立代理物件
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                // 代理物件的方法被呼叫時
                // 呼叫實際的傾聽器方法
                Method mth = methods.get(method.getName());
                return mth.invoke(listener, args);
            }
        };
        
        Object listenerProxy = Proxy.newProxyInstance(
        		ClientListener.class.getClassLoader(),
                new Class[] { ClientListener.class },
                handler);
        
        // 用代理物件作註冊
        Method addclientListener = 
            queue.getClass().getMethod(
            		"addClientListener", ClientListener.class);
        addclientListener.invoke(queue, listenerProxy);
    }
}