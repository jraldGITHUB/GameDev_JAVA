/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.Timer;

public class story extends javax.swing.JFrame {
  private Timer timer;
       private Timer timedan; 
   private int fallSpeed = 12;
   
    private Clip SuccessClip;     
  private Clip gameOverClip;    
  private Clip clip;
    private int initialX;
    private int initialY; 
    private int score = 0;
    private int missCount = 0;
    private final int maxMissCount = 3; 
    private int characterX;
    private JLabel[] foodLabels = new JLabel[15];
    private int currentFoodIndex = 0; 
 private Timer airplaneTimer;
    private int airplaneX = -90; 
    private int airplaneY = 0; 
    private int currentDangerousFoodIndex = 0;
    private JLabel[] dangerousFoodLabels = new JLabel[5]; 
    public story() {
        initComponents();
         playBackgroundMusic();
        
            foodLabels[0] = food4fries;
        foodLabels[1] = food1pizza;
        foodLabels[2] =  food4Pretzel;
         foodLabels[3] = food6bananasplit;
          foodLabels[4] =food3barbique;
           foodLabels[5] = food5kfc;
          foodLabels[6] = food2egg;
           foodLabels[7] = food7cottoncandy;
            foodLabels[8] = Dougnut;
             foodLabels[9] = food6bananasplit;
              foodLabels[10] =food8icecreamcone ; 
               foodLabels[11] = food3barbique;
                foodLabels[12] =food4Pretzel;
               foodLabels[13]= foodlasagna;
           foodLabels[14] = food6bananasplit;
 
       startFallingAnimation(foodLabels[currentFoodIndex]);
        
        
    }
 
    
    

