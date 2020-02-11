package com.example.design_pattern.visitor;

import java.util.Iterator;

public abstract class Entry implements Element {
    public abstract String getName();                                   // 名前を得る
    public abstract int getSize();                                      // サイズを得る
    public Entry add(Entry entry) throws FileTreatmentException {       // エントリを追加する
        throw new FileTreatmentException();
    }
    public Iterator<Entry> iterator() throws FileTreatmentException {    // Iteratorの生成
        throw new FileTreatmentException();
    }
    public String toString() {                                          // 文字列表現
        return getName() + " (" + getSize() + ")";
    }
}
