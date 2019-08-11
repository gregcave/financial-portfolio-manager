import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class User {

    private String username;
    private String password;
    private ArrayList<Stock> stocksOwned = new ArrayList<Stock>();
    private ArrayList<UserTotal> userTotals = new ArrayList<UserTotal>();
    private float money;
    public static String logged_in_user;
    public static String logged_in_password;
    public static String selectedDate;

    public User(String username, String password, float money){

        this.username=username;
        this.password=password;
        this.money=money;

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////NORMAL METHODS/////////////////////////////////////////////////////////////////

    public String toString(){
        setStocksOwned();
        String userInfo = "Stock count and balance of user " + username.toUpperCase() + ":\n\n";
        for (Stock stock: stocksOwned) {
            userInfo = userInfo
                    + stock.getName() + " "
                    + "(" + stock.getSymbol()
                    + "): "
                    + stock.getAmount() + " "
                    + "(CP:"+Stock.realPrice(stock.getSymbol())+")"
                    + "\n";
        }
        userInfo = userInfo
                + "\n";
        userInfo = userInfo
                + "Balance: \u00a3"
                + money
                + "\n";
        return userInfo;
    }



    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setStocksOwned() {

        String path = "src\\resources\\individual\\"+this.username.toLowerCase() + ".txt";
        String line = "";
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimiter);
                stocksOwned.add(new Stock(fields[0], fields[1], Integer.parseInt(fields[2])));
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUserTotals() {

        String path = "src\\resources\\individual\\"+this.username.toLowerCase() + "_total" + ".txt";
        String line = "";
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimiter);
                userTotals.add(new UserTotal(fields[0], Float.parseFloat(fields[1]), Float.parseFloat(fields[2]), fields[3]));
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



    public ArrayList<Stock> getStocksOwned() { return stocksOwned; }

    public ArrayList<UserTotal> getUserTotals() { return userTotals; }

    public float getMoney(){
        return money;
    }

    public void addMoney(float amount) { this.money += amount;}
    public void removeMoney(float amount) { this.money -= amount;}

    public void depositMoney(float amount) {

        ArrayList<User> users = User.getAllUsers();
        int numberOfUsers= users.size();
        for (User user:users) {
            if(user.getUsername().equals(User.logged_in_user)){
                user.addMoney(amount);
            }
        }
        try {
            String file = "src\\resources\\UserInfo.txt";
            Writer buf;
            buf = new BufferedWriter(new FileWriter(file, false));  //clears file every time
            PrintWriter output = new PrintWriter(buf);
           /* for (int i = 0; i < numberOfUsers-1; i++) {
                output.append(users.get(i).getUsername()+","+users.get(i).getPassword()+","+users.get(i).getMoney());
                output.append("\n");
            }
            int i = numberOfUsers-1;
            output.append(users.get(i).getUsername()+","+users.get(i).getPassword()+","+users.get(i).getMoney());  */
            for (User user:users) {
                output.println(user.getUsername()+","+user.getPassword()+","+user.getMoney());
            }
            output.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void withdrawMoney(float amount) {

        ArrayList<User> users = User.getAllUsers();
        int numberOfUsers= users.size();
        for (User user:users) {
            if(user.getUsername().equals(User.logged_in_user)){
                user.removeMoney(amount);
            }
        }
        try {
            String file = "src\\resources\\UserInfo.txt";
            Writer buf;
            buf = new BufferedWriter(new FileWriter(file, false));  //clears file every time
            PrintWriter output = new PrintWriter(buf);
         /*   for (int i = 0; i < numberOfUsers-1; i++) {
                output.append(users.get(i).getUsername()+","+users.get(i).getPassword()+","+users.get(i).getMoney());
                output.append("\n");
            }
            int i = numberOfUsers-1;
            output.append(users.get(i).getUsername()+","+users.get(i).getPassword()+","+users.get(i).getMoney());  */
            for (User user:users) {
                output.println(user.getUsername()+","+user.getPassword()+","+user.getMoney());
            }
            output.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }



    public void createStockFile(String user)
    {
        try {
            String path = "src\\resources\\individual\\"+user.toLowerCase() + ".txt";
            File file = new File(path);
            file.createNewFile(); // if file already exists will do nothing
            //FileOutputStream oFile = new FileOutputStream(file, false);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void createHistoryFile(String user)
    {
        try {
            String path = "src\\resources\\individual\\"+user.toLowerCase() + "_history" + ".txt";
            File file = new File(path);
            file.createNewFile(); // if file already exists will do nothing
            //FileOutputStream oFile = new FileOutputStream(file, false);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void createTotalFile(String user)
    {
        try {
            String path = "src\\resources\\individual\\"+user.toLowerCase() + "_total" + ".txt";
            File file = new File(path);
            file.createNewFile(); // if file already exists will do nothing
            //FileOutputStream oFile = new FileOutputStream(file, false);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////STATIC METHODS////////////////////////////////////////////////////////////

  /*  public static void createAllStockFiles() {
        String FILE = "src\\resources\\UserInfo.txt";
        String line = "";
        String separator = ",";
        ArrayList<User> users = new ArrayList<User>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(separator);
                users.add(new User(fields[0], fields[1], Integer.parseInt(fields[2])));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        for (User user: users) {
            user.createStockFile(user.getUsername());
            System.out.println(user.toString());
        }

    }             */

    public static void addUserStock(String user, String symbol){

        try {
            String file = "src\\resources\\individual\\"+user.toLowerCase() + ".txt";
            Writer buf;
            buf = new BufferedWriter(new FileWriter(file, true));  //clears file every time
            PrintWriter output = new PrintWriter(buf);
            List<Symbol> symbols = Stock.getAllSymbols();
            for (Symbol symbolTemp:symbols) {
                if(symbolTemp.getSymbol().equals(symbol)){
                    output.println(symbolTemp.getName()+","+symbolTemp.getSymbol()+","+"0");
                    output.close();
                }
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void addUserHistory(String user, String history){

        try {
            String file = "src\\resources\\individual\\"+user.toLowerCase() + "_history" + ".txt";
            Writer buf;
            buf = new BufferedWriter(new FileWriter(file, true));  //clears file every time
            PrintWriter output = new PrintWriter(buf);
            output.println(history);
            output.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void addUserTotal(String user, UserTotal userTotal){

        try {
            String file = "src\\resources\\individual\\"+user.toLowerCase() + "_total" + ".txt";
            Writer buf;
            buf = new BufferedWriter(new FileWriter(file, true));  //clears file every time
            PrintWriter output = new PrintWriter(buf);
            output.println(userTotal.getDate() + "," + userTotal.getCashMoney() + "," +userTotal.getStockMoney() + "," +userTotal.getHour());
            output.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String username) {


        String FILE = "src\\resources\\UserInfo.txt";
        String line = "";
        String separator = ",";
        ArrayList<User> users = new ArrayList<User>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(separator);
                users.add(new User(fields[0], fields[1], Float.parseFloat(fields[2])));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        for (User user: users) {
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public static String getDate(){
        Date today = new Date();
        String todayString = today.toString();
        String[] todayArray = todayString.split(" ");
        return todayArray[2] + "-" + todayArray[1] + "-" + todayArray[5] + " " + todayArray[3] + " " + todayArray[4];
    }

    public static String getDateTotal(){
        Date today = new Date();
        String todayString = today.toString();
        String[] todayArray = todayString.split(" ");
        return todayArray[2] + "-" + todayArray[1] + "-" + todayArray[5];
    }

    public static String getHourTotal(){
        Date today = new Date();
        String todayString = today.toString();
        String[] todayArray = todayString.split(" ");
        return todayArray[3] + " " + todayArray[4];
    }

    public static ArrayList<User> getAllUsers() {
        String FILE = "src\\resources\\UserInfo.txt";
        String line = "";
        String separator = ",";
        ArrayList<User> users = new ArrayList<User>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(separator);
                users.add(new User(fields[0], fields[1], Float.parseFloat(fields[2])));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return users;

    }

    public static void createUser(String username, String password){

        try {
            String file = "src\\resources\\UserInfo.txt";
            Writer buf;
            buf = new BufferedWriter(new FileWriter(file, true));  //clears file every time
            PrintWriter output = new PrintWriter(buf);
            output.println(username+","+password+","+"0");
            output.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }


    }

    public static boolean userExists(String username){

        String FILE = "src\\resources\\UserInfo.txt";
        String line = "";
        String separator = ",";
        boolean exists = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(separator);
                if(username.toLowerCase().equals(fields[0].toLowerCase())) {
                    exists=true;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public static boolean validDetails(String username, String password){

        String FILE = "src\\resources\\UserInfo.txt";
        String line = "";
        String separator = ",";
        boolean exists = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(separator);
                if(username.toLowerCase().equals(fields[0].toLowerCase()) && password.toLowerCase().equals(fields[1].toLowerCase())) {
                    exists=true;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return exists;
    }


    public static void main(String[] args) {
        System.out.println(User.getDate());
        System.out.println(User.getDateTotal());
        System.out.println(User.getHourTotal());
    }



}

/*


    public String toString(){
        String userInfo =
                "Stock count and balance of user " + username.toUpperCase() + ":\n\n"
                        + "Amazon: "          + amazon    + "\n"
                        + "Apple: "           + apple     + "\n"
                        + "Intel: "           + intel     + "\n"
                        + "Microsoft: "       + microsoft + "\n"
                        + "Netflix: "         + netflix   + "\n\n"
                        + "Balance: \u00a3"   + money     + "\n";

        return userInfo;
    }

    */
