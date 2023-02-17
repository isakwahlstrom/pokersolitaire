package psmodel;
import cardutils.Pile;
import cardutils.Rank;
import cardutils.Suit;

public class PokerHands {
    private PokerHands()  {

    }
    public static PokerCombo GetPokerCombo(Pile aPile) {
        if(FourOfAKind(aPile))
            return PokerCombo.FOUROFAKIND;

        if(ThreeOfAKind(aPile))
            return PokerCombo.THREEOFAKIND;

         if(Flush(aPile))
             return PokerCombo.FLUSH;

        if(TwoPair(aPile))
            return PokerCombo.TWOPAIRS;

        if(OnePair(aPile))
            return PokerCombo.PAIR;

        return PokerCombo.NONE;
    }
    private static boolean OnePair(Pile aPile) {
        for(Rank r: Rank.values()) {
                if (aPile.noOfRank(r) == 2) {
                    return true;
                }
        }
        return false;
    }
    private static boolean TwoPair (Pile aPile) {
        int howManyPairs = 0;
            for (Rank r : Rank.values()) {
                    if(aPile.noOfRank(r)==2 && howManyPairs==0) {
                        howManyPairs = 1;
                    } else {

                        if(aPile.noOfRank(r)==2 && howManyPairs==1)
                            return true;
                    }
            }
        return false;
    }
    private static boolean Flush(Pile aPile) {
        for(Suit s: Suit.values()) {
            if(aPile.noOfSuit(s)==5) {
                return true;
            }
        }
        return false;
    }
    private static boolean ThreeOfAKind(Pile aPile) {
        for (Rank r : Rank.values()) {
                if (aPile.noOfRank(r) == 3) {
                    return true;
                }
        }
        return false;
    }
    private static boolean FourOfAKind(Pile aPile) {
        for (Rank r : Rank.values()) {
                if (aPile.noOfRank(r) == 4) {
                    return true;
                }
        }
        return false;
    }

}
