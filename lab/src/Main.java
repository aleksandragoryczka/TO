

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class Main {

    static RemoteDataProvider provider;
    static CurrencyDataCollection LastA;
    static XMLCurrencyCollectionProvider xmlProvider;
    static Exchange exchange;
    static StandardView view;
    public static void main(String[] args) {
        provider = new RemoteDataProvider();
        xmlProvider = new XMLCurrencyCollectionProvider();

        LastA = new CurrencyDataCollection();
        exchange = new Exchange();
        view = new StandardView();

        try {
            String result = provider.acquireRemoteData("https://www.nbp.pl/kursy/xml/Lasta.xml");
            xmlProvider.provide(result,LastA);

            view.setDataCollection(LastA);
            view.setExchange(exchange);
            view.menu();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}
