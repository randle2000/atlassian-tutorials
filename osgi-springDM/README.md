### Description
- `consumer` and `service` are 2 separate OSGi bundles
- `service` exports `com.sln.service.api` package where it has `com.sln.service.api.MyPluginComponent` interface
- `consumer` has dependency on `com.sln:service` in its `pom.xml` with scope `provided`
- `consumer` is just a servlet module that uses service


### To run

- go to `service` folder and do `atlas-mvn install`
- go to `consumer` folder and do `atlas-run`
- go to *http://localhost:2990/jira/plugins/servlet/upm*, "Upload add-on" and select `service/target/service-1.0.0-SNAPSHOT.jar`
- go to `consumer` folder and do `atlas-mvn package`
- check that service is wired correctly at *http://localhost:2990/jira/plugins/servlet/myservlet*
	- you can also check OSGiconsole at *http://localhost:2990/jira/plugins/servlet/upm/osgi*
