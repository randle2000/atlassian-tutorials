package com.atlassian.tutorial.ao.todo;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.user.UserManager;

import java.io.IOException;
import java.io.PrintWriter;

import static com.google.common.base.Preconditions.*;

public final class TodoServlet extends HttpServlet
{
    private final TodoService todoService;
    
    @ComponentImport
    private final UserManager userManager; // We need to inject SAL’s user manager to check whether user is logged in

    @Inject
    public TodoServlet(TodoService todoService, UserManager userManager) {
        this.todoService = checkNotNull(todoService);
        this.userManager = checkNotNull(userManager);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	// Enforcing the user is logged in in both the GET and POST method
    	if (!enforceLoggedIn(req, res))
            return;
    	
        final PrintWriter w = res.getWriter();
        w.write("<h1>Todos</h1>");
        // the form to post more TODOs
        w.write("<form method=\"post\">");
        w.write("<input type=\"text\" name=\"task\" size=\"25\"/>");
        w.write("  ");
        w.write("<input type=\"submit\" name=\"submit\" value=\"Add\"/>");
        w.write("</form>");

        w.write("<ol>");

        for (Todo todo : todoService.all()) // (2)
        {
            w.printf("<li><%2$s> %s </%2$s></li>", todo.getDescription(), todo.isComplete() ? "strike" : "strong");
        }

        w.write("</ol>");
        w.write("<script language='javascript'>document.forms[0].elements[0].focus();</script>");

        w.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    	// Enforcing the user is logged in in both the GET and POST method
    	if (!enforceLoggedIn(req, res))
            return;

        final String description = req.getParameter("task");
        todoService.add(description);
        res.sendRedirect(req.getContextPath() + "/plugins/servlet/todo/list");
    }
    
    private boolean enforceLoggedIn(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if (userManager.getRemoteUser() == null) {  // Simply check the username is not null, if it is redirect to the login page.
            res.sendRedirect(req.getContextPath() + "/plugins/servlet/login");
            return false;
        } else
        	return true;
    }
}