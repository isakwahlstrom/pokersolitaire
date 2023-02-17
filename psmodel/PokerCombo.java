package psmodel;

public enum PokerCombo {
        NONE(0), PAIR(1), TWOPAIRS(3), THREEOFAKIND(6), FLUSH(5), FOUROFAKIND(16);
        private int value;
        public int getValue() {
        return value;
    }

        private PokerCombo(int value) {
        this.value = value;
    }
}
