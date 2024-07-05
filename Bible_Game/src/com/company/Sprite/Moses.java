package com.company.Sprite;

import com.company.GameView.DisasterView;
import com.company.GameView.RedSeaGameView;
import com.company.GameView.TenCommandmentsView;
import com.company.Main;
import com.company.Sprite.DisasterViewSprite.Bug;
import com.company.Sprite.DisasterViewSprite.Frog;
import com.company.Sprite.DisasterViewSprite.Ice;
import com.company.Sprite.DisasterViewSprite.Tombstone;
import com.company.Sprite.RedSeaViewSprite.Anubis;
import com.company.Sprite.RedSeaViewSprite.Cat;
import com.company.Sprite.RedSeaViewSprite.Pharaoh;
import com.company.Sprite.TenCommandmentsSprite.TenCommandments;

import javax.swing.*;
import java.util.ArrayList;

public class Moses extends Sprite{
    public Moses(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon(getClass().getResource("Moses.png")); //不是用getClass().getResource("Moses.png")?? 試過了，build後的JAR檔會沒圖片，笑死
    }

    @Override
    public String overlap(int x, int y) {
        if (Main.gameView instanceof DisasterView) {
            // check for bugs and frogs
            ArrayList<Bug> bugs = ((DisasterView) Main.gameView).getBugs();
            ArrayList<Frog> frogs = ((DisasterView) Main.gameView).getFrogs();
            // 看moses下個要到的位置會不會是bug或frog
            for (Bug b : bugs) {
                // 注意if的條件，b.getRelativePosition() != null必須放在前面，因為b.getRelativePosition()若是null，則沒有x和y，順序放錯會發生錯誤
                if ((b.getRelativePosition() != null) && (x == b.getRelativePosition().x) && (y == b.getRelativePosition().y)) {
                    return "Die";
                }
            }
            for (Frog f : frogs) {
                if ((f.getRelativePosition() != null) && (x == f.getRelativePosition().x) && (y == f.getRelativePosition().y)) {
                    return "Die";
                }
            }
            // check for ice and tombstones
            ArrayList<Ice> ices = ((DisasterView) Main.gameView).getIces();
            ArrayList<Tombstone> tombstones = ((DisasterView) Main.gameView).getTombstones();

            for (Ice i : ices) {
                if ((i.getRelativePosition() != null) && (x == i.getRelativePosition().x) && (y == i.getRelativePosition().y)) {
                    return "Cannot move";
                }
            }
            for (Tombstone t : tombstones) {
                if ((t.getRelativePosition() != null) && (x == t.getRelativePosition().x) && (y == t.getRelativePosition().y)) {
                    return "Cannot move";
                }
            }

            //check for door
            Door door = Main.gameView.getDoor();
            if ((x == door.getRelativePosition().x) && (y == door.getRelativePosition().y)) {
                return "Next level";
            }
        } else if (Main.gameView instanceof RedSeaGameView) {
            // check for cats
            ArrayList<Cat> cats = ((RedSeaGameView) Main.gameView).getCats();
            for (Cat c : cats) {
                if ((c.getRelativePosition() != null) && (x == c.getRelativePosition().x) && (y == c.getRelativePosition().y)) {
                    return "Cannot move";
                }
            }

            // check for anubis and pharaoh
            ArrayList<Anubis> anubis = ((RedSeaGameView) Main.gameView).getAnubis();
            ArrayList<Pharaoh> pharaohs = ((RedSeaGameView) Main.gameView).getPharaohs();
            for (Anubis a : anubis) {
                if ((a.getRelativePosition() != null) && (x == a.getRelativePosition().x) && (y == a.getRelativePosition().y)) {
                    return "Die";
                }
            }
            for (Pharaoh p : pharaohs) {
                if ((p.getRelativePosition() != null) && (x == p.getRelativePosition().x) && (y == p.getRelativePosition().y)) {
                    return "Die";
                }
            }

            //check for door
            Door door = Main.gameView.getDoor();
            if ((x == door.getRelativePosition().x) && (y == door.getRelativePosition().y)) {
                return "Next level";
            }
        } else if (Main.gameView instanceof TenCommandmentsView) {
            ArrayList<TenCommandments> stones = ((TenCommandmentsView) Main.gameView).getStones();
            for (TenCommandments t : stones) {
                if ((t.getRelativePosition() != null) && (t.getRelativePosition().x == x) && (t.getRelativePosition().y == y)) {
                    t.setNullPosition();
                    ((TenCommandmentsView) Main.gameView).setCount(1);
                    if (((TenCommandmentsView) Main.gameView).getCount() == 10) {
                        return "Game over";
                    } else {
                        return "none";
                    }
                }
            }
        }

        return "none";
    }
}
