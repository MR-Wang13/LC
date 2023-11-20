package intern;

import java.util.ArrayList;
import java.util.List;

class Dividend{

    Integer amount;
    Integer days;

    Dividend(Integer amount , Integer days){
        this.amount = amount;
        this.days = days;
    }

}
public class FuturePricing {
    private Integer price;

    private Integer dividendCounts;

    private Integer operateCounts;

    private List<Dividend> dividends;
    private

    FuturePricing(Integer price, Integer dividendCounts, Integer operateCounts, List<Dividend> dividends){
        this.price = price;
        this.dividendCounts = dividendCounts;
        this.operateCounts = operateCounts;
        this.dividends = dividends;
    }

    public void dividendUpdate(int i,Integer amount,Integer days){
        Dividend newDividend = new Dividend(amount,days);
        dividends.set(i-1,newDividend);
    }

    public void price(Integer day){
        int amount = 0;
        for (Dividend dividend : dividends){
            if ( day>dividend.days){
                amount+=dividend.amount;
            }else {
                break;
            }
        }
        System.out.println(price-amount);

    }


    public static void main(String[] args) {
        List<Dividend> dividends = new ArrayList<>();
        Dividend dividend1= new Dividend(100,10);
        Dividend dividend2= new Dividend(50,100);
        dividends.add(dividend1);
        dividends.add(dividend2);
        FuturePricing futurePricing = new FuturePricing(1000,2,4,dividends);

        futurePricing.price(15);
        futurePricing.dividendUpdate(2,40,20);
        futurePricing.price(15);
        futurePricing.price(25);

    }
}
