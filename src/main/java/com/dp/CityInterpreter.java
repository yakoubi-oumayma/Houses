package com.dp;

import java.util.List;

import static java.lang.String.valueOf;

public class CityInterpreter implements Interpreter {

    protected String city ;
    protected String searchQuery;

    public CityInterpreter(String searchQuery){
        this.searchQuery=searchQuery;
    }



    @Override
    public String interpret() {
        List<String> query = List.of(searchQuery.split("\\s+"));
        for (int i = 0; i < query.size()-1; i++) {
            if(query.get(i).equalsIgnoreCase("ville")) {
                city = valueOf(query.get(i+2));
                break;

            }
        }
        if (city != null) {
            System.out.println("city trouvée: " + city);
            return "ville = '"+city+"'";
        } else {
            System.out.println("city non trouvée.");
        }
        return null;

    }
}
