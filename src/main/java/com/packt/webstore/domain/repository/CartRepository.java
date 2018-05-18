package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Cart;

public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cardId, Cart cart);
    void delete(String cartId);
}
