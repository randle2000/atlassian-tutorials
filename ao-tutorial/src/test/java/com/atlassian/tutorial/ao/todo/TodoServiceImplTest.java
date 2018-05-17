package com.atlassian.tutorial.ao.todo;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.activeobjects.test.TestActiveObjects;
import net.java.ao.EntityManager;
import net.java.ao.test.jdbc.Data;
import net.java.ao.test.jdbc.DatabaseUpdater;
import net.java.ao.test.junit.ActiveObjectsJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

// we’re using the ActiveObjectsJUnitRunner to run this test, this will help us access a correctly configured Active Objects instance for testing.
// It also wraps each tests in a transaction that is rolled-back after each of them.
// This will leave the test database in the same state for each test.
@RunWith(ActiveObjectsJUnitRunner.class) // (1)
// We introduce the @Data annotation of the Active Objects test framework
// We define the annotation which takes a class parameter.
@Data(TodoServiceImplTest.TodoServiceImplTestDatabaseUpdater.class) // (1)
public class TodoServiceImplTest {
	// We define the class used to deal with test data before the tests are run.
	// A typical usage of this class is to migrate entities under test and then add some data that tests can use.
    public static class TodoServiceImplTestDatabaseUpdater implements DatabaseUpdater
    {
        @Override
        public void update(EntityManager em) throws Exception {
        	// before testing we need to tell AO about the Todo entity
            em.migrate(Todo.class);

            final Todo todo = em.create(Todo.class);
            todo.setDescription(TODO_DESC);
            todo.save();
        }
    }	
	
	
	private static final String TODO_DESC = "This is a todo";
	
	// EntityManager that will be automatically injected by the ActiveObjectsJUnitRunner
    private EntityManager entityManager;  // (2)

    private TodoServiceImpl todoService; // (3)
    
    private ActiveObjects ao;

    @Before
    public void setUp() throws Exception {
    	// here we’re just checking that the EntityManager is not null to make sure we’ve configured our test correctly
        assertNotNull(entityManager); // (4)
        ao = new TestActiveObjects(entityManager);
        // we instantiate the service with a specific TestActiveObjects instance.
        todoService = new TodoServiceImpl(ao);
    }

    @Test
    public void testAdd() throws Exception {
        // before testing we need to tell AO about the Todo entity
        //ao.migrate(Todo.class); // (2)
        
        final String description = TODO_DESC + "#1";

        assertEquals(1, ao.find(Todo.class).length);

        final Todo add = todoService.add(description);
        assertFalse(add.getID() == 0);

        // using flushAll can be handy to make sure we’re actally testing the DB and not the cache.
        ao.flushAll(); // clear all caches

        final Todo[] todos = ao.find(Todo.class);
        assertEquals(2, todos.length);
        assertEquals(add.getID(), todos[1].getID());
        assertEquals(description, todos[1].getDescription());
        assertEquals(false, todos[1].isComplete());        
    }

    @Test
    public void testAll() throws Exception {
        assertEquals(1, todoService.all().size());

        final Todo todo = ao.create(Todo.class);
        todo.setDescription("Some todo");
        todo.save();
        
        // using flushAll can be handy to make sure we’re actally testing the DB and not the cache.
        ao.flushAll(); // clear all caches

        final List<Todo> all = todoService.all();
        assertEquals(2, all.size());
        assertEquals(todo.getID(), all.get(1).getID());        
    }
    
}