
public class Exchange {
    //Oblicza otrzymaną ilość środka pieniężnego po podaniu wartości źródłowej, waluty źródłowej oraz waluty docelowej
    public double exchange(Currency src, Currency tgt, double amt) {
        double exchanged = (amt*src.getRate()/src.getFactor())/(tgt.getRate()/tgt.getFactor());
        return exchanged;
    }
}
