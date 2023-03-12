import java.util.Random;
import java.util.Scanner;

public class Dado {
    private int caras;
    private int ultimaCara;

    public Dado() {
        caras = 6;
        ultimaCara = 1;
    }

    public Dado(int caras) {
        this.caras = caras;
        ultimaCara = 1;
    }

    public int getCaras() {
        return caras;
    }

    public int getUltimaCara() {
        return ultimaCara;
    }

    public void setCaras(int caras) {
        this.caras = caras;
    }

    public int tirar() {
        Random random = new Random();
        ultimaCara = random.nextInt(caras) + 1;
        return ultimaCara;
    }
}

public class JugadorGuerra {
    private String nombre;
    private int fichas;
    private Dado dado;

    public JugadorGuerra(String nombre) {
        this.nombre = nombre;
        fichas = 10;
        dado = new Dado(6);
    }

    public int lanzarDado() {
        int resultado = dado.tirar();
        System.out.println(nombre + " ha lanzado un " + resultado);
        return resultado;
    }

    public void restarFicha() {
        fichas--;
    }

    public int getFichas() {
        return fichas;
    }

    public String getNombre() {
        return nombre;
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del primer jugador");
        JugadorGuerra jugador1 = new JugadorGuerra(scanner.nextLine());

        System.out.println("Introduce el nombre del segundo jugador");
        JugadorGuerra jugador2 = new JugadorGuerra(scanner.nextLine());


        while (jugador1.getFichas() > 0 && jugador2.getFichas() > 0) {
            int resultado1 = jugador1.lanzarDado();
            int resultado2 = jugador2.lanzarDado();

            if (resultado1 > resultado2) {
                jugador2.restarFicha();
                System.out.println(jugador1.getNombre() + " gana una ficha");
                System.out.println("Marcador: " + jugador1.getNombre() + " " + jugador1.getFichas() + " - " + jugador2.getNombre() + " " + jugador2.getFichas());
            } else if (resultado2 > resultado1) {
                jugador1.restarFicha();
                System.out.println(jugador2.getNombre() + " gana una ficha");
                System.out.println("Marcador: " + jugador1.getNombre() + " " + jugador1.getFichas() + " - " + jugador2.getNombre() + " " + jugador2.getFichas());
            } else {
                System.out.println(jugador1.getNombre() + " y " + jugador2.getNombre() + " han empatado");
            }
        }

        if (jugador1.getFichas() == 0) {
            System.out.println(jugador2.getNombre() + " ha ganado la guerra de dados");
        } else {
            System.out.println(jugador1.getNombre() + " ha ganado la guerra de dados");
        }
    }
}

