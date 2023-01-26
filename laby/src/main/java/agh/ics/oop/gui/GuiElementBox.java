package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {

    private Image image;
    private ImageView imageView = new ImageView();
    private VBox vBox = new VBox();

    public GuiElementBox(IMapElement element) {
            this.image = new Image("file:src/main/resources/" + element.getImagePath() + ".png");
            imageView.setImage(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);



        Label label = new Label(element.getDesc());
        vBox.getChildren().addAll(imageView, label);
        vBox.setAlignment(Pos.CENTER);
    }

    public VBox getvBox() {
        return vBox;
    }
}