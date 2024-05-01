package tic_tac_toe_0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Button extends JButton{
    private int index;
    private Logic logic = new Logic();
    private MyFrame myFrame;
    
    public Button(int index,int x, int y,Logic logic,MyFrame myFrame){
        this.index = index;
        
        this.logic = logic;
        this.myFrame = myFrame;
        
        this.setBounds(x*100,y*100,100,100);
        this.addActionListener(new MyKeyAdapter());
    }
    
    public void action(String text){
        JOptionPane.showMessageDialog(null,text);
        logic.startPosition();
        myFrame.update();
    }
    
    public boolean result(String symbol){
        if(symbol=="X")        { action("YOU LOST"); return true; }
        if(symbol=="0")        { action("YOU WIN");  return true; }
        if(symbol=="deadlock") { action("DRAW");     return true; }
        return false;
    }
    
    private class MyKeyAdapter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            logic.positionUser(index);
            myFrame.update();
            if(result(logic.result())){ return; }
           
            logic.positionPC();
            myFrame.update();
            if(result(logic.result())){ return; }
        }
        
    }
}
