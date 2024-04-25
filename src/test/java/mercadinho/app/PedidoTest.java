package mercadinho.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

public class PedidoTest {

  @Test
  public void validaContagemItensPedidoTest() throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dataValidade = simpleDateFormat.parse("2025-05-22");
    Pedido umPedido = new Pedido();

    ProdutoPeso umProdutoPeso = new ProdutoPeso("Camil", "Arroz", (float) 5.00,
        dataValidade, (float) 1.50);
    // ProdutoUnidade umProdutoUnidade = new ProdutoUnidade("Nestlé", "Barra
    // chocolate", (float) 2.50, dataValidade,
    // (int) 1);

    umPedido.pushItemLista(umProdutoPeso);
    // umPedido.pushItemLista(umProdutoUnidade);

    assertTrue(umPedido.validaContagemItensPedido());
  }

  @Test
  public void totalizaPedidoTest() throws ParseException {
    Date dataValidade = new Date();
    Calendar calendario = Calendar.getInstance(); 
    calendario.setTime(dataValidade); 
    calendario.add(Calendar.DATE, 7);
    dataValidade = calendario.getTime();
    Pedido umPedido = new Pedido();
    float valorTotalTeste = 0;

    ProdutoPeso umProdutoPeso = new ProdutoPeso("Camil", "Arroz", (float) 5.00, dataValidade, (float) 1.50);
    ProdutoUnidade umProdutoUnidade = new ProdutoUnidade("Nestlé", "Barra chocolate", (float) 2.50, dataValidade,
        (int) 1);

    umPedido.pushItemLista(umProdutoPeso);
    umPedido.pushItemLista(umProdutoUnidade);

    if (umPedido.validaContagemItensPedido()) {
      valorTotalTeste = (float) umPedido.totalizaPedido();
    }

    assertEquals(10, (float) valorTotalTeste, 0);
  }

}
