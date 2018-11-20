package pl.currenda.repository;

import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.currenda.service.CurrencyService;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyRepositoryTest {

    @DisplayName("should compute average of bid prices")
    @Test
    public void averageTest() throws IOException, JSONException {
        // given
        CurrencyService currencyService = new CurrencyService("http://api.nbp.pl/api/exchangerates/rates/c/");
        CurrencyRepository currencyRepository = currencyService.getCurrencyDataFromDate("EUR", "2017-11-20", "2017-11-24");

        // when
        BigDecimal average = currencyRepository.averageBid();

        // then
        Assertions.assertThat(average).isEqualTo(new BigDecimal("4.1815"));

    }
    @DisplayName("should compute standard deviation of ask prices")
    @Test
    public void standardDeviationTest(){
        // given

        // when

        // then


    }

}