package pl.currenda.service;

import org.json.JSONException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.currenda.model.Currency;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyServiceTest {

    @DisplayName("should return set of currencies from several days")
    @Test
    void getCurrencyDataFromDateTest() throws JSONException, IOException {
        // given
        Currency currency1 = new Currency("EUR", "2017-11-20", 4.1943, 4.2791);
        Currency currency2 = new Currency("EUR", "2017-11-21", 4.1903, 4.2749);

        // when
        CurrencyService currencyService = new CurrencyService("http://api.nbp.pl/api/exchangerates/rates/c/");
        List<Currency> currencySet = currencyService.getCurrencyDataFromDate("EUR", "2017-11-20", "2017-11-21").getCurrencyList();

        // then
        assertThat(currencySet).containsExactlyInAnyOrder(currency1, currency2);

    }
}