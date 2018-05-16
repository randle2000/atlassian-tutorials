Tutorial is [here](https://developer.atlassian.com/server/framework/atlassian-sdk/writing-and-running-plugin-tests/)

### [Unit Testing](https://developer.atlassian.com/server/framework/atlassian-sdk/create-and-run-unit-tests/)
- `atlas-unit-test` command runs just the unit tests (ut/*)

### [Integration Testing](https://developer.atlassian.com/server/framework/atlassian-sdk/create-and-run-traditional-integration-tests/)
- Traditional integration tests typically used Mockito to replicate or mock-up functions in the host. Now, Atlassian offers the Wired Test Framework - it allows to test your plugin in the actual host application environment rather than against mocked functions.
- `atlas-integration-test` command runs unit tests (ut/*), starts a host application, runs integration tests (it/*)
- The difference between traditional tests and wired tests is the use of the `AtlassianPluginsTestRunner`.  If your tests omit the `@RunWith(AtlassianPluginsTestRunner.class)` annotation, they are treated as traditional integration tests.
- by using `<testGroups>` in `pom.xml` you can test against several products: jira, confluence, etc. 
- if you have multiple `<testGroups>` defined, you can run a subset of those groups by using the `-DtestGroups=groupname`
- in this project I created 2 test groups in `pom.xml`: `my-traditional-integration` and `my-wired-integration`
  Maven Surefire plugin creates report for each group in `target/group-<group-name>` folders
  
### [Plugin Test Console](https://developer.atlassian.com/server/framework/atlassian-sdk/run-wired-tests-with-the-plugin-test-console/)
- **Standard JUnit Test**: Tests are stateless and every method is run on its own instance of the test class.  
  @BeforeClass and @AfterClass must annotate a public static void method.  
  **Atlassian Wired Test**: Tests are stateful. All methods run on the same test class instance  
  @BeforeClass and @AfterClassmust not annotate a _static_ method.
- start JIRA with `atlas-debug`
- Access Plugin Test Console: *http://java.host:2990/jira/plugins/servlet/it-test-console*
  console didn't work - maybe this can help [link](https://community.atlassian.com/t5/Questions/Atlassian-Plugin-Test-Console-and-QuickReload/qaq-p/371152)