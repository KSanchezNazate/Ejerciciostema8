import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Obra> obras = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("-- Menú --");
            System.out.println("1. Mostar clientes");
            System.out.println("2. Crear cliente");
            System.out.println("3. Crear obra");
            System.out.println("4. Crear pedido");
            System.out.println("5. Mostrar pedido");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println("-- Clientes --");
                    for (Cliente cliente : clientes) {

                        System.out.println(cliente.getNumeroCliente() + ". " + cliente.getNombre());
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("¿Nombre?");
                    String nombre = scanner.nextLine();
                    Cliente nuevoCliente = new Cliente(nombre);
                    clientes.add(nuevoCliente);
                    System.out.println("Cliente n.°" + nuevoCliente.getNumeroCliente() + " [" + nuevoCliente.getNombre() + "] añadido");
                    break;
                case 3:
                    System.out.println("-- Crear obra --");
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Tipo (1. Libro, 2. Video): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    if (tipo == 1) {
                        System.out.print("Número de páginas: ");
                        int numPaginas = scanner.nextInt();
                        scanner.nextLine();
                        obras.add(new Libro(titulo, autor, numPaginas));
                    } else if (tipo == 2) {
                        System.out.print("Duración (minutos): ");
                        int duracion = scanner.nextInt();
                        scanner.nextLine();
                        obras.add(new Video(titulo, autor, duracion));
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("-- Crear pedido --");
                    System.out.println("Clientes:");
                    for (Cliente cliente : clientes) {
                        System.out.println(cliente.getNumeroCliente() + ". " + cliente.getNombre());
                    }
                    System.out.print("Número de cliente: ");
                    int numeroCliente = scanner.nextInt();
                    scanner.nextLine();
                    Cliente cliente = null;
                    for (Cliente c : clientes) {
                        if (c.getNumeroCliente() == numeroCliente) {
                            cliente = c;
                            break;
                        }
                    }
                    if (cliente == null) {
                        System.out.println("Cliente no encontrado");
                    } else {
                        Pedido pedido = new Pedido(cliente);
                        int opcion2;
                        do {
                            System.out.println("Obras:");
                            for (Obra obra : obras) {
                                System.out.println(obra.getNumeroObra() + ". " + obra.getTitulo() + " de " + obra.getAutor());
                            }
                            System.out.print("Número de obra: ");
                            int numeroObra = scanner.nextInt();
                            scanner.nextLine();
                            Obra obra = null;
                            for (Obra o : obras) {
                                if (o.getNumeroObra() == numeroObra) {
                                    obra = o;
                                    break;
                                }
                            }
                            if (obra == null) {
                                System.out.println("Obra no encontrada");
                            } else {
                                pedido.agregarObra(obra);
                            }
                            System.out.print("¿Desea agregar otra obra? (1. Sí, 2. No): ");
                            opcion2 = scanner.nextInt();
                            scanner.nextLine();
                        } while (opcion2 == 1);
                        pedidos.add(pedido);
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("-- Mostrar pedido --");
                    System.out.println("Pedidos:");
                    for (Pedido pedido : pedidos) {
                        System.out.println(pedido.getNumeroPedido() + ". " + pedido.getCliente().getNombre());
                    }
                    System.out.print("Número de pedido: ");
                    int numeroPedido = scanner.nextInt();
                    scanner.nextLine();
                    Pedido pedido = null;
                    for (Pedido p : pedidos) {
                        if (p.getNumeroPedido() == numeroPedido) {
                            pedido = p;
                            break;
                        }
                    }
                    if (pedido == null) {
                        System.out.println("Pedido no encontrado");
                    } else {
                        pedido.mostrarPedido();
                    }
                    System.out.println();
                    break;
            }
        } while (opcion != 6);
    }
}