package co.edu.poli.agrocultura.servicios;

import co.edu.poli.agrocultura.modelo.Articulo;

/**
 * Clase que implementa las interfaces {@link Operacioncrud} y {@link Operacionarchivo}.
 * Gestiona un arreglo fijo de dos articulos y provee todas las operaciones
 * CRUD sobre ellos, ademas de la serializacion y deserializacion basica.
 *
 * @author Equipo Agrocultura
 * @version 1.0
 * @since 2026-05-22
 */
public class Implementacionoperacioncrud implements Operacioncrud, Operacionarchivo {

    /**
     * Arreglo que almacena hasta 2 articulos en memoria.
     * Las posiciones vacias tienen valor {@code null}.
     */
    private Articulo[] arregloobjetos = new Articulo[2];

    // ─── Operacioncrud ────────────────────────────────────────────────────────

    /**
     * Agrega un articulo en la primera posicion disponible del arreglo.
     * Si el arreglo esta lleno, retorna un mensaje de error.
     *
     * @param articulo Objeto {@link Articulo} a registrar.
     * @return Mensaje con la posicion donde fue creado, o mensaje de error si esta lleno.
     */
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

    /**
     * Retorna el articulo ubicado en la posicion indicada.
     * Si el indice esta fuera de rango, retorna {@code null}.
     *
     * @param indic Indice de la posicion a consultar.
     * @return El {@link Articulo} en esa posicion, o {@code null} si no existe.
     */
    @Override
    public Articulo leer(int indic) {
        if (indic >= 0 && indic < arregloobjetos.length) {
            return arregloobjetos[indic];
        }
        return null;
    }

    /**
     * Retorna el arreglo completo con todos los articulos registrados.
     * Las posiciones sin articulo tendran valor {@code null}.
     *
     * @return Arreglo de {@link Articulo} con todos los registros.
     */
    @Override
    public Articulo[] leertodo() {
        return arregloobjetos;
    }

    /**
     * Reemplaza el articulo en la posicion indicada por el nuevo articulo recibido.
     * Si el indice esta fuera de rango, retorna un mensaje de error.
     *
     * @param indice   Posicion del articulo a modificar.
     * @param articulo Nuevo {@link Articulo} que reemplazara al existente.
     * @return Mensaje de exito o de error si el indice es invalido.
     */
    @Override
    public String modificar(int indice, Articulo articulo) {
        if (indice >= 0 && indice < arregloobjetos.length) {
            arregloobjetos[indice] = articulo;
            return "Articulo modificado en posicion " + indice;
        }
        return "Error: indice fuera de rango.";
    }

    /**
     * Elimina el articulo en la posicion indicada asignando {@code null} en esa posicion.
     * Si el indice esta fuera de rango, retorna un mensaje de error.
     *
     * @param indice Posicion del articulo a eliminar.
     * @return Mensaje de exito o de error si el indice es invalido.
     */
    @Override
    public String eliminar(int indice) {
        if (indice >= 0 && indice < arregloobjetos.length) {
            arregloobjetos[indice] = null;
            return "Articulo eliminado en posicion " + indice;
        }
        return "Error: indice fuera de rango.";
    }

    // ─── Operacionarchivo ─────────────────────────────────────────────────────

    /**
     * Genera una representacion en texto de todos los articulos no nulos
     * almacenados en el arreglo, indicando su posicion.
     * Si no hay articulos, retorna un mensaje informativo.
     *
     * @return String con la informacion de cada articulo, uno por linea.
     */
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

    /**
     * Retorna el arreglo actual de articulos como simulacion de una deserializacion.
     * En una implementacion real, este metodo leeria los datos desde un archivo.
     *
     * @return Arreglo de {@link Articulo} con los registros actuales en memoria.
     */
    @Override
    public Articulo[] deserealizar() {
        return arregloobjetos;
    }

    /**
     * Retorna directamente el arreglo interno de articulos.
     * Util para acceder al estado completo desde la capa de vista.
     *
     * @return Arreglo interno de {@link Articulo}.
     */
    public Articulo[] getArregloobjetos() {
        return arregloobjetos;
    }
}