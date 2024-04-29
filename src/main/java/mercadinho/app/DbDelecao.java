package mercadinho.app;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DbDelecao {
    public static void deletar(Cliente cliente) {
        try {
            Connection dbconn = DbConexao.conectar();
            if (dbconn != null) {
                PreparedStatement pstmt = dbconn.prepareStatement(
                        "DELETE FROM clientes WHERE cpf = ?");
                pstmt.setString(1, cliente.getCpf());
                pstmt.executeUpdate();
                dbconn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}