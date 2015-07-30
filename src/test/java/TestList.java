/**
 * Created by hushuai on 15/7/23
 */
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.tradeshift.bean.Person;
import com.tradeshift.dao.PersonDAO;
import org.junit.Test;

import javax.ws.rs.core.MultivaluedMap;
import java.net.URI;
import java.net.URISyntaxException;


public class TestList {

    @Test
    public void testGet() throws URISyntaxException {
        Client client = Client.create();
        URI url = new URI("http://localhost:8080/spring/get/vincent3");
        System.out.println(url);
        WebResource webResource = client.resource(url);
        System.out.println(webResource.get(String.class));
    }

    @Test
    public void testPut() throws URISyntaxException {
        Client client = Client.create();
        URI url = new URI("http://localhost:8080/spring/update");
        WebResource webResource = client.resource(url);
        MultivaluedMap putParams = new MultivaluedMapImpl();
        putParams.add("name", "vincent1");
        putParams.add("age", "37");
        ClientResponse response = webResource.queryParams(putParams).put(ClientResponse.class, "foo:test");
        System.out.println("put response: " + response.toString());
    }

    @Test
    public void testDelete () throws URISyntaxException {
        Client client = Client.create();
        URI url = new URI("http://localhost:8080/spring/delete/vincentHu");
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource.delete(ClientResponse.class);

        System.out.println("delete response: " + response.getStatus());
    }

    @Test
    public void testAdd () throws URISyntaxException {
        Client client = Client.create();
        URI url = new URI("http://localhost:8080/spring/add/vincentHu/36");
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource.post(ClientResponse.class);
        System.out.println("post response: " + response.getStatus());
    }
}
