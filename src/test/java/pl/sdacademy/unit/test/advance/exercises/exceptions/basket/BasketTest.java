package pl.sdacademy.unit.test.advance.exercises.exceptions.basket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BasketTest {
    Basket basket;
    
    @BeforeEach
    void setUp() {
        basket = new Basket();
    }

    @Test
    void shouldNotBePossibleToAddNewItemWhenBasketIsFull() {
        //given
        prepareData();
        //when & then
        assertThatThrownBy(() -> basket.addToBasket())
                .isInstanceOf(BasketFullException.class)
                .hasMessage("Too many items int he basket");
    }

    @Test
    void shouldNotBePossibleToRemoveElementWhenBasketIsEmpty() {
        //when & then
        assertThatThrownBy(() -> basket.removeFromBasket())
                .isInstanceOf(BasketEmptyException.class)
                .hasMessage("Can't remove item from empty basket");
    }

    private void prepareData() {
        try {
            basket.addToBasket();
            basket.addToBasket();
            basket.addToBasket();
            basket.addToBasket();
            basket.addToBasket();
            basket.addToBasket();
            basket.addToBasket();
            basket.addToBasket();
            basket.addToBasket();
            basket.addToBasket();
        } catch(BasketFullException e) {
            e.printStackTrace();
        }
    }

}