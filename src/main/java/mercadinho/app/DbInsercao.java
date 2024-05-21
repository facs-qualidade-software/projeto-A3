package mercadinho.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DbInsercao {

    private DbInsercao(){
      throw new IllegalStateException("Utility class only");
    };

    public static void inserirCliente(Cliente cliente) {
        try (Connection dbconn = DbConexao.conectar()) {
            if (dbconn != null) {
                try(PreparedStatement pstmt = dbconn.prepareStatement("INSERT INTO clientes (nome, cpf, data_de_nascimento) VALUES (?, ?, ?)")) {
                    pstmt.setString(1, cliente.getNome());
                    pstmt.setString(2, cliente.getCpf());
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    pstmt.setString(3, df.format(cliente.getDataNascimento()));
                    pstmt.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}