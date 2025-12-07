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

/**
 *
 * @author Jrald Baco
 */
public class Story2 extends javax.swing.JFrame {

     private Timer timer;
       private Timer timedan;
       private Timer timedan2;
       private Timer timedan3;
        private Timer timedan4;
         private Timer bossMovementTimer;
  
  private Clip clip;
    private int initialX;
    private int initialY; 
    private int score = 0;
    private int missCount = 0;
    private final int maxMissCount = 3; 
    private int characterX;
   
    private int currentFoodIndex = 0;
    private int currentDangerousFoodIndex = 0;
    private int currentFoodIndex2 = 0;
    private int currentDangerousFoodIndex2= 0;
    private int currentFoodIndex3 = 0;
    private int currentDangerousFoodIndex3 = 0;
    private int currentFoodIndex4 = 0;
    private int currentDangerousFoodIndex4 = 0;
    private Timer airplaneTimer;
    private int airplaneX = -90; 
    private int airplaneY = 0;
    
    private JLabel[] foodLabels = new JLabel[15];
    private JLabel[] dangerousFoodLabels = new JLabel[6]; 
    private JLabel[] dangerousFoodLabels1= new JLabel[5];
    private JLabel[] dangerousFoodLabels2= new JLabel[6];
    private JLabel[] dangerousFoodLabels3= new JLabel[4];
    
    public Story2() {
        initComponents();
        f2.setVisible(false);
     playBackgroundMusic();
        s7.setVisible(false);
        s8.setVisible(false);
        s9.setVisible(false);
        s10.setVisible(false);
        MainMenu.setVisible(false);
startBossMovementAnimation();


       dangerousFoodLabels[0] = dangerousfood10;
dangerousFoodLabels[1] = dangerousfood9;
dangerousFoodLabels[2] = dangerousfood8;
dangerousFoodLabels[3] = dangerousfood7;
dangerousFoodLabels[4] = dangerousfood6;
dangerousFoodLabels[5] = dangerousfood5;


 dangerousFoodLabels3[0] = dangerousfood18;
dangerousFoodLabels3[1] = dangerousfood21;
dangerousFoodLabels3[2] = dangerousfood20;
dangerousFoodLabels3[3] = dangerousfood19;


       dangerousFoodLabels1[0] = dangerousfood12;
dangerousFoodLabels1[1] = dangerousfood11;
dangerousFoodLabels1[2] = dangerousfood3;
dangerousFoodLabels1[3] = dangerousfood2;
dangerousFoodLabels1[4] = dangerousfood;




 
       dangerousFoodLabels2[0] = dangerousfood13;
dangerousFoodLabels2[1] = dangerousfood14;
dangerousFoodLabels2[2] = dangerousfood15;
dangerousFoodLabels2[3] = dangerousfood16;
dangerousFoodLabels2[4] = dangerousfood17;
dangerousFoodLabels2[5] = dangerousfood4;

 
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
      
       startFallingDangerousFoodAnimation4(dangerousFoodLabels3[currentDangerousFoodIndex4]);        
      startFallingDangerousFoodAnimation3(dangerousFoodLabels2[currentDangerousFoodIndex3]);      
     startFallingDangerousFoodAnimation2(dangerousFoodLabels1[currentDangerousFoodIndex2]);
       startFallingDangerousFoodAnimation(dangerousFoodLabels[currentDangerousFoodIndex]);
        startFallingAnimation(foodLabels[currentFoodIndex]);
    }

