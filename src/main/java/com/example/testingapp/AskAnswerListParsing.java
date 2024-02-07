package com.example.testingapp;

import javafx.scene.control.CheckBox;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AskAnswerListParsing {

    private static CheckBox[][] cbArr;
    private static List<String> ask;
    private static List<List> answer;
    private static List<List> rightAnswer;
    private static int numberOptionForEvryAsk = 3;

    public static void splitTestFile() throws IOException {
        var textTest = new String(Files.readAllBytes(Paths.get("TXT_dir/test.txt")), StandardCharsets.UTF_8);
        // разделить символьную строку на вопросы и ответы
        List<String> sentence = Arrays.asList(textTest.trim().split("\\+++"));

        if (sentence.size() > 0 || sentence.size() % 2 == 1) {
            ask = new ArrayList<>();
            answer = new ArrayList<>();
            rightAnswer = new ArrayList<>();
            for (int i = 0; i < sentence.size(); i++) {
                if (i == 0 || i % 2 == 0) {
                    ask.add(sentence.get(i).trim());
                }
                if (i % 2 == 1) {
                    List<String> abc = Arrays.asList(sentence.get(i).split("\\--"));
                    List<String> trimABC = new ArrayList<>();
                    List<String> rightABC = new ArrayList<>();
                    for (int w = 0; w < abc.size(); w++) {
                        if (abc.get(w).trim().toString().contains("**")) {
                            rightABC.add((String) abc.get(w).trim().toString().replaceAll("\\**", ""));
                        }
                        trimABC.add(abc.get(w).trim().replaceAll("\\**", ""));
                    }
                    answer.add(trimABC);
                    rightAnswer.add(rightABC);
                }
            }

            if (ask.size() == answer.size()) {
//                for (int i = 0; i < ask.size(); i++) {
//                    System.out.println(ask.get(i));
//
//                    for (int j = 0; j < answer.get(i).size(); j++) {
//                        System.out.print(answer.get(i).get(j) + " ");
//                    }
//                    System.out.println();
//
//                    System.out.print("Правильный ответ: ");
//                    for (int j = 0; j < rightAnswer.get(i).size(); j++) {
//                        System.out.print(rightAnswer.get(i).get(j) + " ");
//                    }
//                    System.out.println();
//                }

                cbArr = new CheckBox[answer.size()][numberOptionForEvryAsk];
                for (int i = 0; i < answer.size(); i++) {
                    for (int j = 0; j < numberOptionForEvryAsk; j++) {
                        cbArr[i][j] = new CheckBox(answer.get(i).get(j).toString());
                    }
                }
            }

        } else {
            System.out.println("Количество вопросов и ответов не совпадает");
        }


    }

    public static List<String> getAsk() {
        return ask;
    }

    public static List<List> getAnswer() {
        return answer;
    }

    public static List<List> getRightAnswer() {
        return rightAnswer;
    }

    public static CheckBox[][] getCbArr() {
        return cbArr;
    }

    public static int getNumberOptionForEvryAsk() {
        return numberOptionForEvryAsk;
    }

}
