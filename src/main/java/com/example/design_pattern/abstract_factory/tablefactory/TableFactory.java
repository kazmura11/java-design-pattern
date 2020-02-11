package com.example.design_pattern.abstract_factory.tablefactory;

import com.example.design_pattern.abstract_factory.factory.Factory;
import com.example.design_pattern.abstract_factory.factory.Link;
import com.example.design_pattern.abstract_factory.factory.Page;
import com.example.design_pattern.abstract_factory.factory.Tray;

public class TableFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
