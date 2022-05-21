package ui;

import model.BlackJackTable;
import model.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: Implement double down (maybe split), make unable to bet if funds negative(maybe changes to max amount), random tests

public class BlackJackGame implements ActionListener {
    private Scanner input;
    private BlackJackTable table;

    private JPanel panel;
    private JFrame frame;
    private JButton hitButton;
    private JButton standButton;
    private JButton newGameButton;
    private JButton betButton;
    private JList<String> playerCards;
    private JList<String> dealerCards;
    private DefaultListModel pmodel;
    private DefaultListModel dmodel;
    private JTextField betAmount;
    private JLabel fundsLabel;


    public BlackJackGame() {

        frame = new JFrame();

        pmodel = new DefaultListModel();
        dmodel = new DefaultListModel();
        playerCards = new JList<>(pmodel);
        dealerCards = new JList<>(dmodel);

        hitButton = new JButton("Hit");
        hitButton.addActionListener(this);
        hitButton.setActionCommand("hit");
        standButton = new JButton("Stand");
        standButton.addActionListener(this);
        standButton.setActionCommand("stand");
        newGameButton = new JButton("New Hand");
        newGameButton.addActionListener(this);
        newGameButton.setActionCommand("reset");
        betButton = new JButton("Bet");
        betButton.addActionListener(this);
        betButton.setActionCommand("bet");

        JLabel yourHand = new JLabel("Your Hand", SwingConstants.CENTER);
        JLabel dealerHand = new JLabel("Dealer's Hand", SwingConstants.CENTER);
        fundsLabel = new JLabel("Current funds: 100", SwingConstants.CENTER);
        betAmount = new JTextField();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder());
        panel.setLayout(new GridLayout(5, 2));
        panel.add(yourHand);
        panel.add(dealerHand);
        panel.add(playerCards);
        panel.add(dealerCards);
        panel.add(hitButton);
        panel.add(standButton);
        panel.add(newGameButton);
        panel.add(betButton);
        panel.add(fundsLabel);
        panel.add(betAmount);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 1000);
        //frame.pack();
        frame.setVisible(true);

        table = new BlackJackTable();
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
        newGameButton.setEnabled(false);
    }

    private void init() {
        Card c = table.dealerStartHand();
        dmodel.addElement(c.getName());
        hitButton.doClick();
        hitButton.doClick();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("hit")) {
            Card c = table.hit();
            pmodel.addElement(c.getName());
        } else if (e.getActionCommand().equals("stand")) {
            table.stand();
            showDealerCards();
        } else if (e.getActionCommand().equals("reset")) {
            table.newGame();
            pmodel.removeAllElements();
            dmodel.removeAllElements();
            betButton.setEnabled(true);
            newGameButton.setEnabled(false);
        } else if (e.getActionCommand().equals("bet")) {
            String s = betAmount.getText();
            if (isInteger(s)) {
                betButton.setEnabled(false);
                hitButton.setEnabled(true);
                standButton.setEnabled(true);
                table.setBet(Integer.valueOf(betAmount.getText()));
                init();
            } else {
                System.out.println("Invalid bet format");
            }
        }

        if (table.isOver()) {
            hitButton.setEnabled(false);
            standButton.setEnabled(false);
            newGameButton.setEnabled(true);
            fundsLabel.setText("Current funds: " + table.getFunds());
        }
    }

    public boolean isInteger(String s) {
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void showDealerCards() {
        ArrayList<Card> cards = table.getDealerHand().getCards();
        for (int i = 1; i < cards.size(); i++) {
            dmodel.addElement(cards.get(i).getName());
        }
    }
}
