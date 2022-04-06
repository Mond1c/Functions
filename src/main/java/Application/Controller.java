package Application;

import Functions.Function;
import Functions.FunctionParser;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;

public class Controller {
    private static final float ZOOMFACTOR = 1.05f;

    @FXML
    private Canvas canvas;

    @FXML
    private TextField textField;

    @FXML
    private void buttonDrawClicked() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        graphicsContext.beginPath();
        graphicsContext.moveTo(0, height / 2);
        graphicsContext.lineTo(width, height / 2);
        graphicsContext.moveTo(width / 2, 0);
        graphicsContext.lineTo(width / 2, height);
        graphicsContext.stroke();

        Function function = FunctionParser.parse(textField.getText());
        double start_x = -width / 2, start_y = function.calculate(start_x);
        graphicsContext.moveTo(start_x + width / 2, -1 * start_y + height / 2);
        for (double x = -width / 2; x < width / 2; ++x) {
            double y = function.calculate(x);
            if (y > height) continue;
            graphicsContext.lineTo(x + width / 2, -1 * y + height / 2);
        }
        graphicsContext.stroke();
    }

    @FXML
    private void buttonClearClicked() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    private void canvasScroll(ScrollEvent event) {
        double zoomFactor = ZOOMFACTOR;
        double deltaY = event.getDeltaY();
        if (deltaY < 0) zoomFactor = 2.0 - zoomFactor;
        if (canvas.getScaleY() < 1 && deltaY < 0) return;
        canvas.setScaleX(canvas.getScaleX() * zoomFactor);
        canvas.setScaleY(canvas.getScaleY() * zoomFactor);
    }

}
