package pl.name;

public class Name implements IName{
    private final String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
