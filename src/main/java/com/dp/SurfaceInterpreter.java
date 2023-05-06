package com.dp;

import java.util.List;

import static java.lang.String.valueOf;

public class SurfaceInterpreter implements Interpreter {
    protected Integer surface ;
    protected String searchQuery;
    public SurfaceInterpreter(){

    }
    public SurfaceInterpreter(Integer surface) {

        this.surface = surface;
    }

    public SurfaceInterpreter(String searchQuery) {
        this.searchQuery=searchQuery;
    }

    @Override
    public String toString() {
        return ""+surface ;
    }
    public String interpret() {
        List<String> query = List.of(searchQuery.split("\\s+"));
        for (int i = 0; i < query.size()-1; i++) {
            System.out.println("hana dkhalt l dik la boucle int i");
            if(query.get(i).equalsIgnoreCase("surface")) {
                System.out.println("hnaaa l9it le mot surface f my request");
                surface = Integer.valueOf(query.get(i+2));
                break;

            }
        }
        if (surface != null) {
            System.out.println("surface trouvée: " + surface);
            return "surface="+surface.toString();
        } else {
            System.out.println("surface non trouvée.");
        }
        return null;

    }
}

