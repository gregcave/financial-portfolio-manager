import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu extends JFrame {
    public static JPanel panel_main;

    //Timer timer_expand;
    //Timer timer_reduce;
    //int panel_stocksHeight = 60;

    public menu(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Financial Profile Manager");
        setSize(1600,900);
        components();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void components(){
        panel_main = new JPanel();
        //panel_main.setBorder(BorderFactory.createLineBorder(Color.red));
        panel_main.setBackground(Color.darkGray);
        setContentPane(panel_main);
        panel_main.setLayout(null);

        JLabel title = new JLabel("Financial Profile Manager");
        title.setBounds(800,0, 400,50);
        title.setForeground(Color.white);
        title.setFont(title.getFont().deriveFont(30.0f));
        panel_main.add(title);

        //Stocks button
        JPanel panel_stocks = new JPanel();
        panel_stocks.setBounds(1,0,148,60);
        panel_stocks.setBorder(BorderFactory.createLineBorder(Color.red));
        panel_main.add(panel_stocks);
        panel_stocks.setLayout(null);
        JButton stocks = new JButton("Stocks");
        stocks.setBounds(0,0,148,60);
        stocks.setBackground(Color.white);
        stocks.setFocusPainted(false);
        panel_stocks.add(stocks);

   /*     JButton netflix = new JButton("Netflix");
        netflix.setBackground(Color.white);
        netflix.setBounds(0, 61, 148, 60);
        panel_stocks.add(netflix);

        JButton apple = new JButton("Apple");
        apple.setBackground(Color.white);
        apple.setBounds(0, 122, 148, 60);
        panel_stocks.add(apple);

        JButton amazon = new JButton("Amazon");
        amazon.setBackground(Color.white);
        amazon.setBounds(0, 183, 148, 60);
        panel_stocks.add(amazon);

        JButton intel = new JButton("Intel");
        intel.setBackground(Color.white);
        intel.setBounds(0, 244, 148, 60);
        panel_stocks.add(intel);

        JButton facebook = new JButton("Facebook");
        facebook.setBackground(Color.white);
        facebook.setBounds(0, 305, 148, 60);
        panel_stocks.add(facebook);              */


        JPanel panel_user = new JPanel();
        panel_user.setBounds(149,0,296,60);
        panel_user.setBorder(BorderFactory.createLineBorder(Color.yellow));
        panel_main.add(panel_user);
        panel_user.setLayout(null);
        JButton register = new JButton("Register");
        register.setBackground(Color.white);
        register.setFocusPainted(false);
        register.setBounds(0,0,148,60);
        JButton login = new JButton("Login");
        login.setBackground(Color.white);
        login.setFocusPainted(false);
        login.setBounds(148,0,148,60);
        panel_user.add(register);
        panel_user.add(login);

        //LoginComponents

        //username label
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(600,209,200,20);
        usernameLabel.setForeground(Color.lightGray);
        //username field
        JTextField usernameLogin = new JTextField();
        usernameLogin.setBounds(600,230,200,20);
        //password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(600,270,200,20);
        passwordLabel.setForeground(Color.lightGray);
        //password field
        JPasswordField passwordLogin = new JPasswordField();
        passwordLogin.setBounds(600,291,200,20);
        //login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(626,330,148,60);
        loginButton.setBackground(Color.white);
        loginButton.setFocusPainted(false);


        //Register Components

        //set username label
        JLabel setUsernameLabel = new JLabel("Set Username:");
        setUsernameLabel.setBounds(600, 209, 200,20);
        setUsernameLabel.setForeground(Color.lightGray);
        //set username field
        JTextField setUsername = new JTextField();
        setUsername.setBounds(600,230,200,20);
        //set password label
        JLabel setPasswordLabel = new JLabel("Set Password:");
        setPasswordLabel.setBounds(600,270,200,20);
        setPasswordLabel.setForeground(Color.lightGray);
        //set password field
        JPasswordField setPassword = new JPasswordField();
        setPassword.setBounds(600,291,200,20);
        //registration button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(626,330,148,60);
        registerButton.setBackground(Color.white);
        registerButton.setFocusPainted(false);

        setUsernameLabel.setVisible(false);
        setUsername.setVisible(false);
        setPasswordLabel.setVisible(false);
        setPassword.setVisible(false);
        registerButton.setVisible(false);

        panel_main.add(setUsernameLabel);
        panel_main.add(setUsername);
        panel_main.add(setPasswordLabel);
        panel_main.add(setPassword);
        panel_main.add(registerButton);

        usernameLabel.setVisible(false);
        usernameLogin.setVisible(false);
        passwordLabel.setVisible(false);
        passwordLogin.setVisible(false);
        loginButton.setVisible(false);

        panel_main.add(usernameLogin);
        panel_main.add(usernameLabel);
        panel_main.add(passwordLogin);
        panel_main.add(passwordLabel);
        panel_main.add(loginButton);

        stocks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                stocks.setBackground(Color.black);
                stocks.setForeground(Color.white);

                setUsernameLabel.setVisible(false);
                setUsername.setVisible(false);
                setPasswordLabel.setVisible(false);
                setPassword.setVisible(false);
                registerButton.setVisible(false);

                usernameLabel.setVisible(false);
                usernameLogin.setVisible(false);
                passwordLabel.setVisible(false);
                passwordLogin.setVisible(false);
                loginButton.setVisible(false);



            }
            @Override
            public void mouseExited(MouseEvent e) {
                stocks.setBackground(Color.white);
                stocks.setForeground(Color.black);
            }
        });

        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                register.setBackground(Color.black);
                register.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                register.setBackground(Color.white);
                register.setForeground(Color.black);
            }
        });

        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                login.setBackground(Color.black);
                login.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                login.setBackground(Color.white);
                login.setForeground(Color.black);
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameLabel.setVisible(true);
                usernameLogin.setVisible(true);
                passwordLabel.setVisible(true);
                passwordLogin.setVisible(true);
                loginButton.setVisible(true);

                setUsernameLabel.setVisible(false);
                setUsername.setVisible(false);
                setPasswordLabel.setVisible(false);
                setPassword.setVisible(false);
                registerButton.setVisible(false);
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setUsernameLabel.setVisible(true);
                setUsername.setVisible(true);
                setPasswordLabel.setVisible(true);
                setPassword.setVisible(true);
                registerButton.setVisible(true);

                usernameLabel.setVisible(false);
                usernameLogin.setVisible(false);
                passwordLabel.setVisible(false);
                passwordLogin.setVisible(false);
                loginButton.setVisible(false);
            }
        });

        registerButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String username = setUsername.getText();
                String password = setPassword.getText();
                if(User.userExists(username)==false)
                {
                    User user = new User(username, password, 0);
                    User.createUser(username, password);
                    user.createStockFile(username);
                    user.createHistoryFile(username);
                    user.createTotalFile(username);
                    setUsername.setText("");
                    setPassword.setText("");
                    JOptionPane.showMessageDialog(null,"Registration was successful!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"User already exists.");
                }
            }
        });

        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String username = usernameLogin.getText();
                String password = passwordLogin.getText();
                if(User.validDetails(username, password)==false)
                {
                    JOptionPane.showMessageDialog(null,"Invalid credentials. Please try again");
                }
                else
                {
                    usernameLogin.setText("");
                    passwordLogin.setText("");
                    User.logged_in_user=username;
                    User.logged_in_password=password;
                    dispose();
                    new AfterLogin();
                }
            }
        });

        stocks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //new stockTable();
                new StockMenu();
               dispose();
            }
        });


    }





    public static void main(String[] args){
        new menu();
    }
}
