package com.atlassian.tutorial.ao.todo;

import net.java.ao.Entity;

// net.java.ao.Entity defines the primary key as being ID
public interface Todo extends Entity
{
    String getDescription();

    void setDescription(String description);

    boolean isComplete();

    void setComplete(boolean complete);
}