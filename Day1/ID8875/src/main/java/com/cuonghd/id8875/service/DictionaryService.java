package com.cuonghd.id8875.service;

import java.util.HashMap;
import java.util.Map;

public class DictionaryService {
    Map<String, String> dictionary;

    public DictionaryService() {
        dictionary = new HashMap<>();
        dictionary.put("Apple", "Tao");
        dictionary.put("Orange", "Cam");
        dictionary.put("Banana", "Chuoi");
        dictionary.put("Melon", "Dua");
    }
    public String changeEnglishToVietNam(String english) {
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (entry.getKey().equals(english)) return entry.getValue();
        }
        return null;
    }
}
