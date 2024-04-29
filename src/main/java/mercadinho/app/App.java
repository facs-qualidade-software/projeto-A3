package mercadinho.app;

import java.sql.SQLException;
import java.sql.Connection;

public class App {
  public static void main(String[] args) {

    try (Connection connection = DbConexao.conectar()) {
      System.out.println("Conectado ao Banco de Dados com sucesso!");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

  }
}

