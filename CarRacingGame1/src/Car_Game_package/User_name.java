package Car_Game_package;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class User_name extends JFrame {

    private JPanel contentPane;
    private JButton enterButton;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    User_name frame = new User_name();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public User_name() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 649, 478);
        contentPane = new CustomPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        enterButton = new JButton("PLAY NOW") {
            //@Override
            protected void paintComponent(Graphics g) {
                if (getModel().isPressed()) {
                    g.setColor(new Color(204, 0, 0));
                } else if (getModel().isRollover()) {
                    g.setColor(new Color(255, 102, 102));
                } else {
                    g.setColor(new Color(255, 102, 102));
                }
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                super.paintComponent(g);
            }
        };
        enterButton.setBounds(180, 300, 289, 65);
        enterButton.setFocusPainted(false);
        enterButton.setFont(new Font("Arial", Font.BOLD, 20));
        enterButton.setForeground(Color.WHITE);
        enterButton.setBorderPainted(false);
        enterButton.setContentAreaFilled(false);
        enterButton.setOpaque(false);
        contentPane.add(enterButton);

        
        enterButton.addMouseListener(new MouseAdapter() {
            //@Override
            public void mouseEntered(MouseEvent e) {
                enterButton.setForeground(Color.YELLOW);
            }

            //@Override
            public void mouseExited(MouseEvent e) {
                enterButton.setForeground(Color.WHITE);
            }
        });


        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                CarGame car = new CarGame("Player");
                Main.main(null);
                dispose();
            }
        });

        JLabel lblNewLabel_2 = new JLabel("Unleash the Speed: Race to Dominate!");
        lblNewLabel_2.setFont(new Font("Jokerman", Font.BOLD, 26));
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(63, 50, 530, 100);
        contentPane.add(lblNewLabel_2);
    }

    private class CustomPanel extends JPanel {
        //@Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gp = new GradientPaint(0, 0, new Color(255, 204, 153), 0, getHeight(), new Color(255, 153, 102));
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}