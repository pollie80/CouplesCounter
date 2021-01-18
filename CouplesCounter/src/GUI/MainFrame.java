/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 *
 * @author tian
 */
public class MainFrame extends javax.swing.JFrame {
    
    private int person1Score = 0, person2Score = 0;
    private String person1ButtonTitle = "Person 1 remembered", person2ButtonTitle = "Person 2 remembered";

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        WindowListener exitListener = new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                     null, "Are You Sure to Close Application?", 
                     "Exit Confirmation", JOptionPane.YES_NO_OPTION, 
                     JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                   System.exit(0);
                }
            }
        };
        addWindowListener(exitListener);
        
        updateScore();
        updateNamesOnGui();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        person1JButton = new javax.swing.JButton();
        person2JButton = new javax.swing.JButton();
        scoreTitleLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        changeTitlesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 105, 97));

        mainPanel.setBackground(new java.awt.Color(255, 105, 97));

        person1JButton.setBackground(new java.awt.Color(255, 255, 255));
        person1JButton.setText("Person 1 remembered");
        person1JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                person1JButtonActionPerformed(evt);
            }
        });

        person2JButton.setBackground(new java.awt.Color(255, 255, 255));
        person2JButton.setText("Person 2 remembered");
        person2JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                person2JButtonActionPerformed(evt);
            }
        });

        scoreTitleLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        scoreTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreTitleLabel.setText("Score:");

        scoreLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setText("0 - 0");

        changeTitlesButton.setText("Change button titles");
        changeTitlesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeTitlesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(person1JButton, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addComponent(person2JButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(changeTitlesButton)
                .addContainerGap())
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(97, 97, 97)
                    .addComponent(scoreTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(114, Short.MAX_VALUE)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(changeTitlesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(person2JButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(person1JButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(scoreTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(337, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void person1JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_person1JButtonActionPerformed
        // TODO add your handling code here:
        person1Score++;
        updateScore();
    }//GEN-LAST:event_person1JButtonActionPerformed

    private void person2JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_person2JButtonActionPerformed
        // TODO add your handling code here:
        person2Score++;
        updateScore();
    }//GEN-LAST:event_person2JButtonActionPerformed

    private void changeTitlesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeTitlesButtonActionPerformed
        // TODO add your handling code here:
        //show names getting frame here
        NameGettingOkCancelDialog nameDialog = new NameGettingOkCancelDialog(this, true, this);
        nameDialog.setVisible(true);
    }//GEN-LAST:event_changeTitlesButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeTitlesButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton person1JButton;
    private javax.swing.JButton person2JButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreTitleLabel;
    // End of variables declaration//GEN-END:variables

    private void updateScore() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        scoreLabel.setText(person1Score + " - " + person2Score);
    }

    private void updateNamesOnGui() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        person1JButton.setText(person1ButtonTitle);
        person2JButton.setText(person2ButtonTitle);
    }
    
    public void setNewNames(String title1, String title2){
        person1ButtonTitle = title1;
        person2ButtonTitle = title2;
        
        updateNamesOnGui();
    }
}
