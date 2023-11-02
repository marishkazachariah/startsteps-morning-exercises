package week_9.day_4;

import java.util.Random;

enum CardSuit {
    HEARTS, DIAMONDS, CLUBS, SPADES;
    private static final Random RANDOM = new Random();
    public CardSuit getRandomCardSuit() {
        CardSuit[] cardSuits = values();
        return cardSuits[RANDOM.nextInt(cardSuits.length)];
    }
}
public class Exercise2 {
    public static void main(String[] args) {
        CardSuit firstCard = CardSuit.HEARTS;
        CardSuit randomCard = firstCard.getRandomCardSuit();
        System.out.println("Random card: " + randomCard);
    }
}
