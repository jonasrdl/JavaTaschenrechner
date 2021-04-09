package com.jonasriedel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Translation {

    private HashMap<String, JSONObject> translations = new HashMap<>();

    public boolean loadConfig(String path) {

        try {
            File file = new File(path);
            if (!file.canRead()) {
                System.err.println("Provided file can't be read");
                return false;
            }
            Scanner sc = new Scanner(file);
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
        } catch (FileNotFoundException e) {
            System.err.println("Provided file could not be found");
            return false;
        }
        return true;
    }

    public String getValue(String key, String language) { // key = "unterpunkt1.key123";
        try {
            String[] path = key.split("\\."); // String[] path = ["unterpunkt1", "xyz", "key123"];

            JSONObject v = translations.get(language);

            for (int i = 0; i < path.length - 1; i++) {
                v = v.getJSONObject(path[i]);
            }

            return v.get(path[path.length - 1]).toString();
        } catch (JSONException | NullPointerException e) {
            return "";
        }
    }

    /* public void muelltest(String key) {
        System.out.println(translations.get(key).toString());
    } */
}
