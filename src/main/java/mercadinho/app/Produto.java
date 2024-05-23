package mercadinho.app;

import java.util.Date;

import static java.lang.System.out;

public abstract class Produto {

  private String fabricante;
  private String nome;
  private float preco;
  private Date dataValidade;

  // Construtores
  protected Produto() {

  }

  protected Produto(String fabricante, String nome, float preco, Date dataValidade) {
    this.setFabricante(fabricante);
    this.setNome(nome);
    this.setPreco((float) preco);
    this.setDataValidade(dataValidade);
  }

  // Setters
  public void setFabricante(String novoFabricante) {
    if (this.validaStringsProduto(novoFabricante)) {
      this.fabricante = novoFabricante;
    } else {
      out.println("Erro: nome do fabricante não pode ser vazio %n");
    }
  }

  public void setNome(String novoNome) {
    if (this.validaStringsProduto(novoNome)) {
      this.nome = novoNome;
    } else {
      out.println("Erro: nome do produto não pode ser vazio %n");
    }
  }

  public void setPreco(float novoPreco) {
    if (this.validaProdutoFloatNonZero(novoPreco)) {
      this.preco = (float) novoPreco;
    } else {
      out.println("Erro: preço não pode ser zero ou negativo %n");
    }
  }

  public void setDataValidade(Date novaDataValidade) {
    if (this.validaDataValidade(novaDataValidade)) {
      this.dataValidade = novaDataValidade;
    } else {
      out.println("Erro: Data de validade não pode ser anterior %n");
    }
  }

  public abstract void setQuantidade(float quantidade);

  // Getters
  public String getFabricante() {
    return this.fabricante;
  }

  public String getNome() {
    return this.nome;
  }

  public float getPreco() {
    return this.preco;
  }

  public Date getDataValidade() {
    return this.dataValidade;
  }

  public abstract float getQuantidade();

  // Validações
  public boolean validaStringsProduto(String nome) {
    return !nome.trim().isEmpty();
  }

  public boolean validaProdutoFloatNonZero(float someFloat) {
    return !((float) someFloat <= 0);
  }

  public boolean validaDataValidade(Date dataSubmetida) {
    Date dataHoje = new Date();
    int resultadoComparacao = dataSubmetida.compareTo(dataHoje);

    return resultadoComparacao >= 0;
  }

}
