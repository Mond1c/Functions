package Application;

import Functions.Function;
import Functions.FunctionParser;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class Controller {
    @FXML
    private Canvas canvas;

    @FXML
    private TextField textField;

    private static final double moveSpeed = 10;
    private boolean moved = false;

    @FXML
    public void buttonDrawClicked() {
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
    public void buttonClearClicked() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    public void canvasScroll(ScrollEvent event) {
        double zoomFactor = 1.05;
        double deltaY = event.getDeltaY();
        if (deltaY < 0) zoomFactor = 2.0 - zoomFactor;
        if (canvas.getScaleY() < 1 && deltaY < 0) return;
        canvas.setScaleX(canvas.getScaleX() * zoomFactor);
        canvas.setScaleY(canvas.getScaleY() * zoomFactor);
    }


    @FXML
    public void canvasMouseMoved(MouseEvent event) {
//        if (moved) {
//            double x = event.getX();
//            double y = event.getY();
//            x -= 400;
//            y *= -1;
//            y += 400;
//
//            if (x < 0) canvas.setTranslateX(-moveSpeed);
//            else canvas.setTranslateX(moveSpeed);
//            if (y < 0) canvas.setTranslateY(-moveSpeed);
//            else canvas.setTranslateY(moveSpeed);
//        }
    }

    @FXML
    public void canvasMouseClicked(MouseEvent event) {
        moved = true;
    }

    @FXML
    public void canvasMouseReleased(MouseEvent event) {
        moved = false;
    }
}
