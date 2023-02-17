package psmodel;
import cardutils.*;
import ps.IPsLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PsLogic implements IPsLogic {
    private Card nextCard;
    private Deck theDeck;
    private Pile[] PileList;
    public PsLogic() {
        initNewGame();
    }
    @Override
    public void initNewGame() {
        theDeck = new Deck();
        //PileList = new ArrayList<>();
        PileList = new Pile[5];
        //PileList.clear();
        for (int i=0;i<5;i++) {
            PileList[i] = new Pile();
        }
        nextCard = null;
        //System.out.println(theDeck.getCardArrList());
    }
    @Override
    public Card pickNextCard() throws IllegalStateException {
        if(nextCard!=null)  {
            throw new IllegalStateException("next card != null");
        }
        //if(PileList[0].getSize()<=5 && PileList[1].getSize()<=5 && PileList[2].getSize()<=5 && PileList[3].getSize()<=5 && PileList[4].getSize()<=5) {
            nextCard = theDeck.dealCard();
            return nextCard;
        //}
        //return null;
    }
    @Override
    public void addCardToPile(int n) throws IllegalStateException {
        if(nextCard == null) {
            throw new IllegalStateException("next card == null");
        }
        if(PileList[n].getSize()<5) {
            PileList[n].add(nextCard);

        } else {
            throw new IllegalStateException("Chosen pile is full!");
        }
        nextCard=null;
    }
    @Override
    public boolean isGameOver() {
        if(getCardCount()==25) {
            return true;
        }
        return false;
    }
    @Override
    public int getCardCount() {
        return 52 - theDeck.getSize();
    }
    @Override
    public int getPoints() {
        int sum =0;
        for(int i=0;i<5;i++) {
            sum += PokerHands.GetPokerCombo(PileList[i]).getValue();
        }
        return sum;
    }
    public List<Pile> getPiles() {
        //Pile[] Copy = new Pile[5];
        List<Pile> CopyList = new ArrayList<>();
        ArrayList<Pile> CopyList2 = new ArrayList<>();
        Collections.addAll(CopyList, PileList);
        for(int i=0;i<CopyList.size();i++) {
            CopyList2.add(i,CopyList.get(i));
        }
        return CopyList2;
    }

    public String toString() {
        return " " + PileList;
    }
}
