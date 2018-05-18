### Currently this doesn't work
The idea is to use Spring MVC inside Atlassian plugin  
when trying *http://java.host:2990/jira/plugins/servlet/spring/aaa* I get:  
`No mapping found for HTTP request with URI [/jira/plugins/servlet/spring/aaa] in DispatcherServlet with name 'My Servlet'`

### Notes
- I have `org.springframework.web.servlet.DispatcherServlet` defined as a <servlet> in atlassian-plugin.xml
- had error when Spring dependencies were declared with scope `compile` in `pom.xml`  
  you have to check version of Spring provided with OSGi console in JIRA and use that version for your Spring dependencies with scope `provided`
- had trouble refering to Spring components from `*.xml` files. To solve this I had to add corresponding Spring packages manually into `<Import-Package>` in `pom.xml`
  need to check if `<DynamicImport-Package>*</DynamicImport-Package>` and other instructions from that article below helps

### Further
- Check this [example](https://bitbucket.org/activeobjects/ao-plugin/src/d9a561b963d2ae93252996b95d76400086cc934d/activeobjects-plugin/src/main/resources/atlassian-plugin.xml?at=master&_ga=2.144407094.2019164800.1525886966-1793353365.1522254320&fileviewer=file-view-default#cl-17)  
- Also check this article showing how to use Spring Beans with java config inside Atlassian plugins:
  [Article](https://habr.com/company/raiffeisenbank/blog/352558/)
  [English version of article](https://community.atlassian.com/t5/Jira-articles/Spring-Java-based-configuration-and-AOP-in-Jira-plugins/ba-p/762265)
  [Source](https://bitbucket.org/alex1mmm/spring-tutorial)