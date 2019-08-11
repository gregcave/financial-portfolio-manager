import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AfterLogin extends JFrame {

    Timer timer_expand;
    Timer timer_reduce;
    int panel_height = 60;


    public AfterLogin()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Financial Profile Manager");
        setSize(1600,900);
        componentsAfterLogin();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void componentsAfterLogin()
    {
        JPanel panel_main = new JPanel();
        //panel_main.setBorder(BorderFactory.createLineBorder(Color.red));
        panel_main.setBackground(Color.darkGray);
        setContentPane(panel_main);
        panel_main.setLayout(null);

        JLabel title = new JLabel("Financial Profile Manager");
        title.setBounds(800,0, 400,50);
        title.setForeground(Color.white);
        title.setFont(title.getFont().deriveFont(30.0f));
        panel_main.add(title);

        //Portfolio button
        JPanel panel_portfolio = new JPanel();
        panel_portfolio.setBounds(1,0,148,60);
        panel_portfolio.setBorder(BorderFactory.createLineBorder(Color.red));
        panel_main.add(panel_portfolio);
        panel_portfolio.setLayout(null);
        JButton portfolio = new JButton("Portfolio");
        portfolio.setBounds(0, 0, 148, 60);
        portfolio.setBackground(Color.white);
        portfolio.setFocusPainted(false);
        panel_portfolio.add(portfolio);


        //Stocks dropdown buttons
        JPanel panel_stocks = new JPanel();
        panel_stocks.setBounds(149,0,148,60);
        panel_stocks.setBorder(BorderFactory.createLineBorder(Color.red));
        //panel_main.add(panel_stocks);
        panel_stocks.setLayout(null);
        JButton stocks = new JButton("Stocks");
        stocks.setBounds(0,0,148,60);
        stocks.setBackground(Color.white);
        stocks.setFocusPainted(false);
        //panel_stocks.add(stocks);

        //User dropdown button
        JPanel panel_user = new JPanel();
        panel_user.setBounds(1445,0,148,60);
        panel_user.setBorder(BorderFactory.createLineBorder(Color.yellow));
        panel_main.add(panel_user);
        panel_user.setLayout(null);
        JButton userButton = new JButton("User");
        userButton.setBackground(Color.white);
        userButton.setFocusPainted(false);
        userButton.setBounds(0,0,148,60);
        panel_user.add(userButton);

        //User welcome message
        JLabel welcomeUser = new JLabel("Welcome, "+User.logged_in_user);
        welcomeUser.setFont(new Font(Font.SERIF, 0, 40));
        welcomeUser.setBounds(600,400,(int)welcomeUser.getPreferredSize().getWidth(),(int)welcomeUser.getPreferredSize().getHeight());
        welcomeUser.setForeground(Color.lightGray);
        panel_main.add(welcomeUser);

       //Log Out Button
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBackground(Color.white);
        logoutButton.setBounds(0,60,148,60);
        panel_user.add(logoutButton);

        timer_expand = new Timer(5, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // 120 the maximum height
                if(panel_height > 121)
                {
                    timer_expand.stop();
                }
                else{
                    panel_user.setSize(panel_user.getWidth(), panel_height);
                    panel_height += 5;
                }

            }
        });

        timer_reduce = new Timer(5, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // 300 the maximum height
                if(panel_height < 60)
                {
                    timer_reduce.stop();
                }
                else{
                    panel_user.setSize(panel_user.getWidth(), panel_height);
                    panel_height -= 5;
                }

            }
        });

        panel_main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                timer_reduce.start();
            }
        });
        panel_stocks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                timer_reduce.stop();
            }
        });

        portfolio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                portfolio.setBackground(Color.black);
                portfolio.setForeground(Color.white);
                timer_reduce.start();

            }
            @Override
            public void mouseExited(MouseEvent e) {
                portfolio.setBackground(Color.white);
                portfolio.setForeground(Color.black);
            }
        });

        logoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                logoutButton.setBackground(Color.black);
                logoutButton.setForeground(Color.white);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                logoutButton.setBackground(Color.white);
                logoutButton.setForeground(Color.black);
            }
        });

        userButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                timer_expand.start();
                timer_reduce.stop();
                userButton.setBackground(Color.black);
                userButton.setForeground(Color.white);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                userButton.setBackground(Color.white);
                userButton.setForeground(Color.black);
                timer_expand.stop();
            }
        });

        stocks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                timer_reduce.start();
                stocks.setBackground(Color.black);
                stocks.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {

                //timer_reduce.start();
                //panel_stocksHeight = 60;
                stocks.setBackground(Color.white);
                stocks.setForeground(Color.black);
            }
        });

        logoutButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    User.logged_in_user=null;
                    User.logged_in_password=null;
                    dispose();
                    new menu();

            }
        });

        portfolio.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new Portfolio();

            }
        });

    }

}
