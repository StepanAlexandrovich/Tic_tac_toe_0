package tic_tac_toe_0;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MyFrame extends JFrame{
    public Logic logic = new Logic();
    public Button[] buttons = new Button[logic.length];
    
    public MyFrame(){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        
        int index = 0;
        for(int y = 0;y<3;y++){
            for(int x = 0;x<3;x++){
                panel.add(buttons[index] = new Button(index,x,y,logic,this));
                index++;
            }
        }
        
        logic.startPosition();
        this.update();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new MyFrame();
            }
            
        });
        
    }

    public void update() {
        for(int i = 0;i<buttons.length;i++){
            buttons[i].setText(logic.array[i]);
        }
    }
    
}
