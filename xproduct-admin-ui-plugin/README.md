https://developer.atlassian.com/server/framework/atlassian-sdk/creating-an-admin-configuration-form/

## It's a cross product app. It can be run with Jira, or Confluence, etc.

### Error
Getting `java.lang.RuntimeException: `getStaticResourceLocale` is deprecated and not used anymore!` and saving/loading of Name/Time doesn't work
Maybe it has to do with $webResourceManager in admin.vm

### To run as RefApp:

	atlas-run
	
- Access at http://localhost:5990/refapp/ (XProduct Admin in menu) OR http://localhost:5990/refapp/plugins/servlet/xproduct/admin

### To run as JIRA:

	atlas-run --product jira --version 7.7.1
	
- Access at http://localhost:2990/jira/ (ADMINISTRATION -> Add-ons -> XProduct Admin in menu) OR http://localhost:2990/jira/plugins/servlet/xproduct/admin

### To run as Confluence:

	atlas-run --product confluence --version 6.7.1

### To run as Bamboo: 

	atlas-run --product bamboo --version 5.14.1
	
### To open in Eclipse:

	atlas-mvn eclipse:eclipse
	
	
- If a link to the plugin does not exist, check that the plug-in we created is loaded via “Manage add-on”, selecting the option to see “All add-ons” and looking for the entry xproduct-admin-ui-plugin