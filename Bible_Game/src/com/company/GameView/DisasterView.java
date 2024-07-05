package com.company.GameView;

import com.company.Sprite.DisasterViewSprite.Bug;
import com.company.Sprite.DisasterViewSprite.Frog;
import com.company.Sprite.DisasterViewSprite.Ice;
import com.company.Sprite.DisasterViewSprite.Tombstone;
import com.company.Sprite.Door;

import javax.swing.*;
import java.util.ArrayList;

public class DisasterView extends GameView{
    private ArrayList<Bug> bugs = new ArrayList<>();
    private ArrayList<Frog> frogs = new ArrayList<>();
    private ArrayList<Ice> ices = new ArrayList<>();
    private ArrayList<Tombstone> tombstones = new ArrayList<>();

    public DisasterView() {
        img = new ImageIcon(getClass().getResource("egypt.jpg"));
        elements = new ArrayList<>();
        door = new Door(10, 10);

        bugs.add(new Bug(10, 5));
        bugs.add(new Bug(9, 5));
        bugs.add(new Bug(9, 4));
        bugs.add(new Bug(6, 2));
        bugs.add(new Bug(6, 3));
        bugs.add(new Bug(6, 4));
        bugs.add(new Bug(6, 5));
        frogs.add(new Frog(1, 2));
        frogs.add(new Frog(1, 3));
        frogs.add(new Frog(1, 4));
        frogs.add(new Frog(2, 2));
        frogs.add(new Frog(2, 3));
        ices.add(new Ice(7, 5));
        ices.add(new Ice(3, 5));
        ices.add(new Ice(5, 5));
        ices.add(new Ice(4, 5));
        ices.add(new Ice(8, 5));
        tombstones.add(new Tombstone(6, 6));
        tombstones.add(new Tombstone(7, 8));
        tombstones.add(new Tombstone(8, 8));
        tombstones.add(new Tombstone(9, 8));
        tombstones.add(new Tombstone(3, 8));

        //Arraylist可用addAll()，把另一個Arraylist的元素複製過來。
        elements.add(door);
        elements.addAll(bugs);
        elements.addAll(frogs);
        elements.addAll(ices);
        elements.addAll(tombstones);
    }

    public ArrayList<Bug> getBugs() {
        return bugs;
    }

    public ArrayList<Frog> getFrogs() {
        return frogs;
    }

    public ArrayList<Ice> getIces() {
        return ices;
    }

    public ArrayList<Tombstone> getTombstones() {
        return tombstones;
    }
}
