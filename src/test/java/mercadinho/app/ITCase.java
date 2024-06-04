package mercadinho.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

//Classe para rodar testes de integração!
public class ITCase {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @BeforeAll
    public static void DbInsercaoIntegrationTrueTest() throws ParseException {
        Date dataNascimentoCliente1 = sdf.parse("1993-10-06");
        Date dataNascimentoCliente2 = sdf.parse("2003-11-22");
        Date dataNascimentoCliente3 = sdf.parse("1997-05-30");
        Cliente clienteInsercao1 = new Cliente("Ricardo Andrade", "29461598092", dataNascimentoCliente1);
        Cliente clienteInsercao2 = new Cliente("Mariana Chaves", "12345678909", dataNascimentoCliente2);
        Cliente clienteInsercao3 = new Cliente("Rogerio Chaves", "33513222084", dataNascimentoCliente3);

        DbInsercao.inserirCliente(clienteInsercao1);
        DbInsercao.inserirCliente(clienteInsercao2);
        DbInsercao.inserirCliente(clienteInsercao3);

        ArrayList<Cliente> resultado1 = DbSelecao.selecionarNome(clienteInsercao1.getNome());
        assertEquals(clienteInsercao1.getNome(), resultado1.get(0).getNome());

        ArrayList<Cliente> resultado2 = DbSelecao.selecionarNome(clienteInsercao2.getNome());
        assertEquals(clienteInsercao2.getNome(), resultado2.get(0).getNome());

        ArrayList<Cliente> resultado3 = DbSelecao.selecionarNome(clienteInsercao3.getNome());
        assertEquals(clienteInsercao3.getNome(), resultado3.get(0).getNome());
    }

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
        String cpfTest = "33513222084";
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

    @Test
    public void DbAtualizacaoNomeIntegrationTrueTest(){
        String novoNome = "Ricardo Chaves";
        ArrayList<Cliente> resultado = DbSelecao.selecionarCpf("29461598092");
        DbAtualizacao.atualizarNome(resultado.get(0), novoNome);
        assertEquals(novoNome, DbSelecao.selecionarNome(novoNome).get(0).getNome());
    }

    @Test
    public void DbAtualizacaoCpfIntegrationTrueTest(){
        String novoCpf = "64473491005";
        ArrayList<Cliente> resultado = DbSelecao.selecionarNome("Mariana Chaves");
        DbAtualizacao.atualizarCpf(resultado.get(0), novoCpf);
        assertEquals(novoCpf, DbSelecao.selecionarCpf(novoCpf).get(0).getCpf());
    }

    @Test
    public void DbAtualizacaoDataNascimentoIntegrationTrueTest() throws ParseException {
        Date novaData = sdf.parse("1950-02-20");
        ArrayList<Cliente> resultado = DbSelecao.selecionarNome("Rogerio Chaves");
        DbAtualizacao.atualizarDataDeNascimento(resultado.get(0), novaData);
        assertEquals(0, DbSelecao.selecionarNome("Rogerio Chaves").get(0).getDataNascimento().compareTo(novaData));
    }

    @AfterAll
    public static void DbDelecaoIntegrationTrueTest(){
        ArrayList<Cliente> resultado1 = DbSelecao.selecionarNome("Ricardo Chaves");
        DbDelecao.deletar(resultado1.get(0));
        ArrayList<Cliente> resultado2 = DbSelecao.selecionarNome("Mariana Chaves");
        DbDelecao.deletar(resultado2.get(0));
        ArrayList<Cliente> resultado3 = DbSelecao.selecionarNome("Rogerio Chaves");
        DbDelecao.deletar(resultado3.get(0));

        assertTrue(DbSelecao.selecionarNome("Rogerio Chaves").isEmpty());
    }
}
