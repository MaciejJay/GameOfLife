package pl.mjasinski;

import java.util.Scanner;

public class Game {

    public void start() {

        int genCounter = 0;

        System.out.print("Insert the size of a map: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        Board board = new Board(size);

        do {
            board.print();
            System.out.println("==============");
            genCounter++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (board.tick());
        board.print();
        genCounter++;
        System.out.println("Generations: " + genCounter);
    }
}
