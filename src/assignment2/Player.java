/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 *
 * @author kseni
 */
public class Player {
    private String name;
    private int points;
    //private Color color;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }


    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

//    public Color getColor(){
//        return color;
//    }


    public void increasePoints(){
        points++;
    }
}
