package com.sln.osgi.service;

import com.sln.osgi.api.Greeter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
//import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import java.util.Dictionary;
import java.util.Hashtable;

public class GreeterImpl2 implements Greeter, BundleActivator {
	
	private static final String SERVICE_NAME = "SERVICE 2";
	private static final int SERVICE_RANKING = 10;

    //private ServiceReference<Greeter> reference;
    private ServiceRegistration<Greeter> registration;

    @Override
    public String sayHiTo(String name) {
        return "FROM " + SERVICE_NAME + ": Hello " + name;
    }

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("MESSAGE FROM " + SERVICE_NAME + ": Registering service.");
        // If there are more than 1 services started, ServiceTracker will use service with highest ranking
        Dictionary<String, Object> properties = new Hashtable<>();
        properties.put(Constants.SERVICE_RANKING, SERVICE_RANKING);
        registration = context.registerService(Greeter.class, new GreeterImpl2(), properties);
        //reference = registration.getReference();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("MESSAGE FROM " + SERVICE_NAME + ": Unregistering service.");
        registration.unregister();
    }

}
