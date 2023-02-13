package org.example.model;

import java.util.List;

public class Mapper {

    public String map(List<String> result){
        StringBuilder resultToString = new StringBuilder();
        for (String element : result){
            resultToString.append("<");
            resultToString.append(element);
            resultToString.append(">");
        }
        System.out.println(resultToString);
        return resultToString.toString();
    }
}
