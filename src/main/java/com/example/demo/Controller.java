package com.example.demo;

import Functions.Function;
import Functions.FunctionParser;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Canvas canvas;

    @FXML
    private TextField textField;

    @FXML
    public void buttonClicked() {
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
}
