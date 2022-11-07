import java.util.ArrayList;
import java.util.List;

public class CurrencyDataCollection {
    List <Currency> currencies;

    public CurrencyDataCollection(){
        this.currencies = new ArrayList<>();
    }


    public List<Currency> getCurrencyList(){
        return currencies;
    }


    public String ToString(){
        StringBuilder AllCurrenciesDataString = new StringBuilder();
        for(Currency Single: currencies){
            AllCurrenciesDataString.append(Single.getName() + "\t");
            AllCurrenciesDataString.append(Single.getCode() + "\t");
            AllCurrenciesDataString.append(Single.getFactor() + "\t");
            AllCurrenciesDataString.append(Single.getRate() + "\n");
        }
        return AllCurrenciesDataString.toString();
    }

    public Currency getCurrencyByCode(Currency currency){
        Currency NeededCurrency = new Currency();
        for(Currency SingleCurrency : currencies)
            if(SingleCurrency.getCode().equals(currency.getCode()))
                NeededCurrency = SingleCurrency;
        return NeededCurrency;
    }
}
