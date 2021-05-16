package com.jaker.fontawesomefx;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Controller {


    public VBox main;
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
