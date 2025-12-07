package javaapplication2;
 import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.Timer;

public class JavaApplication2 extends javax.swing.JFrame {

    private int fallSpeed = 7; // Adjust fall speed
    private int initialX; // Initial x-coordinate of the labels
    private int[] initialY = new int[10]; // Initial y-coordinate of the labels
    private int currentLabelIndex = 0; // Index of the label currently falling
    private final List<JLabel> fallenLabels = new ArrayList<>(); // List to store fallen labels

    public JavaApplication2 () {
        initComponents();
        move.addKeyListener(new MyKeyListener()); // Add key listener to move label
        move.setFocusable(true);
        startFallingSequence(); // Start the sequence of falling labels
    }

    private void startFallingSequence() {
        // Start falling animation for the first label
        startFalling(getLabelByIndex(currentLabelIndex));
    }

    private void startFalling(JLabel label) {
        initialX = label.getX(); // Store the initial x-coordinate
        String labelText = label.getText();
        int index = Integer.parseInt(labelText.substring(labelText.indexOf("l") + 1)) - 1;
        initialY[index] = label.getY();

        Timer labelTimer = new Timer(30, new ActionListener() { // Set a timer for animation
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update object position
                int randomX = (int) (Math.random() * 10) - 5; // Random horizontal movement
                label.setLocation(label.getX() + randomX, label.getY() + fallSpeed);

                // Check if the label is below the frame height
                if (label.getY() >= jPanel1.getHeight() - label.getHeight()) {
                    label.setVisible(false); // Make the label invisible
                    ((Timer) e.getSource()).stop(); // Stop the timer
                    fallenLabels.add(label); // Add fallen label to the list

                    currentLabelIndex++; // Move to the next label
                    if (currentLabelIndex < 10) {
                        // Reset label position
                        resetLabelPosition(label);
                        // Start falling animation for the next label after a delay
                        Timer delayTimer = new Timer(300, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                startFalling(getLabelByIndex(currentLabelIndex));
                                ((Timer) e.getSource()).stop(); // Stop the timer
                            }
                        });
                        delayTimer.setRepeats(false); // Only run once
                        delayTimer.start();
                    } else {
                        // Reset label index to start from the beginning
                        currentLabelIndex = 0;
                        // Start falling sequence again
                        startFallingSequence();
                    }
                }
            }
        });
        labelTimer.start();
    }

    // Reset label position to initial position
    private void resetLabelPosition(JLabel label) {
        if (!label.equals(move)) { // Exclude the move label from being reset
            String labelText = label.getText();
            int index = Integer.parseInt(labelText.substring(labelText.lastIndexOf("l") + 1)) - 1;
            label.setLocation(initialX, initialY[index]);
            label.setVisible(true);
        }
    }

    // Helper method to get label by index
    private JLabel getLabelByIndex(int index) {
        switch (index) {
            case 0:
                return jLabel1;
            case 1:
                return jLabel2;
            case 2:
                return jLabel3;
            case 3:
                return jLabel4;
            case 4:
                return jLabel5;
            case 5:
                return jLabel6;
            case 6:
                return jLabel7;
            case 7:
                return jLabel8;
            case 8:
                return jLabel9;
            case 9:
                return jLabel10;
            default:
                return null;
        }
    }

 private class MyKeyListener implements KeyListener {
    private int initialX; // Initial x-coordinate of the moving button

    public MyKeyListener() {
        // Store the initial x-coordinate of the moving button
        initialX = move.getX();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int labelWidth = move.getWidth();
        int frameWidth = jPanel1.getWidth();
        if (key == KeyEvent.VK_LEFT) {
            int newX = move.getX() - 5;
            if (newX >= 0) { // Check if within left boundary
                move.setLocation(newX, move.getY());
                checkCollision();
            }
        } else if (key == KeyEvent.VK_RIGHT) {
            int newX = move.getX() + 5;
            if (newX + labelWidth <= frameWidth) { // Check if within right boundary
                move.setLocation(newX, move.getY());
                checkCollision();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // Method to check collision with fallen labels
  private void checkCollision() {
    for (JLabel label : fallenLabels) {
        if (move.getBounds().intersects(label.getBounds())) {
            jPanel1.remove(label); // Remove fallen label from panel
            move.setText(move.getText() + label.getText()); // Record fallen label on move label
            fallenLabels.remove(label); // Remove fallen label from list
            jPanel1.revalidate();
            jPanel1.repaint();
            // Do not reset the moving button's position
            break; // Exit loop after colliding with one label
        }
    }
}
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        move = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        move.setText("move");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel8)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel9)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(move, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(482, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                .addComponent(move)
                .addGap(84, 84, 84))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, -1));

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaApplication2().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel move;
    // End of variables declaration                   
}