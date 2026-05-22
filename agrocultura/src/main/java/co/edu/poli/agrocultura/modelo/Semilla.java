package co.edu.poli.agrocultura.modelo;

public class Semilla extends Articulo {
    private String tipo;

    public Semilla() {}

    public Semilla(int codigo, String descripcion, double stockDisponible, String fechaRegistro,
                   String tipo) {
        super(codigo, descripcion, stockDisponible, fechaRegistro);
        this.tipo = tipo;
    }

    public int calcularTiempoCrecimiento(String fechaplantado) {
        // Lógica de ejemplo: retorna días estimados según tipo de semilla
        switch (tipo.toLowerCase()) {
            case "rapido": return 30;
            case "medio":  return 60;
            case "lento":  return 120;
            default:       return 90;
        }
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Tipo: " + tipo;
    }

    // Getters y Setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}