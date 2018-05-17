- **adminUI** - a simple *RefApp server* servlet which controls access for user, uses Velocity template and stores Name and Age as key/value pairs via `PluginSettings`  
  [Learn the development platform by example](https://developer.atlassian.com/server/framework/atlassian-sdk/learn-the-development-platform-by-example/)
  
- **ao-tutorial** - Active Objects for *server*. A servlet that stores Todo entities as Active objects. Also shows how to unit-test AO  
  2nd tutorial shows how to upgrade entity w/out losing old records when we introduce new field to it  
  [Tutorial Getting Started with Active Objects](https://developer.atlassian.com/server/framework/atlassian-sdk/getting-started-with-active-objects)  
  [Handling AO upgrade tasks](https://developer.atlassian.com/server/framework/atlassian-sdk/handling-ao-upgrade-tasks/)  
  [AO tutorials root](https://developer.atlassian.com/server/framework/atlassian-sdk/active-objects/)
  
- **cloudExample** - just an HTML example of plugin for *JIRA cloud*. Uses ngrok for tunneling.  
  [Getting started](https://developer.atlassian.com/cloud/jira/platform/getting-started/)
  
- **confluence-inception-macro** - SpringBoot Connect plugin for *Confluence cloud*. Shows how to retrieve page content via REST API using RestTemplate, parses JSON response.  
  Taken from [here](https://bitbucket.org/vkok/atlascamp-inception.git)
  
- **Message** - REST module for *RefApp server*. Shows how to return model object as REST resource (JSON/XML).  
  [Developing a REST service plugin](https://developer.atlassian.com/server/framework/atlassian-sdk/developing-a-rest-service-plugin/)
  
- **myConfluenceMacro** - a simple ‘Hello World’ *Confluence server* macro showing how to get a couple of parameters from user and inject some HTML into Confluence page.  
  [Create a Confluence ‘Hello World’ macro](https://developer.atlassian.com/server/framework/atlassian-sdk/create-a-confluence-hello-world-macro/)
  
- **myPlugin** - a *JIRA server* plugin showing how to add Web Section to menu with some items, project blueprint, soy, workflow, project hook  
  [Set up the Atlassian Plugin SDK and build a project](https://developer.atlassian.com/server/framework/atlassian-sdk/set-up-the-atlassian-plugin-sdk-and-build-a-project/)
  
- **osgi-intro** - my example showing the use of a client and 2 services

- **spring-boot-cloud** - SpringBoot Connect plugin for *JIRA cloud* with Thymeleaf. Shows how to retrieve issues via REST API, parses JSON responses using [JIRA REST Java Client Library](https://ecosystem.atlassian.net/wiki/spaces/JRJC/overview).

- **testTutorial** - plugin for *JIRA server* showing how to do Unit Testing and Integration Testing. Also mentions Plugin Test Console.  
  [Writing and running plugin tests](https://developer.atlassian.com/server/framework/atlassian-sdk/writing-and-running-plugin-tests/)
  
- **tutorial-jira-simple-issue-crud** - a servlet for *JIRA server*. Shows how to do CRUD operation on JIRA issues using JIRA API.  
  [Creating a JIRA issue CRUD servlet and issue search](https://developer.atlassian.com/server/jira/platform/creating-a-jira-issue-crud-servlet-and-issue-search/)
  
- **xproduct-admin-ui-plugin** - cross product plugin for *RefApp server* with servlet, web-item menu, Velocity template, i18n and REST module processing GET and PUT for Name and Time, storing it as key/value pairs via PluginSettings  
  [Creating an admin configuration form](https://developer.atlassian.com/server/framework/atlassian-sdk/creating-an-admin-configuration-form/)