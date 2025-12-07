
package javaapplication2;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class GameDifficulty extends javax.swing.JFrame {
  private Clip clip;

    public GameDifficulty() {
        initComponents();
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
     playBackgroundMusic();
    }  private void stopBackgroundMusic() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
    private void playBackgroundMusic() {
        try {
            URL url = getClass().getResource("/javaapplication2/Attack on Titan Final Season OP - My War [8-bit VRC6].wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY); 
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dangerousfood9 = new javax.swing.JLabel();
        dangerousfood3 = new javax.swing.JLabel();
        food4Pretzel = new javax.swing.JLabel();
        food5kfc = new javax.swing.JLabel();
        food6bananasplit = new javax.swing.JLabel();
        food8icecreamcone = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/f98fc2fc9a9e290580817a3ab118f593.gif"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 680, 300, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 230, 190));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 200, 180));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 210, 190));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, -20, 190, 220));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, -10, 250, 180));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 10, 220, 180));

        dangerousfood9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-hammer-70.png"))); // NOI18N
        getContentPane().add(dangerousfood9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 90, 70, 80));

        dangerousfood3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shoes-70.png"))); // NOI18N
        getContentPane().add(dangerousfood3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1518, 40, 80, 50));

        food4Pretzel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-pretzel-70.png"))); // NOI18N
        food4Pretzel.setText("jLabel3");
        getContentPane().add(food4Pretzel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1650, 80, 70, -1));

        food5kfc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-kfc-chicken-70.png"))); // NOI18N
        getContentPane().add(food5kfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 90, 70, 60));

        food6bananasplit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-banana-split-70.png"))); // NOI18N
        getContentPane().add(food6bananasplit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1703, 10, 70, 60));

        food8icecreamcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bone-70.png"))); // NOI18N
        food8icecreamcone.setText("jLabel1");
        getContentPane().add(food8icecreamcone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 90, 60, 80));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/9413 (1).png"))); // NOI18N
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 400, 350));

        jLabel26.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel26.setText("Boss is using 100% of his power, so ");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 660, 50));

        jLabel27.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel27.setText("\"Use the right and left arrow keys ");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 480, 50));

        jLabel28.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel28.setText(" to move your character. Catch the ");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 670, 50));

        jLabel29.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel29.setText(" there are Four things you need to avoid.\"");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 560, 50));

        jLabel30.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel30.setText(" food and avoid the inedible items. ");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 500, 50));
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, -1));

        jButton6.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jButton6.setText("GOT IT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 150, 50));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 980, 400));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/9413 (1).png"))); // NOI18N
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 400, 350));

        jLabel19.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel19.setText("Boss is using 50% of his power, so ");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 660, 50));

        jLabel20.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel20.setText("\"Use the right and left arrow keys ");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 480, 50));

        jLabel21.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel21.setText(" to move your character. Catch the ");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 670, 50));

        jLabel22.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel22.setText(" there are three things you need to avoid.\"");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 560, 50));

        jLabel23.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel23.setText(" food and avoid the inedible items. ");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 500, 50));
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, -1));

        jButton5.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jButton5.setText("GOT IT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 150, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 980, 400));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/9413 (1).png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 400, 350));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel4.setText("final boss is away, so there is only  ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 660, 50));

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel7.setText("\"Use the right and left arrow keys ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 480, 50));

        jLabel14.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel14.setText(" to move your character. Catch the ");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 670, 50));

        jLabel15.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel15.setText("one thing you need to avoid.\"");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 660, 50));

        jLabel16.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel16.setText(" food and avoid the inedible items. ");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 670, 50));
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, -1));

        jButton4.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jButton4.setText("GOT IT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 150, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 950, 400));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1105, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/file.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 420, 300));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,50));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 59)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("GAME DIFFICULTY");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, 126));

        jButton1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Screenshot_2024-05-10_121643-removebg-preview (1) (1).png"))); // NOI18N
        jButton1.setText("HARD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 274, 109));

        jButton2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Screenshot_2024-05-10_121627-removebg-preview (1) (2).png"))); // NOI18N
        jButton2.setText("EASY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 274, 106));

        jButton3.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Screenshot_2024-05-10_121652-removebg-preview (1) (1).png"))); // NOI18N
        jButton3.setText("INSANE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 274, 110));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 780, 630));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue Green Illustrated Dog and Nature Desktop Wallpaper (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1920, 1090));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
 jPanel2.setVisible(false);
 jPanel5.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
jPanel2.setVisible(false);
jPanel3.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
jPanel2.setVisible(false);
jPanel4.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 ingame e= new ingame();
        e.setVisible(true);
        dispose();
    stopBackgroundMusic();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 Hard e= new Hard();
        e.setVisible(true);
        dispose();
 stopBackgroundMusic();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
  Insane e= new Insane();
        e.setVisible(true);
        dispose();
       
 stopBackgroundMusic();

    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(GameDifficulty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameDifficulty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameDifficulty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameDifficulty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameDifficulty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dangerousfood3;
    private javax.swing.JLabel dangerousfood9;
    private javax.swing.JLabel food4Pretzel;
    private javax.swing.JLabel food5kfc;
    private javax.swing.JLabel food6bananasplit;
    private javax.swing.JLabel food8icecreamcone;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
