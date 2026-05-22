package co.edu.poli.agrocultura.servicios;

import co.edu.poli.agrocultura.modelo.Articulo;

public interface Operacionarchivo {
    String serializar();
    Articulo[] deserealizar();
}