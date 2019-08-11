import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StockMenu extends JFrame {
    public static String selection;
    public StockMenu(){


        setSize(1600,900);

        setLocationRelativeTo(null);

        setTitle("Stock Menu");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBackground(Color.darkGray);


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




        JPanel homePanel = new JPanel();
        homePanel.setBounds(1,0,148,60);

        panel_main.add(homePanel);
        homePanel.setLayout(null);
        JButton homeButton = new JButton("Home");
        homeButton.setBounds(0,0,148,60);
        homeButton.setBackground(Color.white);
        homeButton.setFocusPainted(false);

        homePanel.add(homeButton);






        JPanel stockPanel = new JPanel();
        stockPanel.setBounds(149,0,148,60);

        panel_main.add(stockPanel);
        stockPanel.setLayout(null);
        JButton stockButton = new JButton("Famous Companies");
        stockButton.setBounds(0,0,148,60);
        stockButton.setBackground(Color.white);
        stockButton.setFocusPainted(false);

        stockPanel.add(stockButton);


        JPanel APIpanel = new JPanel();

        APIpanel.setBounds(296,0,148,60);

        panel_main.add(APIpanel);

        APIpanel.setLayout(null);
        JButton APIButton = new JButton("All Companies");
        APIButton.setBounds(0,0,148,60);
        APIButton.setBackground(Color.white);
        APIButton.setFocusPainted(false);
        APIpanel.add(APIButton);


        JPanel dividendPanel = new JPanel();

        dividendPanel.setBounds(443,0,161,60);

        panel_main.add(dividendPanel);

        dividendPanel.setLayout(null);
        JButton dividenButton = new JButton("Companies' Dividends");
        dividenButton.setBounds(0,0,161,60);
        dividenButton.setBackground(Color.white);
        dividenButton.setFocusPainted(false);
        dividendPanel.add(dividenButton);

        setVisible(true);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new menu();
                dispose();
            }
        });

        stockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new stockTable();
                dispose();
            }
        });

        APIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Symbol> options = Stock.getAllSymbols();
                JComboBox optionControl = new JComboBox();
                for (Symbol symbol: options) {
                    optionControl.addItem(symbol.getSymbol());
                }
                optionControl.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, optionControl, "Select Stock",
                        JOptionPane.PLAIN_MESSAGE);
                selection = (String)optionControl.getSelectedItem();

                new fiveYearsTable();
                //dispose();
            }
        });

        dividenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Symbol> options = Stock.getAllSymbols();
                JComboBox optionControl = new JComboBox();
                for (Symbol symbol: options) {
                    optionControl.addItem(symbol.getSymbol());
                }
                optionControl.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, optionControl, "Select Stock",
                        JOptionPane.PLAIN_MESSAGE);
                selection = (String)optionControl.getSelectedItem();
                new DynamicTableData();
                //dispose();
            }
        });



    }

    public static void main(String[] args) {
        new StockMenu();

    }
}
