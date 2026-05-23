package co.edu.poli.agrocultura.servicios;

import co.edu.poli.agrocultura.modelo.Articulo;

/**
 * Interfaz que define las operaciones de manejo de archivos
 * para los articulos del sistema de agrocultura.
 * Permite convertir el estado actual de los articulos a texto (serializar)
 * y recuperarlos desde un archivo (deserealizar).
 *
 * @author Equipo Agrocultura
 * @version 1.0
 * @since 2024-01-01
 */
public interface Operacionarchivo {

    /**
     * Convierte los articulos almacenados en una representacion de texto
     * para ser guardada o mostrada.
     *
     * @return String con la informacion de todos los articulos serializados.
     */
    String serializar();

    /**
     * Recupera los articulos desde una fuente externa (archivo u otro medio)
     * y los retorna como un arreglo de objetos {@link Articulo}.
     *
     * @return Arreglo de {@link Articulo} deserializados.
     */
    Articulo[] deserealizar();
}