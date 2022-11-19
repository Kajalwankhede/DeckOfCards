package com.deckofcards;
public class DeckOfCards {
    public static void main(String[] args) {
        System.out.println("Welcome to Deck Of Cards Game");
        String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"};
        int n = suit.length * rank.length;   //// initialize deck
        String[] deck = new String[n];
        for (int i = 0; i < rank.length; i++) {
            for (int j = 0; j < suit.length; j++) {
                deck[suit.length*i + j] = rank[i] + " of " + suit[j];
            }
        }

        for (int i = 0; i < n; i++) {       // shuffle deck
            int r = i + (int) (Math.random() * (52-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
        for (int i = 0; i < 4; i++) {       // print shuffled deck
            System.out.println("Distrubuting card to Player: "+i);
            for (int j = 0; j < 9; j++)
                System.out.println(deck[i]);
        }
    }
}