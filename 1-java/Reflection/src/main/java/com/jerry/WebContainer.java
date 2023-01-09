package com.jerry;

// 1yr back



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author : Jerry
 */
public class WebContainer {

    public void handleHttpRequest(String method, String url) {
        try {

            // classpath-scanning  | .yml | .properties
            Class<?> clazz = Class.forName("com.tom.UserComponent");// .class
            Object instance = clazz.newInstance();

            if (clazz.getAnnotation(Controller.class) != null) {
                Method[] methods = clazz.getMethods();
                for (Method m : methods) {
                    RequestMapping rm = m.getAnnotation(RequestMapping.class);
                    if (rm != null) {
                        String mappedMethod = rm.method().toString();
                        String mappedUrl = rm.url();
                        if (method.equals(mappedMethod) && url.equals(mappedUrl)) {
                            m.invoke(instance, new Object[]{});
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

}
