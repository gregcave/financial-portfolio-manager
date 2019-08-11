import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Investments extends JFrame {

    public Investments()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Financial Profile Manager");
        setSize(1600,900);
        componentsHistory();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void componentsHistory(){

        JPanel panel_main = new JPanel();
        //panel_main.setBorder(BorderFactory.createLineBorder(Color.red));
        panel_main.setBackground(Color.darkGray);
        setContentPane(panel_main);
        panel_main.setLayout(null);

        //JLabel title = new JLabel("Financial Profile Manager");
        //title.setBounds(800,0, 400,50);
        //title.setForeground(Color.white);
        //title.setFont(title.getFont().deriveFont(30.0f));
        //panel_main.add(title);

        //Back button
        JPanel panel_user = new JPanel();
        panel_user.setBounds(1445,0,148,60);
        panel_user.setBorder(BorderFactory.createLineBorder(Color.yellow));
        panel_main.add(panel_user);
        panel_user.setLayout(null);
        JButton backButtton = new JButton("Back");
        backButtton.setBackground(Color.white);
        backButtton.setFocusPainted(false);
        backButtton.setBounds(0,0,148,60);
        panel_user.add(backButtton);

        //User info label
        JLabel infoUser = new JLabel(" ");
        infoUser.setForeground(Color.lightGray);
        panel_main.add(infoUser);
        User user = User.getUser(User.logged_in_user);
        // label.setText("<html>" + user.toString().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        // infoUser.setText("<html>" + user.toString().replaceAll("\n", "<br/>") + "</html>");
        infoUser.setText(StringBuilderInvestments.test(user.getUsername(), User.selectedDate));
        infoUser.setFont(new Font(Font.SERIF, 0, 20));
        infoUser.setBounds(10,10,(int)infoUser.getPreferredSize().getWidth(),(int)infoUser.getPreferredSize().getHeight());

        //Action listeners
        backButtton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                backButtton.setBackground(Color.black);
                backButtton.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {
                backButtton.setBackground(Color.white);
                backButtton.setForeground(Color.black);
            }
        });

        backButtton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Portfolio();

            }
        });

    }

    public static void main(String[] args) {
        new History();
    }
}
