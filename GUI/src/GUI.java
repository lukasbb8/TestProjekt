import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUI implements ActionListener {
  JFrame frame = null;
  JPanel contentPane = null;
  JPanel horizontalButtonbox, leftbuttongroup, rightbuttongroup, textbox;
  JMenu menue = null;
  JMenuBar menuebar = null;
  JMenuItem reset_queue = null;
  JMenuItem print_queue = null;
  JMenuItem exit = null;
  JButton l1 = null;
  JButton l2 = null;
  JButton l3 = null;
  JButton r1 = null;
  JButton r2 = null;
  JButton r3 = null;
  JLabel text = null;
  int comp = 0;

  ArrayList<Integer> list = new ArrayList<Integer>();

  public void actionPerformed(ActionEvent ae) {

    // liit = list.listIterator();

    if (ae.getSource() == this.exit) {
      System.exit(0);
    }
    if (ae.getSource() == this.l1) {
      list.add(1);
      comp = 1;
    }
    if (ae.getSource() == this.l2) {
      list.add(2);
      if (comp == 1) {
        comp = 2;
      } else {
        comp = 0;
      }
    }
    if (ae.getSource() == this.l3) {
      list.add(3);
      if (comp == 2) {
        comp = 3;
      } else {
        comp = 0;
      }
    }
    if (ae.getSource() == this.r1) {
      list.add(11);
      if (comp == 3 && list.get(list.size() - 2) == 3) {
        comp = 0;
        System.exit(0);
      } else {
        comp = 0;

      }
    }
    if (ae.getSource() == this.r2) {
      list.add(12);
      comp = 0;
    }
    if (ae.getSource() == this.r3) {
      list.add(13);
      comp = 0;
    }
    if (ae.getSource() == this.reset_queue) {
      list.clear();

    }
    if (ae.getSource() == this.print_queue) {
      ListIterator<Integer> liit = list.listIterator();
      while (liit.hasNext()) {
        int e = liit.next();

        if (e == 1) {
          System.out.println("Left1");
        }
        if (e == 2) {
          System.out.println("Left2");
        }
        if (e == 3) {
          System.out.println("Left3");
        }
        if (e == 11) {
          System.out.println("Right1");
        }
        if (e == 12) {
          System.out.println("Right2");
        }
        if (e == 13) {
          System.out.println("Right3");
        }
      }
    }
  }

  public GUI() {


    this.frame = new JFrame("GUI-Übung");
    // Mainpanel
    this.contentPane = new JPanel();
    this.frame.setContentPane(this.contentPane);

    // Menü
    this.menuebar = new JMenuBar();
    this.menue = new JMenu("File");
    this.reset_queue = new JMenuItem("Reset queue");
    this.print_queue = new JMenuItem("Print queue");
    this.exit = new JMenuItem("Exit");
    this.menue.add(reset_queue);
    this.menue.addSeparator();
    this.menue.add(print_queue);
    this.menue.addSeparator();
    this.menue.add(exit);

    this.menuebar.add(this.menue);
    this.frame.setJMenuBar(menuebar);



    // Objecte
    this.l1 = new JButton("Left1");
    this.l2 = new JButton("Left2");
    this.l3 = new JButton("Left3");
    this.r1 = new JButton("Right1");
    this.r2 = new JButton("Right2");
    this.r3 = new JButton("Right3");
    this.text = new JLabel("Left1 + Left2 + left3 + Right1 klicken !");

    // LayoutBoxen erstellen
    this.leftbuttongroup = new JPanel();
    this.rightbuttongroup = new JPanel();
    this.horizontalButtonbox = new JPanel();
    this.textbox = new JPanel();

    // LayoutBoxen hinzufügen
    this.contentPane.add(this.horizontalButtonbox);
    this.contentPane.add(this.textbox);
    this.horizontalButtonbox.add(this.leftbuttongroup);
    this.horizontalButtonbox.add(this.rightbuttongroup);

    // Objecte in hinzufügen
    this.leftbuttongroup.add(this.l1);
    this.leftbuttongroup.add(this.l2);
    this.leftbuttongroup.add(this.l3);
    this.rightbuttongroup.add(this.r1);
    this.rightbuttongroup.add(this.r2);
    this.rightbuttongroup.add(this.r3);
    this.textbox.add(this.text);

    // Layouts anordnen
    this.contentPane.setLayout(new BoxLayout(this.contentPane, BoxLayout.Y_AXIS));
    this.horizontalButtonbox.setLayout(new BoxLayout(this.horizontalButtonbox, BoxLayout.X_AXIS));
    this.leftbuttongroup.setLayout(new BoxLayout(this.leftbuttongroup, BoxLayout.Y_AXIS));
    this.rightbuttongroup.setLayout(new BoxLayout(this.rightbuttongroup, BoxLayout.Y_AXIS));
    this.frame.setSize(300, 200);
    this.frame.setVisible(true);

    // Actions hinzufügen
    this.exit.addActionListener(this);
    this.print_queue.addActionListener(this);
    this.reset_queue.addActionListener(this);
    this.l1.addActionListener(this);
    this.l2.addActionListener(this);
    this.l3.addActionListener(this);
    this.r1.addActionListener(this);
    this.r2.addActionListener(this);
    this.r3.addActionListener(this);

  }

  public static void main(String[] args) {
    GUI g = new GUI();
  }
}

