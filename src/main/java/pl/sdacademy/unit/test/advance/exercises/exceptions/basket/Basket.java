package pl.sdacademy.unit.test.advance.exercises.exceptions.basket;

public class Basket {
    private int itemCounter;

    public Basket() {
        this.itemCounter = 0;
    }

    public void addToBasket() throws BasketFullException {
        if(itemCounter >= 10) {
            throw new BasketFullException("Too many items int he basket");
        }
        //logika dodająca element np do listy
        itemCounter++;
    }

    public void removeFromBasket() throws BasketEmptyException {
        if( itemCounter <= 0) {
            throw  new BasketEmptyException("Can't remove item from empty basket");
        }
        itemCounter--;
    }
}
