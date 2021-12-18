public class Card {
    private final int num;
    private final Shape shape;

    public Card(int num, Shape shape) {
        this.num = num;
        this.shape = shape;
    }

    public int getNum() {
        return num;
    }
    public int compare(Card other) {
        /** Compare cards based on their number*/
        if (this.num < other.getNum()) {
            return -1;
        }
        if (this.num > other.getNum()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        /** print with the format: "_number_ of _shape_"*/
        String returnValue = "";
        if (num > 1 && num <= 10) {
            returnValue = "" + this.num;
        } else {
            switch (this.num) {
                case 11:
                    returnValue = "Jack";
                    break;
                case 12:
                    returnValue = "Queen";
                    break;
                case 13:
                    returnValue = "King";
                    break;
                case 1:
                    returnValue = "Ace";
                    break;
                default:
            }
        }
        return returnValue + " of " + this.shape;
    }
}
