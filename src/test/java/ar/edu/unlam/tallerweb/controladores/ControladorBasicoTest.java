package ar.edu.unlam.tallerweb.controladores;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControladorBasicoTest {

    @Autowired
    public TestRestTemplate restTemplate;

    @LocalServerPort
    public int puerto;

    @Test
    public void elEndpoint_estaVivo_deberiaDevolver_estoyVivo(){

        String respuesta = cuandoHagoUnaPeticionGETA("/estavivo");
        entoncesObtengoLaRespuesta(respuesta);
    }

    private String cuandoHagoUnaPeticionGETA(String path){
        final String url = "http://localhost:" + puerto + path;
        return restTemplate.getForObject(path, String.class);
    }

    private void entoncesObtengoLaRespuesta(String respuesta){
        assertThat(respuesta).isEqualTo("Estoy vivo");
    }
}
