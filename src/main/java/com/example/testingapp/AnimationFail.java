package com.example.testingapp;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;


public class AnimationFail {

   final static javafx.scene.image.Image f1 = new javafx.scene.image.Image("file:src\\main\\image\\face_1.png");
    final static javafx.scene.image.Image f2 = new javafx.scene.image.Image("file:src\\main\\image\\face_2.png");
    final static javafx.scene.image.Image f3 = new javafx.scene.image.Image("file:src\\main\\image\\face_3.png");
    final static javafx.scene.image.Image leaf = new javafx.scene.image.Image("file:src\\main\\image\\leaf.png");

    private   static Group face;

    static final ImageView ivFace_1= new ImageView(f1);
    static final ImageView ivFace_2= new ImageView(f2);
    static final ImageView ivFace_3= new ImageView(f3);
    static final ImageView ivLeaf= new ImageView(leaf);
    static final ImageView ivLeaf_2= new ImageView(leaf);;

    static final String text_1 = "Сожалеем!\nВы не сдали тест";


    public static Group animationFail() {
        Text text= new Text(text_1);
        text.setFont(Font.font("Sitka Banner Italic", FontWeight.THIN, FontPosture.ITALIC,40));
        // "verdana", FontWeight.BOLD, FontPosture.REGULAR, 20
        text.setX(210);
        text.setY(100);

        ivLeaf_2.setTranslateX(230);
        ivLeaf_2.setTranslateY(0);

        ivLeaf.setTranslateX(330);
        ivLeaf.setTranslateY(40);

        face = new Group();
        face.setTranslateX(30);
        face.setTranslateY(60);

        face.getChildren().setAll(ivFace_1);

       Timeline t = new Timeline();
        t.setCycleCount(Timeline.INDEFINITE);
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(300),
                (
                        ActionEvent event) -> {
                    face.getChildren().setAll(ivFace_3);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(600),
                (ActionEvent event) -> {
                    face.getChildren().setAll(ivFace_1);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(900),
                (ActionEvent event) -> {
                    face.getChildren().setAll(ivFace_2);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(1200),
                (ActionEvent event) -> {
                    face.getChildren().setAll(ivFace_1);
                }
        ));


     //   Group root = new Group(face,  ivLeaf_2, ivLeaf,text);
        Group root = new Group(face,text);
        t.play();
        return root;

    }
}


