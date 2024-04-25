package mercadinho.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutosTest {

  private final ProdutoPeso produtoPeso = new ProdutoPeso();
  private final ProdutoUnidade produtoUnidade = new ProdutoUnidade();

  @Test
  public void setEGetFabricanteTest() {
    String fabricanteGet;
    produtoPeso.setFabricante("Camil");
    fabricanteGet = produtoPeso.getFabricante();
    assertEquals("Camil", fabricanteGet, "Nome incorreto");

  }

  @Test
  public void setEGetNomeTest() {
    String nomeGet;
    produtoPeso.setNome("Arroz parbolizado");
    nomeGet = produtoPeso.getNome();
    assertEquals("Arroz parbolizado",nomeGet, "Nome incorreto");
  }

  @Test
  public void setEGetPrecoTest() {
    float precoGet;
    produtoPeso.setPreco((float) 7.50);
    precoGet = produtoPeso.getPreco();
    assertEquals((float)7.50, precoGet);
  }

  @Test
  public void setEGetDataValidadeTest() {
    Date dataGet = new Date();
    produtoPeso.setDataValidade(dataGet);
    dataGet = produtoPeso.getDataValidade();
    assertNotNull(dataGet, "Data de validade não definida");
  }

  @Test
  public void setEGetPesoTest() {
    float pesoGet;
    produtoPeso.setQuantidade((float) 1.00);
    pesoGet = produtoPeso.getQuantidade();
    assertEquals(1.00, pesoGet);
  }

  @Test
  public void setEGetUnidadeTest() {
    int unidadeGet;
    produtoUnidade.setQuantidade((int) 5);
    unidadeGet = (int) produtoUnidade.getQuantidade();
    assertEquals(5, unidadeGet);
  }

  @Test
  public void validaStringsProdutoTrueTest() {
    final String stringTest = "Nestlé";
    assertTrue(produtoPeso.validaStringsProduto(stringTest));
  }

  @Test
  public void validaStringsProdutoFalseTeste(){
    final String stringTest = "     ";
    assertFalse(produtoPeso.validaStringsProduto(stringTest));
  }

  @Test
  public void validaDataValidadeTrueTest() throws ParseException {
    Date dataSubmetida = new Date();
    Calendar calendario = Calendar.getInstance(); 
    calendario.setTime(dataSubmetida); 
    calendario.add(Calendar.DATE, 1);
    dataSubmetida = calendario.getTime();
    assertTrue(produtoPeso.validaDataValidade(dataSubmetida));
  }

  @Test
  public void validaDataValidadeFalseTest() throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dataSubmetida = simpleDateFormat.parse("2023-04-25");
    assertFalse(produtoPeso.validaDataValidade(dataSubmetida));
  }

  @Test
  public void validaProdutoFloatNonZeroTrueTest() {
    final float someFloat = (float) 10.23;
    assertTrue(produtoPeso.validaProdutoFloatNonZero(someFloat));
  }

  @Test
  public void validaProdutoFloatNonZeroFalseTest() {
    final float someFloat = (float) 0.0;
    assertFalse(produtoPeso.validaProdutoFloatNonZero(someFloat));
  }

  @Test
  public void validaProdutoIntNonZeroTrueTest() {
    final int someInt = (int) 3;
    assertTrue(produtoUnidade.validaProdutoIntNonZero(someInt));
  }

  @Test
  public void validaProdutoIntNonZeroFalseTest() {
    final int someInt = (int) 0;
    assertFalse(produtoUnidade.validaProdutoIntNonZero(someInt));
  }
}
