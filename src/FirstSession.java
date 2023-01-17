import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstSession implements ActionListener {
    static JFrame frame;//global
    static JTextArea jTextArea;
    static JTextField jTextField;
    static JButton jButton;
    static JMenuBar jMenuBar;
    static JMenu jMenu;
    static JMenuItem jMenuItem,jMenuItem1;
    FirstSession()
    {  //frame.setTitle("first title");
        //frame is heavy weight component or text area ot text field light weight
        frame=new JFrame("first session");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//close operation automatically close program execution
        frame.setLayout(null);//this will show textarea without this textarea is in full screen
        frame.setBounds(200,100,400,400);//left-top-width-height
        jTextArea=new JTextArea("hello worlds");
        jTextArea.setBounds(200,100,300,100);
        jButton=new JButton("BUTTON");
        //action litsner
        //ActionListener in Java is a class that is responsible for handling all action events such as when the user clicks on a component.
        // Mostly,  action listeners are used for JButtons. An ActionListener can be used by the implements keyword to the class definition.
        //It means that the enclosing class ("this" stands by) should implement the interface ActionListener.
        // so when someComponent is clicked (or other actions), the enclosing class will be invoked to process the event.
        // It means that the enclosing class ("this" stands by) should implement the interface ActionListener.
        // so when someComponent is clicked (or other actions), the enclosing class will be invoked to process the event.

        jButton.addActionListener(this );//button action litsner

        //jTextField=new JTextField("first ");
       // jTextArea.add(jTextField);
        jTextArea.add(jButton);

        jButton.setVisible(true);//button is visible after this
        jButton.setBounds(200,225,100,50);
        frame.add(jButton);
        frame.add(jTextArea);

        frame.setVisible(true);//frame visible after this


        //menu bar
        jMenuBar=new JMenuBar();
        jMenu=new JMenu("open");

        jMenuItem=new JMenuItem( "first option");
        jMenuItem1=new JMenuItem("second option");

        jMenuItem.addActionListener(this);// add actionlitsner to menu item
        jMenuItem1.addActionListener(this);//add actionlitsner to menu1

        jMenuBar.add(jMenu); //adding menu to menubar
        jMenu.add(jMenuItem);//adding menuitem in menu
        jMenu.add(jMenuItem1);
        frame.setJMenuBar(jMenuBar);// adding to frame my menu bar

    }
    public static void main(String[] args) {
       new FirstSession();
    }
      // gives functionality to button and menu bar item
    @Override
    public void actionPerformed(ActionEvent e) {
        String s= e.getActionCommand();
        if(s.equals("BUTTON"))
        {
            jTextArea.setText("you click the button tab");
        }
        else if(s.equals("first option"))
        {
            jTextArea.setText("you have opted first option");
        }
        else if(s.equals("second option"))
        {
            jTextArea.setText("you have opted second option");
        }
    }
}
