package mercadinho.app;

import java.sql.SQLException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
  public static void main(String[] args) throws ParseException {

    try (Connection connection = DbConexao.conectar()) {
      System.out.println("Conectado com sucesso!");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date data_nascimento = sdf.parse("2003-11-22");
    Cliente cliente = new Cliente("Mariana Chaves", "12345678909", data_nascimento);

    DbInsercao.inserirCliente(cliente);
//    DbDelecao.deletar(cliente);

  }
}

