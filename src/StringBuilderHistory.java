import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StringBuilderHistory {

    public static String test(String username){
        //List<String> interviewTimingToFrom1 = Arrays.asList(interviewTime1.split(","));
        //List<String> interviewTimingToFrom2 = Arrays.asList(interviewTime2.split(","));
        //List<String> listOfinterviewerName = Arrays.asList(intervierwName.split(","));

        User user = User.getUser(username);
        StringBuilder buf = new StringBuilder();
        buf.append("<html>");

            String path = "src\\resources\\individual\\"+user.getUsername() + "_history" + ".txt";
            String line = "";

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                while ((line = br.readLine()) != null) {
                    buf.append(line);
                    buf.append("<br/>");
                }
                buf.append("</html>");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        String html = buf.toString();
        return html;
    }
}
