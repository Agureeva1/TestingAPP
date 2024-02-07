package com.example.testingapp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class AnimationCongratulation extends Parent {

    final static javafx.scene.image.Image leftFan2 = new javafx.scene.image.Image("file:src\\main\\image\\leftFan2.png");
    final static javafx.scene.image.Image confetti_1 = new javafx.scene.image.Image("file:src\\main\\image\\confetti_1.png");
    final static javafx.scene.image.Image confetti_2 = new javafx.scene.image.Image("file:src\\main\\image\\confetti_2.png");
    final static javafx.scene.image.Image confetti_3 = new javafx.scene.image.Image("file:src\\main\\image\\confetti_3.png");
    final static javafx.scene.image.Image fl = new javafx.scene.image.Image("file:src\\main\\image\\flag.png");


    //  private   static Group horn;
    private   static Group confetti;

  //  static final ImageView horn1= new ImageView(leftFan1);
    static final ImageView horn= new ImageView(leftFan2);
    static final ImageView ivConfetti_1= new ImageView(confetti_1);
    static final ImageView ivConfetti_2= new ImageView(confetti_2);
    static final ImageView ivConfetti_3= new ImageView(confetti_3);
    static final ImageView flag= new ImageView(fl);
    static final String text_1 = "Поздравляем!\nВы сдали тест!";


    public static Group animationCongratulation() {
        Text text= new Text(text_1);
        text.setFont(Font.font("Sitka Banner Italic", FontWeight.THIN, FontPosture.ITALIC,40));
       // "verdana", FontWeight.BOLD, FontPosture.REGULAR, 20
        text.setX(270);
        text.setY(140);
        flag.setTranslateX(250);
        flag.setTranslateY(-80);


        horn.setTranslateX(50);
        horn.setTranslateY(100);

        //    Rectangle fon = new Rectangle(700,400);
     //  fon.setFill(Color.LIGHTBLUE);
        confetti = new Group();
        confetti.setTranslateX(90);
        confetti.setTranslateY(60);

        Timeline t = new Timeline();
        t.setCycleCount(Timeline.INDEFINITE);
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(300),
                (
                        ActionEvent event) -> {
                    confetti.getChildren().setAll(ivConfetti_1);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(400),
                (ActionEvent event) -> {
                    confetti.getChildren().setAll(ivConfetti_2);
                }
        ));
        t.getKeyFrames().add(new KeyFrame(
                Duration.millis(500),
                (ActionEvent event) -> {
                    confetti.getChildren().setAll(ivConfetti_3);
                }
        ));


        Group root = new Group(flag, confetti,horn,text);

        t.play();
       return root;

    }
}
