package cardutils;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> CardArrList;
    //private Suit[] suites;
    //private Rank[] ranks;

    public Deck() {
        this.CardArrList = new ArrayList<>();
        if(!CardArrList.isEmpty()) {
            CardArrList.clear();
        } else {
           Fill();
           shuffleCards();
        }
    }

    public void Fill() {
        Suit[] SuitArray = new Suit[4];
        Rank[] RankArray = new Rank[13];
        SuitArray = Suit.values();
        RankArray = Rank.values();
        for (Suit s : SuitArray) {
            for (Rank r : RankArray) {
                CardArrList.add(new Card(r, s));
            }
        }

    }
    public Card dealCard() {
        Card topCard;
        topCard = CardArrList.get(CardArrList.size()-1);
        CardArrList.remove(CardArrList.size()-1);
        return topCard;
    }

    public void shuffleCards() {
        Collections.shuffle(CardArrList);
    }
    public int getSize() {
        return CardArrList.size();
    }
    @Override
    public String toString() {
        return " " + CardArrList;
    }

    public ArrayList<Card> getCardArrList() {
        return CardArrList;
    }
}
