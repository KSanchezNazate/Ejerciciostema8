public class Cliente {
    private static int contador = 0;
    private int numeroCliente;
    private String nombre;

    public Cliente(String nombre) {
        this.numeroCliente = ++contador;
        this.nombre = nombre;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}