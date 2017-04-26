package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Кэш первого и второго уровня
 * Created by Андрей on 23.04.2017.
 */
public class Cache {
    private String[][] CacheFirstLevel;
    private int capacityF; //количество занятых ячеек
    Map CacheSecondLevelMap;

    public Cache() {
        CacheSecondLevelMap = new HashMap<String, Integer>();
        CacheFirstLevel = new String[10][2];
        capacityF = 0;
        for (int i = 0; i < 10; i++) {
            CacheFirstLevel[i][0] = "";
            CacheFirstLevel[i][1] = "";
        }
    }

    void push(String element, String answer) {
        if (capacityF < 10) {
            CacheFirstLevel[capacityF][0] = element;
            CacheFirstLevel[capacityF][1] = answer;
            capacityF++;
            //System.out.println("Write F");
        } else {
            CacheSecondLevelMap.put(CacheFirstLevel[0][0],CacheFirstLevel[0][1]);
            for (int i = 0; i < 10; i++) {
                CacheFirstLevel[i][0] = CacheFirstLevel[i+1][0];
                CacheFirstLevel[i][1] = CacheFirstLevel[i+1][1];
            }
            //System.out.println("Write S");
        }
    }

    Integer pop(String element) {
        Integer result = null;
        for (int i = 0; i < 10; i++) {
            //System.out.println(CacheFirstLevel[i][0]);
            if (CacheFirstLevel[i][0].equals(element)) {
                result = Integer.valueOf(CacheFirstLevel[i][1]);
                //System.out.println("ReadF");
            }
        }
        if (result == null) {
            result = (Integer) CacheSecondLevelMap.get(element);
        }
        return result;
    }

    int getCapacityF() {
        return capacityF;
    }

}
