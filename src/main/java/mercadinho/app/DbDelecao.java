package mercadinho.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

public class DbDelecao {

    private DbDelecao(){
        throw new IllegalStateException("Utility class only");
    }

    public static void deletar(Cliente cliente) {
        try(Connection dbconn = DbConexao.conectar()) {
            if (dbconn != null) {
                try(PreparedStatement pstmt = dbconn.prepareStatement("DELETE FROM clientes WHERE cpf = ?")) {
                    pstmt.setString(1, cliente.getCpf());
                    pstmt.executeUpdate();
                }
            }
        } catch (Exception e) {
            Logger.getLogger("context", String.valueOf(e));
        }
    }
}