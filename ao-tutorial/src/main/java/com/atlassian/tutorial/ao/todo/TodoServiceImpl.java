package com.atlassian.tutorial.ao.todo;

import com.atlassian.activeobjects.external.ActiveObjects;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;

import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import javax.inject.Inject;
import javax.inject.Named;

@Scanned
@Named
public class TodoServiceImpl implements TodoService
{
    @ComponentImport
    private final ActiveObjects ao;

    @Inject
    public TodoServiceImpl(ActiveObjects ao)
    {
        this.ao = checkNotNull(ao);
    }

    @Override
    public Todo add(String description)
    {
        final Todo todo = ao.create(Todo.class);
        todo.setDescription(description);
        todo.setComplete(false);
        todo.save();
        return todo;
    }

    @Override
    public List<Todo> all()
    {
        return newArrayList(ao.find(Todo.class));
    }
}
