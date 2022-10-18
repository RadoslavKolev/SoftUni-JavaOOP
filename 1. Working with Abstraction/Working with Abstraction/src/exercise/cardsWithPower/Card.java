package exercise.cardsWithPower;

public class Card {
    private final CardRanks cardRank;
    private final CardSuits cardSuit;
    private final int cardPower;

    public Card(CardRanks cardRank, CardSuits cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
        this.cardPower = cardRank.getValue() + cardSuit.getValue();
    }

    @Override
    public String toString() {
        return String.format(
            "Card name: %s of %s; Card power: %d",
            this.cardRank, this.cardSuit, this.cardPower
        );
    }
}
