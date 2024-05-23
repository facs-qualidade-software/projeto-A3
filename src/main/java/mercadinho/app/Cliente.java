package mercadinho.app;

import java.util.Date;
import java.util.regex.*;
import static java.lang.System.out;

public class Cliente {

  private int id;
  private String nome;
  private String cpf;
  private Date dataNascimento;

  // Construtores
  public Cliente() {

  }

  public Cliente(String nome, String cpf, Date dataNascimento) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
  }

  public Cliente(int id, String nome, String cpf, Date dataNascimento) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
  }

  // Setters:
  public void setId(int id) {
    if(this.validaIdCliente(id)) {
      this.id = id;
    }
  }

  public void setNome(String novoNome) {
    if (!novoNome.trim().isEmpty()) {
      if (this.validaNomeCliente(novoNome)) {
        this.nome = novoNome;
      } else {
        out.println("Erro: Nome não pode conter dígitos %n");
      }
    } else {
      out.println("Erro: nome não pode ser vazio %n");
    }

  }

  public void setCpf(String novoCpf) {
    if (!novoCpf.trim().isEmpty()) {
      if (this.validaCpfCliente(novoCpf)) {
        this.cpf = novoCpf;
      } else {
        out.println("Erro: CPF incorreto. Informe novamente %n");
      }
    } else {
      out.println("Erro: CPF não pode ser vazio %n");
    }
  }

  public void setDataNascimento(Date novoDataNascimento) {
    if (this.validaDataNascimentoCliente(novoDataNascimento)) {
      this.dataNascimento = novoDataNascimento;
    } else {
      out.println("Erro: Data de nascimento não pode ser futura %n");
    }
  }

  // Getters:
  public int getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public Date getDataNascimento() {
    return this.dataNascimento;
  }

  // Validações
  public boolean validaIdCliente(int id){
    return id > 0;
  }

  public boolean validaNomeCliente(String nome) {
    String regex = "\\d";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(nome);
    boolean resultado = matcher.find();

    return !resultado;
  }

  public boolean validaCpfCliente(String cpf) {

    int soma = 0;
    int resto;
    String regex = "[^\\d]";
    cpf = cpf.replaceAll(regex, "");

    if (cpf.length() != 11)
    // || "/^(\d)\1{10}$/.test(cpf))
    {
      return false;
    }

    for (int i = 1; i <= 9; i++) {
      soma += Integer.parseInt(cpf.substring(i - 1, i)) * (11 - i);
    }

    resto = (soma * 10) % 11;

    if (resto == 10 || resto == 11) {
      resto = 0;
    }

    if (resto != Integer.parseInt(cpf.substring(9, 10))) {
      return false;
    }

    soma = 0;

    for (int i = 1; i <= 10; i++) {
      soma += Integer.parseInt(cpf.substring(i - 1, i)) * (12 - i);
    }

    resto = (soma * 10) % 11;

    if (resto == 10 || resto == 11) {
      resto = 0;
    }

    return resto == Integer.parseInt(cpf.substring(10, 11));
  }

  public boolean validaDataNascimentoCliente(Date dataSubmetida) {
    Date dataHoje = new Date();
    int resultadoComparacao = dataSubmetida.compareTo(dataHoje);

    return resultadoComparacao < 1;
  }
}
