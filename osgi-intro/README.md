### Taken from:  

http://www.baeldung.com/osgi  
https://github.com/eugenp/tutorials/tree/master/osgi

### To run

- `mvn clean package`
	- this won't work if you do it from inside `osgi-intro-sample-client` folder because client has dependency on service which will not be found in local maven repo.
	  You can do `mvn clean install` from parent project's root
	  
- You can use OSGi console from inside Eclipse instead of installing Apache Karaf (in Console window select "Host OSGi Console")
```
install file:/dev/workspace/atlassian-tutorials/osgi-intro/osgi-intro-sample-client/target/osgi-intro-sample-client-1.0-SNAPSHOT.jar
install file:/dev/workspace/atlassian-tutorials/osgi-intro/osgi-intro-sample-service/target/osgi-intro-sample-service-1.0-SNAPSHOT.jar
ss com.sln     (this shows the status of bundles containing com.sln)
start <CLIENT_ID>
start <SERVICE_ID>
... (see bundles at work) ...
stop <CLIENT_ID>
stop <SERVICE_ID>
uninstall <CLIENT_ID>
uninstall <SERVICE_ID>
```	

### Further feature
This example is valid when there is only one instance of service.
To enchance client with ability to work with multiple services (where each service implements the same API interface) see "4.3.3 Tracking services" in "OSGi in Action" book (page.141)