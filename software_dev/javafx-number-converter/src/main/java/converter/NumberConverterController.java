package converter;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NumberConverterController {
    @FXML
    private TextField binaryField;
    @FXML
    private TextField octalField;
    @FXML
    private TextField decimalField;
    @FXML
    private TextField hexadecimalField;
    @FXML
    private void initialize(){
        decimalField.textProperty().bindBidirectional(binaryField.textProperty(), new NumberSystemConverter(2, 10));
        decimalField.textProperty().bindBidirectional(octalField.textProperty(), new NumberSystemConverter(8, 10));
        decimalField.textProperty().bindBidirectional(hexadecimalField.textProperty(), new NumberSystemConverter(16, 10));
    }
}
