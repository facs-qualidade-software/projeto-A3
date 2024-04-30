package mercadinho.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static java.lang.System.getenv;
import io.github.cdimascio.dotenv.Dotenv;

public class DbConexao {

    public static Connection conectar() throws SQLException {

//        Credenciais para rodar Banco de dados com arquivo .env local:
//        Dotenv dotenv = Dotenv.load();
//        String dbUrl = dotenv.get("MY_ENV_DBURL");
//        String user = dotenv.get("MY_ENV_USER");
//        String password = dotenv.get("MY_ENV_PASSWORD");

//        Credenciais para rodar Banco de dados com .env no github secrets:
        String dbUrl = getenv("MY_ENV_DBURL");
        String user = getenv("MY_ENV_USER");
        String password = getenv("MY_ENV_PASSWORD");

        try {

            return DriverManager.getConnection(dbUrl, user, password);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}