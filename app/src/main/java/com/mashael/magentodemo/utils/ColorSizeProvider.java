package com.mashael.magentodemo.utils;

import java.util.HashMap;

public final class ColorSizeProvider {
    public static final HashMap<String, String> COLOR_HASHMAP
            = new HashMap<String, String>() {
        {
            put("49", "Black");
            put("50", "Blue");
            put("51", "Brown");
            put("52", "Gray");
            put("53", "Green");
            put("54", "Lavender");
            put("55", "Multi");
            put("56", "Orange");
            put("57", "Purple");
            put("58", "Red");
            put("59", "White");
            put("60", "Yellow");
        }
    };

    public static final HashMap<String, String> SIZE_HASH_MAP
            = new HashMap<String, String>() {
        {
            put("91", "55 cm");
            put("92", "65 cm");
            put("93", "75 cm");
            put("94", "6 foot");
            put("95", "8 foot");
            put("96", "10 foot");
            put("167", "XS");
            put("168", "S");
            put("169", "M");
            put("170", "L");
            put("171", "XL");
            put("172", "28");
            put("173", "29");
            put("174", "30");
            put("175", "31");
            put("176", "32");
            put("177", "33");
            put("178", "34");
            put("179", "36");
            put("180", "38");
        }
    };
}
