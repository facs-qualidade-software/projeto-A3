package mercadinho.app;

import java.util.Date;

import static java.lang.System.out;

public class ProdutoUnidade extends Produto {

  private int unidade;

  // Construtores
  public ProdutoUnidade() {
    super();
  }

  public ProdutoUnidade(String fabricante, String nome, float preco, Date dataValidade, int unidade) {
    super.setFabricante(fabricante);
    super.setNome(nome);
    super.setPreco((float) preco);
    super.setDataValidade(dataValidade);
    this.setQuantidade((int) unidade);
  }

  // Setters
  @Override
  public void setQuantidade(float novaUnidade) {
    if (this.validaProdutoIntNonZero((int) novaUnidade)) {
      this.unidade = (int) novaUnidade;
    } else {
      out.println("Erro: Unidade não pode ser zero ou negativo %n");
    }
  }

  // Getters
  public float getQuantidade() {
    return (float) this.unidade;
  }

  // Validações
  public boolean validaProdutoIntNonZero(int someInt) {
    if ((int) someInt > 0)
      return true;
    else
      return false;
  }
}
