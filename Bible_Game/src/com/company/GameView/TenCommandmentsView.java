package com.company.GameView;

import com.company.Sprite.TenCommandmentsSprite.TenCommandments;

import javax.swing.*;
import java.util.ArrayList;

public class TenCommandmentsView extends GameView{
    private ArrayList<TenCommandments> stones = new ArrayList<>();
    private int count;

    public TenCommandmentsView() {
        img = new ImageIcon(getClass().getResource("mountain.jpg"));
        elements = new ArrayList<>();
        count = 0;

        stones.add(new TenCommandments(1, 3));
        stones.add(new TenCommandments(1, 8));
        stones.add(new TenCommandments(2, 5));
        stones.add(new TenCommandments(2, 10));
        stones.add(new TenCommandments(3, 1));
        stones.add(new TenCommandments(3, 7));
        stones.add(new TenCommandments(6, 4));
        stones.add(new TenCommandments(7, 2));
        stones.add(new TenCommandments(9, 9));
        stones.add(new TenCommandments(10, 1));

        elements.addAll(stones);
    }

    public ArrayList<TenCommandments> getStones() {
        return stones;
    }

    public void setCount(int count) {
        this.count += count;
    }

    public int getCount() {
        return count;
    }
}
