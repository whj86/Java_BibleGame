package com.company.Sprite;

import com.company.Main;

import javax.swing.*;
import java.awt.*;

public abstract class Sprite {
    protected ImageIcon img;
    protected Point relativePosition;
    protected Point absolutePosition;

    public void draw(Graphics g) {
        if (relativePosition != null) { //被殺死relativePosition就會被設為null
            img.paintIcon(null, g, absolutePosition.x, absolutePosition.y);
        }
    }

    public void setPosition(int x, int y) {
        relativePosition = new Point(x, y);
        absolutePosition = new Point((x - 1) * Main.CELL, (y - 1) * Main.CELL);
    }

    public void setPosition(Point p) {
        setPosition(p.x, p.y);
    }

    public void setNullPosition() {
        relativePosition = null;
        absolutePosition = null;
    }

    public Point getRelativePosition() {
        if (relativePosition == null) {
            return null;
        } else {
            return new Point(relativePosition); //因為沒有要用call by reference，所以不是直接return relativePosition
        }
    }

    public abstract String overlap(int x, int y);
}
