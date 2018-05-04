https://developer.atlassian.com/server/jira/platform/creating-a-jira-issue-crud-servlet-and-issue-search/

Access your plugin at: http://java.host:2990/jira/plugins/servlet/issuecrud

Had to comment-out `component-import` entries in atlassian-plugin.xml and use `@Scanned` and `@ComponentImport` in `com.example.plugins.tutorial.crud.servlet.IssueCRUD` instead.
You can either use Spring Scanner Annotations (new way) or `<component>` and `<component-import>` (old way), but not both.
Explained here: https://community.atlassian.com/t5/Answers-Developer-Questions/atlassian-plugin-xml-contains-a-definition-of-component-import/qaq-p/560580
and here: https://stackoverflow.com/questions/36008446/atlassian-plugin-xml-contains-a-definition-of-component-import-this-is-not-allo
Also read about Atlassian Spring Scanner here: https://bitbucket.org/atlassian/atlassian-spring-scanner

Also, I'm getting instance of `com.atlassian.jira.user.util.UserManager` via static `ComponentAccessor`'s method, because constructor injection didn't work for some reason.

Also changed `com.atlassian.crowd.embedded.api.User` to `com.atlassian.jira.user.ApplicationUser`