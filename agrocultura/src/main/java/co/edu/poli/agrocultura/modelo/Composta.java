package co.edu.poli.agrocultura.modelo;

public class Composta extends Articulo {
    private String fuente;
    private int tiempoDescomposicion;
    private String tipoUnidad;

    public Composta() {}

    public Composta(int codigo, String descripcion, double stockDisponible, String fechaRegistro,
                    String fuente, int tiempoDescomposicion, String tipoUnidad) {
        super(codigo, descripcion, stockDisponible, fechaRegistro);
        this.fuente = fuente;
        this.tiempoDescomposicion = tiempoDescomposicion;
        this.tipoUnidad = tipoUnidad;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Fuente: " + fuente +
               " | Tiempo Descomposicion: " + tiempoDescomposicion + " | Unidad: " + tipoUnidad;
    }

    // Getters y Setters
    public String getFuente() { return fuente; }
    public void setFuente(String fuente) { this.fuente = fuente; }

    public int getTiempoDescomposicion() { return tiempoDescomposicion; }
    public void setTiempoDescomposicion(int tiempoDescomposicion) { this.tiempoDescomposicion = tiempoDescomposicion; }

    public String getTipoUnidad() { return tipoUnidad; }
    public void setTipoUnidad(String tipoUnidad) { this.tipoUnidad = tipoUnidad; }
}