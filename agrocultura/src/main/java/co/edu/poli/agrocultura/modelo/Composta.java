package co.edu.poli.agrocultura.modelo;

/**
 * Representa un articulo de tipo composta, utilizado para mejorar
 * la fertilidad del suelo mediante materia organica descompuesta.
 * Extiende la clase {@link Articulo} agregando la fuente organica,
 * el tiempo de descomposicion y la unidad de medida.
 *
 * @author Equipo Agrocultura
 * @version 1.0
 * @since 2024-01-01
 */
public class Composta extends Articulo {

    /** Origen o fuente de la materia organica (ej: residuos vegetales, estiercol). */
    private String fuente;

    /** Tiempo estimado de descomposicion en dias. */
    private int tiempoDescomposicion;

    /** Unidad de medida de la composta (ej: Kg, Toneladas). */
    private String tipoUnidad;

    /**
     * Constructor vacio. Crea una composta sin datos iniciales.
     */
    public Composta() {}

    /**
     * Constructor con todos los atributos de la composta.
     *
     * @param codigo               Codigo unico del articulo.
     * @param descripcion          Descripcion de la composta.
     * @param stockDisponible      Cantidad disponible en inventario.
     * @param fechaRegistro        Fecha de registro (formato yyyy-mm-dd).
     * @param fuente               Fuente u origen de la materia organica.
     * @param tiempoDescomposicion Tiempo de descomposicion en dias.
     * @param tipoUnidad           Unidad de medida de la composta.
     */
    public Composta(int codigo, String descripcion, double stockDisponible, String fechaRegistro,
                    String fuente, int tiempoDescomposicion, String tipoUnidad) {
        super(codigo, descripcion, stockDisponible, fechaRegistro);
        this.fuente = fuente;
        this.tiempoDescomposicion = tiempoDescomposicion;
        this.tipoUnidad = tipoUnidad;
    }

    /**
     * Retorna la informacion completa de la composta, incluyendo
     * la informacion base del articulo mas fuente, tiempo de descomposicion y unidad.
     *
     * @return String con toda la informacion de la composta.
     */
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Fuente: " + fuente +
               " | Tiempo Descomposicion: " + tiempoDescomposicion + " | Unidad: " + tipoUnidad;
    }

    // ─── Getters y Setters ────────────────────────────────────────────────────

    /**
     * Retorna la fuente de la composta.
     * @return fuente u origen de la materia organica.
     */
    public String getFuente() { return fuente; }

    /**
     * Establece la fuente de la composta.
     * @param fuente Nueva fuente a asignar.
     */
    public void setFuente(String fuente) { this.fuente = fuente; }

    /**
     * Retorna el tiempo de descomposicion en dias.
     * @return tiempo de descomposicion.
     */
    public int getTiempoDescomposicion() { return tiempoDescomposicion; }

    /**
     * Establece el tiempo de descomposicion de la composta.
     * @param tiempoDescomposicion Nuevo tiempo en dias.
     */
    public void setTiempoDescomposicion(int tiempoDescomposicion) { this.tiempoDescomposicion = tiempoDescomposicion; }

    /**
     * Retorna la unidad de medida de la composta.
     * @return tipo de unidad.
     */
    public String getTipoUnidad() { return tipoUnidad; }

    /**
     * Establece la unidad de medida de la composta.
     * @param tipoUnidad Nueva unidad a asignar.
     */
    public void setTipoUnidad(String tipoUnidad) { this.tipoUnidad = tipoUnidad; }
}