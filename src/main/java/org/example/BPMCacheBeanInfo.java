package org.example;

import teamworks.TWBeanInfo;

public final class BPMCacheBeanInfo extends TWBeanInfo {
    private static Class beanClass = BPMCache.class;
    private static MethodInfo[] bpmCacheBeanInfoBeanMethods = new MethodInfo[5];

    public BPMCacheBeanInfo() {
        super(bpmCacheBeanInfoBeanMethods);
    }

    public Class getBeanClass() {
        return beanClass;
    }

    protected void handleException(Throwable exception) {
    }

    static {
        bpmCacheBeanInfoBeanMethods[0] = new MethodInfo(beanClass, "put", "put(String, String, TWObject, int, int, int)");
        bpmCacheBeanInfoBeanMethods[0].addArgument(String.class, "JNDI Name");
        bpmCacheBeanInfoBeanMethods[0].addArgument(String.class, "Cache Key");
        bpmCacheBeanInfoBeanMethods[0].addArgument(Object.class, "Cache Value");
        bpmCacheBeanInfoBeanMethods[0].addArgument(Integer.class, "Priority");
        bpmCacheBeanInfoBeanMethods[0].addArgument(Integer.class, "Time to Live");
        bpmCacheBeanInfoBeanMethods[0].addArgument(Integer.class, "Inactivity Time");

        bpmCacheBeanInfoBeanMethods[1] = new MethodInfo(beanClass, "get", "get(String, String)");
        bpmCacheBeanInfoBeanMethods[1].addArgument(String.class, "JNDI Name");
        bpmCacheBeanInfoBeanMethods[1].addArgument(String.class, "Cache Key");

        bpmCacheBeanInfoBeanMethods[2] = new MethodInfo(beanClass, "containsKey", "containsKey(String, String)");
        bpmCacheBeanInfoBeanMethods[2].addArgument(String.class, "JNDI Name");
        bpmCacheBeanInfoBeanMethods[2].addArgument(String.class, "Cache Key");

        bpmCacheBeanInfoBeanMethods[3] = new MethodInfo(beanClass, "invalidate", "invalidate(String, String)");
        bpmCacheBeanInfoBeanMethods[3].addArgument(String.class, "JNDI Name");
        bpmCacheBeanInfoBeanMethods[3].addArgument(String.class, "Cache Key");

        bpmCacheBeanInfoBeanMethods[4] = new MethodInfo(beanClass, "clearCache", "clearCache(String)");
        bpmCacheBeanInfoBeanMethods[4].addArgument(String.class, "JNDI Name");
    }
}
