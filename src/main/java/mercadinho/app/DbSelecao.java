package mercadinho.app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;

public class DbSelecao {
    public static ArrayList<String[]> selecionarNome(String nome) {
        return selecionar(nome, "SELECT * FROM clientes WHERE nome = ?");
    }

    public static ArrayList<String[]> selecionarCpf(String cpf) {
        return selecionar(cpf, "SELECT * FROM clientes WHERE cpf = ?");
    }

    public static ArrayList<String[]> selecionarDataDeNascimento(String data_de_nascimento) {
        return selecionar(data_de_nascimento, "SELECT * FROM clientes WHERE data_de_nascimento = ?");
    }

    private static ArrayList<String[]> selecionar(String parametro, String query) {
        ArrayList<String[]> listaDeResultados = new ArrayList<>();
        try {
            Connection dbconn = DbConexao.conectar();
            if (dbconn != null) {
                PreparedStatement pstmt = dbconn.prepareStatement(query);
                pstmt.setString(1, parametro);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    listaDeResultados.add(new String[]{
                            String.valueOf(rs.getInt("id")),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("data_de_nascimento")
                    });
                }
                dbconn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDeResultados;
    }
}