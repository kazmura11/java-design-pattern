package com.example.design_pattern.state;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;

public class SafeFrame extends Frame implements Context {
    private TextField textClock = new TextField(60);        // 現在時刻表示
    private TextArea textScreen = new TextArea(10, 60);     // 警備センター出力
    private Button buttonUse = new Button("Use Safe");      // 金庫使用ボタン
    private Button buttonAlarm = new Button("Use Alerm");    // 非常ベルボタン
    private Button buttonPhone = new Button("Phone");    // 通常通話ボタン
    private Button buttonExit = new Button("Exit");         // 終了ボタン

    private State state = DayState.getInstance();           // 現在の状態

    // コンストラクタ
	public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // textClockを配置
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        // textScreenを配置
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        // パネルにボタンを格納
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        // そのパネルを配置
        add(panel, BorderLayout.SOUTH);
        // 表示
        pack();
        setVisible(true);
        // リスナーの設定
        buttonUse.addActionListener((ActionEvent e) -> state.doUse(this));
        buttonAlarm.addActionListener((ActionEvent e) -> state.doAlarm(this));
        buttonPhone.addActionListener((ActionEvent e) -> state.doPhone(this));
        buttonExit.addActionListener((ActionEvent e) -> System.exit(0));
    }
	
    // 時刻の設定
    @Override
    public void setClock(int hour) {
        String clockstring = "CurrentTime";
        if (hour < 10) {
            clockstring += "0" + hour + ":00";
        } else {
            clockstring += hour + ":00";
        }
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this, hour);
    }
    // 状態変化
    @Override
    public void changeState(State state) {
        System.out.println("State changed from " + this.state + " to " + state + ".");
        this.state = state;
    }
    // 警備センター警備員呼び出し
    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }
    // 警備センター記録
    @Override
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }
}
