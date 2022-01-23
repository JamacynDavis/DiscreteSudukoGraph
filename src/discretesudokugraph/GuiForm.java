/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package discretesudokugraph;

/**
 *
 * @author jmdav
 */
public class GuiForm extends javax.swing.JFrame {
    
    int[][] sudokuArr = new int[9][9];
    int invalidx = -1;  
    int invalidy = -1;
    /**
     * Creates new form GuiForm
     */
    public GuiForm() {
        initComponents();
        //entryTable.setRowCount(9);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        entryTable = new javax.swing.JTable(9,9);
        ExitButton = new javax.swing.JButton();
        SubmitButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        colorTable = new javax.swing.JTable(9,9);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sudoku");

        entryTable.setName("entryTable"); // NOI18N
        jScrollPane1.setViewportView(entryTable);

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(colorTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(ExitButton)
                .addGap(54, 54, 54)
                .addComponent(SubmitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubmitButton)
                    .addComponent(ExitButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        //ExitButton.dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        for( int i = 0; i < sudokuArr.length; i++ ) {
            for ( int j = 0; j < sudokuArr.length; j++ ) {
                sudokuArr[i][j] = Integer.parseInt((String) entryTable.getValueAt(i, j));
            }
        }
        verify();

    }//GEN-LAST:event_SubmitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JTable colorTable;
    private javax.swing.JTable entryTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

public void verify(){
                String[] colors = {"Yellow", "Blue", "Orange", "Purple", "Red", "Aqua", "Green", "Light Blue", "Light Green"};
        
        String[][] colorsArr = new String[sudokuArr.length][sudokuArr[0].length]; 
        for (int i = 0; i < sudokuArr.length; i += 1) { 
            for ( int j = 0; j < sudokuArr.length; j += 1 ) { 
                if ( sudokuArr[i][j] == 1 ){ 
                    colorsArr[i][j] = colors[0]; 
                }
                if ( sudokuArr[i][j] == 2 ){ 
                    colorsArr[i][j] = colors[1]; 
                }
                if ( sudokuArr[i][j] == 3 ){ 
                    colorsArr[i][j] = colors[2]; 
                }
                if ( sudokuArr[i][j] == 4 ){ 
                    colorsArr[i][j] = colors[3]; 
                }
                if ( sudokuArr[i][j] == 5 ){ 
                    colorsArr[i][j] = colors[4]; 
                }                
                if ( sudokuArr[i][j] == 6 ){ 
                    colorsArr[i][j] = colors[5]; 
                }                
                if ( sudokuArr[i][j] == 7 ){ 
                    colorsArr[i][j] = colors[6]; 
                }                
                if ( sudokuArr[i][j] == 8 ){ 
                    colorsArr[i][j] = colors[7]; 
                } 
                if ( sudokuArr[i][j] == 9 ){ 
                    colorsArr[i][j] = colors[8]; 
                }
            }
            
        }
        int[][] edges = new int[2000][4];
        
        // edgeCount keeps track of the edges added
        int edgeCount = 0; 
        
        // This adds all the edges between the adjacent vertices across the rows 
        for(int i = 0; i < sudokuArr.length; i+=1){     // row of first and second index held constant 
            for(int j = 0; j < sudokuArr[i].length; j+=1){     // column of first vertex 
                for(int k = 0; k < sudokuArr[i].length; k+=1){   // column of the second that keeps moving until all are done for that j value 
                    if ( j == k ) { 
                        // do nothing 
                    }
                    else { 
                        edges[edgeCount][0] = j;
                        edges[edgeCount][1] = i;
                        edges[edgeCount][2] = k;
                        edges[edgeCount][3] = i; 
                        edgeCount++; 
                    } 
                }
            }
        }
         
        // This adds all the edges between the adjacent vertices down the columns
        for(int j = 0; j < sudokuArr.length; j+=1){     // column is held constant 
            for(int i = 0; i < sudokuArr[j].length; i+=1) { // row of first vertex
                for(int k = 0; k < sudokuArr[j].length; k+=1){  // second row value in point that keeps moving until all edges are built for that row
                    if ( i == k ) { 
                        // do nothing 
                    }
                    else { 
                        edges[edgeCount][0] = j; // same column
                        edges[edgeCount][1] = i; // inner for loop so first point value 
                        edges[edgeCount][2] = j; // same column 
                        edges[edgeCount][3] = k; // outer for loop so second poitn value 
                        edgeCount++; 
                    }
                }
            
            }
        }
    
    // This adds all the edges adjacent to the vertices in the three by three subboxes in the graph 
        for ( int box = 0; box < 9; box += 1) { // Represents the 8 3 by 3 boxes in graph 
            for( int i = (box%3)*3; i < (box%3)*3 + 3; i += 1 ) { // columns across the graph and writes them in terms of box. 
                for ( int j = box/3*3; j < box/3*3 + 3; j +=1 ) { // rows down the graph using box to make sure it is within the 3 by 3 box.
                    for ( int k = (box%3)*3; k < (box%3)*3 + 3; k += 1) { // second x vertex for second point of adjacency
                        for ( int f = box/3*3; f < box/3*3; f += 1) { // second y vertex for second point of adjacency. 
                            if ( i == k || j == f ) { // already down in the above for loops for adjacienecies across the columns and down the rows. 
                            // do nothing 
                            }
                            else { 
                                edges[edgeCount][0] = i; // x coordinate 
                                edges[edgeCount][1] = j; // y coordinate  
                                edges[edgeCount][2] = k; // second x coordinate 
                                edges[edgeCount][3] = f; // second y coordinate 
                                edgeCount++; // keeps track of the edges 
                            }
                        }
                    }    
                }
            }
        }
        
        // checks if adjacent vertices are colored the same, then it outputs invalid
        for ( int x = 0; x < edgeCount; x += 1){ 
            if (colors[sudokuArr[edges[x][0]][edges[x][1]] - 1] == colors[sudokuArr[edges[x][2]][edges[x][3]] - 1]){ 
                System.out.println("Invalid");    
                invalidx = edges[x][0]; 
                invalidy = edges[x][1]; 
                break; 
            }
        } 
    }
}

