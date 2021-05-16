package com.jaker.fontawesomefx;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;


public class FontAwesomeIconView extends Pane {

    static Font fab = Font.loadFont(FontAwesomeIconView.class.getResource("/fontawesome/fa-brands-400.ttf").toExternalForm(),12);
    static Font fad = Font.loadFont(FontAwesomeIconView.class.getResource("/fontawesome/fa-duotone-900.ttf").toExternalForm(), 12.0D);
    static Font fal = Font.loadFont(FontAwesomeIconView.class.getResource("/fontawesome/fa-light-300.ttf").toExternalForm(),12);
    static Font far = Font.loadFont(FontAwesomeIconView.class.getResource("/fontawesome/fa-regular-400.ttf").toExternalForm(),12);
    static Font fas = Font.loadFont(FontAwesomeIconView.class.getResource("/fontawesome/fa-solid-900.ttf").toExternalForm(),12);


    private Label label;
    private Label label_fad;
    public FontAwesomeIconView(String icon) throws Exception {

//        Loading custom fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("faicon.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();


//        Initialize a label(icon)
        label = new Label();
        label_fad = new Label();
        this.setIcon(icon);
        this.getChildren().add(label);
    }
    public FontAwesomeIconView() throws Exception {
        this("fal fa-eye");
    }



//    To get font from string(fab,fal,fas...)
    public Font getFontFamily(String fontname){
        switch (fontname){
            case "fal":
                return fal;
             case "fas":
                return fas;
             case "far":
                return far;
             case "fab":
                return fab;
             case "fad":
                return fad;
            default:
                return fal;
        }
    }


    public String getIcon() {
        return textProperty().get();
    }
    public void setIcon(String icon){

        String ff = icon.split(" ")[0];
        Font font;

        String raw_icon = icon.split(" ")[1];
        String icon_itself = raw_icon.split("-",2)[1];
        icon_itself = icon_itself.toUpperCase().replace("-","_");

        if (ff.equals("fad")){
            font = getFontFamily("fad");
            label_fad.setStyle("-fx-font-family: "+'"'+fad.getName()+'"'); // Setting font
            label_fad.setText(this.getUnicode("FAD_"+icon_itself));
            label_fad.setOpacity(0.4);
            this.getChildren().add(label_fad);
        }
        else{
            font = getFontFamily(ff);
        }

        label.setStyle("-fx-font-family: "+'"'+font.getName()+'"'); // Setting font
        textProperty().set(this.getUnicode(icon_itself)); // Setting unicode
    }
    public StringProperty textProperty() {
        return label.textProperty();
    }


    public Paint getColor(){
        return paintObjectProperty().get(); // Getting color;
    }
    public void setColor(Paint color){
        label.setTextFill(color);
        label_fad.setTextFill(color);
        paintObjectProperty().set(color); // Setting color
    }
    public ObjectProperty<Paint> paintObjectProperty(){
        return label.textFillProperty();
    }




//    Additional functions
    private String getUnicode(String icon){
        Object obj = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream resource = classLoader.getResourceAsStream("icons.json");
            File file = new File("icons.json");
            copyInputStreamToFile(resource,file);

            obj = new JSONParser().parse(new FileReader(file));

        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject icons = (JSONObject) obj;
        try {
            return icons.get(icon).toString();
        }
        catch (NullPointerException ex){
            System.err.println("Icon named "+icon+" does not exist in FontAwesome library.");
        }
        return icons.get("EYE").toString();
    }

    private static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {

        // append = false
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[8192];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }

    }


}
