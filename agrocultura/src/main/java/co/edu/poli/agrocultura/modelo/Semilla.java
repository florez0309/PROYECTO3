package co.edu.poli.agrocultura.modelo;

/**
 * Representa una semilla agricola, la cual es un tipo de articulo
 * que se siembra para producir cultivos.
 * Extiende la clase {@link Articulo} agregando el tipo de semilla
 * y la capacidad de calcular su tiempo estimado de crecimiento.
 *
 * @author Equipo Agrocultura
 * @version 1.0
 * @since 2026-05-22
 */
public class Semilla extends Articulo {

    /**
     * Tipo de semilla segun su velocidad de crecimiento.
     * Valores posibles: "Rapido", "Medio", "Lento".
     */
    private String tipo;

    /**
     * Constructor vacio. Crea una semilla sin datos iniciales.
     */
    public Semilla() {}

    /**
     * Constructor con todos los atributos de la semilla.
     *
     * @param codigo          Codigo unico del articulo.
     * @param descripcion     Descripcion de la semilla.
     * @param stockDisponible Cantidad disponible en inventario.
     * @param fechaRegistro   Fecha de registro (formato yyyy-mm-dd).
     * @param tipo            Tipo de semilla (Rapido, Medio, Lento).
     */
    public Semilla(int codigo, String descripcion, double stockDisponible, String fechaRegistro,
                   String tipo) {
        super(codigo, descripcion, stockDisponible, fechaRegistro);
        this.tipo = tipo;
    }

    /**
     * Calcula el tiempo estimado de crecimiento en dias segun el tipo de semilla.
     * <ul>
     *   <li>Rapido: 30 dias</li>
     *   <li>Medio: 60 dias</li>
     *   <li>Lento: 120 dias</li>
     *   <li>Desconocido: 90 dias por defecto</li>
     * </ul>
     *
     * @param fechaplantado Fecha en que se planto la semilla (formato yyyy-mm-dd).
     * @return Numero de dias estimados para el crecimiento.
     */
    public int calcularTiempoCrecimiento(String fechaplantado) {
        switch (tipo.toLowerCase()) {
            case "rapido": return 30;
            case "medio":  return 60;
            case "lento":  return 120;
            default:       return 90;
        }
    }

    /**
     * Retorna la informacion completa de la semilla, incluyendo
     * la informacion base del articulo mas el tipo de semilla.
     *
     * @return String con toda la informacion de la semilla.
     */
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Tipo: " + tipo;
    }

    // ─── Getters y Setters ────────────────────────────────────────────────────

    /**
     * Retorna el tipo de la semilla.
     * @return tipo de semilla.
     */
    public String getTipo() { return tipo; }

    /**
     * Establece el tipo de la semilla.
     * @param tipo Nuevo tipo a asignar (Rapido, Medio, Lento).
     */
    public void setTipo(String tipo) { this.tipo = tipo; }
}