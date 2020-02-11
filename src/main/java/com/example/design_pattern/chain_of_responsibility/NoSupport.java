package com.example.design_pattern.chain_of_responsibility;

public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }
    protected boolean resolve(Trouble trouble) {     // 解決用メソッド
        return false; // 自分は何も処理しない
    }
}
