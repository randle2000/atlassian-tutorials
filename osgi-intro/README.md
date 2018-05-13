### Taken from:  

http://www.baeldung.com/osgi  
https://github.com/eugenp/tutorials/tree/master/osgi  
also from  
"4.3.3 Tracking services" in "OSGi in Action" book (page.141)  
https://github.com/randle2000/osgi-in-action/blob/master/chapter04/dynamics/custom_tracker/src/org/foo/log/Activator.java


### To run

- `mvn clean package`
	- this won't work if you do it from inside `osgi-client` or `osgi-service*` folders because they have dependency on osgi-api which will not be found in local maven repo.
	  You can do `mvn clean install` from parent project's root
	  
- You can use OSGi console from inside Eclipse instead of installing Apache Karaf (in Console window select "Host OSGi Console")
```
install file:/dev/workspace/atlassian-tutorials/osgi-intro/osgi-client/target/osgi-client-2.0-SNAPSHOT.jar
install file:/dev/workspace/atlassian-tutorials/osgi-intro/osgi-service1/target/osgi-service1-2.0-SNAPSHOT.jar
install file:/dev/workspace/atlassian-tutorials/osgi-intro/osgi-service2/target/osgi-service2-2.0-SNAPSHOT.jar
ss com.sln     (this shows the status of bundles containing com.sln)
start <CLIENT_ID>
start <SERVICE1_ID>
start <SERVICE2_ID>
... (see bundles at work) ...
stop <CLIENT_ID>
stop <SERVICE1_ID>
stop <SERVICE2_ID>
uninstall <CLIENT_ID>
uninstall <SERVICE1_ID>
uninstall <SERVICE2_ID>
```	


### Notice
- `com.sln.osgi.api` should probably be packaged and installed into OSGi container as separate bundle
  But right now it's just a jar and is exported from all `osgi-client`, `osgi-service1` and `osgi-service2` - this way they can all be resolved and started independently of each other
- `osgi-service1` and `osgi-service2` both implement `com.sln.osgi.api interface`. Client will automatically use other service if one is stopped
- `osgi-service1` and `osgi-service2` are identical, just have their SERVICE_NAME and SERVICE_RANKING different
- if there are more than 1 services started, ServiceTracker in client will use service with highest ranking
- for more simple example where client just registers as ServiceListener (ServiceTracker is not used) see [simple-listener tag](https://github.com/randle2000/atlassian-tutorials/tree/simple-listener/osgi-intro)