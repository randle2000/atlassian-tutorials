package com.atlassian.connect.atlascamp;

import com.atlassian.connect.spring.AtlassianHostRestClients;
import com.atlassian.connect.spring.AtlassianHostUser;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class InceptionController {

    private static final String PAGE_URL = "%s/rest/api/content/%s?expand=body.export_view";
    private static final String JS_URL = "%s/atlassian-connect/all.js";

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private AtlassianHostRestClients atlassianHostRestClients;

    @RequestMapping(value = "/inception-macro")
    public String render(@RequestParam long pageId, @AuthenticationPrincipal AtlassianHostUser hostUser, Model model) {
        final String baseURL = hostUser.getHost().getBaseUrl();
        final String contentUrl = String.format(PAGE_URL, baseURL, pageId);

        final String pageBody = extractPageBody(restTemplate.getForObject(contentUrl, String.class));
        //final String pageBody = atlassianHostRestClients.authenticatedAsAddon().getForObject(contentUrl, String.class);
        //final String pageBody = atlassianHostRestClients.authenticatedAsHostActor().getForObject(contentUrl, String.class);
        

        model.addAttribute("body", pageBody);
        model.addAttribute("jsurl", String.format(JS_URL, baseURL));

        return "inception-macro";
    }

    private String extractPageBody(String response) {
        JsonObject responseObject = new JsonParser().parse(response).getAsJsonObject();
        return responseObject.getAsJsonObject("body").getAsJsonObject("export_view").get("value").getAsString();
    }
}
