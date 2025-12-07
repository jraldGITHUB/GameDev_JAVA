
package javaapplication2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.io.IOException;
import javax.sound.sampled.*;

public class Hard extends javax.swing.JFrame implements KeyListener {
       private Timer timer;
       private Timer timedan;
       private Timer timedan2;
       private Timer timedan3;
 private Timer bossMovementTimer;
  private Clip SuccessClip;     
  private Clip gameOverClip;    
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


    private Timer airplaneTimer;
    private int airplaneX = -90; 
    private int airplaneY = 0;
    
    private JLabel[] foodLabels = new JLabel[15];
    private JLabel[] dangerousFoodLabels = new JLabel[6]; 
    private JLabel[] dangerousFoodLabels1= new JLabel[5];
    private JLabel[] dangerousFoodLabels2= new JLabel[6];

    
    public Hard() {
        initComponents();
        addKeyListener(this);
        setFocusable(true);
  jPanel2.setVisible(false);
  jPanel3.setVisible(false);
  Success.setVisible(false);

startAirplaneAnimation();
playBackgroundMusic();
startBossMovementAnimation();
       dangerousFoodLabels[0] = dangerousfood10;
dangerousFoodLabels[1] = dangerousfood9;
dangerousFoodLabels[2] = dangerousfood8;
dangerousFoodLabels[3] = dangerousfood7;
dangerousFoodLabels[4] = dangerousfood6;
dangerousFoodLabels[5] = dangerousfood5;





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
          
            int newY = label.getY() + 8;
            if (newY <= maxY) {
                label.setLocation(label.getX(), newY);

                if (characterLabel.getBounds().intersects(label.getBounds())) {
                 score++;
         Score.setText("Score: " + score);
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
                  if (score == 10) {
                            success();
                        
                        }
                   
            } else {
                
                missCount++;
         
             

                if (missCount >= maxMissCount) {
                    gameOver();
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
                        missCount++;
                        if (missCount >= maxMissCount) {
                            gameOver();
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
                            gameOver();
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
                            gameOver();
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


    private void stopBackgroundMusic() {
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
  private void playGameOverSound() {
        try {
            URL url = getClass().getResource("/javaapplication2/SUPER MARIO - game over - sound effect.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            gameOverClip = AudioSystem.getClip();
            gameOverClip.open(audioIn);
            gameOverClip.start(); // Play once, no loop
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    
  }
   private void playSuccessSound() {
        try {
            URL url = getClass().getResource("/javaapplication2/GTA San Andreas Mission Passed - Sound Effect (HD).wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
           SuccessClip = AudioSystem.getClip();
            SuccessClip.open(audioIn);
            SuccessClip.start(); // Play once, no loop
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    
  }
 private void success(){
       pause.setVisible(false);
       Success.setVisible(true);
      
         timer.stop();
        timedan.stop();
         timedan2.stop();
          timedan3.stop();
        
stopBackgroundMusic();
 playSuccessSound();
 
   } 
  private void resetGame() {
  
    score = 0;
    missCount = 0;

    Score.setText("Score: " + score);
  
}      
        
        
    private void gameOver() {
         
        ScoreinGameOver.setText("Score: " + score);
        timer.stop();
        timedan.stop();
         timedan2.stop();
          timedan3.stop();
         
           stopBackgroundMusic();
           playGameOverSound();
         
        
        
       jPanel3.setVisible(true);
        missCount = 0;
        pause.setVisible(false);
    }


        @Override
    public void keyTyped(KeyEvent e) {
  
    }

    @Override
    public void keyPressed(KeyEvent e) {
      int currentX = characterLabel.getX();
    int currentY = characterLabel.getY();
    int stepSize = 35;

     if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            int newX = currentX - stepSize;
            if (newX >= 0) {
                characterLabel.setLocation(newX, currentY);
  
                characterX = newX;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            int newX = currentX + stepSize;
            if (newX + characterLabel.getWidth() <= jPanel1.getWidth()) {
                characterLabel.setLocation(newX, currentY);
                
                characterX = newX;
        }
    }

    
    }
   private void startAirplaneAnimation() {
        airplaneTimer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                airplaneX += 5; 
                airplane.setLocation(airplaneX, airplaneY);

              
                if (airplaneX > jPanel1.getWidth()) {
                    airplaneX = -90;
                    airplane.setLocation(airplaneX, airplaneY);
                }
            }
        
        });
        airplaneTimer.start();
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



    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Score = new javax.swing.JTextPane();
        pause = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        boss = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Success = new javax.swing.JPanel();
        SuccessLabel = new javax.swing.JLabel();
        MainMenu = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        characterLabel = new javax.swing.JLabel();
        airplane = new javax.swing.JLabel();
        food1pizza = new javax.swing.JLabel();
        food2egg = new javax.swing.JLabel();
        food4fries = new javax.swing.JLabel();
        food3barbique = new javax.swing.JLabel();
        food4Pretzel = new javax.swing.JLabel();
        food5kfc = new javax.swing.JLabel();
        food6bananasplit = new javax.swing.JLabel();
        food7cottoncandy = new javax.swing.JLabel();
        food8icecreamcone = new javax.swing.JLabel();
        foodlasagna = new javax.swing.JLabel();
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
        dog = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ScoreinGameOver = new javax.swing.JLabel();
        gameover = new javax.swing.JLabel();
        Retry = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Score.setEditable(false);
        Score.setBackground(new java.awt.Color(0, 0, 0,0));
        Score.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Score.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(Score);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 70));

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/icons8-pause-100 (2).png"))); // NOI18N
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        jPanel1.add(pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(1760, 20, 100, 100));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, 260));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 210, 270));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, -60, 200, 260));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 60, 200, 240));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 210, 290));

        boss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/final boss (2).png"))); // NOI18N
        jPanel1.add(boss, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, -20, -1, 280));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 40, 210, 260));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, -90, 200, 250));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icegif-898.gif"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 50, 210, 290));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, -10, -1, 240));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, -100, 220, 310));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, -40, 220, 250));

        Success.setBackground(new java.awt.Color(0, 0, 0,80));
        Success.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SuccessLabel.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 68)); // NOI18N
        SuccessLabel.setForeground(new java.awt.Color(255, 255, 255));
        SuccessLabel.setText("LEVEL COMPLETE");
        Success.add(SuccessLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 24, -1, 96));

        MainMenu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        MainMenu.setText("NEXT LEVEL");
        MainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuActionPerformed(evt);
            }
        });
        Success.add(MainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, 76));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("MAIN MENU");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Success.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 190, 80));

        jPanel1.add(Success, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 930, 470));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,80));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("GAME PAUSE");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, 65));

        jButton1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jButton1.setText("RESUME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, 43));

        jButton2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jButton2.setText("MAIN MENU");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, 43));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 740, 270));

        characterLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-dog-bowl-100 (1) (2).png"))); // NOI18N
        jPanel1.add(characterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 880, 140, 120));

        airplane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ZBOF.gif"))); // NOI18N
        jPanel1.add(airplane, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 0, 280, 320));

        food1pizza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-salami-pizza-70.png"))); // NOI18N
        jPanel1.add(food1pizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, 70));

        food2egg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-sunny-side-up-eggs-70.png"))); // NOI18N
        jPanel1.add(food2egg, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, 70, -1));

        food4fries.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-mcdonald`s-french-fries-70.png"))); // NOI18N
        food4fries.setText("jLabel1");
        jPanel1.add(food4fries, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 60, 80));

        food3barbique.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-barbecue-70.png"))); // NOI18N
        food3barbique.setText("jLabel2");
        jPanel1.add(food3barbique, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 60, -1));

        food4Pretzel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-pretzel-70.png"))); // NOI18N
        food4Pretzel.setText("jLabel3");
        jPanel1.add(food4Pretzel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 30, 70, -1));

        food5kfc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-kfc-chicken-70.png"))); // NOI18N
        jPanel1.add(food5kfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 30, 70, 60));

        food6bananasplit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-banana-split-70.png"))); // NOI18N
        jPanel1.add(food6bananasplit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 30, 70, 60));

        food7cottoncandy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-pancake-stack-70.png"))); // NOI18N
        jPanel1.add(food7cottoncandy, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 90, 90));

        food8icecreamcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bone-70.png"))); // NOI18N
        food8icecreamcone.setText("jLabel1");
        jPanel1.add(food8icecreamcone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 30, 70, 80));

        foodlasagna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-lasagna-70.png"))); // NOI18N
        foodlasagna.setText("jLabel5");
        jPanel1.add(foodlasagna, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 70, 60));

        dangerousfood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chili-pepper-70.png"))); // NOI18N
        jPanel1.add(dangerousfood, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 80, 70));

        dangerousfood2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-poop-70.png"))); // NOI18N
        dangerousfood2.setText("jLabel1");
        jPanel1.add(dangerousfood2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 90, 80, 70));

        dangerousfood3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shoes-70.png"))); // NOI18N
        jPanel1.add(dangerousfood3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 90, 80, 50));

        dangerousfood4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-panty-70.png"))); // NOI18N
        jPanel1.add(dangerousfood4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 60, 70));

        dangerousfood5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-socks-70.png"))); // NOI18N
        jPanel1.add(dangerousfood5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 60, 60));

        dangerousfood6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-body-armor-70.png"))); // NOI18N
        jPanel1.add(dangerousfood6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 80, -1, 80));

        dangerousfood7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bike-70.png"))); // NOI18N
        jPanel1.add(dangerousfood7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 70, 80, -1));

        dangerousfood8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-book-70.png"))); // NOI18N
        jPanel1.add(dangerousfood8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 90, -1, 70));

        dangerousfood9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-hammer-70.png"))); // NOI18N
        jPanel1.add(dangerousfood9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 60, 70, 80));

        dangerousfood10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cellphone-70.png"))); // NOI18N
        jPanel1.add(dangerousfood10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 80, 70, 80));

        dangerousfood11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chair-70.png"))); // NOI18N
        jPanel1.add(dangerousfood11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 90, 70, 60));

        dangerousfood12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-electric-fan-70.png"))); // NOI18N
        jPanel1.add(dangerousfood12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 80, -1, -1));

        dangerousfood13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/icons8-gun-70.png"))); // NOI18N
        jPanel1.add(dangerousfood13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 70, -1));

        dangerousfood14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-broom-70.png"))); // NOI18N
        jPanel1.add(dangerousfood14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, -1, -1));

        dangerousfood15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-money-70.png"))); // NOI18N
        jPanel1.add(dangerousfood15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        dangerousfood16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-metal-70.png"))); // NOI18N
        jPanel1.add(dangerousfood16, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, -1, -1));

        dangerousfood17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shades-70.png"))); // NOI18N
        jPanel1.add(dangerousfood17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        dangerousfood18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-poop-70.png"))); // NOI18N
        jPanel1.add(dangerousfood18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        dangerousfood19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-poop-70.png"))); // NOI18N
        jPanel1.add(dangerousfood19, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        dangerousfood20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shoes-70.png"))); // NOI18N
        jPanel1.add(dangerousfood20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        dangerousfood21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-socks-70.png"))); // NOI18N
        jPanel1.add(dangerousfood21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 80, -1, -1));

        dangerousfood22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-metal-70.png"))); // NOI18N
        jPanel1.add(dangerousfood22, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, -1));

        dangerousfood23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chair-70.png"))); // NOI18N
        jPanel1.add(dangerousfood23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 90, -1, -1));

        Dougnut.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jrald Baco\\Downloads\\icons8-doughnut-70.png")); // NOI18N
        jPanel1.add(Dougnut, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 70, 60));

        dog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/f98fc2fc9a9e290580817a3ab118f593.gif"))); // NOI18N
        jPanel1.add(dog, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 610, 260, 340));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0,80));

        ScoreinGameOver.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 36)); // NOI18N
        ScoreinGameOver.setForeground(new java.awt.Color(255, 255, 255));
        ScoreinGameOver.setText("SCORE:");

        gameover.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 48)); // NOI18N
        gameover.setForeground(new java.awt.Color(255, 255, 255));
        gameover.setText("GAME OVER ");

        Retry.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        Retry.setText("RETRY");
        Retry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Retry, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(298, 298, 298))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(gameover, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(ScoreinGameOver, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(gameover, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScoreinGameOver, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(Retry, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 740, 260));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue Green Illustrated Dog and Nature Desktop Wallpaper (9).png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1900, 1040));

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 290, -1, -1));

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

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        timer.stop();
        timedan.stop();
        timedan2.stop();
        timedan3.stop();
        
        stopBackgroundMusic();
        jPanel2.setVisible(true);
    }//GEN-LAST:event_pauseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPanel2.setVisible(false);
        playBackgroundMusic();
        startFallingAnimation(foodLabels[currentFoodIndex]);
        startFallingDangerousFoodAnimation(dangerousFoodLabels[currentDangerousFoodIndex]);
        startFallingDangerousFoodAnimation3(dangerousFoodLabels2[currentDangerousFoodIndex3]);
         startFallingDangerousFoodAnimation2(dangerousFoodLabels1[currentDangerousFoodIndex2]);
        startFallingDangerousFoodAnimation2(dangerousFoodLabels1[currentDangerousFoodIndex2]);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Home h=new Home();
        h.setVisible(true);
        dispose();
        stopBackgroundMusic();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void RetryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetryActionPerformed
        resetGame();

        jPanel3.setVisible(false);
        pause.setVisible(true);
        playBackgroundMusic();
       
        startFallingAnimation(foodLabels[currentFoodIndex]);
        startFallingDangerousFoodAnimation(dangerousFoodLabels[currentDangerousFoodIndex]);
        startFallingDangerousFoodAnimation3(dangerousFoodLabels2[currentDangerousFoodIndex3]);
        startFallingDangerousFoodAnimation2(dangerousFoodLabels1[currentDangerousFoodIndex2]);
    }//GEN-LAST:event_RetryActionPerformed

    private void MainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuActionPerformed
       Insane h=new Insane();
        h.setVisible(true);
        dispose();
        stopBackgroundMusic();
    }//GEN-LAST:event_MainMenuActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Home h=new Home();
        h.setVisible(true);
        dispose();
        stopBackgroundMusic();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Hard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dougnut;
    private javax.swing.JButton MainMenu;
    private javax.swing.JButton Retry;
    private javax.swing.JTextPane Score;
    private javax.swing.JLabel ScoreinGameOver;
    private javax.swing.JPanel Success;
    private javax.swing.JLabel SuccessLabel;
    private javax.swing.JLabel airplane;
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
    private javax.swing.JLabel dog;
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
    private javax.swing.JLabel gameover;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pause;
    // End of variables declaration//GEN-END:variables
}
