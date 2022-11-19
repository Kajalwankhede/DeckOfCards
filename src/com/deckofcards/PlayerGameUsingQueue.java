package com.deckofcards;

import java.util.Random;

class MyQueue<T> {

    MyLinkedList<T> linkedList;
    public MyQueue() {
        linkedList = new MyLinkedList<T>();
    }
    public void enqueueData(T data){
        linkedList.add(data);
    }
    public T dequeueData() {
        return linkedList.pop(0);
    }

}

class MyLinkedList<T> {

    MyNode<T> head;
    MyNode<T> current;
    int position;

    public MyLinkedList() {
        head = null;
        current = null;
        position = -1;
    }
    public void add(T data){
        MyNode<T> node = new MyNode<T>(data);
        if(head == null){
            head = node;
            current = head;
        }
        else{
            current.next = node;
            current = current.next;
        }
        position++;
    }

    public T pop(int location){
        MyNode<T> tempCurrent = head;
        MyNode<T> tempPrev = null;
        int tempPosition = 0;
        position--;
        while(tempPosition != location){
            tempPrev = tempCurrent;
            tempCurrent = tempCurrent.next;
            tempPosition++;
        }
        if(tempCurrent == head){
            head = head.next;
            return tempCurrent.data;
        }
        else if(tempCurrent == current){
            current = tempPrev;
            tempPrev.next = tempCurrent.next;
            return tempCurrent.data;
        }
        else{
            tempPrev.next = tempCurrent.next;
            return tempCurrent.data;
        }
    }

}

class MyNode<T>{
    T data;
    MyNode<T> next;

    MyNode(T data){
        this.data = data;
        next = null;
    }
}


public class PlayerGameUsingQueue {

    MyQueue<Player> playerQueue;
    int[][] arrayCard;

    void start() {
        playerQueue = new MyQueue<Player>();
        arrayCard = new int[4][13];
        for(int i = 0; i < 4; i++) {
            totalAddPlayer();
        }
    }
    void totalAddPlayer() {
        Player player = new Player();
        for (int i = 0; i < 9; i++) {
            shuffleCard(player);
        }
        player.enqueueCards();
        playerQueue.enqueueData(player);
    }
    void shuffleCard(Player player) {
        Random random = new Random();
        int suit = random.nextInt(4);
        int rank = random.nextInt(13);
        if(arrayCard[suit][rank] == 0)
        {
            player.addCard(suit, rank);
            arrayCard[suit][rank] = 1;
        }
        else
        {
            shuffleCard(player);
        }
    }
    void popPlayers() {
        for(int i = 0; i < 4; i++) {
            Player player = playerQueue.dequeueData();
            System.out.println("Player " + (i+1) + " cards: ");
            printCardPlayers(player);
            System.out.println("_________________________________________________________________________");
            System.out.println();
        }
    }
    void printCardPlayers(Player player) {
        for (int i = 0; i < 9; i++) {

            Card card = player.getCard();
            System.out.print(card.getSuit() + " " + card.getRank());

        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        System.out.println("\n*************************Welcome To Deck Of Cards Game *********************");
        PlayerGameUsingQueue game = new PlayerGameUsingQueue();
        game.start();
        System.out.println("_________________________________________________________________________");
        game.popPlayers();
    }

}
