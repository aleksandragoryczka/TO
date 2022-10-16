import java.util.Scanner;

public class StandardView{
    Exchange ex;
    CurrencyDataCollection collectedData;

    public void setExchange(Exchange exchange) { //Ustawia referencję do obiektu typu implementującego IExchange
        this.ex = exchange;
    }


    public void setDataCollection(CurrencyDataCollection collection){
        this.collectedData = collection;
    }


    public void ViewAll(CurrencyDataCollection coll){
        System.out.println(coll.ToString());
    }


    public Currency StringToCurrency(String code){
        Currency SearchedCurrency = new Currency();
        SearchedCurrency.setCode(code);
        return collectedData.getCurrencyByCode(SearchedCurrency);
    }


    public Currency ChooseCurrency(String label){
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj kod waluty, "+label);
        String code = in.nextLine();
        return StringToCurrency(code);
    }


    public void exchange(){
        Currency BeforeExchange = ChooseCurrency("ktora posiadasz");
        System.out.println("Ile jej posiadasz?");
        Scanner in = new Scanner(System.in);
        String MoneyStr = in.nextLine();
        double Money = Double.parseDouble(MoneyStr);
        Currency AfterExchange = ChooseCurrency("ktora kupujesz");
        double Result = this.ex.exchange(BeforeExchange,AfterExchange,Money);
        System.out.println("Orzymujesz " + Result + " " + AfterExchange.getName());
    }

    public void menu(){
        System.out.println("Co chcesz zrobic?\n 0 - Skoncz\n 1 - Wymien walute\n 2 - Wyswietl kursy\n");
        Scanner in = new Scanner(System.in);
        int i_int = in.nextInt();
        if (i_int == 2)
        {
            ViewAll(collectedData);
            System.out.println("Co chcesz zrobic?\n 0 - Skoncz\n 1 - Wymien walute\n");
            i_int = in.nextInt();
            if (i_int == 1) {
                exchange();
            }
            else if(i_int==0)
                System.out.println("KONIEC");
            else {
                System.out.println("Nie udalo sie. Podales zla cyfre.");
            }
        }
        else if(i_int==1){
            exchange();
        }
        else if(i_int==0)
            System.out.println("KONIEC");
        else {
            System.out.println("Nie udalo sie. Podales zla cyfre.");
        }
    }
}
