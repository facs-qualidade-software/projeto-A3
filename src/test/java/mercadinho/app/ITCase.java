package mercadinho.app;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

//Classe para rodar testes de integração!
public class ITCase {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void DbSelecaoNomeIntegrationTrueTest() {
        String nomeTeste = "Mariana Chaves";
        ArrayList<Cliente> resultado = DbSelecao.selecionarNome(nomeTeste);
        assertEquals(nomeTeste, resultado.get(0).getNome());
    }

    @Test
    public void DbSelecaoNomeIntegrationFalseTest() {
        String nomeTeste = "Ricardo Menezes";
        ArrayList<Cliente> resultado = DbSelecao.selecionarNome(nomeTeste);
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void DbSelecaoCpfIntegrationTrueTest() {
        String cpfTest = "12345678909";
        ArrayList<Cliente> resultado = DbSelecao.selecionarCpf(cpfTest);
        assertEquals(cpfTest, resultado.get(0).getCpf());
    }

    @Test
    public void DbSelecaoCpfIntegrationFalseTest() {
        String cpfTest = "04378825279";
        ArrayList<Cliente> resultado = DbSelecao.selecionarCpf(cpfTest);
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void DbSelecaoDataDeNascimentoIntegrationTrueTest() {
        String dataNascimentoTest = "2003-11-22";
        ArrayList<Cliente> resultado = DbSelecao.selecionarDataDeNascimento(dataNascimentoTest);
        assertEquals(dataNascimentoTest, sdf.format(resultado.get(0).getDataNascimento()));
    }

    @Test
    public void DbSelecaoDataDeNascimentoIntegrationFalseTest() {
        String dataNascimentoTest = "1990-06-06";
        ArrayList<Cliente> resultado = DbSelecao.selecionarDataDeNascimento(dataNascimentoTest);
        assertTrue(resultado.isEmpty());
    }

}
