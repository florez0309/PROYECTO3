package co.edu.poli.agrocultura;

import co.edu.poli.agrocultura.modelo.*;
import co.edu.poli.agrocultura.servicios.Implementacionoperacioncrud;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class PrimaryController {
    
    // ─── Inyección FXML ─────────────────────────────────────────────
    @FXML private TableView<ArticuloWrapper> tablaArticulos;
    @FXML private TableColumn<ArticuloWrapper, Integer> colIndice, colCodigo;
    @FXML private TableColumn<ArticuloWrapper, String> colDescripcion, colFecha, colTipo, colDetalles;
    @FXML private TableColumn<ArticuloWrapper, Double> colStock;
    
    @FXML private ComboBox<String> comboTipoArticulo;
    @FXML private TextField txtCodigo, txtDescripcion, txtStock, txtFecha;
    @FXML private TextField txtTipoSemilla;
    @FXML private TextField txtFuente, txtTiempoDescomposicion, txtUnidadComposta;
    @FXML private TextField txtComposicion, txtUnidadNutriente;
    @FXML private TextField txtPlagaObjetivo, txtToxicidad, txtUnidadPlaga;
    @FXML private TextField txtIndiceLeer;
    
    @FXML private VBox panelSemilla, panelComposta, panelNutriente, panelControlPlaga;
    @FXML private Label lblMensaje, lblContador;
    
    // ─── Servicio y datos ───────────────────────────────────────────
    private final Implementacionoperacioncrud servicio = new Implementacionoperacioncrud();
    private final ObservableList<ArticuloWrapper> datosTabla = FXCollections.observableArrayList();
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    // Wrapper para mostrar índice + artículo en TableView
    public static class ArticuloWrapper {
        private final int indice;
        private final Articulo articulo;
        
        public ArticuloWrapper(int indice, Articulo articulo) {
            this.indice = indice;
            this.articulo = articulo;
        }
        public int getIndice() { return indice; }
        public Articulo getArticulo() { return articulo; }
        public String getTipo() {
            if (articulo instanceof Semilla) return "Semilla";
            if (articulo instanceof Composta) return "Composta";
            if (articulo instanceof Nutriente) return "Nutriente";
            if (articulo instanceof Controlplaga) return "ControlPlaga";
            return "Artículo";
        }
        public String getDetalles() {
            if (articulo == null) return "";
            String info = articulo.mostrarInfo();
            return info.replaceFirst("^[^|]+\\|\\s*", ""); // Quita código y descripción
        }
    }
    
    // ─── Inicialización ─────────────────────────────────────────────
    @FXML
    public void initialize() {
        configurarTabla();
        cargarTabla();
        mostrarMensaje("", false);
    }
    
    private void configurarTabla() {
        colIndice.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getIndice()).asObject());
        colCodigo.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getArticulo().getCodigo()).asObject());
        colDescripcion.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getArticulo().getDescripcion()));
        colStock.setCellValueFactory(c -> new javafx.beans.property.SimpleDoubleProperty(c.getValue().getArticulo().getStockDisponible()).asObject());
        colFecha.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getArticulo().getFechaRegistro()));
        colTipo.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getTipo()));
        colDetalles.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getDetalles()));
        tablaArticulos.setItems(datosTabla);
    }
    
    // ─── Cambiar tipo de artículo (muestra/oculta paneles) ─────────
    @FXML
    private void cambiarTipoArticulo() {
        String tipo = comboTipoArticulo.getValue();
        panelSemilla.setVisible(false); panelSemilla.setManaged(false);
        panelComposta.setVisible(false); panelComposta.setManaged(false);
        panelNutriente.setVisible(false); panelNutriente.setManaged(false);
        panelControlPlaga.setVisible(false); panelControlPlaga.setManaged(false);
        
        if ("Semilla".equals(tipo)) { panelSemilla.setVisible(true); panelSemilla.setManaged(true); }
        else if ("Composta".equals(tipo)) { panelComposta.setVisible(true); panelComposta.setManaged(true); }
        else if ("Nutriente".equals(tipo)) { panelNutriente.setVisible(true); panelNutriente.setManaged(true); }
        else if ("ControlPlaga".equals(tipo)) { panelControlPlaga.setVisible(true); panelControlPlaga.setManaged(true); }
    }
    
    // ─── CREAR ─────────────────────────────────────────────────────
    @FXML
    private void crearArticulo() {
        try {
            if (!validarCamposComunes()) return;
            Articulo nuevo = construirArticulo();
            if (nuevo == null) return;
            
            String resultado = servicio.crear(nuevo);
            mostrarMensaje("✅ " + resultado, false);
            cargarTabla();
            limpiarFormulario();
        } catch (NumberFormatException e) {
            mostrarMensaje("⚠️ Verifique datos numéricos (código, stock, tiempo)", true);
        } catch (DateTimeParseException e) {
            mostrarMensaje("⚠️ Fecha inválida. Use formato yyyy-mm-dd", true);
        } catch (Exception e) {
            mostrarMensaje("❌ Error: " + e.getMessage(), true);
        }
    }
    
    // ─── LEER POR ÍNDICE ───────────────────────────────────────────
    @FXML
    private void leerPorIndice() {
        try {
            int indice = Integer.parseInt(txtIndiceLeer.getText().trim());
            Articulo a = servicio.leer(indice);
            if (a != null) {
                mostrarMensaje("📄 " + a.mostrarInfo(), false);
                cargarTabla();
                tablaArticulos.getSelectionModel().selectIf(w -> w.getIndice() == indice);
            } else {
                mostrarMensaje("⚠️ No hay artículo en el índice " + indice, true);
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("⚠️ Ingrese un índice válido", true);
        } catch (Exception e) {
            mostrarMensaje("❌ Error: " + e.getMessage(), true);
        }
    }
    
    // ─── MODIFICAR ─────────────────────────────────────────────────
    @FXML
    private void modificarArticulo() {
        try {
            ArticuloWrapper seleccionado = tablaArticulos.getSelectionModel().getSelectedItem();
            if (seleccionado == null || seleccionado.getArticulo() == null) {
                mostrarMensaje("⚠️ Seleccione un artículo de la tabla", true);
                return;
            }
            if (!validarCamposComunes()) return;
            
            Articulo modificado = construirArticulo();
            if (modificado == null) return;
            
            String resultado = servicio.modificar(seleccionado.getIndice(), modificado);
            mostrarMensaje("✅ " + resultado, false);
            cargarTabla();
            limpiarFormulario();
        } catch (NumberFormatException e) {
            mostrarMensaje("⚠️ Verifique datos numéricos", true);
        } catch (DateTimeParseException e) {
            mostrarMensaje("⚠️ Fecha inválida. Use formato yyyy-mm-dd", true);
        } catch (Exception e) {
            mostrarMensaje("❌ Error: " + e.getMessage(), true);
        }
    }
    
    // ─── ELIMINAR ──────────────────────────────────────────────────
    @FXML
    private void eliminarArticulo() {
        try {
            ArticuloWrapper seleccionado = tablaArticulos.getSelectionModel().getSelectedItem();
            if (seleccionado == null || seleccionado.getArticulo() == null) {
                mostrarMensaje("⚠️ Seleccione un artículo para eliminar", true);
                return;
            }
            int indice = seleccionado.getIndice();
            
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, 
                "¿Eliminar artículo en índice " + indice + "?", ButtonType.YES, ButtonType.NO);
            confirm.setTitle("Confirmar");
            confirm.showAndWait().ifPresent(r -> {
                if (r == ButtonType.YES) {
                    String resultado = servicio.eliminar(indice);
                    mostrarMensaje("✅ " + resultado, false);
                    cargarTabla();
                    limpiarFormulario();
                }
            });
        } catch (Exception e) {
            mostrarMensaje("❌ Error: " + e.getMessage(), true);
        }
    }
    
    // ─── SERIALIZAR ────────────────────────────────────────────────
    @FXML
    private void serializar() {
        try {
            String resultado = servicio.serializar();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("📦 Artículos Serializados");
            alert.setContentText(resultado.isEmpty() ? "No hay artículos" : resultado);
            alert.getDialogPane().setPrefWidth(500);
            alert.showAndWait();
        } catch (Exception e) {
            mostrarMensaje("❌ Error: " + e.getMessage(), true);
        }
    }
    
    // ─── CARGAR TABLA ──────────────────────────────────────────────
    @FXML
    private void cargarTabla() {
        datosTabla.clear();
        Articulo[] todos = servicio.leertodo();
        int contador = 0;
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] != null) {
                datosTabla.add(new ArticuloWrapper(i, todos[i]));
                contador++;
            }
        }
        lblContador.setText("Artículos: " + contador + "/" + todos.length);
        tablaArticulos.refresh();
    }
    
    // ─── LIMPIAR FORMULARIO ────────────────────────────────────────
    @FXML
    private void limpiarFormulario() {
        txtCodigo.clear(); txtDescripcion.clear(); txtStock.clear(); txtFecha.clear();
        txtTipoSemilla.clear(); txtFuente.clear(); txtTiempoDescomposicion.clear(); txtUnidadComposta.clear();
        txtComposicion.clear(); txtUnidadNutriente.clear();
        txtPlagaObjetivo.clear(); txtToxicidad.clear(); txtUnidadPlaga.clear();
        txtIndiceLeer.clear();
        comboTipoArticulo.setValue(null);
        cambiarTipoArticulo();
        tablaArticulos.getSelectionModel().clearSelection();
        mostrarMensaje("", false);
    }
    
    // ─── UTILIDADES ────────────────────────────────────────────────
    private Articulo construirArticulo() throws DateTimeParseException {
        int codigo = Integer.parseInt(txtCodigo.getText().trim());
        String desc = txtDescripcion.getText().trim();
        double stock = Double.parseDouble(txtStock.getText().trim());
        String fecha = validarFecha(txtFecha.getText().trim());
        String tipo = comboTipoArticulo.getValue();
        
        switch (tipo) {
            case "Semilla":
                if (txtTipoSemilla.getText().trim().isEmpty()) {
                    mostrarMensaje("⚠️ Complete tipo de semilla", true); return null;
                }
                return new Semilla(codigo, desc, stock, fecha, txtTipoSemilla.getText().trim());
            case "Composta":
                if (txtFuente.getText().trim().isEmpty() || txtTiempoDescomposicion.getText().trim().isEmpty() || txtUnidadComposta.getText().trim().isEmpty()) {
                    mostrarMensaje("⚠️ Complete campos de composta", true); return null;
                }
                return new Composta(codigo, desc, stock, fecha, txtFuente.getText().trim(),
                    Integer.parseInt(txtTiempoDescomposicion.getText().trim()), txtUnidadComposta.getText().trim());
            case "Nutriente":
                if (txtComposicion.getText().trim().isEmpty() || txtUnidadNutriente.getText().trim().isEmpty()) {
                    mostrarMensaje("⚠️ Complete campos de nutriente", true); return null;
                }
                return new Nutriente(codigo, desc, stock, fecha, txtComposicion.getText().trim(), txtUnidadNutriente.getText().trim());
            case "ControlPlaga":
                if (txtPlagaObjetivo.getText().trim().isEmpty() || txtToxicidad.getText().trim().isEmpty() || txtUnidadPlaga.getText().trim().isEmpty()) {
                    mostrarMensaje("⚠️ Complete campos de control de plaga", true); return null;
                }
                return new Controlplaga(codigo, desc, stock, fecha, txtPlagaObjetivo.getText().trim(),
                    txtToxicidad.getText().trim(), txtUnidadPlaga.getText().trim());
            default:
                mostrarMensaje("⚠️ Seleccione un tipo de artículo", true);
                return null;
        }
    }
    
    private boolean validarCamposComunes() {
        if (txtCodigo.getText().trim().isEmpty() || txtDescripcion.getText().trim().isEmpty() || 
            txtStock.getText().trim().isEmpty() || txtFecha.getText().trim().isEmpty()) {
            mostrarMensaje("⚠️ Complete campos obligatorios", true);
            return false;
        }
        return true;
    }
    
    private String validarFecha(String fecha) {
        LocalDate.parse(fecha, DATE_FORMAT);
        return fecha;
    }
    
    private void mostrarMensaje(String msg, boolean error) {
        lblMensaje.setText(msg);
        lblMensaje.setStyle("-fx-text-fill: " + (error ? "#d32f2f" : "#388e3c") + "; -fx-font-weight: bold;");
    }
}