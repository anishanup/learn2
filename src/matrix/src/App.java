import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    /* Declare the buttons here because they will be  
       used in various methods in this class */
   
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;

    /* Declare variables that will be needed in different
       methods in this class */

    // Declare other components
    public JFrame frame = new JFrame();
    public JPanel panel = new JPanel(new BorderLayout());
    private DisplayPane display;

  public static void main(String args[]) throws Exception{
    /* This is where the panel gets created */
    App f = new App();
  }
  public App (){ 
    /* This constructor tells what the graphic will be like.    
       when it is created */
    display = new DisplayPane();
    // Instantiate the buttons
    btn1 = new JButton("Bigger");
    btn2 = new JButton("Smaller");
    btn3 = new JButton("Right");
    btn4 = new JButton("Left");
    
    // Set up the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    panel.setBackground(Color.black);
    
    // Place the buttons 
    frame.add(btn1, BorderLayout.SOUTH);
    frame.add(btn2, BorderLayout.NORTH);
    frame.add(btn3, BorderLayout.EAST);
    frame.add(btn4, BorderLayout.WEST);
    
    /* Set Button1 Action Listener */
    btn1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        System.out.println("button 1 pushed");
        Dimension size = frame.getSize();
        System.out.println("Height is: "+ size.height);
        size.height = size.height + 10;
        frame.setSize(size);
      }
    });
    
    /* Set Button2 Action Listener */
    btn2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        System.out.println("button 2 pushed");
        Dimension size = frame.getSize();
        System.out.println("Height is: "+ size.height);
        size.height = size.height - 10;
        frame.setSize(size);
      }
    });

    /* Set Button3 Action Listener */
    btn3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        Point location = frame.getLocation();
        System.out.println("Location x is : "+ location.x);
        location.x = location.x + 10;
        frame.setLocation(location);
        frame.repaint();
        System.out.println("button 3 pushed");
      }
    });

    /* Set Button4 Action Listener */
    btn4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        Point location = frame.getLocation();
        System.out.println("Location x is : "+ location.x);
        location.x = location.x - 10;
        frame.setLocation(location);
        frame.repaint();
        System.out.println("button 4 pushed");
      }
    });

    // Put things on the graphic
    panel.add(display);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public class DisplayPane extends JComponent {
    public DisplayPane ( ) {
      setOpaque(false);
    }
    @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }   
  }  
}
