package io.github.perrymant.moneymaker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

class JSONPersistentData implements Serializable {

    void writeJSONObject(Object dataToConvert) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dataToConvert);
        SerializedObject SObj = new SerializedObject();
        System.out.println(json);
    }

}
