package com.jonasriedel;

import libs.org.json.JSONException;
import libs.org.json.JSONObject;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Translation {

    private HashMap<String, JSONObject> translations = new HashMap<>();

    public boolean loadConfig(String path) {
        try {
            InputStream input = getClass().getResourceAsStream(path);
            Scanner sc = new Scanner(input);
            StringBuilder fileContent = new StringBuilder();
            if (sc.hasNextLine()) {
                fileContent.append(sc.nextLine());
            }

            while (sc.hasNextLine()) {
                fileContent.append("\n").append(sc.nextLine());
            }

            try {
                JSONObject dict = new JSONObject(fileContent.toString());
                translations.put(dict.get("language").toString(), dict.getJSONObject("translations"));
            } catch (JSONException ex) {
                System.err.println("Provided file is in wrong format");
                return false;
            }
        } catch (NullPointerException e) {
            System.err.println("Provided file could not be found");
            return false;
        }
        return true;
    }

    public String getValue(String key, String language) {
        try {
            String[] path = key.split("\\."); 

            JSONObject v = translations.get(language);

            for (int i = 0; i < path.length - 1; i++) {
                v = v.getJSONObject(path[i]);
            }

            return v.get(path[path.length - 1]).toString();
        } catch (JSONException | NullPointerException e) {
            return "";
        }
    }
}
