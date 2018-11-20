package pl.currenda.service;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pl.currenda.model.Currency;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

public class CurrencyService {
    private String url;

    public CurrencyService(String url) {
        this.url = url;
    }

    public Set<Currency> getCurrencyDataFromDate(String code, String startDate, String endDate) throws JSONException {
        Set<Currency> setOfCurrencies = new HashSet<>();
        JSONArray currencyJsonArray = new JSONArray();

        String requestUrl = url + "/" + code + "/" + startDate + "/" + endDate + "?format=json";

        JSONObject json = null;
        try {
            json = new JSONObject(IOUtils.toString(new URL(requestUrl), Charset.forName("UTF-8")));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            currencyJsonArray = json.getJSONArray("rates");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < currencyJsonArray.length(); i++){
            Currency currency = new Currency();
            currency.setCode(code);
            currency.setDate(currencyJsonArray.getJSONObject(i).getString("effectiveDate"));
            currency.setAsk(currencyJsonArray.getJSONObject(i).getDouble("ask"));
            currency.setBid(currencyJsonArray.getJSONObject(i).getDouble("bid"));
            setOfCurrencies.add(currency);
        }
        return setOfCurrencies;
    }
}
