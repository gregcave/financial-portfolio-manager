import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class stockTable {

    public stockTable() {

        JTable table;
        JScrollPane scPane;


        JFrame frame = new JFrame("Famous Companies' Stock Table");

        JButton backBut = new JButton("Menu");

        backBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new StockMenu();
            }
        });





        frame.setSize(1300,700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





        table = new JTable(new tableModel());
        table.setPreferredScrollableViewportSize(frame.getPreferredSize());


        //creating menu_old for netflix stock
        JMenu menuNetflix = new JMenu("Netflix");

        JMenuItem nfxMonth1 = new JMenuItem("One month");

        JMenuItem nfxYear1 = new JMenuItem("One year");

        JMenuItem nfxYear5 = new JMenuItem("Five years");


        //creating menu_old for amazon stock
        JMenu menuAmazon = new JMenu("Amazon");

        JMenuItem amzMonth1 = new JMenuItem("One month");

        JMenuItem amzYear1 = new JMenuItem("One year");

        JMenuItem amzYear5 = new JMenuItem("Five years");


        //creating menu_old for apple stock
        JMenu menuApple = new JMenu("Apple");

        JMenuItem aplMonth1 = new JMenuItem("One month");

        JMenuItem aplYear1 = new JMenuItem("One year");

        JMenuItem aplYear5 = new JMenuItem("Five years");



        JMenu menuFacebook = new JMenu("Facebook");


        JMenuItem fbMonth1 = new JMenuItem("One month");

        JMenuItem fbYear1 = new JMenuItem("One year");

        JMenuItem fbYear5 = new JMenuItem("Five years");



        JMenu menuAlphabet = new JMenu("Alphabet");


        JMenuItem googlMonth1 = new JMenuItem("One month");

        JMenuItem googlYear1 = new JMenuItem("One year");

        JMenuItem googlYear5 = new JMenuItem("Five years");



        menuNetflix.add(nfxMonth1);
        menuNetflix.add(nfxYear1);
        menuNetflix.add(nfxYear5);

        menuAmazon.add(amzMonth1);
        menuAmazon.add(amzYear1);
        menuAmazon.add(amzYear5);

        menuApple.add(aplMonth1);
        menuApple.add(aplYear1);
        menuApple.add(aplYear5);

        menuAlphabet.add(googlMonth1);
        menuAlphabet.add(googlYear1);
        menuAlphabet.add(googlYear5);

        menuFacebook.add(fbMonth1);
        menuFacebook.add(fbYear1);
        menuFacebook.add(fbYear5);

        JMenuBar bar = new JMenuBar();



        bar.add(backBut);
        bar.add(menuNetflix);
        bar.add(menuAmazon);
        bar.add(menuApple);
        bar.add(menuAlphabet);
        bar.add(menuFacebook);


        frame.add(bar,BorderLayout.NORTH);


        scPane = new JScrollPane(table);
        frame.add(scPane, BorderLayout.CENTER);

        //Netflix actionlistener
        nfxMonth1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                    stockFile r = new stockFile();

                    tableModel newModel = new tableModel();

                    File stocks = new File("src/company_csv/netflixStock1m.csv");
                    ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                    newModel.addStocksInfo(arrayList2);
                    table.setModel(newModel);

            }
        });

        nfxYear1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/netflixStock1yr.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });

        nfxYear5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/netflixStock.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });


        //Amazon actionlistener

        amzMonth1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    stockFile r = new stockFile();

                    tableModel newModel = new tableModel();

                    File stocks = new File("src/company_csv/amazonStock1m.csv");
                    ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                    newModel.addStocksInfo(arrayList2);
                    table.setModel(newModel);

            }
        });

        amzYear1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/amazonStock1yr.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });

        amzYear5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/amazonStock.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });



        //Apple actionlistener
        aplMonth1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/appleStock1m.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });

        aplYear1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/appleStock1yr.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });

        aplYear5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/appleStock.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });

        //Alphabet actionlistener

        googlMonth1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/alphabetStock1m.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });

        googlYear1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/alphabetStock1yr.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });

        googlYear5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/alphabetStock5yr.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });


        //Facebook actionlistener

        fbMonth1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/fbStock1m.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });

        fbYear1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/fbStock1yr.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });

        fbYear5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                stockFile r = new stockFile();

                tableModel newModel = new tableModel();

                File stocks = new File("src/company_csv/fbStock5yr.csv");
                ArrayList<String[]> arrayList2 = r.readStockFile(stocks);

                newModel.addStocksInfo(arrayList2);
                table.setModel(newModel);

            }
        });





    }





    //Reads the stock file
    public class stockFile {
        ArrayList<String[]> arrayList = new ArrayList<>();
        String[] row1;

        public ArrayList<String[]> readStockFile (File stocks) {
            try {
                BufferedReader br = new BufferedReader (new FileReader(stocks));

                while (br.readLine() != null) {
                    String s = br.readLine();
                    row1 = s.split(",");
                    arrayList.add(row1);
                    //System.out.println (Arrays.toString(row1));
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null,"File not found");
                System.out.println("File not found: " + e.getMessage());
            }
            return arrayList;
        }
    }

    //creating new abstract table model
    class tableModel extends AbstractTableModel {
        String[] columnNames = { "date", "open", "high", "low", "close", "volume", "unadjustedVolume", "change"};
        ArrayList<String[]> Info =  new ArrayList<>();

        public void addStocksInfo(ArrayList<String[]> inputInfo) {
            this.Info = inputInfo;
            this.fireTableDataChanged();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }
        @Override
        public int getRowCount() {
            return Info.size();
        }
        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }
        @Override
        public Object getValueAt(int row, int col)
        {
            return Info.get(row)[col];

        }
    }
}


