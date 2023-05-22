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

    @Override
    public String interpret() {
        List<String> query = List.of(searchQuery.split("\\s+"));
        for (int i = 0; i < query.size()-1; i++) {

            if(query.get(i).equalsIgnoreCase("surface")) {
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