    private void startFallingAnimation(JLabel label) {
           int initialY = label.getY();
    int maxY = jPanel1.getHeight() - label.getHeight();

    timer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          
            int newY = label.getY() + fallSpeed;
            if (newY <= maxY) {
                label.setLocation(label.getX(), newY);

                if (characterLabel.getBounds().intersects(label.getBounds())) {
                
                    label.setLocation(label.getX(), initialY);
                    timer.stop();
                    currentFoodIndex++;
                
                    if (currentFoodIndex < foodLabels.length) {
                        startFallingAnimation(foodLabels[currentFoodIndex]);
                    } else {
                        currentFoodIndex = 0;
                        startFallingAnimation(foodLabels[currentFoodIndex]);
                    }
                }
                       if (score == 15) {
                     
                        
                        }
            } else {
                
         
             

                if (missCount >= maxMissCount) {
                  
                } else {
                    label.setLocation(label.getX(), initialY);
                    timer.stop();
                    currentFoodIndex++;
                    if (currentFoodIndex < foodLabels.length) {
                        startFallingAnimation(foodLabels[currentFoodIndex]);
                    } else {
                        currentFoodIndex = 0;
                        startFallingAnimation(foodLabels[currentFoodIndex]);
                    }
                }
            }
             
        }
    });
    timer.start();
}  
       private void playBackgroundMusic() {
        try {
            URL url = getClass().getResource("/javaapplication2/Demon Slayer _ Kimetsu no Yaiba OP - Gurenge [8-bit VRC6].wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
      
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
          private void stopBackgroundMusic() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
       
       
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        characterLabel = new javax.swing.JLabel();
        food1pizza = new javax.swing.JLabel();
        s1 = new javax.swing.JLabel();
        food2egg = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        dangerousfood9 = new javax.swing.JLabel();
        dangerousfood7 = new javax.swing.JLabel();
        dangerousfood6 = new javax.swing.JLabel();
        dangerousfood = new javax.swing.JLabel();
        food4fries = new javax.swing.JLabel();
        dangerousfood3 = new javax.swing.JLabel();
        dangerousfood2 = new javax.swing.JLabel();
        food3barbique = new javax.swing.JLabel();
        food4Pretzel = new javax.swing.JLabel();
        food5kfc = new javax.swing.JLabel();
        food6bananasplit = new javax.swing.JLabel();
        dangerousfood4 = new javax.swing.JLabel();
        dangerousfood5 = new javax.swing.JLabel();
        food7cottoncandy = new javax.swing.JLabel();
        food8icecreamcone = new javax.swing.JLabel();
        foodlasagna = new javax.swing.JLabel();
        Dougnut = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, -20, 230, 190));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, -10, 220, 170));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, -10, 200, 180));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, -10, 200, 180));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 210, 190));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, -20, 190, 220));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, -10, 250, 180));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 10, 220, 180));

        characterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-dog-bowl-100.png"))); // NOI18N
        jPanel1.add(characterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 890, 90, 80));

        food1pizza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-salami-pizza-70.png"))); // NOI18N
        jPanel1.add(food1pizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, 70));

        s1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 27)); // NOI18N
        s1.setText(" John Lloyd was an adventurous soul with a heart full of curiosity and a dog named Sparky who was always by his side. ");
        jPanel1.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 60));

        food2egg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-sunny-side-up-eggs-70.png"))); // NOI18N
        jPanel1.add(food2egg, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 60, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("NEXT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 550, 140, 60));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("SKIP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1570, 550, 140, 60));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cellphone-70.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 70, 80));

        dangerousfood9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-hammer-70.png"))); // NOI18N
        jPanel1.add(dangerousfood9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 90, 70, 80));

        dangerousfood7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bike-70.png"))); // NOI18N
        jPanel1.add(dangerousfood7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 90, 80, -1));

        dangerousfood6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-body-armor-70.png"))); // NOI18N
        jPanel1.add(dangerousfood6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, 80));

        dangerousfood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chili-pepper-70.png"))); // NOI18N
        jPanel1.add(dangerousfood, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 5, 80, 70));

        food4fries.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-mcdonald`s-french-fries-70.png"))); // NOI18N
        food4fries.setText("jLabel1");
        jPanel1.add(food4fries, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 60, 80));

        dangerousfood3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shoes-70.png"))); // NOI18N
        jPanel1.add(dangerousfood3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1518, 40, 80, 50));

        dangerousfood2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-poop-70.png"))); // NOI18N
        dangerousfood2.setText("jLabel1");
        jPanel1.add(dangerousfood2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 80, 70));

        food3barbique.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-barbecue-70.png"))); // NOI18N
        food3barbique.setText("jLabel2");
        jPanel1.add(food3barbique, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 70, -1));

        food4Pretzel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-pretzel-70.png"))); // NOI18N
        food4Pretzel.setText("jLabel3");
        jPanel1.add(food4Pretzel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1650, 80, 70, -1));

        food5kfc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-kfc-chicken-70.png"))); // NOI18N
        jPanel1.add(food5kfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 90, 70, 60));

        food6bananasplit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-banana-split-70.png"))); // NOI18N
        jPanel1.add(food6bananasplit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1703, 10, 70, 60));

        dangerousfood4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-panty-70.png"))); // NOI18N
        jPanel1.add(dangerousfood4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1015, 93, 60, 70));

        dangerousfood5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-socks-70.png"))); // NOI18N
        jPanel1.add(dangerousfood5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 60, 60));

        food7cottoncandy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cotton-candy-70.png"))); // NOI18N
        jPanel1.add(food7cottoncandy, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 90, 90));

        food8icecreamcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bone-70.png"))); // NOI18N
        food8icecreamcone.setText("jLabel1");
        jPanel1.add(food8icecreamcone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 90, 60, 80));

        foodlasagna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-lasagna-70.png"))); // NOI18N
        foodlasagna.setText("jLabel5");
        jPanel1.add(foodlasagna, new org.netbeans.lib.awtextra.AbsoluteConstraints(791, 76, 70, 60));

        Dougnut.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jrald Baco\\Downloads\\icons8-doughnut-70.png")); // NOI18N
        jPanel1.add(Dougnut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 90, 70, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/f98fc2fc9a9e290580817a3ab118f593.gif"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 660, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Screenshot_2024-05-10_121627-removebg-preview (1).png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stickman-transparent-background-1 (1).png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 630, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue Green Illustrated Dog and Nature Desktop Wallpaper (1).png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -20, 1920, 1090));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       GameDifficulty h=new GameDifficulty();
        h.setVisible(true);
        dispose();
stopBackgroundMusic();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Story2 e= new Story2();
        e.setVisible(true);
        dispose();
       stopBackgroundMusic();
       
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(story.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(story.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(story.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(story.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new story().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dougnut;
    private javax.swing.JLabel characterLabel;
    private javax.swing.JLabel dangerousfood;
    private javax.swing.JLabel dangerousfood2;
    private javax.swing.JLabel dangerousfood3;
    private javax.swing.JLabel dangerousfood4;
    private javax.swing.JLabel dangerousfood5;
    private javax.swing.JLabel dangerousfood6;
    private javax.swing.JLabel dangerousfood7;
    private javax.swing.JLabel dangerousfood9;
    private javax.swing.JLabel food1pizza;
    private javax.swing.JLabel food2egg;
    private javax.swing.JLabel food3barbique;
    private javax.swing.JLabel food4Pretzel;
    private javax.swing.JLabel food4fries;
    private javax.swing.JLabel food5kfc;
    private javax.swing.JLabel food6bananasplit;
    private javax.swing.JLabel food7cottoncandy;
    private javax.swing.JLabel food8icecreamcone;
    private javax.swing.JLabel foodlasagna;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel s1;
    // End of variables declaration//GEN-END:variables
}
