package com.example.ticketer.module;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class mapper {

    private static Map<String, String> map;
    public static Map<String,String> stringmapper(String jsonstring){
        ObjectMapper mapper = new ObjectMapper();
        try {
            //Map<String, String> map = mapper.readValue(json, Map.class);
            map = mapper.readValue(jsonstring, new TypeReference<Map<String, String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
