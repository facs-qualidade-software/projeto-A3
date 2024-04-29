package mercadinho.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DbAtualizacao {
    public static void atualizarNome(Cliente cliente, String nome) {
        atualizar(cliente.getCpf(), nome, "UPDATE clientes SET nome = ? WHERE cpf = ?");
    }

    public static void atualizarCpf(Cliente cliente, String cpf) {
        atualizar(cliente.getCpf(), cpf, "UPDATE clientes SET cpf = ? WHERE cpf = ?");
    }

    public static void atualizarDataDeNascimento(Cliente cliente, Date data_de_nascimento) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        atualizar(cliente.getCpf(), df.format(data_de_nascimento), "UPDATE clientes SET data_de_nascimento = ? WHERE id = ?");
    }

    private static void atualizar(String cpf, String parametro, String query) {
        try {
            Connection dbconn = DbConexao.conectar();
            if (dbconn != null) {
                PreparedStatement pstmt = dbconn.prepareStatement(query);
                pstmt.setString(1, parametro);
                pstmt.setString(2, cpf);
                pstmt.executeUpdate();
                dbconn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}