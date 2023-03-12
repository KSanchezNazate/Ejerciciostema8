import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Obra> obrasCompradas;

    private static int contador = 0;
    private int numeroPedido;

    public Pedido(Cliente cliente) {
        this.numeroPedido = ++contador;
        this.cliente = cliente;
        obrasCompradas = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Obra> getObrasCompradas() {
        return obrasCompradas;
    }

    public void agregarObra(Obra obra) {
        obrasCompradas.add(obra);
    }

    public void mostrarPedido() {
        System.out.println("Pedido del cliente " + cliente.getNombre());
        for (Obra obra : obrasCompradas) {
            if (obra instanceof Libro) {
                Libro libro = (Libro) obra;
                System.out.println("- Libro: " + libro.getTitulo() + " de " + libro.getAutor() + " (" + libro.getNumPaginas() + " páginas)");
            } else if (obra instanceof Video) {
                Video video = (Video) obra;
                System.out.println("- Video: " + video.getTitulo() + " de " + video.getAutor() + " (" + video.getDuracion() + " minutos)");
            }
        }
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }
}