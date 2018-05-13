package com.sln.osgi.service;

import com.sln.osgi.api.Greeter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import java.util.Hashtable;

public class GreeterImpl1 implements Greeter, BundleActivator {

    private ServiceReference<Greeter> reference;
    private ServiceRegistration<Greeter> registration;

    @Override
    public String sayHiTo(String name) {
        return "FROM SERVICE1: Hello " + name;
    }

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("MESSAGE FROM SERVICE1: Registering service.");
        registration = context.registerService(Greeter.class, new GreeterImpl1(), new Hashtable<String, String>());
        reference = registration.getReference();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("MESSAGE FROM SERVICE1: Unregistering service.");
        registration.unregister();
    }
}