    private void startFallingAnimation(JLabel label) {
           int initialY = label.getY();
    int maxY = jPanel1.getHeight() - label.getHeight();

    timer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          
            int newY = label.getY() + 12;
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
                if (score == 40) {
                       
                        
                        }
                   
            } else {
                
                missCount++;
         
             

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
private void startFallingDangerousFoodAnimation(JLabel label) {
    int initialY = label.getY();
    int maxY = jPanel1.getHeight() - label.getHeight();

  timedan = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        
                int newY = label.getY() + 17;
                if (newY <= maxY) {
                    label.setLocation(label.getX(), newY);

                    if (characterLabel.getBounds().intersects(label.getBounds())) { 
                     
                        if (missCount >= maxMissCount) {
                          
                            timedan.stop();
                        } else {
                            label.setLocation(label.getX(), initialY);

                            // Check if there are more dangerous food items to drop
                            currentDangerousFoodIndex++;
                            if (currentDangerousFoodIndex < dangerousFoodLabels.length) {
                          
                                startFallingDangerousFoodAnimation(dangerousFoodLabels[currentDangerousFoodIndex]);
                            } else {
                                currentDangerousFoodIndex = 0;
                                // Start dropping from the beginning again
                                startFallingDangerousFoodAnimation(dangerousFoodLabels[currentDangerousFoodIndex]);
                            }
                        }
                        ((Timer) e.getSource()).stop();
                    }
                } else {
                    // Reset label position
                    label.setLocation(label.getX(), initialY);

                    // Check if there are more dangerous food items to drop
                    currentDangerousFoodIndex++;
                    if (currentDangerousFoodIndex < dangerousFoodLabels.length) {
                        // Start dropping the next dangerous food item
                        startFallingDangerousFoodAnimation(dangerousFoodLabels[currentDangerousFoodIndex]);
                    } else {
                        currentDangerousFoodIndex = 0;
                        // Start dropping from the beginning again
                        startFallingDangerousFoodAnimation(dangerousFoodLabels[currentDangerousFoodIndex]);
                    }

                    ((Timer) e.getSource()).stop();
                }
            
        }
    });
    timedan.start();
}
private void startFallingDangerousFoodAnimation2(JLabel label) {
    int initialY = label.getY();
    int maxY = jPanel1.getHeight() - label.getHeight();

  timedan2 = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        
                int newY = label.getY() + 15;
                if (newY <= maxY) {
                    label.setLocation(label.getX(), newY);

                    if (characterLabel.getBounds().intersects(label.getBounds())) { 
                        missCount++;
                        if (missCount >= maxMissCount) {
                       
                            timedan2.stop();
                        } else {
                            label.setLocation(label.getX(), initialY);

                            // Check if there are more dangerous food items to drop
                            currentDangerousFoodIndex2++;
                            if (currentDangerousFoodIndex2 < dangerousFoodLabels1.length) {
                          
                                startFallingDangerousFoodAnimation2(dangerousFoodLabels1[currentDangerousFoodIndex2]);
                            } else {
                                currentDangerousFoodIndex2 = 0;
                                // Start dropping from the beginning again
                                startFallingDangerousFoodAnimation2(dangerousFoodLabels1[currentDangerousFoodIndex2]);
                            }
                        }
                        ((Timer) e.getSource()).stop();
                    }
                } else {
                    // Reset label position
                    label.setLocation(label.getX(), initialY);

                    // Check if there are more dangerous food items to drop
                    currentDangerousFoodIndex2++;
                    if (currentDangerousFoodIndex2 < dangerousFoodLabels1.length) {
                        // Start dropping the next dangerous food item
                        startFallingDangerousFoodAnimation2(dangerousFoodLabels1[currentDangerousFoodIndex2]);
                    } else {
                        currentDangerousFoodIndex2 = 0;
                        // Start dropping from the beginning again
                        startFallingDangerousFoodAnimation2(dangerousFoodLabels1[currentDangerousFoodIndex2]);
                    }

                    ((Timer) e.getSource()).stop();
                }
            
        }
    });
    timedan2.start();
}

