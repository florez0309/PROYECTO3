package co.edu.poli.agrocultura.modelo;

/**
 * Representa un nutriente agricola, el cual es un tipo de articulo
 * que se usa para mejorar la calidad del suelo o de los cultivos.
 * Extiende la clase {@link Articulo} agregando composicion y unidad de medida.
 *
 * @author Equipo Agrocultura
 * @version 1.0
 * @since 2026-05-22
 */
public class Nutriente extends Articulo {

    /** Composicion quimica o biologica del nutriente. */
    private String composicion;

    /** Unidad de medida del nutriente (por ejemplo: Kg, Litros). */
    private String tipoUnidad;

    /**
     * Constructor vacio. Crea un nutriente sin datos iniciales.
     */
    public Nutriente() {}

    /**
     * Constructor con todos los atributos del nutriente.
     *
     * @param codigo          Codigo unico del articulo.
     * @param descripcion     Descripcion del nutriente.
     * @param stockDisponible Cantidad disponible en inventario.
     * @param fechaRegistro   Fecha de registro (formato yyyy-mm-dd).
     * @param composicion     Composicion del nutriente.
     * @param tipoUnidad      Unidad de medida del nutriente.
     */
    public Nutriente(int codigo, String descripcion, double stockDisponible, String fechaRegistro,
                     String composicion, String tipoUnidad) {
        super(codigo, descripcion, stockDisponible, fechaRegistro);
        this.composicion = composicion;
        this.tipoUnidad = tipoUnidad;
    }

    /**
     * Retorna la informacion completa del nutriente, incluyendo
     * la informacion base del articulo mas composicion y unidad.
     *
     * @return String con toda la informacion del nutriente.
     */
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Composicion: " + composicion + " | Unidad: " + tipoUnidad;
    }

    // ─── Getters y Setters ────────────────────────────────────────────────────

    /**
     * Retorna la composicion del nutriente.
     * @return composicion del nutriente.
     */
    public String getComposicion() { return composicion; }

    /**
     * Establece la composicion del nutriente.
     * @param composicion Nueva composicion a asignar.
     */
    public void setComposicion(String composicion) { this.composicion = composicion; }

    /**
     * Retorna la unidad de medida del nutriente.
     * @return tipo de unidad.
     */
    public String getTipoUnidad() { return tipoUnidad; }

    /**
     * Establece la unidad de medida del nutriente.
     * @param tipoUnidad Nueva unidad a asignar.
     */
    public void setTipoUnidad(String tipoUnidad) { this.tipoUnidad = tipoUnidad; }
}