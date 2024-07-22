package Cryptography;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Cryptography
{
    public static void operation(int key)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        if (file != null) 
        {
            try 
            {
                FileInputStream fis = new FileInputStream(file);
                byte[] data = new byte[fis.available()];
                fis.read(data);
                for (byte b : data) 
                {
                    System.out.print(b + " ");
                }
                int i = 0;
                for (byte b : data)
                {
                    data[i] = (byte) (b ^ key);
                    i++;
                }
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(data);
                fos.close();
                fis.close();
                JOptionPane.showMessageDialog(null, "Done");
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        System.out.println("Hello, This is the Image Cryptography model made by Sneha Uniyal");

        JFrame f = new JFrame("Image Cryptography System - By Sneha Uniyal");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("THE IMAGE CODER / DECODER", JLabel.CENTER);
        label.setFont(new Font("Roboto", Font.BOLD, 25));
        label.setOpaque(true);
        label.setBackground(Color.RED);

        Font font = new Font("Roboto", Font.PLAIN, 20);

        JButton button = new JButton("Encrypt");
        button.setFont(font);

        JButton button1 = new JButton("Decrypt");
        button1.setFont(font);

        JTextField textfield = new JTextField(10);
        textfield.setFont(new Font("Roboto", Font.PLAIN, 35));
        textfield.setPreferredSize(new Dimension(250, 40));
        textfield.setBackground(Color.white);
        textfield.setCaretColor(Color.black);
        
        button.addActionListener(e -> {
            System.out.println("Button clicked");
            String text = textfield.getText();
            if (!text.isEmpty()) {
                try {
                    int temp = Integer.parseInt(text);
                    operation(temp);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid key format. Please enter a valid integer key.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a key.");
            }
            textfield.setText(null);
        });

        button1.addActionListener(e -> {
            System.out.println("Button clicked");
            String text = textfield.getText();
            if (!text.isEmpty()) {
                try {
                    int temp = Integer.parseInt(text);
                    operation(temp);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid key format. Please enter a valid integer key.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a key.");
            }
            textfield.setText(null);
        });

        f.setLayout(new FlowLayout());
        f.add(label);
        f.add(button);
        f.add(button1);
        f.add(textfield);
        f.setVisible(true);
    }
}
