package co.edu.poli.agrocultura.modelo;

public class Nutriente extends Articulo {
    private String composicion;
    private String tipoUnidad;

    public Nutriente() {}

    public Nutriente(int codigo, String descripcion, double stockDisponible, String fechaRegistro,
                     String composicion, String tipoUnidad) {
        super(codigo, descripcion, stockDisponible, fechaRegistro);
        this.composicion = composicion;
        this.tipoUnidad = tipoUnidad;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Composicion: " + composicion + " | Unidad: " + tipoUnidad;
    }

    // Getters y Setters
    public String getComposicion() { return composicion; }
    public void setComposicion(String composicion) { this.composicion = composicion; }

    public String getTipoUnidad() { return tipoUnidad; }
    public void setTipoUnidad(String tipoUnidad) { this.tipoUnidad = tipoUnidad; }
}