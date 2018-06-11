### Purpose
This example shows how Spring Scanner annotations can be replaced with XML config for SpringDM  
SpringDM example is taken from [here](https://www.javaworld.com/article/2077853/java-se/java-se-hello-osgi-part-2-introduction-to-spring-dynamic-modules.html)

### Description
- `consumer` and `service` are 2 separate OSGi bundles
- `service` exports `com.sln.service.api` package where it has `com.sln.service.api.MyPluginComponent` interface
- `consumer` has dependency on `com.sln:service` in its `pom.xml` with scope `provided`
- `consumer` is just a servlet module that uses service
- OSGi and Spring DM
	- see [annotations TAG](https://github.com/randle2000/atlassian-tutorials/tree/annotations/osgi-springDM)
		- `@ExportAsService` and `@Named` annotations are used in `com.sln.service.impl.MyPluginComponentImpl`
		- `@Scanned`, `@ComponentImport` and `@Inject` annotations are used in `com.sln.servlet.MyServlet`
	- see [xml TAG](https://github.com/randle2000/atlassian-tutorials/tree/xml/osgi-springDM)
		- `service.xml` and `osgi.xml` are placed in `META-INF/spring` in `service`
		- `beans.xml` and `osgi.xml` are placed in `META-INF/spring` in `consumer`
		- Spring DM reads `META-INF/spring/*.xml`, registers services, wires up beans and wires up services, read first two paragraphs [here](https://www.javaworld.com/article/2077853/java-se/java-se-hello-osgi-part-2-introduction-to-spring-dynamic-modules.html?page=2)

### To run

- go to `service` folder and do `atlas-mvn install`
- go to `consumer` folder and do `atlas-run`
- go to *http://localhost:2990/jira/plugins/servlet/upm*, "Upload add-on" and select `service/target/service-1.0.0-SNAPSHOT.jar`
- go to `consumer` folder and do `atlas-mvn package`
- check that service is wired correctly at *http://localhost:2990/jira/plugins/servlet/myservlet*
	- you can also check OSGiconsole at *http://localhost:2990/jira/plugins/servlet/upm/osgi*
