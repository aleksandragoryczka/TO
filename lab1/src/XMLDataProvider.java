import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class XMLDataProvider {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final String urlAddress;

    public XMLDataProvider(String urlAddress){
        this.urlAddress=urlAddress;
    }

    public Document readContent() throws IOException, InterruptedException, ParserConfigurationException, SAXException {
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(urlAddress)).GET().build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String xmlContent = httpResponse.body();

        DocumentBuilder db = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
        InputSource inputSrc = new InputSource();
        inputSrc.setCharacterStream(new StringReader(xmlContent));

        return db.parse(inputSrc);
    }


}
