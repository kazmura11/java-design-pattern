package com.example.design_pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    // すでに作ったBigCharのインスタンスを管理
    private Map<String, BigChar> pool = new HashMap<>();
    // Singletonパターン
    private static BigCharFactory singleton = new BigCharFactory();
    // コンストラクタ
    private BigCharFactory() {
    }
    // 唯一のインスタンスを得る
    public static BigCharFactory getInstance() {
        return singleton;
    }
    // BigCharのインスタンス生成(共有)
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = pool.get("" + charname);
        if (bc == null) {
            bc = new BigChar(charname); // ここでBigCharのインスタンスを生成
            pool.put("" + charname, bc);
        }
        return bc;
    }
}
