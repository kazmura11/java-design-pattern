package com.example.design_pattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;

class ElementArrayList extends ArrayList<Element> implements Element {
    public void accept(Visitor v) {
        Iterator<Element> it = iterator();
        while (it.hasNext()) {
            Element e = (Element)it.next();
            e.accept(v);
        }
    }
}
