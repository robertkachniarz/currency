package pl.currenda.controller;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.currenda.model.DataForm;
import pl.currenda.repository.CurrencyRepository;
import pl.currenda.service.CurrencyService;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class CurrencyController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView currencyDataForm(ModelAndView modelAndView, DataForm dataForm){
        modelAndView.addObject("dataForm", dataForm);
        modelAndView.setViewName("currency/form");
        return modelAndView;
    }

    @RequestMapping(value = "/currency/form", method = RequestMethod.POST)
    public ModelAndView currencyOutputData(ModelAndView modelAndView, @Valid DataForm dataForm){
        String url = "http://api.nbp.pl/api/exchangerates/rates/c/";
        CurrencyService service = new CurrencyService(url);

        try {
            CurrencyRepository repository = service.getCurrencyDataFromDate(dataForm.getCode(), dataForm.getStartDate(), dataForm.getEndDate());
            modelAndView.addObject("averageBid", repository.averageBid());
            modelAndView.addObject("standardDeviation", repository.standardDeviationAsk());

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        modelAndView.setViewName("currency/form");
        return modelAndView;
    }
}
