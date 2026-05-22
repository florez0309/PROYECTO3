package co.edu.poli.agrocultura.servicios;

import co.edu.poli.agrocultura.modelo.Articulo;

public interface Operacioncrud {
    String crear(Articulo articulo);
    Articulo leer(int indic);
    Articulo[] leertodo();
    String modificar(int indice, Articulo articulo);
    String eliminar(int indice);
}