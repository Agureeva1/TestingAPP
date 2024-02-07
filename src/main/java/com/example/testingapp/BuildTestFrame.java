package com.example.testingapp;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.example.testingapp.AskAnswerListParsing.*;
import static com.example.testingapp.CheckYourResult.*;

public class BuildTestFrame {
    public static BorderPane buildFrame() throws IOException {
        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        ScrollPane scrollPane = new ScrollPane(vbox);
        root.setCenter(scrollPane);

        Button ok = new Button("OK");
        Button newTest = new Button("Еще раз");
        ok.setMinWidth(120);
        newTest.setMinWidth(120);
        HBox hbox = new HBox(10, ok, newTest);
        hbox.setPadding(new Insets(15, 5, 5, 5));
        hbox.setHgrow(ok, Priority.ALWAYS);
        hbox.setHgrow(newTest, Priority.ALWAYS);
        ok.setMaxWidth(Double.MAX_VALUE);
        newTest.setMaxWidth(Double.MAX_VALUE);
        root.setBottom(hbox);

        newTest.setOnAction(e -> {
            for (int i = 0; i < getCbArr().length; i++) {
                for (int j = 0; j < getCbArr()[i].length; j++) {

                    getCbArr()[i][j].setSelected(false);
                }

            }

            int[] resultTest = new int[getAnswer().size()];
            setResultTest(resultTest);
            setPoint(0);

        });
        ok.setOnAction(e -> {
            checkAnswer();
        });



        File f = new File("TXT_dir/title.txt");
        if (f.exists()) {
            var titleTest = new String(Files.readAllBytes(Paths.get(f.toURI())), StandardCharsets.UTF_8);
            Label titleT = new Label(titleTest);
            titleT.setFont(Font.font("verdana", FontWeight.BOLD, 12));
            vbox.getChildren().addAll(titleT);
        }

        for (int i = 0; i < getAsk().size(); i++) {
            vbox.getChildren().add(new Label(getAsk().get(i)));
            for (int j = 0; j < getCbArr()[i].length; j++) {
                vbox.getChildren().add(getCbArr()[i][j]);
            }
        }
        int indexSep = getNumberOptionForEvryAsk()+2;
        int numAnswer = getAnswer().size();
        while (numAnswer > 0) {
            Separator separator = new Separator();
            separator.setMaxWidth(300);
            vbox.getChildren().add(indexSep, separator);
            indexSep += getNumberOptionForEvryAsk()+2;
            numAnswer--;
        }

        vbox.setSpacing(5);
        scrollPane.setStyle("-fx-padding: 10;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;");

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
return root;

    }
}
