public class Pelicula {
    private int numeroID;
    private String titulo;
    private String director;
    private String genero;
    private int anio;
    private int meGusta;

    public Pelicula(int numeroID, String titulo, String director, String genero, int anio, int meGusta) {
        this.numeroID = numeroID;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.anio = anio;
        this.meGusta = meGusta;
    }

    public int getNumeroID() {
        return numeroID;
    }

    public void setNumeroID(int numeroID) {
        this.numeroID = numeroID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }

    @Override
    public String toString() {
        return "Pelicula " +
                "numeroID: " + numeroID +
                ", titulo: '" + titulo + '\'' +
                ", director: '" + director + '\'' +
                ", genero: '" + genero + '\'' +
                ", anio: " + anio +
                ", meGusta: " + meGusta;
    }
}
