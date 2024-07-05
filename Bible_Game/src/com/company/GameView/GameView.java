package com.company.GameView;

import com.company.Main;
import com.company.Sprite.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class GameView {
    protected ArrayList<Sprite> elements;
    protected Door door;
    protected ImageIcon img;

    public void drawView(Graphics g) {
        img.paintIcon(null, g, 0, 0);

        //在背景上一層黑色遮罩，僅美化用。
        g.setColor(new Color(0f, 0f, 0f, .3f));
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        for (Sprite s : elements) {
            s.draw(g);
        }
    }

    public Door getDoor() {
        return this.door;
    }

    public ArrayList<Sprite> getElements() {
        return this.elements;
    }
}
