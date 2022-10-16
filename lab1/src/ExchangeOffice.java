import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExchangeOffice {

    Map<String, Currency> currencyMap = Collections.emptyMap();

    public ExchangeOffice() throws IOException, ParserConfigurationException, InterruptedException, SAXException {
        this.currencyMap = getContent();
    }

    Map<String, Currency> getContent() throws IOException, ParserConfigurationException, InterruptedException, SAXException {
        String urlAddress = "https://www.nbp.pl/kursy/xml/lasta.xml";
        XMLDataProvider xmlDataProvider = new XMLDataProvider(urlAddress);
        Document content = xmlDataProvider.readContent();

        Map <String, Currency> tmpMap = new HashMap<>();

        int length = content.getElementsByTagName("pozycja").getLength();

        for(int i=0; i<length; i++){
            String code = content.getElementsByTagName("kod_waluty").item(i).getTextContent();
            Currency currency = new Currency(content.getElementsByTagName("nazwa_waluty").item(i).getTextContent(),
                    content.getElementsByTagName("przelicznik").item(i).getTextContent(),code,
                    content.getElementsByTagName("kurs_sredni").item(i).getTextContent());
            tmpMap.put(code, currency);
        }
        tmpMap.put("PLN", new Currency("polski zloty", "1", "PLN", "1,0000"));
        return tmpMap;
    }

}
