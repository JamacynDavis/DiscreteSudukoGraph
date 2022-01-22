// Description: Creates the board display of a nine by nine sudoku graph. 

package discretesudokugraph;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jmdav
 */
public class Board {
    JFrame f;     
    
    Board(String d[][], int dataDim, int invX, int invY){    
        f = new JFrame(); 
        f.setTitle("Sudoku -- Jamacyn Davis");
            
        String column[] = new String[dataDim];
        for(int i  = 0; i < dataDim; i++){
            column[i] = "";
        }
        JTable jt=new JTable(d,column);    
        jt.setBounds(100, 100, 400, 600);  
        JScrollPane sp=new JScrollPane(jt);
        
        JButton b = new JButton("Exit");
        b.setBounds(250,250,95,30);
        b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
                    f.dispose();

                }  
            });
        f.add(b);
        f.add(sp);    
        

        
        f.setSize(600,700);  
        jt.setBackground(Color.WHITE);
        
        if ( invX != -1 ) { 
            jt.changeSelection(invX, invY, false, false);  
        }
       
        f.setVisible(true);  
       
    }
    


}
