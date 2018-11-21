package pl.currenda.repository;

import pl.currenda.model.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CurrencyRepository {
    private List<Currency> currencyList = new ArrayList<>();

    public CurrencyRepository() {
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public void save(Currency currency){
        currencyList.add(currency);
    }

    public BigDecimal averageBid(){
        double average = 0;
        double sum = 0;
        for (Currency currency:currencyList){
            sum = sum + currency.getBid();
        }
        average = sum / currencyList.size();
        return new BigDecimal(average).setScale(4, RoundingMode.HALF_UP);
    }
    public BigDecimal averageAsk(){
        double average = 0;
        double sum = 0;
        for (Currency currency:currencyList){
            sum = sum + currency.getAsk();
        }
        average = sum / currencyList.size();
        return new BigDecimal(average).setScale(4, RoundingMode.HALF_UP);
    }

    public BigDecimal standardDeviationAsk(){
        BigDecimal standardDeviation = new BigDecimal("0");
        BigDecimal average = this.averageAsk();
        BigDecimal sum = new BigDecimal("0");
        for (Currency currency:currencyList){
            BigDecimal subtract = new BigDecimal(currency.getAsk()).subtract(average);
            BigDecimal power = new BigDecimal(String.valueOf(subtract)).pow(2);
            sum = new BigDecimal(String.valueOf(sum)).add(power);
        }
        BigDecimal divide = new BigDecimal(String.valueOf(sum)).divide(BigDecimal.valueOf(currencyList.size()));
        standardDeviation = new BigDecimal(String.valueOf(Math.sqrt(Double.valueOf(String.valueOf(divide)))));

        return standardDeviation.setScale(4, RoundingMode.HALF_UP);
    }
}
