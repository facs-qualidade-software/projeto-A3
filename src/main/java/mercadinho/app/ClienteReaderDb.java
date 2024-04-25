package mercadinho.app;

public class ClienteReaderDb {

    private ControladorEntidades controladorEntidades;

    public String getNomeCompletoCliente (int ClienteId) {
        Cliente cliente = controladorEntidades.find(Cliente.class, ClienteId);
        if(cliente!= null) {
            return cliente.getNome();
        } else {
            return null;
        }
    }

    public void setControlador(ControladorEntidades controladorEntidades) {
        this.controladorEntidades = controladorEntidades;
    }
}
