package ar.edu.unlam.tallerweb.aceptacion;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AcceptanceTest {

    @LocalServerPort
    private int port;
    protected String url;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Before
    public void init(){
        url = "http://localhost:" + port;
    }

    protected <T> List<T> getForObject(String uri, ParameterizedTypeReference<List<T>> responseType){
        return restTemplate.exchange(uri, HttpMethod.GET, null, responseType).getBody();
    }
}