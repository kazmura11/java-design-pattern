package com.example.design_pattern.factory_method.idcard;

import java.util.HashMap;
import java.util.Map;

import com.example.design_pattern.factory_method.framework.Factory;
import com.example.design_pattern.factory_method.framework.Product;

public class IDCardFactory extends Factory {
    private Map<Integer, String> database = new HashMap<>();
    private int serial = 100;
    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }
    protected void registerProduct(Product product) {
        IDCard card = (IDCard)product;
        database.put(new Integer(card.getSerial()), card.getOwner());
    }
    public Map<Integer, String> getDatabase() {
        return database;
    }
}
