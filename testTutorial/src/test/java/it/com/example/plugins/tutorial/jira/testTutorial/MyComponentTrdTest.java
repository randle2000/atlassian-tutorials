package it.com.example.plugins.tutorial.jira.testTutorial;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
     
// Traditional Integration Test 
public class MyComponentTrdTest {
	
	@Ignore
    @Test
    public void testSomeFailure()
    {
        System.out.println("I RAN But failed...");
        assertEquals("something failed","blah","boo");
    }
}