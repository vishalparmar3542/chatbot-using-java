import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class  Gui  implements ActionListener {
    JButton button;
    JFrame frame;
    JTextArea textArea;
    JTextArea outputArea =new JTextArea(" Hi ! ASK Anything..........");
    Answer  ob=new Answer();
    private JPanel panel1;
    private JTextArea textArea1;

    Gui()
    {
        Icon sendimg=new ImageIcon("D:\\java_coding_space\\minor\\pics\\chat.png");
        button = new JButton("asK") ;
        JLabel label=new JLabel("Welcome to customer services Bot");
        label.setBounds(180,0, 450,30);
        ImageIcon img=new ImageIcon("D:\\java_coding_space\\minor\\pics\\email.png");
        label.setBackground(new Color(85, 113, 83));
        label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame = new JFrame();
        frame.add(label);


        frame.setLayout(null);
        frame.setResizable(false);
        button.setBounds(610,720,70,30);
        button.addActionListener(this);
        textArea = new JTextArea(10, 40);

        frame.getContentPane().setBackground(new Color(164, 188, 146));
        frame.setIconImage(img.getImage());

        outputArea.setBounds(10,35,670,680);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setBackground(new Color(199, 233, 176));


        ////experiment start
        JScrollPane scrollableTextArea = new JScrollPane(outputArea);

        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.getContentPane().add(scrollableTextArea);

        outputArea.setFont(new Font("Arial", Font.PLAIN, 15));

        /////experimental end

        frame.add(outputArea);
        textArea.setLineWrap(true);
        textArea.setBackground(new Color(221, 255, 187));
        textArea.setBounds(10,720,600,30);
        frame.add(textArea);
        frame.add(button);
        frame.setSize(700,800);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        String s= textArea.getText();

        outputArea.append("\n YOU : " +s );

        String reply=answer(s);
        outputArea.append("\n BOT : " +reply);

        textArea.setText("");
        printReply(reply);


    }

    //tempraory function
    public void  printReply(String reply)
    {
        //do be done later on

        System.out.println(reply);

    }
    public String answer(String question)
    {
        return  ob.getAnswer(question);
    }


}

