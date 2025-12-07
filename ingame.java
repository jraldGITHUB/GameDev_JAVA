
package javaapplication2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ingame extends javax.swing.JFrame implements KeyListener {
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
    public ingame() {
        initComponents();
        addKeyListener(this);
        setFocusable(true);
  jPanel2.setVisible(false);
  jPanel3.setVisible(false);
 Success.setVisible(false);
 
startAirplaneAnimation();
playBackgroundMusic();

 
       dangerousFoodLabels[0] = dangerousfood;
dangerousFoodLabels[1] = dangerousfood2;
dangerousFoodLabels[2] = dangerousfood3;
dangerousFoodLabels[3] = dangerousfood4;
dangerousFoodLabels[4] = dangerousfood5;
 
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
        
                int newY = label.getY() + fallSpeed;
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


  private void resetGame() {
  
    score = 0;
    missCount = 0;

    Score.setText("Score: " + score);
  
}      
        
        
    private void gameOver() {
             ScoreinGameOver.setText("Score: " + score);
        timer.stop();
        timedan.stop();
       jPanel3.setVisible(true);
        missCount = 0;
        pause.setVisible(false);
          stopBackgroundMusic();
           playGameOverSound();
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
private void success(){
       pause.setVisible(false);
       Success.setVisible(true);
      
         timer.stop();
        timedan.stop();
         
        
stopBackgroundMusic();
 playSuccessSound();
 
   } 


    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }
       private void stopBackgroundMusic() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Score = new javax.swing.JTextPane();
        pause = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
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
        jPanel3 = new javax.swing.JPanel();
        ScoreinGameOver = new javax.swing.JLabel();
        gameover = new javax.swing.JLabel();
        Retry = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Score.setEditable(false);
        Score.setBackground(new java.awt.Color(0, 0, 0,0));
        Score.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jScrollPane1.setViewportView(Score);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 220, 70));

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/icons8-pause-100 (2).png"))); // NOI18N
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        jPanel1.add(pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(1720, 30, 100, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, -20, 230, 190));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, -10, 220, 170));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 200, 180));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, -10, 200, 180));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 210, 190));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, -20, 190, 220));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, -10, 250, 180));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication2/0d6cf5b4980702758a616a14bed86e3a_w200.gif"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 10, 220, 180));

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
        jPanel1.add(characterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 860, 140, 110));

        airplane.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ZBOF.gif"))); // NOI18N
        jPanel1.add(airplane, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, -10, 300, 320));

        food1pizza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-salami-pizza-70.png"))); // NOI18N
        jPanel1.add(food1pizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, 70));

        food2egg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-sunny-side-up-eggs-70.png"))); // NOI18N
        jPanel1.add(food2egg, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 60, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cellphone-70.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 70, 80));

        dangerousfood9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-hammer-70.png"))); // NOI18N
        jPanel1.add(dangerousfood9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 90, 70, 80));

        dangerousfood7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bike-70.png"))); // NOI18N
        jPanel1.add(dangerousfood7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 90, 80, -1));

        dangerousfood6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-body-armor-70.png"))); // NOI18N
        jPanel1.add(dangerousfood6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, 80));

        dangerousfood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-chili-pepper-70.png"))); // NOI18N
        jPanel1.add(dangerousfood, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 80, 70));

        food4fries.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-mcdonald`s-french-fries-70.png"))); // NOI18N
        food4fries.setText("jLabel1");
        jPanel1.add(food4fries, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 60, 80));

        dangerousfood3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shoes-70.png"))); // NOI18N
        jPanel1.add(dangerousfood3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1518, 40, 80, 50));

        dangerousfood2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-poop-70.png"))); // NOI18N
        dangerousfood2.setText("jLabel1");
        jPanel1.add(dangerousfood2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 80, 70));

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
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 610, 260, 340));

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue Green Illustrated Dog and Nature Desktop Wallpaper (1).png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 1910, 1040));

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
    stopBackgroundMusic();

    jPanel2.setVisible(true);
    }//GEN-LAST:event_pauseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPanel2.setVisible(false);
    
    startFallingAnimation(foodLabels[currentFoodIndex]); 
    startFallingDangerousFoodAnimation(dangerousFoodLabels[currentDangerousFoodIndex]);
       playBackgroundMusic();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RetryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetryActionPerformed
       resetGame();
       
        jPanel3.setVisible(false);
       pause.setVisible(true);
        startFallingAnimation(foodLabels[currentFoodIndex]);
               startFallingDangerousFoodAnimation(dangerousFoodLabels[currentDangerousFoodIndex]);
           playBackgroundMusic();   
    }//GEN-LAST:event_RetryActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  Home h=new Home();
  h.setVisible(true);
  dispose();
  stopBackgroundMusic();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void MainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuActionPerformed
        Hard h=new Hard();
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
            java.util.logging.Logger.getLogger(ingame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ingame().setVisible(true);
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
    private javax.swing.JLabel gameover;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
