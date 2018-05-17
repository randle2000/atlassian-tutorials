package com.atlassian.tutorial.ao.todo;

import net.java.ao.Entity;
import net.java.ao.Preload;

//net.java.ao.Entity defines the primary key as being ID
@Preload
public interface Todo extends Entity {
	
	void setUserName(String userName);

    String getUserName();
    
    String getDescription();

    void setDescription(String description);

    boolean isComplete();

    void setComplete(boolean complete);
}