/* We’ve created a specific package for this upgrade task, and this version of the data model.
 * Also note that the Todo class used here is the com.atlassian.tutorial.ao.todo.upgrade.v1.Todo class,
 * we copied the model corresponding to that upgrade task into that same package.
 * This code is never to be touched and should remain like so for the whole life of the plugin.
 */
package com.atlassian.tutorial.ao.todo.upgrade.v1; // (1)

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.activeobjects.external.ActiveObjectsUpgradeTask;
import com.atlassian.activeobjects.external.ModelVersion;

public final class TodoUpgradeTask001 implements ActiveObjectsUpgradeTask
{
    @Override
    public ModelVersion getModelVersion()
    {
    	/*
    	 * Setting the model version, here 1. This is used by Active Objects to figure out which upgrade tasks to run and in which order.
    	 * By default plugins that never defined any upgrade tasks are assigned the version 0.
    	 */
        return ModelVersion.valueOf("1"); // (2)
    }

    /*
     * The Active Objects component passed a parameter here is the only one you should use for the upgrade task.
     * You should never inject your plugin’s Active Objects component in any upgrade task.
     * This instance is specific to that one upgrade task and will be discarded after the upgrade task has run.
     */
    @Override
    public void upgrade(ModelVersion currentVersion, ActiveObjects ao) // (3)
    {
    	/*
    	 * When writing your upgrade task, you must call the migrate method yourself to let Active Objects know about the data model you want to work this.
    	 * This will update the database to match the model.
    	 * Note that if you omit part of the model objects here, their respective tables in the database will be dropped!
    	 */
        ao.migrate(Todo.class); // (4)

        /*
         * Then we can update our data model as we need.
         */
        for (Todo todo : ao.find(Todo.class)) // (5)
        {
            todo.setUserName("admin");
            todo.save();
        }
    }
}
