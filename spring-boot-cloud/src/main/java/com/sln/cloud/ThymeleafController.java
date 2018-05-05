package com.sln.cloud;

import com.atlassian.connect.spring.IgnoreJwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/spring-boot")
    public String getIframe() {
        return "thymeleaf";
    }
}
