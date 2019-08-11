import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.awt.Color.*;

public class BeforeLogin extends JFrame {

    JTextField infoField;
    JButton infoButton;
    JButton backButton;
    JLabel infoLabel;
    JLabel dateLabel;
    JPanel buttonPanel;
    JPanel infoPanel;

    public BeforeLogin(){
        setSize(1600,900);
        setTitle("Netflix Shares Info");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        netflixWindowComponents();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void netflixWindowComponents(){

        infoField = new JTextField(12);
        infoButton = new JButton("Login");
        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 20));
        backButton.setBackground(gray);
        infoLabel = new JLabel(" ");
        dateLabel = new JLabel("Username");



        buttonPanel = new JPanel();
        infoPanel = new JPanel();
        buttonPanel.add(dateLabel);
        buttonPanel.add(infoField);
        buttonPanel.add(infoButton);
        buttonPanel.add(backButton);
        infoPanel.add(infoLabel);
        add(buttonPanel, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.WEST);




        infoButton.addActionListener(new ButtonHandlerInfoNetflix(infoLabel, infoField, infoPanel));


    }

}

class ButtonHandlerInfoNetflix implements ActionListener {
    JLabel label;
    JTextField textField;
    JPanel infoPanel;

    ButtonHandlerInfoNetflix(JLabel label, JTextField textField, JPanel infoPanel)
    {
        this.label=label;
        this.textField=textField;
        this.infoPanel=infoPanel;
    }


    public void actionPerformed(ActionEvent click)
    {
        String csvFile = "src\\resources\\UserInfo.txt";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile)))
        {
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] rowWords = line.split(cvsSplitBy);
                if(rowWords[0].equals(textField.getText()))
                {
                    User user = new User(rowWords[0],rowWords[1],Integer.parseInt(rowWords[2])); //the info of each column
                    // label.setText("<html>" + user.toString().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
                    label.setText("<html>" + user.toString().replaceAll("\n", "<br/>") + "</html>");
                    br.close();
                    break;
                }
                else{
                    label.setText("Incorrect credentials. Please try again.");
                    label.setForeground(Color.red);
                    br.close();
                    break;
                }
            }

        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public static void main(String[] args){
        BeforeLogin display = new BeforeLogin();
    }
}
