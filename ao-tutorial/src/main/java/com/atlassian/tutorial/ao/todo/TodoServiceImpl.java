package com.atlassian.tutorial.ao.todo;

import com.atlassian.activeobjects.external.ActiveObjects;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;

import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.user.UserManager;

import net.java.ao.Query;

import javax.inject.Inject;
import javax.inject.Named;

@Scanned
@Named
public class TodoServiceImpl implements TodoService
{
    @ComponentImport
    private final ActiveObjects ao;
    
    @ComponentImport
    private final UserManager userManager; // We get SAL’s UserManager injected as we use it to get the current user,

    @Inject
    public TodoServiceImpl(ActiveObjects ao, UserManager userManager) {
        this.ao = checkNotNull(ao);
        this.userManager = checkNotNull(userManager);
    }

    @Override
    public Todo add(String description)
    {
        final Todo todo = ao.create(Todo.class);
        todo.setDescription(description);
        todo.setComplete(false);
        todo.setUserName(currentUserName()); // Setting the user name when adding a TODO item
        todo.save();
        return todo;
    }

    @Override
    public List<Todo> all() {
        //return newArrayList(ao.find(Todo.class));
    	// Finding the TODO items for the current user only
        return newArrayList(ao.find(Todo.class, Query.select().where("USER_NAME = ?", currentUserName())));
    }
    
    private String currentUserName() {
        return userManager.getRemoteUser().getUsername();
    }
    
}
