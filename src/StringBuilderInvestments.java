import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StringBuilderInvestments {

    public static String test(String username, String date){
        //List<String> interviewTimingToFrom1 = Arrays.asList(interviewTime1.split(","));
        //List<String> interviewTimingToFrom2 = Arrays.asList(interviewTime2.split(","));
        //List<String> listOfinterviewerName = Arrays.asList(intervierwName.split(","));

        User user = User.getUser(username);
        user.setUserTotals();
        ArrayList<UserTotal> userTotals = user.getUserTotals();
        StringBuilder buf = new StringBuilder();
        buf.append("<html>");
        buf.append("Value of investments on date " + date + ":");
        buf.append("<br/>");
        buf.append("<br/>");

        for (UserTotal userTotal:userTotals) {

            if(userTotal.getDate().equals(date)){
                buf.append("Money amount: "+userTotal.getCashMoney()+", value of stocks: "+userTotal.getStockMoney()+" ("+userTotal.getHour()+")");
                buf.append("<br/>");
            }

        }


            buf.append("</html>");

        String html = buf.toString();
        return html;
    }
}
