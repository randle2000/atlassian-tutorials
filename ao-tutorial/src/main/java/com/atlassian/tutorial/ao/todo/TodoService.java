package com.atlassian.tutorial.ao.todo;

import com.atlassian.activeobjects.tx.Transactional;

import java.util.List;

@Transactional	// These annotations will only work on interfaces, so we won’t be able to apply it on our servlet.
public interface TodoService
{
    Todo add(String description);

    List<Todo> all();
}