package model;

import java.util.Random;

public class BlackJackTable {
    private Hand playerHand;
    private Hand dealerHand;
    private CardDeck cardDeck;
    private boolean over;
    private int bet;
    private int funds;

    private Random random;

    public BlackJackTable() {
        playerHand = new Hand();
        dealerHand = new Hand();
        cardDeck = new CardDeck();
        random = new Random();
        over = false;
        funds = 100;
        bet = 0;
    }

    public Card dealerStartHand() {
        Card c = dealNextCard();
        dealerHand.addCard(c);
        return c;
    }

    public void newGame() {
        playerHand = new Hand();
        dealerHand = new Hand();
        over = false;
    }

    public Card hit() {
        Card c = playerHand.hit(cardDeck);
        if (playerHand.isBusted()) {
            over = true;
            System.out.println("You Lose!!!");
            setFunds(funds - bet);
        }
        return c;
    }

    public void stand() {
        over = true;
        dealerHand.handleDealer(cardDeck);
        if (dealerHand.isBusted() || playerHand.getTotal() > dealerHand.getTotal()) {
            //System.out.println("You Win!!!"); // Testing purposes
            setFunds(funds + bet);
        } else if (playerHand.getTotal() == dealerHand.getTotal()) {
            //System.out.println("You Tied!!!");
        } else {
            //System.out.println("You Lose!!!");
            setFunds(funds - bet);
        }
    }

    public Card dealNextCard() {
        int i = random.nextInt(cardDeck.size());
        return cardDeck.remove(i);
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int i) {
        bet = i;
    }

    public int getFunds() {
        return funds;
    }

    private void setFunds(int f) {
        funds = f;
    }

    public boolean isOver() {
        return over;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }
    public Hand getDealerHand() { return dealerHand; }
}
