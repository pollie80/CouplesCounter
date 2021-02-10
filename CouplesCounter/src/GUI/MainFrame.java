/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author tian
 */
public class MainFrame extends javax.swing.JFrame {
    
    private int person1Score = 0, person2Score = 0;
    private String person1ButtonTitle = "Person 1 remembered", person2ButtonTitle = "Person 2 remembered";
    private final String PATHTODATA = "Data/data.txt";
    private final String PATHTODATE = "Data/lastdate.txt";
    private Calendar lastDateCalendar;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        //based off https://stackoverflow.com/questions/6084039/create-custom-operation-for-setdefaultcloseoperation
        WindowListener exitListener = new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                UIManager.put("OptionPane.background", new ColorUIResource(	174, 198, 207));
                UIManager.getLookAndFeelDefaults().put("Panel.background", new ColorUIResource(	174, 198, 207));

                int confirm = JOptionPane.showOptionDialog(
                     null, "Are you sure to close this application?", 
                     "Exit CouplesCounter", JOptionPane.YES_NO_OPTION, 
                     JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    exitSave();
                    System.exit(0);
                }
            }

            private void exitSave() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                //save data to data.txt based on https://stackoverflow.com/questions/9620683/java-fileoutputstream-create-file-if-not-exists
                try {
                    FileOutputStream fout = new FileOutputStream(PATHTODATA, false);
                    //save data in format: score1 score2 name1 name2
                    fout.write((person1Score + " " + person2Score + " \"" + person1ButtonTitle + "\" \"" + person2ButtonTitle + "\"" +
                            "\n" + scoreTypeLabel.getText()).getBytes());
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //save last date
                try {
                    FileOutputStream fout = new FileOutputStream(PATHTODATE, false);
                    //save data in specific format
                    DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");
                    fout.write((dateFormat.format(lastDateCalendar.getTime()).toString()).getBytes());
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        addWindowListener(exitListener);

        //load saved names
        File f = new File(PATHTODATA);
        if(f.exists()){
            Scanner scanner = null;
            try {
                scanner = new Scanner(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            person1Score = Integer.parseInt(scanner.next());
            person2Score = Integer.parseInt(scanner.next());

            StringBuilder name1 = new StringBuilder();
            int numQuots = 0;
            while (numQuots != 2){
                String nextWord = scanner.next();
                name1.append(" ").append(nextWord);

                numQuots += nextWord.length() - nextWord.replaceAll("\"","").length();
            }

            StringBuilder name2 = new StringBuilder();
            numQuots = 0;
            while (numQuots != 2){
                String nextWord = scanner.next();
                name2.append(" ").append(nextWord);

                numQuots += nextWord.length() - nextWord.replaceAll("\"","").length();
            }

            setNewNames(name1.toString().replace("\"", ""), name2.toString().replace("\"", ""));

            //get title of scoreTypeLabel
            scanner.nextLine(); //move to next line
            scoreTypeLabel.setText(scanner.nextLine());
            scanner.close();
        }
        //load saved date - format is: dd MM yyyy
        f = new File(PATHTODATE);
        if(f.exists()){
            Scanner scanner = null;
            try {
                scanner = new Scanner(f);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            lastDateCalendar = Calendar.getInstance();
            lastDateCalendar.set(scanner.nextInt(), scanner.nextInt()-1, scanner.nextInt());
//            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            System.out.println("from file: "+dateFormat.format(lastDateCalendar.getTime()));
            scanner.close();
        }

        updateScore();
        updateNamesOnGui();
        updateDateLabel();
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
        resetScoreButton = new javax.swing.JButton();
        lastUpdatedLabel = new javax.swing.JLabel();
        scoreLabel1 = new javax.swing.JLabel();
        scoreLabel2 = new javax.swing.JLabel();
        scoreTypeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CouplesCounter");
        setBackground(new java.awt.Color(255, 105, 97));
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/download.png"));

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
        scoreLabel.setText("-");

        changeTitlesButton.setText("Change button titles");
        changeTitlesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeTitlesButtonActionPerformed(evt);
            }
        });

        resetScoreButton.setText("Reset Score");
        resetScoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetScoreButtonActionPerformed(evt);
            }
        });

        lastUpdatedLabel.setText("Last updated: 10/10/1969");

        scoreLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        scoreLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel1.setText("0");
        scoreLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scoreLabel1MouseClicked(evt);
            }
        });

        scoreLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        scoreLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel2.setText("0");
        scoreLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scoreLabel2MouseClicked(evt);
            }
        });

        scoreTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        scoreTypeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreTypeLabel.setText("Who remembered the most anniversaries");
        scoreTypeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scoreTypeLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(changeTitlesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resetScoreButton)
                .addContainerGap())
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(person1JButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE)
                .addComponent(person2JButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(scoreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scoreLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(lastUpdatedLabel)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(scoreTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
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
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeTitlesButton)
                    .addComponent(resetScoreButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scoreTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(person2JButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(person1JButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(lastUpdatedLabel)
                .addGap(27, 27, 27))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(scoreTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(325, Short.MAX_VALUE)))
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
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void person1JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_person1JButtonActionPerformed
        //increase and update score
        person1Score++;
        scoreLabel1.setText(String.valueOf(person1Score));

        //update updated label
        lastDateCalendar = Calendar.getInstance();
        updateDateLabel();
    }//GEN-LAST:event_person1JButtonActionPerformed

    private void person2JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_person2JButtonActionPerformed
        // TODO add your handling code here:
        person2Score++;
        scoreLabel2.setText(String.valueOf(person2Score));
        
        //update updated label
        lastDateCalendar = Calendar.getInstance();
        updateDateLabel();
    }//GEN-LAST:event_person2JButtonActionPerformed

    private void changeTitlesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeTitlesButtonActionPerformed
        // TODO add your handling code here:
        //show names getting frame here
        NameGettingOkCancelDialog nameDialog = new NameGettingOkCancelDialog(this, true, this);
        nameDialog.setVisible(true);
    }//GEN-LAST:event_changeTitlesButtonActionPerformed

    private void resetScoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetScoreButtonActionPerformed
        // TODO add your handling code here:
        person1Score = 0;
        person2Score = 0;
        
        updateScore();
    }//GEN-LAST:event_resetScoreButtonActionPerformed

    private void scoreLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scoreLabel1MouseClicked
        // TODO add your handling code here:
        person1Score = getScore(1);
        scoreLabel1.setText(String.valueOf(person1Score));
    }//GEN-LAST:event_scoreLabel1MouseClicked

    private void scoreLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scoreLabel2MouseClicked
        // TODO add your handling code here:
        person2Score = getScore(2);
        scoreLabel2.setText(String.valueOf(person2Score));
    }//GEN-LAST:event_scoreLabel2MouseClicked

    private void scoreTypeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scoreTypeLabelMouseClicked
        // TODO add your handling code here:
        String newLabel = JOptionPane.showInputDialog("Enter the new topic:", scoreTypeLabel.getText());
        if (newLabel != null)
            scoreTypeLabel.setText(newLabel);
    }//GEN-LAST:event_scoreTypeLabelMouseClicked

    private int getScore(int player){
        SpinnerNumberModel sModel = new SpinnerNumberModel(0, 0, 30, 1);
        JSpinner spinner = new JSpinner(sModel);

        int option = JOptionPane.showOptionDialog(null, spinner, "Enter the new score for player "+player+":",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (option == JOptionPane.CANCEL_OPTION)
        {
            // user hit cancel
            if (player == 1)
                return person1Score;
            return person2Score;
        }
            // user entered a number
            return (int) spinner.getValue();
    }

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
    private javax.swing.JLabel lastUpdatedLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton person1JButton;
    private javax.swing.JButton person2JButton;
    private javax.swing.JButton resetScoreButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreLabel1;
    private javax.swing.JLabel scoreLabel2;
    private javax.swing.JLabel scoreTitleLabel;
    private javax.swing.JLabel scoreTypeLabel;
    // End of variables declaration//GEN-END:variables

    private void updateScore() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        scoreLabel1.setText(String.valueOf(person1Score));
        scoreLabel2.setText(String.valueOf(person2Score));
    }

    private void updateNamesOnGui() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        person1JButton.setText(person1ButtonTitle);
        person2JButton.setText(person2ButtonTitle);
    }

    private void updateDateLabel(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        lastUpdatedLabel.setText("Last updated: "+dateFormat.format(lastDateCalendar.getTime()));
    }
    
    public void setNewNames(String title1, String title2){
        person1ButtonTitle = title1;
        person2ButtonTitle = title2;
        
        updateNamesOnGui();
    }

    public String getPerson1ButtonTitle(){
        return person1ButtonTitle;
    }

    public String getPerson2ButtonTitle() {
        return person2ButtonTitle;
    }
}
