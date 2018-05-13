package com.sln.osgi.client;

import com.sln.osgi.api.Greeter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

// For more info see "4.3.3 Tracking services" in "OSGi in Action" book (page.141)
// or example source: https://github.com/randle2000/osgi-in-action/blob/master/chapter04/dynamics/custom_tracker/src/org/foo/log/Activator.java
public class Client implements BundleActivator {

    //private BundleContext ctx;
    private ServiceTracker<Greeter, Greeter> serviceTracker;
    private volatile Thread workerThread;
    
    // Poll Greeter service by using its method every 5 secs
    class Poller implements Runnable {
    	@Override
    	public void run() {
    		while (Thread.currentThread() == workerThread) {
    			// query the tracker to find the best matching service
    			Greeter greeterService = serviceTracker.getService();

    			// if the service instance is null then we know there is no LogService available
    			if (greeterService != null) {
    				try {
    	    			// trying to use service
    	    			System.out.println(greeterService.sayHiTo("Client"));
    				} catch (RuntimeException re) {
    					System.out.println("CLIENT: Error in GreeterService");
    				}
    			} else {
    				System.out.println("CLIENT: No service available");
    			}

		    	// sleep for a bit
    		    try {
    		    	Thread.sleep(5000);
    		    } catch (InterruptedException e) {}
    		}
    	}
    }


    /**
     * Start using service
     **/
    public void start(BundleContext ctx) {
    	
        // we still need to store the current bundle context in a shared field
        //this.ctx = ctx;

        // 3rd parameter is a customizer object. for now, we don’t need any customization, so we pass null.
        // for customizer example see "4.3.3 Tracking services" in "OSGi in Action" book (page.141)
        serviceTracker = new ServiceTracker<>(ctx, Greeter.class.getName(), null);

        // we must remember to open the ServiceTracker so it can add a listener and start tracking
        serviceTracker.open();

        // start new thread to poll Greeter service - remember to keep bundle activator methods short!
        startPollThread();    	
    }

    /**
     * Stop using service
     **/
    public void stop(BundleContext bundleContext) {
    	// remember to explicitly close down the ServiceTracker so it can clear untracked services
    	serviceTracker.close();

        stopPollThread();
    }
    
    private void startPollThread() {
    	// start separate worker thread to run the actual service polls, managed by the bundle lifecycle
    	workerThread = new Thread(new Poller(), "GreeterService poller");
    	workerThread.setDaemon(true);
    	workerThread.start();
    }

    private void stopPollThread() {
    	// thread should cooperatively shutdown on the next iteration, because field is now null
    	Thread testThread = workerThread;
    	workerThread = null;
    	if (testThread != null) {
    		testThread.interrupt();
    		try {
    			testThread.join();
    		} catch (InterruptedException e) {}
    	}
    }    

}
