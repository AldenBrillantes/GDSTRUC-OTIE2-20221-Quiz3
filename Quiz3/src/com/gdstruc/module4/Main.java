package com.gdstruc.module4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int idCount = 1;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int turns = 1, gamesMade = 0;

        ArrayQueue arrayQueue = new ArrayQueue(11);


        while (gamesMade <= 10) {
            System.out.println("Turn " + turns);
            System.out.println("Matches found:" + gamesMade);
            System.out.println();

            int numOfPlayers = r.nextInt(7) + 1;


            addPlayersToQueue(arrayQueue, numOfPlayers);


            System.out.println("Players inside the queue: ");
            arrayQueue.printQueue();

            if (arrayQueue.size() >= 5) {
                dequeuePlayers(arrayQueue);
                gamesMade++;
            }

            System.out.println("press ENTER to continue.");

            s.nextLine();

            turns++;
        }

        s.close();

    }

    public static void addPlayersToQueue(ArrayQueue queue, int amount) {
        String[] playerName = {"Panda", "Mahito", "Nanami", "Yuta", "MechaMaru", "Yuji", "Sukuna", "Nobara",
                "Geto", "Rika", "Toji", "Megumi", "\"Gojo\"", "Todou", "Maki", "Choso"};
        Random r = new Random();

        for (int i = 0; i < amount; i++) {
            queue.enqueue(new Player(idCount, playerName[r.nextInt(16)], r.nextInt(1000) + 1));
            idCount++;
        }
    }

    //dequeue 5 players in the queue
    public static void dequeuePlayers(ArrayQueue queue) {
        while (queue.size() >= 5) {
            System.out.println("Match Started!!!");
            System.out.println("5 Players have been detected.");
            System.out.println("Dequeuing 5 players...");
            for (int i = 0; i < 5; i++)
                queue.dequeue();

        }
    }
}