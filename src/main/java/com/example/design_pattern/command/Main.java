package com.example.design_pattern.command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.example.design_pattern.command.command.Command;
import com.example.design_pattern.command.command.MacroCommand;
import com.example.design_pattern.command.drawer.DrawCanvas;
import com.example.design_pattern.command.drawer.DrawCommand;

public class Main extends JFrame implements ActionListener {        
    // 描画履歴
    private MacroCommand history = new MacroCommand();
    // 描画領域
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 消去ボタン
    private JButton clearButton  = new JButton("clear");

    // コンストラクタ
    @SuppressWarnings("deprecation")
	public Main(String title) {
        super(title);

        this.addWindowListener(new WindowAdapter() {        
            public void windowClosing(WindowEvent e) {      
                System.exit(0);                             
            }                                               
        });                                                 
        canvas.addMouseMotionListener(new MouseMotionAdapter() {    
            public void mouseDragged(MouseEvent e) {                
                Command cmd = new DrawCommand(canvas, e.getPoint());    
                history.append(cmd);                                    
                cmd.execute();                                          
            }                                                           
        });                                                             
        clearButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }

    // ActionListener用
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        }
    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
