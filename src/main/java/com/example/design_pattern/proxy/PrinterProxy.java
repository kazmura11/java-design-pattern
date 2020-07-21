package com.example.design_pattern.proxy;

public class PrinterProxy implements Printable {
    private String name;            // 名前
    private Printable real;         // 「本人」
    private String className;       // 「本人」のクラス名
    public PrinterProxy(String name, String className) {      // コンストラクタ
        this.name = name;
        this.className = className;
    }
    @Override
    public synchronized void setPrinterName(String name) {  // 名前の設定
        if (real != null) {
            real.setPrinterName(name);  // 「本人」にも設定する
        }
        this.name = name;
    }
    @Override
    public String getPrinterName() {    // 名前の取得
        return name;
    }
    @Override
    public void print(String string) {  // 表示
        System.out.println("call realize");
        realize();
        System.out.println("realize called");
        real.print(string);
    }
    private synchronized void realize() {   // 「本人」を生成
        if (real == null) {
            try {
                System.out.println(className);
                real = (Printable)Class.forName(className).newInstance();
                real.setPrinterName(name);
            } catch (ClassNotFoundException e) {
                System.err.println("クラス " + className + " が見つかりません。");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
