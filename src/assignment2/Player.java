package assignment2;

import javax.swing.JLabel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int points;
    private Color color;
    private JLabel label;

    public Player(String name, Color color) {
        this.name = name;
        this.points = 0;
        this.color = color;
        this.label = new JLabel();
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public Color getColor() {
        return color;
    }

    public JLabel getLabel() {
        return label;
    }

    public void calculatePoints(List<FieldButton> buttons) {
        points = 0;
        for (FieldButton button : buttons) {
            if (button.getPlayer().equals(name)) {
                points++;
            }
        }
    }

    public void resetPoints() {
        points = 0;
    }
}