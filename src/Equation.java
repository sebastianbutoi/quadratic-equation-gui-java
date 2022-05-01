import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Equation extends JFrame implements ActionListener {
    private JButton calculate = new JButton("Calculate");
    private JButton reset = new JButton("Reset");
    private JLabel title = new JLabel("Quadratic Equation");
    private JTextField firstValue = new JTextField(10);
    private JLabel l1 = new JLabel("A");
    private JTextField secondValue = new JTextField(10);
    private JLabel l2 = new JLabel("B");
    private JTextField thirdValue = new JTextField(10);
    private JLabel l3 = new JLabel("C");
    private JTextField res1 = new JTextField(10);
    private JLabel l4 = new JLabel("x1");
    private JTextField res2 = new JTextField(10);
    private JLabel l5 = new JLabel("x2");
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();
    private JPanel globalPanel = new JPanel();
    private Font f = new Font("Arial", Font.BOLD, 20);

    public Equation() {
        setTitle("Quadratic equation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title.setFont(f);
        p1.add(title);
        p2.add(l1);
        p2.add(firstValue);
        p2.add(l2);
        p2.add(secondValue);
        p2.add(l3);
        p2.add(thirdValue);
        p3.add(l4);
        p3.add(res1);
        p3.add(l5);
        p3.add(res2);
        p4.add(calculate);
        p4.add(reset);
        globalPanel.setLayout(new GridLayout(4,3));
        globalPanel.add(p1);
        globalPanel.add(p2);
        globalPanel.add(p3);
        globalPanel.add(p4);
        getContentPane().add(globalPanel);
        calculate.addActionListener(this);
        reset.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        int a, b, c;
        float x1, x2;
        int delta;
        if (choice.equals("Calculate")) {
            try {
                a = Integer.parseInt(firstValue.getText());
                b = Integer.parseInt(secondValue.getText());
                c = Integer.parseInt(thirdValue.getText());
                delta = b * b - 4 * a * c;
                if (delta == 0) {
                    x1 = (float)((-b-Math.sqrt(delta))/(2 * a));
                    x2 = x1;
                    res1.setText("" + x1);
                    res2.setText("" + x2);
                }
                if (delta > 0) {
                    x1 = (float)((-b-Math.sqrt(delta))/(2 * a));
                    x2 = (float)((-b+Math.sqrt(delta))/(2 * a));
                    res1.setText("" + x1);
                    res2.setText("" + x2);
                }
                if (delta < 0) {
                    res1.setText("Impossible");
                    res2.setText("Impossible");
                }
            } catch (Exception ex) {
                res1.setText("");
                res2.setText("");
            }
        }
        if (choice.equals("Reset")) {
            firstValue.setText("");
            secondValue.setText("");
            thirdValue.setText("");
            res1.setText("");
            res2.setText("");
        }
    }
}

