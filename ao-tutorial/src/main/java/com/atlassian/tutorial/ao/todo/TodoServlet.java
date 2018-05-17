package com.atlassian.tutorial.ao.todo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.google.common.base.Preconditions.*;

public final class TodoServlet extends HttpServlet
{
    private final TodoService todoService;

    public TodoServlet(TodoService todoService)
    {
        this.todoService = checkNotNull(todoService);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
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
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        final String description = req.getParameter("task");
        todoService.add(description);
        res.sendRedirect(req.getContextPath() + "/plugins/servlet/todo/list");
    }
}