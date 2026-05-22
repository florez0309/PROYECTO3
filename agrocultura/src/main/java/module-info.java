module co.edu.poli.agrocultura {
    requires javafx.controls;
    requires javafx.fxml;
    
    opens co.edu.poli.agrocultura to javafx.fxml;
    opens co.edu.poli.agrocultura.vista to javafx.fxml;
    opens co.edu.poli.agrocultura.modelo to javafx.fxml;
    
    exports co.edu.poli.agrocultura;
    exports co.edu.poli.agrocultura.vista;
    exports co.edu.poli.agrocultura.modelo;
    exports co.edu.poli.agrocultura.servicios;
}