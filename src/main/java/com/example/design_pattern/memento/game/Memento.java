package com.example.design_pattern.memento.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Memento implements Serializable {  
    int money;                              // 所持金
    List<String> fruits;                          // フルーツ
    public int getMoney() {                 // 所持金を得る(narrow interface)
        return money;
    }
    Memento(int money) {                    // コンストラクタ(wide interface)
        this.money = money;
        this.fruits = new ArrayList<String>();
    }
    void addFruit(String fruit) {           // フルーツを追加する(wide interface)
        fruits.add(fruit);
    }
    List<String> getFruits() {                    // フルーツを得る(wide interface)
         return new ArrayList<>(fruits);
    }
}
