package Car_Game_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EventHandlingSwing extends JFrame implements ActionListener {
private JButton button;
private JLabel label;
public EventHandlingSwing() {
// Create JFrame
setTitle("Event Handling with Swings");
setSize(300, 200);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setLayout(new FlowLayout());
// Create JButton
button = new JButton("Click Me!");
button.addActionListener(this);
add(button);
// Create JLabel
label = new JLabel("Press the button to see the event!");
add(label);
}
// ActionListener method
public void actionPerformed(ActionEvent e) {
if (e.getSource() == button) {
label.setText("Button Clicked!");
}
}
public static void main(String[] args) {
EventHandlingSwing frame = new EventHandlingSwing();
frame.setVisible(true);
}
}