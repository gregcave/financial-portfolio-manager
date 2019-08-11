import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Portfolio extends JFrame {

    private BarChartStocks<CategoryChart> Stocks;

    public Portfolio()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Financial Profile Manager");
        setSize(1600,900);
        componentsPortfolio();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void componentsPortfolio(){

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
        //infoUser.setText("<html>" + user.toString().replaceAll("\n", "<br/>") + "</html>");
        infoUser.setText(StringBuilderUserStocks.test(user.getUsername()));
        infoUser.setFont(new Font(Font.SERIF, 0, 20));
        infoUser.setBounds(10,10,(int)infoUser.getPreferredSize().getWidth(),(int)infoUser.getPreferredSize().getHeight());

        //Add new symbol, buy and sell buttons
        JPanel stockUpdatePanel = new JPanel();
        stockUpdatePanel.setBounds(0,690,148,180);
        stockUpdatePanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        panel_main.add(stockUpdatePanel);
        stockUpdatePanel.setLayout(null);
        JButton addNewSymbolButton = new JButton("Add New Stock");
        addNewSymbolButton.setBackground(Color.white);
        addNewSymbolButton.setFocusPainted(false);
        addNewSymbolButton.setBounds(0,120,148,60);
        stockUpdatePanel.add(addNewSymbolButton);
        JButton buyStocksButton = new JButton("Buy Stocks");
        buyStocksButton.setBackground(Color.white);
        buyStocksButton.setFocusPainted(false);
        buyStocksButton.setBounds(0,60,148,60);
        stockUpdatePanel.add(buyStocksButton);
        JButton SellStocksButton = new JButton("Sell Stocks");
        SellStocksButton.setBackground(Color.white);
        SellStocksButton.setFocusPainted(false);
        SellStocksButton.setBounds(0,0,148,60);
        stockUpdatePanel.add(SellStocksButton);
        //Deposit and withdraw money buttons
        JPanel moneyUpdatePanel = new JPanel();
        moneyUpdatePanel.setBounds(148,750,148,120);
        moneyUpdatePanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        panel_main.add(moneyUpdatePanel);
        moneyUpdatePanel.setLayout(null);
        JButton depositMoneyButton = new JButton("Deposit Money");
        depositMoneyButton.setBackground(Color.white);
        depositMoneyButton.setFocusPainted(false);
        depositMoneyButton.setBounds(0,60,148,60);
        moneyUpdatePanel.add(depositMoneyButton);
        JButton withdrawMoneyButton = new JButton("Withdraw Money");
        withdrawMoneyButton.setBackground(Color.white);
        withdrawMoneyButton.setFocusPainted(false);
        withdrawMoneyButton.setBounds(0,0,148,60);
        moneyUpdatePanel.add(withdrawMoneyButton);
        //Graphical panel
        JPanel graphicalPanel = new JPanel();
        graphicalPanel.setBounds(1445,810,148,60);
        graphicalPanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        panel_main.add(graphicalPanel);
        graphicalPanel.setLayout(null);
        JButton graphButton = new JButton("Graph Info");
        graphButton.setBackground(Color.white);
        graphButton.setFocusPainted(false);
        graphButton.setBounds(0,0,148,60);
        graphicalPanel.add(graphButton);
        //History panel
        JPanel historyPanel = new JPanel();
        historyPanel.setBounds(1297,810,148,60);
        historyPanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        panel_main.add(historyPanel);
        historyPanel.setLayout(null);
        JButton historyButton = new JButton("User History");
        historyButton.setBackground(Color.white);
        historyButton.setFocusPainted(false);
        historyButton.setBounds(0,0,148,60);
        historyPanel.add(historyButton);
        //Investments panel
        JPanel investmentsPanel = new JPanel();
        investmentsPanel.setBounds(1077,810,220,60);
        investmentsPanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        panel_main.add(investmentsPanel);
        investmentsPanel.setLayout(null);
        JButton investmentsButton = new JButton("Total Investments By Date");
        investmentsButton.setBackground(Color.white);
        investmentsButton.setFocusPainted(false);
        investmentsButton.setBounds(0,0,220,60);
        investmentsPanel.add(investmentsButton);
        //Line Chart
        JButton lineButton = new JButton("Line Chart");
        lineButton.setBackground(Color.white);
        lineButton.setFocusPainted(false);
        lineButton.setBounds(1445,750,148,60);
        panel_main.add(lineButton);
        //Pdf
        JButton pdf = new JButton("Export to PDF");
        pdf.setBackground(Color.white);
        pdf.setFocusPainted(false);
        pdf.setBounds(1445,500,148,60);
        panel_main.add(pdf);
        //Save panel
        JPanel savePanel = new JPanel();
        savePanel.setBounds(1445,440,148,60);
        savePanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        panel_main.add(savePanel);
        savePanel.setLayout(null);
        JButton saveButton = new JButton("Save Changes");
        saveButton.setBackground(Color.white);
        saveButton.setFocusPainted(false);
        saveButton.setBounds(0,0,148,60);
        savePanel.add(saveButton);







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

        addNewSymbolButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                addNewSymbolButton.setBackground(Color.black);
                addNewSymbolButton.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {
                addNewSymbolButton.setBackground(Color.white);
                addNewSymbolButton.setForeground(Color.black);
            }
        });

        buyStocksButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                buyStocksButton.setBackground(Color.black);
                buyStocksButton.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {
                buyStocksButton.setBackground(Color.white);
                buyStocksButton.setForeground(Color.black);
            }
        });

        SellStocksButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                SellStocksButton.setBackground(Color.black);
                SellStocksButton.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {
                SellStocksButton.setBackground(Color.white);
                SellStocksButton.setForeground(Color.black);
            }
        });

        graphButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                graphButton.setBackground(Color.black);
                graphButton.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {
                graphButton.setBackground(Color.white);
                graphButton.setForeground(Color.black);
            }
        });

        lineButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                lineButton.setBackground(Color.black);
                lineButton.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {
                lineButton.setBackground(Color.white);
                lineButton.setForeground(Color.black);
            }
        });

        pdf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                pdf.setBackground(Color.black);
                pdf.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {
                pdf.setBackground(Color.white);
                pdf.setForeground(Color.black);
            }
        });

        historyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                historyButton.setBackground(Color.black);
                historyButton.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {
                historyButton.setBackground(Color.white);
                historyButton.setForeground(Color.black);
            }
        });

        depositMoneyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                depositMoneyButton.setBackground(Color.black);
                depositMoneyButton.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {
                depositMoneyButton.setBackground(Color.white);
                depositMoneyButton.setForeground(Color.black);
            }
        });

        withdrawMoneyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                withdrawMoneyButton.setBackground(Color.black);
                withdrawMoneyButton.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {
                withdrawMoneyButton.setBackground(Color.white);
                withdrawMoneyButton.setForeground(Color.black);
            }
        });

        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                saveButton.setBackground(Color.black);
                saveButton.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {
                saveButton.setBackground(Color.white);
                saveButton.setForeground(Color.black);
            }
        });

        investmentsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                investmentsButton.setBackground(Color.black);
                investmentsButton.setForeground(Color.white);


            }
            @Override
            public void mouseExited(MouseEvent e) {
                investmentsButton.setBackground(Color.white);
                investmentsButton.setForeground(Color.black);
            }
        });

        backButtton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new AfterLogin();

            }
        });

        investmentsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                User user = User.getUser(User.logged_in_user);
                user.setUserTotals();
                ArrayList<UserTotal> userTotals = user.getUserTotals();
                JComboBox optionControl = new JComboBox();
                String current = "";
                for (UserTotal userTotal: userTotals) {
                    if(!userTotal.getDate().equals(current)) {
                        optionControl.addItem(userTotal.getDate());
                        current = userTotal.getDate();
                    }
                }
                optionControl.setSelectedIndex(0);
                JOptionPane.showMessageDialog(panel_main, optionControl, "Select Stock",
                        JOptionPane.PLAIN_MESSAGE);
                User.selectedDate = (String)optionControl.getSelectedItem();
                dispose();
                new Investments();

            }
        });

        addNewSymbolButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                List<Symbol> options = Stock.getAllSymbols();
                JComboBox optionControl = new JComboBox();
                for (Symbol symbol: options) {
                    optionControl.addItem(symbol.getSymbol());
                }
                optionControl.setSelectedIndex(0);
                JOptionPane.showMessageDialog(panel_main, optionControl, "Select Stock",
                        JOptionPane.PLAIN_MESSAGE);
                System.out.println(optionControl.getSelectedItem());
                User currentUser = User.getUser(User.logged_in_user);
                currentUser.setStocksOwned();
                ArrayList<Stock> currentUserStocksOwned = currentUser.getStocksOwned();
                boolean stockAlreadyExists=false;
                for (Stock stock:
                     currentUserStocksOwned) {

                    if(stock.getSymbol().equals(optionControl.getSelectedItem())){
                        stockAlreadyExists=true;
                    }

                }
                if(!stockAlreadyExists){

                    User.addUserStock(User.logged_in_user, (String)optionControl.getSelectedItem());
                    String history =
                                            "(NEW STOCK)Added new stock: " +
                                    (String)optionControl.getSelectedItem()+
                                    " (" + User.getDate() + ")";

                    User.addUserHistory(User.logged_in_user, history);

                }
                else{
                    JOptionPane.showMessageDialog(null,"Stock already exists");
                }

                infoUser.setText(StringBuilderUserStocks.test(user.getUsername()));
                infoUser.setBounds(10,10,(int)infoUser.getPreferredSize().getWidth(),(int)infoUser.getPreferredSize().getHeight());


            }
        });

        depositMoneyButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                float amount = Float.parseFloat(JOptionPane.showInputDialog(panel_main, "How much money would you like to deposit?"));
                User currentUser = User.getUser(User.logged_in_user);
                float currentMoney = currentUser.getMoney();
                currentUser.depositMoney(amount);
                infoUser.setText(StringBuilderUserStocks.test(user.getUsername()));
                infoUser.setBounds(10,10,(int)infoUser.getPreferredSize().getWidth(),(int)infoUser.getPreferredSize().getHeight());
                String history =
                                "(DEPOSIT)Amount before deposit: " +
                                currentMoney +
                                ", after deposit: " +
                                (currentMoney+amount) +
                                ", deposited: " +
                                amount +
                                " (" + User.getDate() + ")";
                User.addUserHistory(User.logged_in_user, history);

            }
        });

        withdrawMoneyButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                float amount = Float.parseFloat(JOptionPane.showInputDialog(panel_main, "How much money would you like to withdraw?"));
                User currentUser = User.getUser(User.logged_in_user);
                float currentMoney = currentUser.getMoney();
                currentUser.withdrawMoney(amount);
                infoUser.setText(StringBuilderUserStocks.test(user.getUsername()));
                infoUser.setBounds(10,10,(int)infoUser.getPreferredSize().getWidth(),(int)infoUser.getPreferredSize().getHeight());
                String history =
                                "(WITHDRAW)Amount before withdraw: " +
                                currentMoney +
                                ", after withdraw: " +
                                (currentMoney-amount) +
                                ", withdrawn: " +
                                amount +
                                " (" + User.getDate() + ")";
                User.addUserHistory(User.logged_in_user, history);

            }
        });

        graphButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                User.getUser(User.logged_in_user).setStocksOwned();
                Stocks = new StockChart();
                Stocks.getChart();



            }
        });

        lineButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                User.getUser(User.logged_in_user).getStocksOwned();

                LineChartNew<XYChart> chart = new LineChart2();
                XYChart chart2 = chart.getChart();




            }
        });

        pdf.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                User.getUser(User.logged_in_user).getStocksOwned();
                try {
                    CreateBlankPDF.main(null);

                    JOptionPane.showMessageDialog(null,"PDF Successfully Created!");

                }catch (IOException el){
                    System.out.println("ERROR");
                }











            }
        });

        historyButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new History();
                dispose();

            }
        });

        /////////BUYING AND SELLING////////////////////////////////////////////////////////////////////////////////
        buyStocksButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int initialAmount = 0;
                float price = 0;
                String symbol = "";
                User currentUser = User.getUser(User.logged_in_user);
                currentUser.setStocksOwned();
                ArrayList<Stock> currentUserStocksOwned = currentUser.getStocksOwned();
                JComboBox optionControl = new JComboBox();
                for (Stock stock: currentUserStocksOwned) {
                    optionControl.addItem(stock.getSymbol());
                }
                optionControl.setSelectedIndex(0);
                JTextField amount = new JTextField(5);
                //JLabel userMoney = new JLabel(" ");
                //userMoney.setText(String.valueOf(currentUser.getMoney()));
                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Stock:"));
                myPanel.add(optionControl);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("Amount:"));
                myPanel.add(amount);
                //myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                //myPanel.add(userMoney);

                JOptionPane.showMessageDialog(panel_main, myPanel, "Select Stock",
                        JOptionPane.PLAIN_MESSAGE);
                String selectedSymbol = (String)optionControl.getSelectedItem();
                int selectedAmount = Integer.parseInt(amount.getText());
                for (Stock stock: currentUserStocksOwned) {
                    if(stock.getSymbol().equals(selectedSymbol)){
                        symbol = stock.getSymbol();
                        initialAmount = stock.getAmount();
                        price = Float.parseFloat(Stock.realPrice(stock.getSymbol()));
                        stock.setAmount(stock.getAmount()+selectedAmount);
                        user.withdrawMoney(selectedAmount * Float.parseFloat(Stock.realPrice(stock.getSymbol())));
                    }
                }
                try {
                    String file = "src\\resources\\individual\\" +currentUser.getUsername().toLowerCase() + ".txt";
                    Writer buf;
                    buf = new BufferedWriter(new FileWriter(file, false));  //clears file every time
                    PrintWriter output = new PrintWriter(buf);
                    for (Stock stock:currentUserStocksOwned) {
                            output.println(stock.getName()+","+stock.getSymbol()+","+stock.getAmount());

                    }
                    output.close();

                }
                catch(Exception er) {
                    er.printStackTrace();
                }

                System.out.println(optionControl.getSelectedItem());
                infoUser.setText(StringBuilderUserStocks.test(user.getUsername()));
                infoUser.setBounds(10,10,(int)infoUser.getPreferredSize().getWidth(),(int)infoUser.getPreferredSize().getHeight());

                String history =
                                "(BUY)Company: " +
                                symbol +
                                ", amount before buying: " +
                                initialAmount +
                                ", after buying: " +
                                (initialAmount+selectedAmount) +
                                ", bought: " +
                                selectedAmount +
                                ", price: " +
                                price +
                                " (" + User.getDate() + ")";
                User.addUserHistory(currentUser.getUsername(), history);
                float total = currentUser.getMoney();
          /*      for (Stock stock:currentUserStocksOwned) {
                    total += (stock.getAmount()*Float.parseFloat(Stock.realPrice(stock.getSymbol())));
                }
                UserTotal userTotal = new UserTotal(User.getDateTotal(), total);
                User.addUserTotal(currentUser.getUsername(), userTotal);  */


            }
        });






        SellStocksButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int initialAmount = 0;
                float price = 0;
                String symbol = "";
                User currentUser = User.getUser(User.logged_in_user);
                currentUser.setStocksOwned();
                ArrayList<Stock> currentUserStocksOwned = currentUser.getStocksOwned();
                JComboBox optionControl = new JComboBox();
                for (Stock stock: currentUserStocksOwned) {
                    optionControl.addItem(stock.getSymbol());
                }
                optionControl.setSelectedIndex(0);
                JTextField amount = new JTextField(5);
                //JLabel userMoney = new JLabel(" ");
                //userMoney.setText(String.valueOf(currentUser.getMoney()));
                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Stock:"));
                myPanel.add(optionControl);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("Amount:"));
                myPanel.add(amount);
                //myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                //myPanel.add(userMoney);

                JOptionPane.showMessageDialog(panel_main, myPanel, "Select Stock",
                        JOptionPane.PLAIN_MESSAGE);
                String selectedSymbol = (String)optionControl.getSelectedItem();
                int selectedAmount = Integer.parseInt(amount.getText());
                for (Stock stock: currentUserStocksOwned) {
                    if(stock.getSymbol().equals(selectedSymbol)){
                        symbol = stock.getSymbol();
                        initialAmount = stock.getAmount();
                        price = Float.parseFloat(Stock.realPrice(stock.getSymbol()));
                        stock.setAmount(stock.getAmount()-selectedAmount);
                        user.depositMoney(selectedAmount * Float.parseFloat(Stock.realPrice(stock.getSymbol())));
                    }
                }
                try {
                    String file = "src\\resources\\individual\\" +currentUser.getUsername().toLowerCase() + ".txt";
                    Writer buf;
                    buf = new BufferedWriter(new FileWriter(file, false));  //clears file every time
                    PrintWriter output = new PrintWriter(buf);
                    for (Stock stock:currentUserStocksOwned) {
                        output.println(stock.getName()+","+stock.getSymbol()+","+stock.getAmount());

                    }
                    output.close();

                }
                catch(Exception er) {
                    er.printStackTrace();
                }

                System.out.println(optionControl.getSelectedItem());
                infoUser.setText(StringBuilderUserStocks.test(user.getUsername()));
                infoUser.setBounds(10,10,(int)infoUser.getPreferredSize().getWidth(),(int)infoUser.getPreferredSize().getHeight());

                String history =
                                "(SELL)Company: " +
                                symbol +
                                ", amount before selling: " +
                                initialAmount +
                                ", after selling: " +
                                (initialAmount-selectedAmount) +
                                ", sold: " +
                                selectedAmount +
                                ", price: " +
                                price +
                                " (" + User.getDate() + ")";
                User.addUserHistory(currentUser.getUsername(), history);
         /*       float total = currentUser.getMoney();
                for (Stock stock:currentUserStocksOwned) {
                    total += (stock.getAmount()*Float.parseFloat(Stock.realPrice(stock.getSymbol())));
                }
                UserTotal userTotal = new UserTotal(User.getDateTotal(), total);
                User.addUserTotal(currentUser.getUsername(), userTotal);   */


            }
        });

        saveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                User user = User.getUser(User.logged_in_user);
                user.setStocksOwned();
                ArrayList<Stock> userStocks = user.getStocksOwned();
                float money = user.getMoney();
                float stockMoney = 0;
                for (Stock stock:userStocks) {
                    stockMoney += (stock.getAmount()*Float.parseFloat(Stock.realPrice(stock.getSymbol())));
                }
                UserTotal userTotal = new UserTotal(User.getDateTotal(), money, stockMoney, User.getHourTotal());
                User.addUserTotal(user.getUsername(), userTotal);

            }
        });




    /*    //user info table

                ArrayList<User> users = User.getAllUsers();

        for (User user:users) {

            if (user.getUsername().equals(User.logged_in_user)){
                user.setStocksOwned();
                ArrayList<Stock> userStocksOwned = user.getStocksOwned();
                String[][] rowData = {};
                String headers[]={"Name","Symbol","Amount","Current Price","Money"}; //the column's headers

                DefaultTableModel listTableModel;
                listTableModel = new DefaultTableModel(rowData, headers);
                for (Stock stock: userStocksOwned) {
                    listTableModel.addRow(new Object[]{stock.getName(), stock.getSymbol(), stock.getAmount(), Stock.realPrice(stock.getSymbol()), user.getMoney()});
                }

                //listTableModel = new DefaultTableModel(50, 50);

                JTable userInfoTable;
                userInfoTable = new JTable(listTableModel);
                userInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                userInfoTable.setCellEditor(null);
                JScrollPane pane=new JScrollPane(userInfoTable);
                pane.setBounds(50, 50, (int)pane.getPreferredSize().getWidth()-70, (int)pane.getPreferredSize().getHeight()-150);
                panel_main.add(pane);

            }

        }

     */





    }
}
