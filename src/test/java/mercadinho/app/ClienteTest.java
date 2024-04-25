package mercadinho.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

  private final Cliente cliente = new Cliente();

  @Test
  public void setEGetIdTest(){
    int idGet;
    cliente.setId(1);
    idGet = cliente.getId();
    assertEquals(1, idGet);
  }

  @Test
  public void setEGetNomeTest() {
    String nomeGet;
    cliente.setNome("Luísa Ferreira");
    nomeGet = cliente.getNome();
    assertEquals("Luísa Ferreira", nomeGet);
  }

  @Test
  public void setEGetCpfTest() {
    String cpfGet;
    cliente.setCpf("123.456.789-09");
    cpfGet = cliente.getCpf();
    assertEquals("123.456.789-09", cpfGet);
  }

  @Test
  public void setEGetDataNascimentoTest() {
    Date dataGet = new Date();
    cliente.setDataNascimento(dataGet);
    dataGet = cliente.getDataNascimento();
    assertNotNull(dataGet, "Data de nascimento não definida");
  }

  @Test
  public void validaNomeClienteTrueTest() {
    final String nome = "Adrianô M´aciél";
    assertTrue(cliente.validaNomeCliente(nome));
  }

  @Test
  public void validaNomeClienteFalseTest(){
    final String nome = "C3-PO";
    assertFalse(cliente.validaNomeCliente(nome));
  }

  @Test
  public void validaCpfClienteTrueTest() {
    final String cpf = "123.456.789-09";
    assertTrue(cliente.validaCpfCliente(cpf));

  }

  @Test
  public void validaCpfClienteFalseTest() {
    final String cpf = "123.456.789-19";
    assertFalse(cliente.validaCpfCliente(cpf));
  }

  @Test
  public void validaDataNascimentoClienteTrueTest() throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dataSubmetida = simpleDateFormat.parse("2024-04-05");
    assertTrue(cliente.validaDataNascimentoCliente(dataSubmetida));
  }

  @Test
  public void validaDataNascimentoClienteFalseTest() throws ParseException {
    Date dataSubmetida = new Date();
    Calendar calendario = Calendar.getInstance(); 
    calendario.setTime(dataSubmetida); 
    calendario.add(Calendar.DATE, 1);
    dataSubmetida = calendario.getTime();
    assertFalse(cliente.validaDataNascimentoCliente(dataSubmetida));
  }
}
