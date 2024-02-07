package com.example.testingapp;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import static com.example.testingapp.AnimationCongratulation.animationCongratulation;
import static com.example.testingapp.AnimationFail.animationFail;
import static com.example.testingapp.AskAnswerListParsing.*;
import static com.example.testingapp.AskAnswerListParsing.getRightAnswer;

public class CheckYourResult {


    private static int [] resultTest = new int[getAnswer().size()];
    private static int point = 0;
    private static int minPointPassTest = getAnswer().size()/2;

    public static int[] getResultTest() {
        return resultTest;
    }

    public static void setResultTest(int[] resultTest) {
        CheckYourResult.resultTest = resultTest;
    }

    public static int getPoint() {
        return point;
    }

    public static void setPoint(int point) {
        CheckYourResult.point = point;
    }

    public static void increasePoint() {
        point++;
    }

    public static void checkAnswer() {
        List <List<String>> allSelectedAnswer = new ArrayList<>();
        for (int i = 0; i < getAnswer().size(); i++) {
            List <String> selAnswer= new ArrayList<>();
            for (int j = 0; j < getNumberOptionForEvryAsk(); j++) {
                if (getCbArr()[i][j].isSelected()) {
                    selAnswer.add(getCbArr()[i][j].getText());}
            } if (selAnswer.size()>0) allSelectedAnswer.add(selAnswer);
        }

        if (getRightAnswer().size()>allSelectedAnswer.size()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Информационное сообщение");
            alert.setHeaderText(null);
            alert.setContentText("Вы ответили не на все вопросы. Проверьте результат теста после того" +
                    ", как дадите ответ на все вопросы.");

            alert.showAndWait();
            int[] resultTest = new int[getAnswer().size()];
            setResultTest(resultTest);
            setPoint(0);
        }

        if (getRightAnswer().size()==allSelectedAnswer.size()) {
            for (int i = 0; i < allSelectedAnswer.size(); i++) {
                if (getRightAnswer().get(i).size()==allSelectedAnswer.get(i).size()) {
                    int mark = 0;
                    for (int j = 0; j < getRightAnswer().get(i).size(); j++) {
                        if (getRightAnswer().get(i).get(j).equals(allSelectedAnswer.get(i).get(j))){
                            mark ++;
                        } if (mark==getRightAnswer().get(i).size())  {
                            getResultTest()[i]=1;
                            increasePoint();
                        }

                    }
                } else {
                    getResultTest()[i]=0;
                }
            }
        }
if (getPoint()>=minPointPassTest) {

    Scene scene = new Scene(animationCongratulation(),600, 300);
    Stage stage = new Stage();
    stage.setTitle("Результат теста");

    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();
}else {
    Scene scene = new Scene(animationFail(),600, 300);
    Stage stage = new Stage();
    stage.setTitle("Результат теста");

    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();


}  for (int i = 0; i < getCbArr().length; i++) {
            for (int j = 0; j < getCbArr()[i].length; j++) {

                getCbArr()[i][j].setSelected(false);
            }

        }

        int[] resultTest = new int[getAnswer().size()];
        setResultTest(resultTest);
        setPoint(0);
    }
}
