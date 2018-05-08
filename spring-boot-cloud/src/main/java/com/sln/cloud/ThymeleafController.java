package com.sln.cloud;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.connect.spring.AtlassianHostRestClients;
import com.atlassian.connect.spring.AtlassianHostUser;
//import com.atlassian.jira.rest.client.internal.json.BasicIssueJsonParser;
import com.atlassian.jira.rest.client.internal.json.GenericJsonArrayParser;
import com.atlassian.jira.rest.client.internal.json.IssueJsonParser;
//import com.atlassian.jira.rest.client.api.domain.BasicIssue;
import com.atlassian.jira.rest.client.api.domain.Issue;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.sln.cloud.domain.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Integrate with JIRA REST Java Client: https://ecosystem.atlassian.net/browse/ACSPRING-20?focusedCommentId=276827&page=com.atlassian.jira.plugin.system.issuetabpanels%3Acomment-tabpanel#comment-276827
@Controller
public class ThymeleafController {
	
	private static final Logger log = LoggerFactory.getLogger(ThymeleafController.class);
	
	//private static final String PAGE_URL = "/rest/api/2/search?jql=project%20%3D%20\"MYP\"";
	private static final String PAGE_URL = "/rest/api/2/search?expand=%s";
	//private static final String PROJECT_KEY = "MYP";
	
	//private IssueJsonParser issueJsonParser = new IssueJsonParser();
	//private BasicIssueJsonParser basicIssueJsonParser = new BasicIssueJsonParser();
	//private GenericJsonArrayParser<Issue> genericJsonArrayParser = new GenericJsonArrayParser<>(issueJsonParser); 
	
	@Autowired
    private AtlassianHostRestClients atlassianHostRestClients;

    @GetMapping("/spring-boot")
    public String getIframe(@AuthenticationPrincipal AtlassianHostUser hostUser, Model model) throws JSONException {
    	//final String baseURL = hostUser.getHost().getBaseUrl();
        //final String contentUrl = String.format(PAGE_URL, baseURL, PROJECT_KEY);
    	//final String contentUrl = baseURL + PAGE_URL;
    	final String contentUrl = String.format(PAGE_URL, "names,schema");
        
        //final String pageBody = atlassianHostRestClients.authenticatedAsAddon().getForObject(contentUrl, String.class);
        //final JSONObject response = atlassianHostRestClients.authenticatedAsAddon().getForObject(contentUrl, JSONObject.class);
    	// using my own SearchResult class 
        //final SearchResult searchResult = atlassianHostRestClients.authenticatedAsAddon().getForObject(contentUrl, SearchResult.class);
        //final String pageBody = searchResult.toString();
        //model.addAttribute("issues", searchResult.getIssues());

        
        //String requestUrl = String.format("/rest/api/2/issue/%s?expand=%s", "AAA-1", "names,schema");
        ResponseEntity<String> response = atlassianHostRestClients.authenticatedAsAddon().getForEntity(contentUrl, String.class);
    	JSONObject jsonResponse = new JSONObject(response.getBody());
    	JSONObject providedNames = jsonResponse.getJSONObject("names");
    	JSONObject providedSchema = jsonResponse.getJSONObject("schema");
    	JSONArray issuesArray = jsonResponse.getJSONArray("issues");
    
    	IssueJsonParser issueJsonParser = new IssueJsonParser(providedNames, providedSchema);
    	GenericJsonArrayParser<Issue> genericJsonArrayParser = new GenericJsonArrayParser<>(issueJsonParser);
    	Iterable<Issue> issues = genericJsonArrayParser.parse(issuesArray);
    	//List<Issue> issues2 = new ArrayList<>();
    	//issues.forEach(issues2::add);

        //Issue issue = issueJsonParser.parse(new JSONObject(response.getBody()));
        //BasicIssue issue = basicIssueJsonParser.parse(new JSONObject(response.getBody()));
        
        model.addAttribute("issues", issues);
    	
        return "thymeleaf";
    }
    
//    private String extractIssuesBody(String response) {
//        JsonObject responseObject = new JsonParser().parse(response).getAsJsonObject();
//        JsonArray ja = responseObject.getAsJsonArray("issues");
//    	
//        genericJsonArrayParser.parse(ja);
//        return ja.toString();
//    }
}
