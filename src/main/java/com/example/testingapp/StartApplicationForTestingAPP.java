package com.example.testingapp;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

import static com.example.testingapp.AnimationCongratulation.animationCongratulation;
import static com.example.testingapp.AnimationFail.animationFail;
import static com.example.testingapp.AskAnswerListParsing.*;
import static com.example.testingapp.BuildTestFrame.buildFrame;



public class StartApplicationForTestingAPP extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        try {

            splitTestFile();

          if (getAsk().size() == getAnswer().size()) {
              Scene scene = new Scene(buildFrame(), 300, 600);

                stage.setTitle("Тестирование");
                //  stage.getIcons().add(new Image("C:\\Users\\aagureeva\\IdeaProjects\\GardenCalendar\\src\\main\\image\\клевер.png"));

                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

            } else {
                VBox root = new VBox();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Информационное сообщение");
                alert.setHeaderText(null);
                alert.setContentText("Количество вопросов и ответов не совпадает. " +
                        "Внесите изменение в тест.");

                alert.showAndWait();
                Platform.exit();
            }
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Информационное сообщение");
            alert.setHeaderText(null);
            alert.setContentText("Что-то пошло не так. Система не смогла прочитать файл.");
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
