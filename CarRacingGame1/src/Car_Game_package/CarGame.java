package Car_Game_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class CarGame extends JFrame implements KeyListener, ActionListener {
    private int xpos = 300;
    private int ypos = 700;
    private ImageIcon car;
    private Random random = new Random();

    private int num1 = 400;
    private int tree1ypos = 400, tree2ypos = -200, tree3ypos = -500, tree4ypos = 100, tree5ypos = -300, tree6ypos = 500;
    private int roadmove = 0;
    private int carxpos[] = {100, 200, 300, 400, 500};
    private int carypos[] = {-240, -480, -720, -960, -1200};
    private int cxpos1 = 0, cxpos2 = 2, cxpos3 = 4;
    private int cypos1 = random.nextInt(5), cypos2 = random.nextInt(5), cypos3 = random.nextInt(5);
    private int y1pos = carypos[cypos1], y2pos = carypos[cypos2], y3pos = carypos[cypos3];
    private ImageIcon car1, car2, car3;
    private int score = 0, delay = 100, speed = 90;
    private ImageIcon tree1, tree2, tree3;
    private boolean gameover = false, paint = false;
    public int highestScore = 0; // Variable to store the highest score
    public int finalScore = 0;
    

    public CarGame(String title, int i) {
        super(title);
        setBounds(300, 10, 700, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);
        setResizable(false);
    }

    public static String username;

    public CarGame(String x) {
        username = x;
    }

    //@Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 700, 700);
        g.setColor(Color.BLACK);
        g.fillRect(90, 0, 10, 700);
        g.fillRect(600, 0, 10, 700);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(100, 0, 500, 700);

        if (roadmove == 0) {
            for (int i = 0; i <= 700; i += 100) {
                g.setColor(Color.white);
                g.fillRect(350, i, 10, 70);
            }
            roadmove = 1;
        } else if (roadmove == 1) {
            for (int i = 50; i <= 700; i += 100) {
                g.setColor(Color.white);
                g.fillRect(350, i, 10, 70);
            }
            roadmove = 0;
        }

        tree1 = new ImageIcon("./resources/images/tree.png");

        tree1.paintIcon(this, g, 0, tree1ypos);
        num1 = random.nextInt(500);
        tree1ypos += 50;

        tree2 = new ImageIcon("./resources/images/tree.png");
        tree2.paintIcon(this, g, 0, tree2ypos);
        tree2ypos += 50;

        tree3 = new ImageIcon("./resources/images/tree.png");
        tree3.paintIcon(this, g, 0, tree3ypos);
        tree3ypos += 50;
        tree1.paintIcon(this, g, 600, tree4ypos);
        tree4ypos += 50;
        tree3.paintIcon(this, g, 600, tree5ypos);
        tree5ypos += 50;
        tree2.paintIcon(this, g, 600, tree6ypos);
        tree6ypos += 50;

        if (tree1ypos > 700) {
            num1 = random.nextInt(500);
            tree1ypos = -num1;
        }
        if (tree2ypos > 700) {
            num1 = random.nextInt(500);
            tree2ypos = -num1;
        }
        if (tree3ypos > 700) {
            num1 = random.nextInt(500);
            tree3ypos = -num1;
        }
        if (tree4ypos > 700) {
            num1 = random.nextInt(500);
            tree4ypos = -num1;
        }
        if (tree5ypos > 700) {
            num1 = random.nextInt(500);
            tree5ypos = -num1;
        }
        if (tree6ypos > 700) {
            num1 = random.nextInt(500);
            tree6ypos = -num1;
        }

        car = new ImageIcon("./resources/images/car4.png");
        car.paintIcon(this, g, xpos, ypos);
        ypos -= 40;
        if (ypos < 500) {
            ypos = 500;
        }

        // opposite cars
        car1 = new ImageIcon("./resources/images/car1.png");
        car2 = new ImageIcon("./resources/images/car2.png");
        car3 = new ImageIcon("./resources/images/car3.png");

        car1.paintIcon(this, g, carxpos[cxpos1], y1pos);
        car2.paintIcon(this, g, carxpos[cxpos2], y2pos);
        car3.paintIcon(this, g, carxpos[cxpos3], y3pos);
        y1pos += 50;
        y2pos += 50;
        y3pos += 50;
        if (y1pos > 700) {
            cxpos1 = random.nextInt(5);
            cypos1 = random.nextInt(5);
            y1pos = carypos[cypos1];
        }
        if (y2pos > 700) {
            cxpos2++;
            if (cxpos2 > 4) {
                cxpos2 = 0;
            }

            cxpos2 = random.nextInt(5);
            cypos2 = random.nextInt(5);
            y2pos = carypos[cypos2];

        }
        if (y3pos > 700) {
            cxpos3++;
            if (cxpos3 > 4) {
                cxpos3 = 0;
            }
            cxpos3 = random.nextInt(5);
            cypos3 = random.nextInt(5);
            y3pos = carypos[cypos3];
        }

        if (cxpos1 == cxpos2 && cypos1 > -100 && cypos2 > -100) {
            cxpos1 -= 1;
            if (cxpos1 < 0) {
                cxpos1 += 2;
            }
        }
        if (cxpos1 == cxpos3 && cypos1 > -100 && cypos3 > -100) {
            cxpos3 -= 1;
            if (cxpos3 < 0) {
                cxpos3 += 2;
            }
        }
        if (cxpos2 == cxpos3 && cypos3 > -100 && cypos2 > -100) {
            cxpos2 -= 1;
            if (cxpos2 < 0) {
                cxpos2 += 2;
            }
        }
        if (cxpos1 < 2 && cxpos2 < 2 && cxpos3 < 2) {
            if (cxpos1 == 0 && cxpos2 == 0 && cxpos3 == 1) {
                cxpos3++;
                cxpos2++;
            } else if (cxpos1 == 0 && cxpos2 == 1 && cxpos3 == 0) {
                cxpos3++;
                cxpos2++;
            } else if (cxpos1 == 1 && cxpos2 == 0 && cxpos3 == 0) {
                cxpos1++;
                cxpos2++;
            }
        }

        if (y1pos < ypos && y1pos + 60 > ypos && carxpos[cxpos1] == xpos) {
            gameover = true;
        }
        if (y2pos < ypos && y2pos + 60 > ypos && carxpos[cxpos2] == xpos) {
            gameover = true;
        }
        if (y3pos < ypos && y3pos + 60 > ypos && carxpos[cxpos3] == xpos) {
            gameover = true;
        }
        if (ypos < y1pos && ypos + 60 > y1pos && carxpos[cxpos1] == xpos) {
            gameover = true;
        }
        if (ypos < y2pos && ypos + 60 > y2pos && carxpos[cxpos2] == xpos) {
            gameover = true;
        }
        if (ypos < y3pos && ypos + 60 > y3pos && carxpos[cxpos3] == xpos) {
            gameover = true;
        }

        // score
        g.setColor(Color.RED);
        g.fillRect(120, 35, 220, 50);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(125, 40, 210, 40);
        g.setColor(Color.RED);
        g.fillRect(385, 35, 180, 50);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(390, 40, 170, 40);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));

        g.drawString("Score : " + score, 130, 67);
        g.drawString(speed + " Km/h", 400, 67);

        score++;
        speed++;

        if (speed > 140) {
            speed = 240 - delay;
        }

        if (score % 175 == 0) {
            delay -= 10;
            if (delay < 60) {
                delay = 60;
            }
        }

        if (gameover) {
            finalScore = score; // Store the final score in the variable

            if (finalScore > highestScore) {
                highestScore = finalScore; // Update the highest score
            }

            g.setColor(Color.RED);
            g.fillRect(120, 210, 460, 200);
            g.setColor(Color.DARK_GRAY);
            g.fillRect(130, 220, 440, 180);
            g.setFont(new Font("Serif", Font.BOLD, 50));
            g.setColor(Color.RED);
            g.drawString("! Game Over !", 210, 270);
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Press Enter to Restart", 190, 320);
            g.drawString("Player Final Score  "+(score-1), 190, 375);
            return; // Exit the paint method to avoid further updates
        }

        try {
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }

    public static void main(String[] args) {
        CarGame c = new CarGame("Car Game", 0);
    }

    /*@Override*/
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && !gameover) {
            xpos -= 100;
            if (xpos < 100) {
                xpos = 100;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !gameover) {
            xpos += 100;
            if (xpos > 500) {
                xpos = 500;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER && gameover) {
            resetGame();
        }
    }

    private void resetGame() {
        gameover = false;
        paint = false;
        cxpos1 = 0;
        cxpos2 = 2;
        cxpos3 = 4;
        cypos1 = random.nextInt(5);
        cypos2 = random.nextInt(5);
        cypos3 = random.nextInt(5);
        y1pos = carypos[cypos1];
        y2pos = carypos[cypos2];
        y3pos = carypos[cypos3];
        speed = 90;
        score = 0;
        delay = 100;
        xpos = 300;
        ypos = 700;
        repaint(); // Ensure the game state is redrawn after reset
    }

    //@Override
    public void keyReleased(KeyEvent arg0) {
    }

    //@Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'a' && !gameover) {
            xpos -= 100;
        }
        if (e.getKeyChar() == 's' && !gameover) {
            xpos += 100;
        }
        repaint();
    }

    //@Override
    public void actionPerformed(ActionEvent arg0) {
    }
}
