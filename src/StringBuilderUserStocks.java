import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringBuilderUserStocks {

    public static String test(String username){
        //List<String> interviewTimingToFrom1 = Arrays.asList(interviewTime1.split(","));
        //List<String> interviewTimingToFrom2 = Arrays.asList(interviewTime2.split(","));
        //List<String> listOfinterviewerName = Arrays.asList(intervierwName.split(","));

        User user = User.getUser(username);
        user.setStocksOwned();
        ArrayList<Stock> stocksOwned = user.getStocksOwned();


        StringBuilder buf = new StringBuilder();
        buf.append("<html>" +
                "<body>" +
                "<table>" +
                "<tr>" +
                "<th><font color='white'>Company</font></th>" +
                "<th><font color='white'>Symbol</font></th>" +
                "<th><font color='white'>Amount</font></th>" +
                "<th><font color='white'>Price</font></th>" +
                "</tr>");
        for (int i = 0; i < stocksOwned.size(); i++) {
            buf.append("<tr><td>")
                    .append(stocksOwned.get(i).getName())
                    .append("</td><td><font color='white'>")
                    .append(stocksOwned.get(i).getSymbol())
                    .append("</font></td><td>")
                    .append(stocksOwned.get(i).getAmount())
                    .append("</td><td><font color='white'>")
                    .append(Stock.realPrice(stocksOwned.get(i).getSymbol()))
                    .append("</font></td></tr>");
        }
        buf.append("</table>" + "<br><br><br>" +
                "<p><font color='white'>Money: " + user.getMoney() + "</font></p>" +
                "</body>" +
                "</html>");
        String html = buf.toString();
        return html;
    }

}