private void startFallingDangerousFoodAnimation3(JLabel label) {
    int initialY = label.getY();
    int maxY = jPanel1.getHeight() - label.getHeight();

  timedan3 = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        
                int newY = label.getY() + 16;
                if (newY <= maxY) {
                    label.setLocation(label.getX(), newY);

                    if (characterLabel.getBounds().intersects(label.getBounds())) { 
                        missCount++;
                        if (missCount >= maxMissCount) {

                            timedan3.stop();
                        } else {
                            label.setLocation(label.getX(), initialY);

                            // Check if there are more dangerous food items to drop
                            currentDangerousFoodIndex3++;
                            if (currentDangerousFoodIndex3 < dangerousFoodLabels2.length) {
                          
                                startFallingDangerousFoodAnimation3(dangerousFoodLabels2[currentDangerousFoodIndex3]);
                            } else {
                                currentDangerousFoodIndex3 = 0;
                                // Start dropping from the beginning again
                                startFallingDangerousFoodAnimation3(dangerousFoodLabels2[currentDangerousFoodIndex3]);
                            }
                        }
                        ((Timer) e.getSource()).stop();
                    }
                } else {
                    // Reset label position
                    label.setLocation(label.getX(), initialY);

                    // Check if there are more dangerous food items to drop
                    currentDangerousFoodIndex3++;
                    if (currentDangerousFoodIndex3 < dangerousFoodLabels2.length) {
                        // Start dropping the next dangerous food item
                        startFallingDangerousFoodAnimation3(dangerousFoodLabels2[currentDangerousFoodIndex3]);
                    } else {
                        currentDangerousFoodIndex3 = 0;
                        
                        startFallingDangerousFoodAnimation3(dangerousFoodLabels2[currentDangerousFoodIndex3]);
                    }

                    ((Timer) e.getSource()).stop();
                }
            
        }
    });
    timedan3.start();
}

