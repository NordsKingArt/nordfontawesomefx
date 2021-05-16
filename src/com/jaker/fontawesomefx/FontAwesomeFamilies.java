package com.jaker.fontawesomefx;

import javafx.scene.text.Font;

public enum FontAwesomeFamilies {


    FAR(FontAwesomeIconView.far),
    FAL(FontAwesomeIconView.fal),
    FAD(FontAwesomeIconView.fad),
    FAB(FontAwesomeIconView.fab),
    FAS(FontAwesomeIconView.fas);


    private final Font fontfamily;
    FontAwesomeFamilies(Font fontfamily){
        this.fontfamily = fontfamily;
    }

    public Font getFontfamily() {
        return fontfamily;
    }
}
