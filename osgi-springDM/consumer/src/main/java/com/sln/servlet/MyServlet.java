package com.sln.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

import com.sln.service.api.MyPluginComponent;

//@Scanned
public class MyServlet extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(MyServlet.class);
	
	//@ComponentImport
	private MyPluginComponent mpc;
	
	//@Inject
	public void setMyPluginComponent(MyPluginComponent mpc) {
		this.mpc = mpc;
	}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		String cn = mpc.getName();
		
        resp.setContentType("text/html");
        resp.getWriter().write("<html><body>Hello World " + cn + "</body></html>");
    }

}