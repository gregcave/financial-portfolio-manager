
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

public class fiveYearsTable extends JFrame {


        public fiveYearsTable() {


            components();
            setTitle("API Stock Table of five years"+ ", Company: "+"'"+StockMenu.selection+"'");
            setSize(1300, 700);
            setBackground(Color.darkGray);
            setVisible(true);
            setLocationRelativeTo(null);
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

            public void components() {
                JTable table;
                JScrollPane scrollPane;

                table = new JTable(new TableFiveYears());
                table.setPreferredScrollableViewportSize(new Dimension(1200, 600));





                scrollPane = new JScrollPane(table);
                add(scrollPane, BorderLayout.CENTER);




                List<fiveYears> five;

                five = getFiveYears(StockMenu.selection);


                TableFiveYears divTable = new TableFiveYears();
                for (fiveYears fiveY :
                        five) {

                    divTable.addRow(fiveY);
                    table.setModel(divTable);

                }
            }
    public static List<fiveYears> getFiveYears(String symbol){

        List<fiveYears> five = new ArrayList<>();

        try
        {

            URL url = new URL("https://api.iextrading.com/1.0/stock/"+symbol+"/chart/5y");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            String stringData ="";
            while ((inputLine = in.readLine()) != null) {
                stringData =stringData+inputLine;
                ObjectMapper mapper = new ObjectMapper();
                five = mapper.readValue(stringData, new TypeReference<List<fiveYears>>() { });

            }
            in.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return five;
    }


    static class TableFiveYears extends DefaultTableModel {

        public static final String[] columnNames = {"Date", "Open", "High", "Low", "Close", "Volume", "Unadjusted Volume", "Change", "Change Percent", "VWAP", "Change Over Time"  };

        public TableFiveYears() {
            super(columnNames, 0);
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            if (getRowCount() > 0 && getValueAt(0, columnIndex) != null) {
                return getValueAt(0, columnIndex).getClass();
            }
            return super.getColumnClass(columnIndex);
        }


        public void addRow(fiveYears five) {
            if (five == null) {
                throw new IllegalArgumentException("Rows cannot be null");
            }
            Vector<Object> rowVector = new Vector<>();
            rowVector.add(five.getDate());
            rowVector.add(five.getOpen());
            rowVector.add(five.getHigh());
            rowVector.add(five.getLow());
            rowVector.add(five.getClose());
            rowVector.add(five.getVolume());
            rowVector.add(five.getUnadjustedVolume());
            rowVector.add(five.getChange());
            rowVector.add(five.getChangePercent());
            rowVector.add(five.getVwap());
            rowVector.add(five.getChangeOverTime());


            super.addRow(rowVector);
        }


    }

    public static void main(String[] args) {
        new fiveYearsTable();
    }





}
