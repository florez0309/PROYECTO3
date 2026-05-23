package co.edu.poli.agrocultura.modelo;

/**
 * Representa un articulo de control de plagas, utilizado para combatir
 * o prevenir insectos y organismos que danan los cultivos.
 * Extiende la clase {@link Articulo} agregando la plaga objetivo,
 * el nivel de toxicidad y la unidad de medida.
 *
 * @author Equipo Agrocultura
 * @version 1.0
 * @since 2026-05-22
 */
public class Controlplaga extends Articulo {

    /** Nombre de la plaga o insecto que este producto combate. */
    private String plagaObjetivo;

    /** Nivel de toxicidad del producto (ej: Bajo, Medio, Alto). */
    private String nivelToxicidad;

    /** Unidad de medida del producto (ej: Litros, Kg). */
    private String tipoUnidad;

    /**
     * Constructor vacio. Crea un control de plaga sin datos iniciales.
     */
    public Controlplaga() {}

    /**
     * Constructor con todos los atributos del control de plaga.
     *
     * @param codigo          Codigo unico del articulo.
     * @param descripcion     Descripcion del producto.
     * @param stockDisponible Cantidad disponible en inventario.
     * @param fechaRegistro   Fecha de registro (formato yyyy-mm-dd).
     * @param plagaObjetivo   Nombre de la plaga que combate.
     * @param nivelToxicidad  Nivel de toxicidad del producto.
     * @param tipoUnidad      Unidad de medida del producto.
     */
    public Controlplaga(int codigo, String descripcion, double stockDisponible, String fechaRegistro,
                        String plagaObjetivo, String nivelToxicidad, String tipoUnidad) {
        super(codigo, descripcion, stockDisponible, fechaRegistro);
        this.plagaObjetivo = plagaObjetivo;
        this.nivelToxicidad = nivelToxicidad;
        this.tipoUnidad = tipoUnidad;
    }

    /**
     * Retorna la informacion completa del control de plaga, incluyendo
     * la informacion base del articulo mas plaga, toxicidad y unidad.
     *
     * @return String con toda la informacion del control de plaga.
     */
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Plaga: " + plagaObjetivo +
               " | Toxicidad: " + nivelToxicidad + " | Unidad: " + tipoUnidad;
    }

    // ─── Getters y Setters ────────────────────────────────────────────────────

    /**
     * Retorna la plaga objetivo del producto.
     * @return nombre de la plaga objetivo.
     */
    public String getPlagaObjetivo() { return plagaObjetivo; }

    /**
     * Establece la plaga objetivo del producto.
     * @param plagaObjetivo Nueva plaga objetivo.
     */
    public void setPlagaObjetivo(String plagaObjetivo) { this.plagaObjetivo = plagaObjetivo; }

    /**
     * Retorna el nivel de toxicidad del producto.
     * @return nivel de toxicidad.
     */
    public String getNivelToxicidad() { return nivelToxicidad; }

    /**
     * Establece el nivel de toxicidad del producto.
     * @param nivelToxicidad Nuevo nivel de toxicidad.
     */
    public void setNivelToxicidad(String nivelToxicidad) { this.nivelToxicidad = nivelToxicidad; }

    /**
     * Retorna la unidad de medida del producto.
     * @return tipo de unidad.
     */
    public String getTipoUnidad() { return tipoUnidad; }

    /**
     * Establece la unidad de medida del producto.
     * @param tipoUnidad Nueva unidad a asignar.
     */
    public void setTipoUnidad(String tipoUnidad) { this.tipoUnidad = tipoUnidad; }
}