package com.example.design_pattern.flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    // 大きな文字を表現する文字列('#' '.' '\n'の列)
    private String fontdata;
    // コンストラクタ
    public BigChar(char charname) {
        try {
            BufferedReader reader = new BufferedReader(
                new FileReader("big" + charname + ".txt")
            );
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontdata = buf.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }
    // 大きな文字を表示する
    public void print() {
        System.out.print(fontdata);
    }
}
