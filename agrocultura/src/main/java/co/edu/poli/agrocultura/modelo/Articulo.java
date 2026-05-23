package co.edu.poli.agrocultura.modelo;

/**
 * Clase base que representa un articulo generico del sistema de agrocultura.
 * Contiene los atributos comunes que comparten todos los tipos de articulos
 * como semillas, composta, nutrientes y control de plagas.
 *
 * @author Equipo Agrocultura
 * @version 1.0
 * @since 2026-05-22
 */
public class Articulo {

    /** Codigo unico que identifica al articulo. */
    private int codigo;

    /** Descripcion breve del articulo. */
    private String descripcion;

    /** Cantidad disponible en inventario. */
    private double stockDisponible;

    /** Fecha en que se registro el articulo (formato yyyy-mm-dd). */
    private String fechaRegistro;

    /**
     * Constructor vacio. Crea un articulo sin datos iniciales.
     */
    public Articulo() {}

    /**
     * Constructor con todos los atributos del articulo.
     *
     * @param codigo          Codigo unico del articulo.
     * @param descripcion     Descripcion del articulo.
     * @param stockDisponible Cantidad disponible en inventario.
     * @param fechaRegistro   Fecha de registro (formato yyyy-mm-dd).
     */
    public Articulo(int codigo, String descripcion, double stockDisponible, String fechaRegistro) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.stockDisponible = stockDisponible;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Retorna una cadena con la informacion basica del articulo.
     *
     * @return String con codigo, descripcion, stock y fecha de registro.
     */
    public String mostrarInfo() {
        return "Codigo: " + codigo + " | Descripcion: " + descripcion +
               " | Stock: " + stockDisponible + " | Fecha: " + fechaRegistro;
    }

    /**
     * Retorna la cantidad disponible en inventario.
     *
     * @return Stock disponible como valor double.
     */
    public double obtenerStock() {
        return stockDisponible;
    }

    // ─── Getters y Setters ────────────────────────────────────────────────────

    /**
     * Retorna el codigo del articulo.
     * @return codigo del articulo.
     */
    public int getCodigo() { return codigo; }

    /**
     * Establece el codigo del articulo.
     * @param codigo Nuevo codigo a asignar.
     */
    public void setCodigo(int codigo) { this.codigo = codigo; }

    /**
     * Retorna la descripcion del articulo.
     * @return descripcion del articulo.
     */
    public String getDescripcion() { return descripcion; }

    /**
     * Establece la descripcion del articulo.
     * @param descripcion Nueva descripcion a asignar.
     */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    /**
     * Retorna el stock disponible del articulo.
     * @return stock disponible.
     */
    public double getStockDisponible() { return stockDisponible; }

    /**
     * Establece el stock disponible del articulo.
     * @param stockDisponible Nuevo valor de stock.
     */
    public void setStockDisponible(double stockDisponible) { this.stockDisponible = stockDisponible; }

    /**
     * Retorna la fecha de registro del articulo.
     * @return fecha de registro en formato yyyy-mm-dd.
     */
    public String getFechaRegistro() { return fechaRegistro; }

    /**
     * Establece la fecha de registro del articulo.
     * @param fechaRegistro Nueva fecha en formato yyyy-mm-dd.
     */
    public void setFechaRegistro(String fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}