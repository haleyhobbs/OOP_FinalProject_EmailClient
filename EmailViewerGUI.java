
//libraries
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;

public class EmailViewerGUI extends JFrame {
    // fields
    private JPanel contentPane;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JButton btnClose;

    private Email email;
    private FileHandler fileHandler;
    private String userEmail;

    // constructor
    public EmailViewerGUI(Email email, FileHandler fileHandler, String userEmail) {
        this.email = email;
        this.fileHandler = fileHandler;
        this.userEmail = userEmail;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("From: " + email.getSender() + "\n"
                + "To: " + email.getRecipient() + "\n"
                + "Subject: " + email.getSubject() + "\n"
                + "Message: " + email.getEmailContent());

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(5, 5, 440, 233);
        contentPane.add(scrollPane);

        JButton btnReply = new JButton("Reply");
        btnReply.setBounds(10, 240, 100, 30);
        btnReply.addActionListener(e -> {
            // Open the ComposeGUI with the sender's email as the recipient
            ComposeGUI composeGUI = new ComposeGUI(userEmail, email.getSender());
            composeGUI.setVisible(true);
            dispose(); // Close the email viewer
        });
        contentPane.add(btnReply);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(290, 237, 100, 30);
        btnClose.addActionListener(e -> dispose());
        contentPane.add(btnClose);

        setTitle("View Email");
    }

}