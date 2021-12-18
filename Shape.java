public enum Shape {
    SPADES {
        @Override
        public String toString() {
            return "♠";
        }
    },
    DIAMONDS {
        @Override
        public String toString() {
            return "♦";
        }
    },
    CLUBS {
        @Override
        public String toString() {
            return "♣";
        }
    },
    HEARTS {
        @Override
        public String toString() {
            return "♥";
        }
    }
}
