import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {

    private String name;
    private String symbol;
    private int amount;



    public Stock(String name,String symbol, int amount){
        this.name=name;
        this.symbol=symbol;
        this.amount=amount;
    }

    public String getName(){
        return name;
    }
    public String getSymbol(){
        return symbol;
    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount) { this.amount = amount; }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////STATIC METHODS//////////////////////////////////////////////////////////////


    public static String realPrice(String symbol){
        try {
            URL oracle = new URL("https://api.iextrading.com/1.0/stock/"+symbol+"/price");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                return inputLine;
            in.close();

        }
        catch(Exception e){
            System.out.println("ERROR");
        }
        return "ERROR";
    }

    public static List<Symbol> getAllSymbols(){

        List<Symbol> symbols = new ArrayList<Symbol>();


        try
        {

            URL url = new URL("https://api.iextrading.com/1.0/ref-data/symbols");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            String stringData="";
            while ((inputLine = in.readLine()) != null)
                stringData=stringData+inputLine;
            in.close();
            ObjectMapper mapper = new ObjectMapper();
            symbols = mapper.readValue(stringData, new TypeReference<List<Symbol>>(){});

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return symbols;
    }

    public static List<Dividends> getDividends(){

        List<Dividends> dividends = new ArrayList<Dividends>();


        try
        {

            URL url = new URL("https://api.iextrading.com/1.0/stock/aapl/dividends/1y");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            String stringData="";
            while ((inputLine = in.readLine()) != null)
                stringData=stringData+inputLine;
            in.close();
            ObjectMapper mapper = new ObjectMapper();
            dividends = mapper.readValue(stringData, new TypeReference<List<Dividends>>(){});

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return dividends;
    }

    public static void main(String[] args) {

        List<Dividends> dividends = new ArrayList<Dividends>();
        dividends = getDividends();
        for (Dividends dividend: dividends) {

            System.out.print(dividend.getExDate()+"\n");
            System.out.print(dividend.getDeclaredDate()+"\n");
            System.out.print(dividend.getQualified()+"\n");
            System.out.print(dividend.getPaymentDate()+"\n");
            System.out.print(dividend.getType()+"\n");
            System.out.print(dividend.getAmount()+"\n");
            System.out.print(dividend.getRecordDate()+"\n\n\n");
           // System.out.print(dividend.getFlag()+"\n");
           // System.out.print(dividend.getIndicated()+"\n");

        }
    }

}



