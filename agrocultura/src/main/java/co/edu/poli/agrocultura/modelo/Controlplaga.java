package co.edu.poli.agrocultura.modelo;

public class Controlplaga extends Articulo {
    private String plagaObjetivo;
    private String nivelToxicidad;
    private String tipoUnidad;

    public Controlplaga() {}

    public Controlplaga(int codigo, String descripcion, double stockDisponible, String fechaRegistro,
                        String plagaObjetivo, String nivelToxicidad, String tipoUnidad) {
        super(codigo, descripcion, stockDisponible, fechaRegistro);
        this.plagaObjetivo = plagaObjetivo;
        this.nivelToxicidad = nivelToxicidad;
        this.tipoUnidad = tipoUnidad;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Plaga: " + plagaObjetivo +
               " | Toxicidad: " + nivelToxicidad + " | Unidad: " + tipoUnidad;
    }

    // Getters y Setters
    public String getPlagaObjetivo() { return plagaObjetivo; }
    public void setPlagaObjetivo(String plagaObjetivo) { this.plagaObjetivo = plagaObjetivo; }

    public String getNivelToxicidad() { return nivelToxicidad; }
    public void setNivelToxicidad(String nivelToxicidad) { this.nivelToxicidad = nivelToxicidad; }

    public String getTipoUnidad() { return tipoUnidad; }
    public void setTipoUnidad(String tipoUnidad) { this.tipoUnidad = tipoUnidad; }
}