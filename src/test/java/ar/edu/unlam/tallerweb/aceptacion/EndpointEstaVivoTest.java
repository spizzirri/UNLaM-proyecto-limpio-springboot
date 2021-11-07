package ar.edu.unlam.tallerweb.aceptacion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EndpointEstaVivoTest {

    @Autowired
    public TestRestTemplate restTemplate;

    @LocalServerPort
    public int puerto;

    @Test
    public void elEndpoint_estaVivo_deberiaDevolver_estoyVivo(){

        String respuesta = cuandoHagoUnaPeticionGETAEstaVivo();
        entoncesObtengoLaRespuestaEstoyVivo(respuesta);
    }

    private String cuandoHagoUnaPeticionGETAEstaVivo(){
        final String url = "http://localhost:" + puerto + "/estavivo";
        return restTemplate.getForObject(url, String.class);
    }

    private void entoncesObtengoLaRespuestaEstoyVivo(String respuesta){
        assertThat(respuesta).isEqualTo("Estoy vivo");
    }
}
