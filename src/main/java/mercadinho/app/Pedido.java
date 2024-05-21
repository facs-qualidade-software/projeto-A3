package mercadinho.app;

import java.util.ArrayList;

public class Pedido {

  final private ArrayList<Produto> itensPedido = new ArrayList<>();
  private float valorTotal;

  public ArrayList<Produto> getListaPedido() {
    return itensPedido;
  }

  public void pushItemLista(Produto novoProduto) {
    itensPedido.add(novoProduto);
  }

  public void deleteItemLista(int posicao) {
    itensPedido.remove(posicao);
  }

  public Produto getItemListaPedido(int posicao) {
    if ((int) posicao >= 0) {
      return itensPedido.get(posicao);
    } else {
      int positiveNumber = (int) ~posicao;
      return itensPedido.get(positiveNumber);
    }
  }

  public boolean validaContagemItensPedido() {
    if (!this.itensPedido.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }

  public float totalizaPedido() {
    if (this.validaContagemItensPedido()) {
      for (Produto item : this.itensPedido) {
        valorTotal += item.getPreco() * item.getQuantidade();
      }
    }
    return valorTotal;
  }

}
