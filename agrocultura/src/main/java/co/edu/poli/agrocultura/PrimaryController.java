package co.edu.poli.agrocultura;

import java.io.IOException;

import co.edu.poli.agrocultura.vista.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
