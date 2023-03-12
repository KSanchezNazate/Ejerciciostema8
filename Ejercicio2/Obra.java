public class Obra {
    private String titulo;
    private String autor;

    private int numeroObra;

    private static int contador = 0;

    public Obra(String titulo, String autor) {
        this.numeroObra = ++contador;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroObra() {
        return numeroObra;
    }
}