private void startFallingDangerousFoodAnimation4(JLabel label) {
    int initialY = label.getY();
    int maxY = jPanel1.getHeight() - label.getHeight();

  timedan4 = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        
                int newY = label.getY() + 19;
                if (newY <= maxY) {
                    label.setLocation(label.getX(), newY);

                    if (characterLabel.getBounds().intersects(label.getBounds())) { 
                        missCount++;
                        if (missCount >= maxMissCount) {
                  
                            timedan4.stop();
                        } else {
                            label.setLocation(label.getX(), initialY);

                            // Check if there are more dangerous food items to drop
                            currentDangerousFoodIndex4++;
                            if (currentDangerousFoodIndex4 < dangerousFoodLabels3.length) {
                          
                                startFallingDangerousFoodAnimation4(dangerousFoodLabels3[currentDangerousFoodIndex4]);
                            } else {
                                currentDangerousFoodIndex4 = 0;
                                // Start dropping from the beginning again
                                startFallingDangerousFoodAnimation4(dangerousFoodLabels3[currentDangerousFoodIndex4]);
                            }
                        }
                        ((Timer) e.getSource()).stop();
                    }
                } else {
                    // Reset label position
                    label.setLocation(label.getX(), initialY);

                    // Check if there are more dangerous food items to drop
                    currentDangerousFoodIndex4++;
                    if (currentDangerousFoodIndex4 < dangerousFoodLabels3.length) {
                        // Start dropping the next dangerous food item
                        startFallingDangerousFoodAnimation4(dangerousFoodLabels3[currentDangerousFoodIndex4]);
                    } else {
                        currentDangerousFoodIndex4 = 0;
                        
                        startFallingDangerousFoodAnimation4(dangerousFoodLabels3[currentDangerousFoodIndex4]);
                    }

                    ((Timer) e.getSource()).stop();
                }
            
        }
    });
    timedan4.start();
}
 private void startBossMovementAnimation() {
     
  boss.setLocation(0, 0);
        bossMovementTimer = new Timer(20, new ActionListener() {
            int direction = 5; // Positive value for right, negative for left

            @Override
            public void actionPerformed(ActionEvent e) {
                int newX = boss.getX() + direction;
                if (newX < 0 || newX + boss.getWidth() > jPanel1.getWidth()) {
                    direction *= -1; // Change direction
                }
                boss.setLocation(newX, boss.getY());
            }
        });
        bossMovementTimer.start();
    }
     private void stopBackgroundMusic() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
   private void playBackgroundMusic() {
        try {
            URL url = getClass().getResource("/javaapplication2/Attack on Titan Final Season Part 2 OP - The Rumbling [8-bit VRC6] (ft. Fabulous Reindeer).wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
                 clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        boss = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        s3 = new javax.swing.JLabel();
        s4 = new javax.swing.JLabel();
        s5 = new javax.swing.JLabel();
        s6 = new javax.swing.JLabel();
        s7 = new javax.swing.JLabel();
        s8 = new javax.swing.JLabel();
        s9 = new javax.swing.JLabel();
        s10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        MainMenu = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        characterLabel = new javax.swing.JLabel();
        food1pizza = new javax.swing.JLabel();
        food2egg = new javax.swing.JLabel();
        food4fries = new javax.swing.JLabel();
        food3barbique = new javax.swing.JLabel();
        food4Pretzel = new javax.swing.JLabel();
        food5kfc = new javax.swing.JLabel();
        food6bananasplit = new javax.swing.JLabel();
        food7cottoncandy = new javax.swing.JLabel();
        food8icecreamcone = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        foodlasagna = new javax.swing.JLabel();
        f2 = new javax.swing.JLabel();
        dangerousfood = new javax.swing.JLabel();
        dangerousfood2 = new javax.swing.JLabel();
        dangerousfood3 = new javax.swing.JLabel();
        dangerousfood4 = new javax.swing.JLabel();
        dangerousfood5 = new javax.swing.JLabel();
        dangerousfood6 = new javax.swing.JLabel();
        dangerousfood7 = new javax.swing.JLabel();
        dangerousfood8 = new javax.swing.JLabel();
        dangerousfood9 = new javax.swing.JLabel();
        dangerousfood10 = new javax.swing.JLabel();
        dangerousfood11 = new javax.swing.JLabel();
        dangerousfood12 = new javax.swing.JLabel();
        dangerousfood13 = new javax.swing.JLabel();
        dangerousfood14 = new javax.swing.JLabel();
        dangerousfood15 = new javax.swing.JLabel();
        dangerousfood16 = new javax.swing.JLabel();
        dangerousfood17 = new javax.swing.JLabel();
        dangerousfood18 = new javax.swing.JLabel();
        dangerousfood19 = new javax.swing.JLabel();
        dangerousfood20 = new javax.swing.JLabel();
        dangerousfood21 = new javax.swing.JLabel();
        dangerousfood22 = new javax.swing.JLabel();
        dangerousfood23 = new javax.swing.JLabel();
        Dougnut = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 40, -1, 260));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 200, 240));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 30, 200, 250));

        boss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/final boss.png"))); // NOI18N
        jPanel1.add(boss, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, -60, -1, 440));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/f98fc2fc9a9e290580817a3ab118f593.gif"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 640, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 210, 260));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 200, 230));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 20, 220, 260));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, 210, 290));

        s3.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 27)); // NOI18N
        s3.setForeground(new java.awt.Color(255, 255, 255));
        s3.setText("One sunny afternoon, while John Lloyd and Sparky were enjoying a picnic in the park, something strange began to happen. ");
        jPanel1.add(s3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 1870, 40));

        s4.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 27)); // NOI18N
        s4.setForeground(new java.awt.Color(255, 255, 255));
        s4.setText("From this UFO, objects began to rain down—but not the delicious foods that Foodelians were used to instead a inedible items like");
        jPanel1.add(s4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 1910, 60));

        s5.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 27)); // NOI18N
        s5.setForeground(new java.awt.Color(255, 255, 255));
        s5.setText(" Poop, Bikes, and broken gadgets began to fall from the sky.");
        jPanel1.add(s5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 1180, 60));

        s6.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 27)); // NOI18N
        s6.setForeground(new java.awt.Color(255, 255, 255));
        s6.setText(" The sky, usually clear and blue, started to darken. John Lloyd looked up and saw a shiny, metallic UFO hovering above the town. ");
        jPanel1.add(s6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 1920, 60));

        s7.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 27)); // NOI18N
        s7.setForeground(new java.awt.Color(255, 255, 255));
        s7.setText("Through the open hatch of the UFO, they saw a sinister figure—Busano, the mischievous alien who hated all things delicious ");
        jPanel1.add(s7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 1860, 60));

        s8.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 27)); // NOI18N
        s8.setForeground(new java.awt.Color(255, 255, 255));
        s8.setText("and edible. Busano had always been envious of Foodelia's culinary delights and had now decided to spoil everyone's fun by ");
        jPanel1.add(s8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 1840, 60));

        s9.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 27)); // NOI18N
        s9.setForeground(new java.awt.Color(255, 255, 255));
        s9.setText("raining down useless junk.Johnllyod is furious and determined to fight Busano but he is too hungry he needs energy and his dog ");
        jPanel1.add(s9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 1900, 60));

        s10.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 27)); // NOI18N
        s10.setForeground(new java.awt.Color(255, 255, 255));
        s10.setText("to fight him so johnllyod catch the food to get his energy and powers to beat Busano and save the town Foodelia");
        jPanel1.add(s10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 1720, 60));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, 230));

        MainMenu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        MainMenu.setText("START");
        MainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuActionPerformed(evt);
            }
        });
        jPanel1.add(MainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1670, 780, 130, 70));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, -10, -1, 270));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 10, 220, 250));

        characterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-dog-bowl-100.png"))); // NOI18N
        jPanel1.add(characterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 850, 90, 80));

        food1pizza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-salami-pizza-70.png"))); // NOI18N
        jPanel1.add(food1pizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, 70));

        food2egg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-sunny-side-up-eggs-70.png"))); // NOI18N
        jPanel1.add(food2egg, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 30, 70, -1));

        food4fries.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-mcdonald`s-french-fries-70.png"))); // NOI18N
        food4fries.setText("jLabel1");
        jPanel1.add(food4fries, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 60, 80));

        food3barbique.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-barbecue-70.png"))); // NOI18N
        food3barbique.setText("jLabel2");
        jPanel1.add(food3barbique, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 70, -1));

        food4Pretzel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-pretzel-70.png"))); // NOI18N
        food4Pretzel.setText("jLabel3");
        jPanel1.add(food4Pretzel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 60, 70, -1));

        food5kfc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-kfc-chicken-70.png"))); // NOI18N
        jPanel1.add(food5kfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1570, 50, 70, 60));

        food6bananasplit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-banana-split-70.png"))); // NOI18N
        jPanel1.add(food6bananasplit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 40, 70, 60));

        food7cottoncandy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-pancake-stack-70.png"))); // NOI18N
        jPanel1.add(food7cottoncandy, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 90, 90));

        food8icecreamcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bone-70.png"))); // NOI18N
        food8icecreamcone.setText("jLabel1");
        jPanel1.add(food8icecreamcone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 40, 70, 80));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("NEXT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 630, 140, 60));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("SKIP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1650, 630, 140, 60));

        foodlasagna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-lasagna-70.png"))); // NOI18N
        foodlasagna.setText("jLabel5");
        jPanel1.add(foodlasagna, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 70, 60));

        f2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Screenshot_2024-05-10_121652-removebg-preview (1).png"))); // NOI18N
        jPanel1.add(f2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 210, 270));

        dangerousfood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chili-pepper-70.png"))); // NOI18N
        jPanel1.add(dangerousfood, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 80, 70));

        dangerousfood2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-poop-70.png"))); // NOI18N
        dangerousfood2.setText("jLabel1");
        jPanel1.add(dangerousfood2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 80, 80, 70));

        dangerousfood3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shoes-70.png"))); // NOI18N
        jPanel1.add(dangerousfood3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1670, 50, 80, 50));

        dangerousfood4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-panty-70.png"))); // NOI18N
        jPanel1.add(dangerousfood4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 60, 70));

        dangerousfood5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-socks-70.png"))); // NOI18N
        jPanel1.add(dangerousfood5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 60, 60));

        dangerousfood6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-body-armor-70.png"))); // NOI18N
        jPanel1.add(dangerousfood6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 60, -1, 80));

        dangerousfood7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bike-70.png"))); // NOI18N
        jPanel1.add(dangerousfood7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 70, 80, -1));

        dangerousfood8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-book-70.png"))); // NOI18N
        jPanel1.add(dangerousfood8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 80, -1, 70));

        dangerousfood9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-hammer-70.png"))); // NOI18N
        jPanel1.add(dangerousfood9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1670, 50, 70, 80));

        dangerousfood10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cellphone-70.png"))); // NOI18N
        jPanel1.add(dangerousfood10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 60, 70, 80));

        dangerousfood11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chair-70.png"))); // NOI18N
        jPanel1.add(dangerousfood11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 70, 70, 60));

        dangerousfood12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-electric-fan-70.png"))); // NOI18N
        jPanel1.add(dangerousfood12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 70, -1, -1));

        dangerousfood13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/icons8-gun-70.png"))); // NOI18N
        jPanel1.add(dangerousfood13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 70, -1));

        dangerousfood14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-broom-70.png"))); // NOI18N
        jPanel1.add(dangerousfood14, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, -1, -1));

        dangerousfood15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-money-70.png"))); // NOI18N
        jPanel1.add(dangerousfood15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        dangerousfood16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-metal-70.png"))); // NOI18N
        jPanel1.add(dangerousfood16, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, -1, -1));

        dangerousfood17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shades-70.png"))); // NOI18N
        jPanel1.add(dangerousfood17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        dangerousfood18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-poop-70.png"))); // NOI18N
        jPanel1.add(dangerousfood18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        dangerousfood19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-poop-70.png"))); // NOI18N
        jPanel1.add(dangerousfood19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1700, 60, -1, -1));

        dangerousfood20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shoes-70.png"))); // NOI18N
        jPanel1.add(dangerousfood20, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, -1, -1));

        dangerousfood21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-socks-70.png"))); // NOI18N
        jPanel1.add(dangerousfood21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1640, 50, -1, -1));

        dangerousfood22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-metal-70.png"))); // NOI18N
        jPanel1.add(dangerousfood22, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));

        dangerousfood23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chair-70.png"))); // NOI18N
        jPanel1.add(dangerousfood23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 90, -1, -1));

        Dougnut.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jrald Baco\\Downloads\\icons8-doughnut-70.png")); // NOI18N
        jPanel1.add(Dougnut, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 70, 60));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Screenshot_2024-05-10_121643-removebg-preview (1).png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 150, 220));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stickman-transparent-background-1 (1).png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 630, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue Green Illustrated Dog and Nature Desktop Wallpaper (3).png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1920, 1060));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     s3.setVisible(false);
 s4.setVisible(false);
 s5.setVisible(false);
 s6.setVisible(false);
 s7.setVisible(true);
 s8.setVisible(true);
 jButton1.setVisible(false);
 f2.setVisible(true);
   jButton2.setVisible(false);
    jLabel17.setVisible(false);
     s9.setVisible(true);
       s10.setVisible(true);
        MainMenu.setVisible(true);
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        GameDifficulty h=new GameDifficulty();
        h.setVisible(true);
        dispose();
stopBackgroundMusic();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void MainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuActionPerformed
        GameDifficulty h=new GameDifficulty();
        h.setVisible(true);
        dispose();
stopBackgroundMusic();
    }//GEN-LAST:event_MainMenuActionPerformed

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
            java.util.logging.Logger.getLogger(Story2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Story2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Story2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Story2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Story2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dougnut;
    private javax.swing.JButton MainMenu;
    private javax.swing.JLabel boss;
    private javax.swing.JLabel characterLabel;
    private javax.swing.JLabel dangerousfood;
    private javax.swing.JLabel dangerousfood10;
    private javax.swing.JLabel dangerousfood11;
    private javax.swing.JLabel dangerousfood12;
    private javax.swing.JLabel dangerousfood13;
    private javax.swing.JLabel dangerousfood14;
    private javax.swing.JLabel dangerousfood15;
    private javax.swing.JLabel dangerousfood16;
    private javax.swing.JLabel dangerousfood17;
    private javax.swing.JLabel dangerousfood18;
    private javax.swing.JLabel dangerousfood19;
    private javax.swing.JLabel dangerousfood2;
    private javax.swing.JLabel dangerousfood20;
    private javax.swing.JLabel dangerousfood21;
    private javax.swing.JLabel dangerousfood22;
    private javax.swing.JLabel dangerousfood23;
    private javax.swing.JLabel dangerousfood3;
    private javax.swing.JLabel dangerousfood4;
    private javax.swing.JLabel dangerousfood5;
    private javax.swing.JLabel dangerousfood6;
    private javax.swing.JLabel dangerousfood7;
    private javax.swing.JLabel dangerousfood8;
    private javax.swing.JLabel dangerousfood9;
    private javax.swing.JLabel f2;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel s10;
    private javax.swing.JLabel s3;
    private javax.swing.JLabel s4;
    private javax.swing.JLabel s5;
    private javax.swing.JLabel s6;
    private javax.swing.JLabel s7;
    private javax.swing.JLabel s8;
    private javax.swing.JLabel s9;
    // End of variables declaration//GEN-END:variables
}
