package lesson7a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    public Window(){
        setBounds(200,200,500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lesson 7a");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JTextArea textAreaA  = new JTextArea();
        add(textAreaA);

        JTextArea textAreaB  = new JTextArea();
        add(textAreaB);

        JTextArea textAreaRez  = new JTextArea();
        add(textAreaRez);


        JButton minus  =new JButton("-");
        add(minus);
        JButton division  =new JButton("/");
        add(division);
        JButton multiply  =new JButton("*");
        add(multiply);
        JButton plus  =new JButton("+");
        add(plus);


        plus.addActionListener(e-> {
            int a=Integer.parseInt(textAreaA.getText());
            int b=Integer.parseInt(textAreaB.getText());
            int rez=a+b;
            textAreaRez.setText(Integer.toString(rez));
                }
        );
        minus.addActionListener(e-> {
                    int a=Integer.parseInt(textAreaA.getText());
                    int b=Integer.parseInt(textAreaB.getText());
                    int rez=a-b;
                    textAreaRez.setText(Integer.toString(rez));
                }
        );
        division.addActionListener(e-> {
                    int a=Integer.parseInt(textAreaA.getText());
                    int b=Integer.parseInt(textAreaB.getText());
                    int rez=a/b;
                    textAreaRez.setText(Integer.toString(rez));
                }
        );
        multiply.addActionListener(e-> {
                    int a=Integer.parseInt(textAreaA.getText());
                    int b=Integer.parseInt(textAreaB.getText());
                    int rez=a*b;
                    textAreaRez.setText(Integer.toString(rez));
                }
        );


        setVisible(true);

    }

}
