package cardutils;
import java.util.ArrayList;


public class Pile {
    public Pile() {
        this.CardArrayList = new ArrayList<>();
        //System.out.println(CardArrayList);
    }

    public void add(Card dealtCard) {
        if(CardArrayList.size()<5) {
            CardArrayList.add(dealtCard);
        }
    }

    public void add(ArrayList<Card> CardList) {
        Card tempCard;
        for(int i=0;i<CardList.size();i++) {
            tempCard = CardList.get(i);
            CardArrayList.add(tempCard);
        }
    }
    public ArrayList<Card> getCards() {
        ArrayList<Card> Copy = new ArrayList<>();
        for(int i=0;i< CardArrayList.size();i++) {
            Copy.add(i,CardArrayList.get(i));
        }
        return Copy;
    }
    public int getSize() {
        return CardArrayList.size();
    }
    @Override
    public String toString() {
            return "\n" + CardArrayList;
    }
    public Card get(int position) {
        return CardArrayList.get(position);
    }

    public void clear() {
        CardArrayList.clear();
    }

    public Card remove(int position) {
        if(position>0) {
            return CardArrayList.remove(position - 1);
        }
        return null;
    }
    public boolean remove(Card card) {
        if(!CardArrayList.contains(card)) {
            return false;
        }
        //if(CardArrayList.size()>0)
        CardArrayList.remove(card);
        return true;
    }

    public boolean remove(ArrayList<Card> cardList) {
        if(CardArrayList.containsAll(cardList))
        return CardArrayList.removeAll(cardList);

        return false;
    }

    public boolean contains(Card card) {
        if(!CardArrayList.contains(card)) {
            return false;
        }
        return true;
    }
    public int noOfSuit(Suit suit) {
        int which = 1;
        return check(which,suit);
    }
    public int noOfRank(Rank rank) {
        int which = 2;
        return check(which,rank);
    }
    //Help method
    public int check(int whichMethod, Object rankOrSuit) {
        int amount = 0;
        Card tempCard;
        if(whichMethod==1) { //if whichMethod==1 check suit
            for (int i = 0; i < CardArrayList.size(); i++) {
                tempCard = CardArrayList.get(i);
                if (tempCard.getSuit() == rankOrSuit) {
                    amount++;
                }
            }
        }
        if(whichMethod==2) { //if whichMethod==2 check rank
            for (int i = 0; i < CardArrayList.size(); i++) {
                tempCard = CardArrayList.get(i);
                if (tempCard.getRank() == rankOrSuit) {
                    amount++;
                }
            }
        }
        return amount;
    }
    private ArrayList<Card> CardArrayList;
   // private Card dealtCard;

}
