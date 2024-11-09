package assignment2;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldButton extends JButton {
    private int position;
    private String player;
    private int currentValue;
    private GameBoard gameBoard;

    public FieldButton(int position, GameBoard gameBoard) {
        this.position = position;
        this.player = "";
        this.currentValue = 0;
        this.gameBoard = gameBoard;
        this.setFont(new Font("Arial", Font.PLAIN, 15));
        this.setBackground(Color.GREEN);
        this.setText(String.valueOf(currentValue));

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameBoard.restartIdleTimer();
                boolean isValidMove = incrementValue();
                if (isValidMove) {
                    incrementNeighbors();
                    gameBoard.switchPlayer();
                }
            }
        });
    }

    public int getPosition() {
        return position;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
        this.setText(player);
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public boolean incrementValue() {
        if (this.currentValue == 4) return false;

        this.currentValue++;
        if (this.currentValue == 4) {
            Player currentPlayer = gameBoard.getCurrentPlayer();
            this.setBackground(currentPlayer.getColor());
            this.player = currentPlayer.getName();
        }
        this.setText(String.valueOf(currentValue));
        return true;
    }

    private void incrementNeighbors() {
        int size = gameBoard.getBoardSize();
        int row = position / size;
        int col = position % size;

        incrementNeighbor(row - 1, col); // Up
        incrementNeighbor(row + 1, col); // Down
        incrementNeighbor(row, col - 1); // Left
        incrementNeighbor(row, col + 1); // Right
    }

    private void incrementNeighbor(int row, int col) {
        int size = gameBoard.getBoardSize();
        if (row >= 0 && row < size && col >= 0 && col < size) {
            int neighborPosition = row * size + col;
            FieldButton neighbor = (FieldButton) gameBoard.getBoard().get(neighborPosition);
            if (neighbor != null) {
                neighbor.incrementValue();
            }
        }
    }

    public void reset() {
        this.player = "";
        this.currentValue = 0;
        this.setBackground(Color.GREEN);
        this.setText(String.valueOf(currentValue));
    }


}