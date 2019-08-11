import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DynamicTableData extends JFrame {

    public DynamicTableData() {

        components();
        setSize(1300, 700);
        setBackground(Color.darkGray);
        setTitle("API Dividends Table"+ ", Company: "+"'"+StockMenu.selection+"'");
        setVisible(true);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void components() {
        JTable table;
        JScrollPane scrollPane;


        table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(1200, 600));





        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);



        List<Dividends> divid;

        divid = getDividends(StockMenu.selection);



        MyTableModel divTable = new MyTableModel();
        for (Dividends dividends :
                divid) {

            divTable.addRow(dividends);
            table.setModel(divTable);

            if(divTable ==null){
                JOptionPane.showMessageDialog(this,"Error");
            }
        }

    }


    public static List<Dividends> getDividends(String symbol) {

        List<Dividends> dividends = new ArrayList<>();

        try {

            URL url = new URL("https://api.iextrading.com/1.0/stock/" + symbol + "/dividends/1y");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            String stringData = "";
            while ((inputLine = in.readLine()) != null) {
                stringData = stringData + inputLine;
                ObjectMapper mapper = new ObjectMapper();
                dividends = mapper.readValue(stringData, new TypeReference<List<Dividends>>() {
                });

            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dividends;
    }


    static class MyTableModel extends DefaultTableModel {

        public static final String[] columnNames = {"Ex-Date", "Payment Date", "Record Date", "declaredDate", "amount", "type"};

        public MyTableModel() {
            super(columnNames, 0);
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            if (getRowCount() > 0 && getValueAt(0, columnIndex) != null) {
                return getValueAt(0, columnIndex).getClass();
            }
            return super.getColumnClass(columnIndex);
        }


        public void addRow(Dividends dividends) {
            if (dividends == null) {
                throw new IllegalArgumentException("Rows cannot be null");
            }
            Vector<Object> rowVector = new Vector<>();
            rowVector.add(dividends.getExDate());
            rowVector.add(dividends.getPaymentDate());
            rowVector.add(dividends.getRecordDate());
            rowVector.add(dividends.getDeclaredDate());
            rowVector.add(dividends.getAmount());
            rowVector.add(dividends.getType());


            super.addRow(rowVector);
        }


        public static void main(String[] args) {

            new DynamicTableData();

        }
    }
}





