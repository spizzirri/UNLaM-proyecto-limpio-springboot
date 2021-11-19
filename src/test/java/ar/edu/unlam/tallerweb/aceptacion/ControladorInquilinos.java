package ar.edu.unlam.tallerweb.aceptacion;
import ar.edu.unlam.tallerweb.modelos.Inquilino;
import org.junit.After;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ControladorInquilinos extends AcceptanceTest{

    @After
    public void limpiarDatos(){

    }

    @Test
    @Sql(value = "/sql/borrarDatos.sql")
    public void deberiaDevolverUnInquilinoCuandoConsultoElEndpointGETInquilinosYSoloHayUnInquilinoCargado(){

        dadoQueHaySoloUnInquilinoCargado();
        List<Inquilino> inquilinos = cuandoConsultaElEndpointGETInquilinos();
        entoncesObtengoSoloUnInquilino(inquilinos);
    }

    @Test
    @Sql(value = "/sql/borrarDatos.sql")
    public void deberiaDevolverUnArregloVacioCuandoConsultoElEndpointGETInquilinosYNoHayInquilinosCargados(){

        dadoQueNoHayInquilinosCargados();
        List<Inquilino> inquilinos = cuandoConsultaElEndpointGETInquilinos();
        entoncesNoObtengoInquilinos(inquilinos);
    }

    @Test
    @Sql(value = "/sql/borrarDatos.sql")
    public void deberiaDevoler204SiElEndpointRespondeSinDatos(){
        dadoQueNoHayInquilinosCargados();
        int respuesta = cuandoConsultaElEndpointGETInquilinosYObtengoElCodigoDeRespuesta();
        entoncesSeObtieneElCodigo204(respuesta);
    }

    private void entoncesSeObtieneElCodigo204(int respuesta){
        assertThat(respuesta).isEqualTo(204);
    }

    private void dadoQueHaySoloUnInquilinoCargado() {
        Inquilino inquilinoEjemplo1 = new Inquilino();
        inquilinoEjemplo1.setNombre("Ruben");
        this.restTemplate.postForObject(this.url + "/inquilinos", inquilinoEjemplo1, Long.class);
    }

    private void entoncesObtengoSoloUnInquilino(List<Inquilino> inquilinos){
        assertThat(inquilinos).hasSize(1);
    }

    private void dadoQueNoHayInquilinosCargados() {
    }

    private int cuandoConsultaElEndpointGETInquilinosYObtengoElCodigoDeRespuesta(){
        return this.restTemplate.getForEntity(this.url + "/inquilinos", List.class).getStatusCodeValue();
    }

    private List<Inquilino> cuandoConsultaElEndpointGETInquilinos(){
        return this.restTemplate.getForObject(this.url + "/inquilinos", List.class);
    }

    private void entoncesNoObtengoInquilinos(List<Inquilino> inquilinos){
        assertThat(inquilinos).isNull();
    }
}
