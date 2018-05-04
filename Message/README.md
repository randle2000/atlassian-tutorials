https://developer.atlassian.com/server/framework/atlassian-sdk/developing-a-rest-service-plugin/

You can also run Jira standalone (from any folder):  
	`atlas-run-standalone --product jira --version 7.7.1`
and then add the plugin manually by uploading `target/Message-1.0.jar` as described here: 
https://confluence.atlassian.com/display/UPM/Installing+Add-ons?&_ga=2.268225229.210664904.1525247698-1793353365.1522254320#InstallingAdd-ons-Installingbyfileupload

Info on REST, annotations, XML/JSON response: https://developer.atlassian.com/server/framework/atlassian-sdk/rest-plugin-module/