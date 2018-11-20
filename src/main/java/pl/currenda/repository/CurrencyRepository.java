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

    public double standardDeviationAsk(){
        double standardDeviation = 0;

        return standardDeviation;
    }
}
