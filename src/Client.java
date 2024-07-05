package src;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8000;

    private static Socket socket;
    private static BufferedReader reader;
    private static PrintWriter writer;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Client GUI");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextField textField = new JTextField(20);
        JButton sendButton = new JButton("Send");

        panel.add(textField);
        panel.add(sendButton);

        frame.add(panel);
        frame.setVisible(true);

        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            sendButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String message = textField.getText();
                    writer.println(message);

                    try {
                        String response = reader.readLine();
                        JOptionPane.showMessageDialog(frame, "Server response: " + response);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    textField.setText("");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}