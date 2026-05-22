package co.edu.poli.agrocultura.servicios;

import co.edu.poli.agrocultura.modelo.Articulo;

public class Implementacionoperacioncrud implements Operacioncrud, Operacionarchivo {

    private Articulo[] arregloobjetos = new Articulo[2];

    // ── OperacionCRUD ──────────────────────────────────────────────────────────

    @Override
    public String crear(Articulo articulo) {
        for (int i = 0; i < arregloobjetos.length; i++) {
            if (arregloobjetos[i] == null) {
                arregloobjetos[i] = articulo;
                return "Articulo creado en posicion " + i;
            }
        }
        return "Error: arreglo lleno, no se puede agregar el articulo.";
    }

    @Override
    public Articulo leer(int indic) {
        if (indic >= 0 && indic < arregloobjetos.length) {
            return arregloobjetos[indic];
        }
        return null;
    }

    @Override
    public Articulo[] leertodo() {
        return arregloobjetos;
    }

    @Override
    public String modificar(int indice, Articulo articulo) {
        if (indice >= 0 && indice < arregloobjetos.length) {
            arregloobjetos[indice] = articulo;
            return "Articulo modificado en posicion " + indice;
        }
        return "Error: indice fuera de rango.";
    }

    @Override
    public String eliminar(int indice) {
        if (indice >= 0 && indice < arregloobjetos.length) {
            arregloobjetos[indice] = null;
            return "Articulo eliminado en posicion " + indice;
        }
        return "Error: indice fuera de rango.";
    }

    // ── OperacionArchivo ───────────────────────────────────────────────────────

    @Override
    public String serializar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arregloobjetos.length; i++) {
            if (arregloobjetos[i] != null) {
                sb.append("[").append(i).append("] ").append(arregloobjetos[i].mostrarInfo()).append("\n");
            }
        }
        return sb.length() > 0 ? sb.toString() : "No hay articulos para serializar.";
    }

    @Override
    public Articulo[] deserealizar() {
        // Implementacion basica: retorna el arreglo actual
        return arregloobjetos;
    }

    // Getter del arreglo (util para la vista)
    public Articulo[] getArregloobjetos() {
        return arregloobjetos;
    }
}