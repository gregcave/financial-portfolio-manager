public class UserTotal {

    private String date;
    private float cashMoney;
    private float stockMoney;
    private String hour;

    public UserTotal(String date, float cashMoney, float stockMoney, String hour){
        this.date = date;
        this.cashMoney = cashMoney;
        this.stockMoney = stockMoney;
        this.hour = hour;
    }

    public String getDate(){
        return date;
    }
    public float getCashMoney(){
        return cashMoney;
    }
    public float getStockMoney() { return stockMoney; }
    public String getHour() { return hour; }

}
