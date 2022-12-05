package com.name;

import java.util.HashMap;

public class NameFactory {
    private HashMap<String, IName> names;

    public NameFactory() {
        this.names = new HashMap<String, IName>();
    }

    public IName getName(String name){
        if(this.names.containsKey(name)){
            return names.get(name);
        }
        Name newName = new Name(name);
        names.put(name, newName);
        return newName;
    }



}
