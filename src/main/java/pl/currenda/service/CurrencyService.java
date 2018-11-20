package pl.currenda.service;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pl.currenda.model.Currency;
import pl.currenda.repository.CurrencyRepository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CurrencyService {
    private String url;

    public CurrencyService(String url) {
        this.url = url;
    }

    public CurrencyRepository getCurrencyDataFromDate(String code, String startDate, String endDate) throws JSONException, IOException {
        CurrencyRepository currencyRepository = new CurrencyRepository();
        JSONArray currencyJsonArray;

        String requestUrl = url + "/" + code + "/" + startDate + "/" + endDate + "?format=json";

        JSONObject json;

        json = new JSONObject(IOUtils.toString(new URL(requestUrl), Charset.forName("UTF-8")));
        currencyJsonArray = json.getJSONArray("rates");

        for (int i = 0; i < currencyJsonArray.length(); i++){
            Currency currency = new Currency();
            currency.setCode(code);
            currency.setDate(currencyJsonArray.getJSONObject(i).getString("effectiveDate"));
            currency.setAsk(currencyJsonArray.getJSONObject(i).getDouble("ask"));
            currency.setBid(currencyJsonArray.getJSONObject(i).getDouble("bid"));
            currencyRepository.save(currency);
        }
        return currencyRepository;
    }
}
