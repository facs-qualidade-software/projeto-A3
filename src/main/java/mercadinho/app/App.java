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

  }
}

