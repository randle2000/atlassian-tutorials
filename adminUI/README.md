https://developer.atlassian.com/server/framework/atlassian-sdk/learn-the-development-platform-by-example/

- Maven
Atlassian SDK uses its own bundled Maven installation.
Create ${user.home}/.m2/settings.xml and specify location of Maven's repository there so that other Mavens installations could find it

- To clean:
`atlas-mvn clean`
or
`atlas-clean`

- To run as RefApp:
`atlas-run`
	- access servlet at http://localhost:5990/refapp/plugins/servlet/test

- To run as Jira:
`atlas-run --product jira --version 7.7.1`
	- access servlet at http://localhost:2990/jira/plugins/servlet/test
	
- To make Eclipse recognize pom.xml and have paths updated:
`atlas eclipse:eclipse`

- QuickReload:
`atlas-mvn package`