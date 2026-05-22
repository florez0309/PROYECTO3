module co.edu.poli.agrocultura {
    requires javafx.controls;
    requires javafx.fxml;
    
    opens co.edu.poli.agrocultura to javafx.fxml;
    opens co.edu.poli.agrocultura.vista to javafx.fxml;
    
    exports co.edu.poli.agrocultura.vista;
}