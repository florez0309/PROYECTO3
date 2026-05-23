package co.edu.poli.agrocultura.servicios;

import co.edu.poli.agrocultura.modelo.Articulo;

/**
 * Interfaz que define las operaciones basicas de gestion (CRUD)
 * sobre los articulos del sistema de agrocultura.
 * Cualquier clase que implemente esta interfaz debe proveer la logica
 * para crear, leer, modificar y eliminar articulos.
 *
 * @author Equipo Agrocultura
 * @version 1.0
 * @since 2026-05-22
 */
public interface Operacioncrud {

    /**
     * Agrega un nuevo articulo al sistema.
     *
     * @param articulo Objeto {@link Articulo} a registrar.
     * @return Mensaje indicando si el articulo fue creado exitosamente o si hubo un error.
     */
    String crear(Articulo articulo);

    /**
     * Busca y retorna un articulo segun su posicion en el arreglo.
     *
     * @param indic Indice de la posicion del articulo.
     * @return El {@link Articulo} encontrado, o {@code null} si no existe.
     */
    Articulo leer(int indic);

    /**
     * Retorna todos los articulos almacenados en el sistema.
     *
     * @return Arreglo con todos los objetos {@link Articulo} registrados.
     */
    Articulo[] leertodo();

    /**
     * Reemplaza el articulo en la posicion indicada por uno nuevo
     *
     * @param indice   Posicion del articulo a modificar.
     * @param articulo Nuevo objeto {@link Articulo} que reemplazara al existente.
     * @return Mensaje indicando si la modificacion fue exitosa o si hubo un error.
     */
    String modificar(int indice, Articulo articulo);

    /**
     * Elimina el articulo en la posicion indicada.
     *
     * @param indice Posicion del articulo a eliminar.
     * @return Mensaje indicando si la eliminacion fue exitosa o si hubo un error.
     */
    String eliminar(int indice);
}