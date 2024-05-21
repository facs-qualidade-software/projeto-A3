package mercadinho.app;

import java.util.Date;

import static java.lang.System.out;

public class ProdutoPeso extends Produto {

  private float peso;

  // Construtores
  public ProdutoPeso() {
    super();
  }

  public ProdutoPeso(String fabricante, String nome, float preco, Date dataValidade, float peso) {
    super.setFabricante(fabricante);
    super.setNome(nome);
    super.setPreco((float) preco);
    super.setDataValidade(dataValidade);
    this.setQuantidade((float) peso);
  }

  // Setters
  @Override
  public void setQuantidade(float novoPeso) {
    if (this.validaProdutoFloatNonZero(novoPeso)) {
      this.peso = (float) novoPeso;
    } else {
      out.println("Erro: peso não pode ser zero ou negativo %n");
    }
  }

  // Getters
  public float getQuantidade() {
    return this.peso;
  }
}
