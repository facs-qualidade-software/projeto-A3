package mercadinho.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DbTest {

    private ClienteReaderDb clienteReaderDb;

    private ControladorEntidades controladorEntidades;

    @BeforeEach
    public void setup(){
        clienteReaderDb = new ClienteReaderDb();
        controladorEntidades = mock(ControladorEntidades.class);
        clienteReaderDb.setControlador(controladorEntidades);

    }

    @Test
    public void clienteReaderDbFoundTest() {
        Cliente cliente = new Cliente();
        cliente.setNome("Maria Antônia");

        when(controladorEntidades.find(Cliente.class, 1)).thenReturn(cliente);

        String nome = clienteReaderDb.getNomeCompletoCliente(1);
        assertEquals("Maria Antônia", nome);

    }

    @Test
    public void clienteReaderDbNotFoundTest() {
        when(controladorEntidades.find(Cliente.class, 1)).thenReturn(null);

        String nome = clienteReaderDb.getNomeCompletoCliente(1);
        assertNull(nome);
    }

}

