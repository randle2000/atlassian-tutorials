package ut.com.atlassian.plugins.tutorial.rest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.atlassian.plugins.tutorial.rest.MyRestResource;
import com.atlassian.plugins.tutorial.rest.MyRestResourceModel;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

public class MyRestResourceTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {
        MyRestResource resource = new MyRestResource();

		Response response = resource.getMessage("Hello World");
        final MyRestResourceModel message = (MyRestResourceModel) response.getEntity();

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
