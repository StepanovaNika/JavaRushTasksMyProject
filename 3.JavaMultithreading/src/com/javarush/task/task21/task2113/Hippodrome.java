package com.javarush.task.task21.task2113;


import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;

    public Hippodrome() {

    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();

        game.horses.add(new Horse("Loshadka1", 3, 0));
        game.horses.add(new Horse("Loshadka2", 3, 0));
        game.horses.add(new Horse("Loshadka3", 3, 0));

        game.run();

        game.printWinner();

    }
    private List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses(){
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(200);
        }

    }

    public Horse getWinner(){
        double max = 0;
        Horse winner = null;
         for (Horse horse : horses){
             if (horse.distance > max){
                 max = horse.distance;
                 winner = horse;
             }
         }
         return winner;
    }

    public void printWinner(){
        Horse winner = getWinner();
        System.out.println("Winner is " + winner.getName() + "!");


    }

    public void move(){
        for (Horse h : horses){
            h.move();
        }

    }
    public void print(){
        for (Horse h : horses){
            h.print();
        }
        System.out.println();
        System.out.println();

    }

}
