### Currently this doesn't work
The idea is to use Spring MVC inside Atlassian plugin  
when trying *http://java.host:2990/jira/plugins/servlet/spring/aaa* I get:  
```
[o.s.c.io.support.PathMatchingResourcePatternResolver] Cannot search for matching files underneath URL [bundle://171.0:1/com/sln/plugins/controllers/] because it does not correspond to a directory in the file system
[INFO] [talledLocalContainer] java.io.FileNotFoundException: URL [bundle://171.0:1/com/sln/plugins/controllers/] cannot be resolved to absolute file path because it does not reside in the file system: bundle://171.0:1/com/sln/plugins/controllers/
```

### Notes
- I have `com.sln.plugins.servlet.MyDispatcherServlet` which extends `org.springframework.web.servlet.DispatcherServlet` defined as a `<servlet>` in `atlassian-plugin.xml`
- had error when Spring dependencies were declared with scope `compile` in `pom.xml`  
  you have to check version of Spring provided with OSGi console in JIRA and use that version for your Spring dependencies with scope `provided`
- had trouble refering to Spring components from `*.xml` files. To solve this I had to add corresponding Spring packages manually into `<Import-Package>` in `pom.xml`  
  need to check if `<DynamicImport-Package>*</DynamicImport-Package>` and other instructions from that article below can help

### Further
- Check this [example](https://bitbucket.org/activeobjects/ao-plugin/src/d9c00d17de6c3be4625f4572dc3ceba4d2402d3f/activeobjects-plugin/src/main/resources/atlassian-plugin.xml?at=master&fileviewer=file-view-default)  
- Also check this article showing how to use Spring Beans with java config inside Atlassian plugins:  
  [Article](https://habr.com/company/raiffeisenbank/blog/352558/)  
  [English version of article](https://community.atlassian.com/t5/Jira-articles/Spring-Java-based-configuration-and-AOP-in-Jira-plugins/ba-p/762265)  
  [Source](https://bitbucket.org/alex1mmm/spring-tutorial)