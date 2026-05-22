package co.edu.poli.agrocultura.modelo;

public class Articulo {
    private int codigo;
    private String descripcion;
    private double stockDisponible;
    private String fechaRegistro;

    public Articulo() {}

    public Articulo(int codigo, String descripcion, double stockDisponible, String fechaRegistro) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.stockDisponible = stockDisponible;
        this.fechaRegistro = fechaRegistro;
    }

    public String mostrarInfo() {
        return "Codigo: " + codigo + " | Descripcion: " + descripcion +
               " | Stock: " + stockDisponible + " | Fecha: " + fechaRegistro;
    }

    public double obtenerStock() {
        return stockDisponible;
    }

    // Getters y Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getStockDisponible() { return stockDisponible; }
    public void setStockDisponible(double stockDisponible) { this.stockDisponible = stockDisponible; }

    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(String fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}