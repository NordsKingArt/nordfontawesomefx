package com.jaker.fontawesomefx;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;

public class Controller {


    public StackPane main;
    public FontAwesomeIconView fa;

    public void initialize() throws Exception{

        Label label = new Label();

//        FontAwesomeIconView pc = new FontAwesomeIconView("COG", FontAwesomeFamilies.FAR);
//        label.setFont(pc.font);
//        label.setText(pc.icon);







        main.getChildren().add(label);


    }

    public Controller(){


    }
}
