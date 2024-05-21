package mercadinho.app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Connection;

public class DbSelecao {

    private DbSelecao(){
        throw new IllegalStateException("Utility class only");
    }

    public static ArrayList<Cliente> selecionarNome(String nome) {
        return selecionar(nome, "SELECT * FROM clientes WHERE nome = ?");
    }

    public static ArrayList<Cliente> selecionarCpf(String cpf) {
        return selecionar(cpf, "SELECT * FROM clientes WHERE cpf = ?");
    }

    public static ArrayList<Cliente> selecionarDataDeNascimento(String data_de_nascimento) {
        return selecionar(data_de_nascimento, "SELECT * FROM clientes WHERE data_de_nascimento = ?");
    }

    private static ArrayList<Cliente> selecionar(String parametro, String query) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<Cliente> listaDeResultados = new ArrayList<>();

        try (Connection dbconn = DbConexao.conectar()) {
            if (dbconn != null) {
                PreparedStatement pstmt = dbconn.prepareStatement(query);
                pstmt.setString(1, parametro);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    listaDeResultados.add(
                            new Cliente(
                                    rs.getInt("id"),
                                    rs.getString("nome"),
                                    rs.getString("cpf" ),
                                    sdf.parse(rs.getString("data_de_nascimento"))
                                        ){
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDeResultados;
    }
}