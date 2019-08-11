

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler; //used a 3rd party library called 'xchart' to provide to me a more customizable and modern chart


import javax.swing.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.Float.parseFloat;


class BarChartStocks<T> {
    public T getChart() {
        return null;
    }

}

class StockChart extends BarChartStocks<CategoryChart> {

    private static JFrame frame = new JFrame();
    private CategoryChart chart;
    private JPanel panel;

    public static void main(String[] args) { //main method

        BarChartStocks<CategoryChart> Stocks = new StockChart();
        CategoryChart chart = Stocks.getChart();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);




    }

    public CategoryChart getChart() {


        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());



        User user = User.getUser(User.logged_in_user);
        user.setStocksOwned();
        ArrayList<Stock> stocks = user.getStocksOwned();





        chart = new CategoryChartBuilder().width(1000).height(800).xAxisTitle("").yAxisTitle("Stock Price").build();
        List<String> dates = Arrays.asList(date); //fixed date values

        chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideE); //setting the location where the Legend will be
        chart.getStyler().setHasAnnotations(true);
        chart.setTitle("Your personalized Bar Chart of your Stocks");


        for (Stock stock: stocks) {
            double price = parseFloat(Stock.realPrice(stock.getSymbol()));
            DecimalFormat f = new DecimalFormat("##.00");

            double finalPrice = Double.parseDouble(f.format(price));
            chart.addSeries(stock.getName(), dates, Arrays.asList(finalPrice));



        }












        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                SwingWrapper<CategoryChart> frame = new SwingWrapper<CategoryChart>(chart);

                frame.displayChart().setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);




            }

        });
        t.start();


        return chart;
    }


}

