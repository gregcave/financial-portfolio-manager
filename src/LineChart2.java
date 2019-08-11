import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.colors.ChartColor;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


import static java.lang.Float.parseFloat;

class LineChartNew<T> {
    public T getChart() {
        return null;
    }

}

public class LineChart2 extends LineChartNew<XYChart>  {


    public XYChart getChart () {

        User currentUser = User.getUser(User.logged_in_user);
        currentUser.setStocksOwned();
        ArrayList<Stock> currentUserStocksOwned = currentUser.getStocksOwned();
        JComboBox optionControl = new JComboBox();
        for (Stock stock: currentUserStocksOwned) {
            optionControl.addItem(stock.getSymbol());
        }
        optionControl.setSelectedIndex(0);
        JTextField amount = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Stock:"));
        myPanel.add(optionControl);


        JOptionPane.showMessageDialog(menu.panel_main, myPanel, "Select Stock to view",
                JOptionPane.PLAIN_MESSAGE);
        String selectedSymbol = (String)optionControl.getSelectedItem();


        XYChart chart = new XYChartBuilder().width(800).height(600).title("Price of selected stock over this week").xAxisTitle("Date").yAxisTitle("Price").build();


        chart.getStyler().setDatePattern("dd-MMM");
        chart.getStyler().setLocale(Locale.ENGLISH);



        DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;


        User user = User.getUser(User.logged_in_user);


        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String datenew = simpleDateFormat.format(new Date());

        List<String> dates = Arrays.asList(datenew); //fixed date values



        List<Date> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();

        for (Stock stock: currentUserStocksOwned) {
            if(stock.getSymbol().equals(selectedSymbol)) {

                List<Double> op = new ArrayList<>();


                try {
                    URL url = new URL("https://api.iextrading.com/1.0/stock/"+selectedSymbol+"/chart/1m?filter=open");

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(url.openStream()));
                    String inputLine;
                    String stringData ="";

                    while ((inputLine = in.readLine()) != null) {
                        stringData =stringData+inputLine;


                        final ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode rootNode = objectMapper.readValue(stringData, JsonNode.class);

                        for(int i =0; i<=rootNode.size()-1; i++) {

                            String fin = rootNode.get(i).toString();

                            fin = fin.replaceAll("[^0-9.]", "");



                            op.add(i, Double.valueOf(fin));
                        }



                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


                double price = parseFloat(Stock.realPrice(stock.getSymbol()));
                DecimalFormat f = new DecimalFormat("##.00");


                double finalPrice = Double.parseDouble(f.format(price));

                try {
                    xData.add(0, previous7());
                    xData.add(1, previous6());
                    xData.add(2, previous5());
                    xData.add(3, previous4());
                    xData.add(4, previous3());
                    xData.add(5, previous2());
                    xData.add(6, previous1());

                    yData.add(0, op.get(6));
                    yData.add(1, op.get(5));
                    yData.add(2, op.get(4));
                    yData.add(3, op.get(3));
                    yData.add(4, op.get(2));
                    yData.add(5, op.get(1));
                    yData.add(6, op.get(0));

                }catch (IndexOutOfBoundsException e){
                    JOptionPane.showMessageDialog(null, "Not enough information for "+stock.getName()+", cannot generate graph");
                }
                catch (IllegalArgumentException el){
                    System.out.println("Error");
                }

            }
        }

        for (Stock stock: currentUserStocksOwned){

            if(stock.getSymbol().equals(selectedSymbol)) {



                XYSeries series = chart.addSeries(stock.getName(), xData, yData);

            }
        }

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                SwingWrapper<XYChart> frame = new SwingWrapper<XYChart>(chart);

                frame.displayChart().setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);



            }

        });
        t.start();


        return chart;

    }
    private Date today() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        return cal.getTime();
    }

    private Date previous1() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    private Date previous2() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        return cal.getTime();
    }

    private Date previous3() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -3);
        return cal.getTime();
    }

    private Date previous4() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -4);
        return cal.getTime();
    }

    private Date previous5() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -5);
        return cal.getTime();
    }

    private Date previous6() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -6);
        return cal.getTime();
    }

    private Date previous7() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

}