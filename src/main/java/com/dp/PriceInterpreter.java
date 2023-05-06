package com.dp;

import java.sql.SQLException;
import java.util.List;

public class PriceInterpreter implements Interpreter{
    protected Integer price ;
    protected String searchQuery;

    public PriceInterpreter(String searchQuery){
        this.searchQuery=searchQuery;
    }
    public PriceInterpreter(Integer price) {
        this.price = price;
    }

    public PriceInterpreter() {

    }


    @Override
    public String toString() {
        return ""+price ;
    }
    @Override
    public String interpret() {
        List<String> query = List.of(searchQuery.split("\\s+"));
        for (int i = 0; i < query.size()-1; i++) {
            if(query.get(i).equalsIgnoreCase("prix")) {
                price = Integer.valueOf(query.get(i+2));
                break;

            }
        }
        if (price != null) {
            System.out.println("price trouvée: " + price);
            return "prix="+ price.toString();
        } else {
            System.out.println("price non trouvée.");
        }
        return null;

    }
}
