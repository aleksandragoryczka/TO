public class Currency {
    private final String currencyName;
    private final String conversionFactor;
    private final String currencyCode;
    private final String averageRate;

    public Currency(String currencyName, String conversionFactor, String currencyCode, String averageRate){
        this.currencyName=currencyName;
        this.conversionFactor=conversionFactor;
        this.currencyCode=currencyCode;
        this.averageRate=averageRate.replaceAll(",",".");

    }

}
