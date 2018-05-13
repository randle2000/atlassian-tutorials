### Taken from:  

http://www.baeldung.com/osgi  
https://github.com/eugenp/tutorials/tree/master/osgi

### To run

- `mvn clean package`
	- this won't work if you do it from inside `osgi-client` or `osgi-service*` folders because they have dependency on osgi-api which will not be found in local maven repo.
	  You can do `mvn clean install` from parent project's root
	  
- You can use OSGi console from inside Eclipse instead of installing Apache Karaf (in Console window select "Host OSGi Console")
```
install file:/dev/workspace/atlassian-tutorials/osgi-intro/osgi-client/target/osgi-client-2.0-SNAPSHOT.jar
install file:/dev/workspace/atlassian-tutorials/osgi-intro/osgi-service1/target/osgi-service1-2.0-SNAPSHOT.jar
ss com.sln     (this shows the status of bundles containing com.sln)
start <CLIENT_ID>
start <SERVICE_ID>
... (see bundles at work) ...
stop <CLIENT_ID>
stop <SERVICE_ID>
uninstall <CLIENT_ID>
uninstall <SERVICE_ID>
```	

### Notice
com.sln.osgi.api should probably be packaged and installed into OSGi container as separate bundle
But right now it's just a jar and is exported from both osgi-client and osgi-service1 - this way they can both be resolved and started independently of each other

### Further feature
This example is valid when there is only one instance of service.
To enchance client with ability to work with multiple services (where each service implements the same API interface) see "4.3.3 Tracking services" in "OSGi in Action" book (page.141)