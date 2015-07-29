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

//    @Test
//    public void testGet() throws URISyntaxException {
//        Client client = Client.create();
//        URI url = new URI("http://localhost:8080/spring/get/vincent");
//        System.out.println(url);
//        WebResource webResource = client.resource(url);
//        System.out.println(webResource.get(String.class));
//    }
//
//    @Test
//    public void testPut() throws URISyntaxException {
//        Client client = Client.create();
//        URI url = new URI("http://localhost:8080/spring/update");
//        WebResource webResource = client.resource(url);
//        MultivaluedMap putParams = new MultivaluedMapImpl();
//        putParams.add("name", "vincent4");
//        putParams.add("age", "33");
//        ClientResponse response = webResource.queryParams(putParams).put(ClientResponse.class, "foo:test");
//        System.out.println("response: " + response.toString());
//    }
//
//    @Test
//    public void testDelete () throws URISyntaxException {
//        Client client = Client.create();
//        URI url = new URI("http://localhost:8080/spring/delete/vincent4");
//        WebResource webResource = client.resource(url);
//        ClientResponse response = webResource.delete(ClientResponse.class);
//
////        MultivaluedMap putParams = new MultivaluedMapImpl();
////        putParams.add("name", "vincent4");
////        ClientResponse response = webResource.queryParams(putParams).put(ClientResponse.class, "foo:test");
//        System.out.println("response: " + response.getStatus());
//    }
//
//    @Test
//    public void testAdd () throws URISyntaxException {
//        Client client = Client.create();
//        URI url = new URI("http://localhost:8080/spring/add/vincent4/33");
//        WebResource webResource = client.resource(url);
//        ClientResponse response = webResource.post(ClientResponse.class);
//        System.out.println("aad response: " + response.getStatus());
//    }
//
//    @Test
//    public void readTest() {
//        PersonDAO personDAO = new PersonDAO();
//        Person person = personDAO.read("VincentHu");
//        System.out.println(person.getName() + person.getName());
//    }
}
