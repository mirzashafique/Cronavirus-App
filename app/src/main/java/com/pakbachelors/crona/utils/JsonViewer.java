package com.pakbachelors.crona.utils;

import com.pakbachelors.crona.model.Staticts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonViewer {

    public static boolean isNotNull(JSONObject jsonObject, String value) {
        if (jsonObject.has(value) && !jsonObject.isNull(value)) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Staticts> parseDate(String responce) {
        List<Staticts> data = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(responce);
            JSONArray array = jsonObject.getJSONArray("results");
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                Staticts current = new Staticts();
                if (isNotNull(object, "locationId")) {
                    current.setLocationId(object.getInt("locationId"));
                } else {
                    current.setLocationId(0);
                }
                if (isNotNull(object, "continentEnglishName")) {
                    current.setContinentEnglishName(object.getString("continentEnglishName"));
                } else {
                    current.setContinentEnglishName("N/A");
                }
                if (isNotNull(object, "countryEnglishName")) {
                    current.setCountryEnglishName(object.getString("countryEnglishName"));
                } else {
                    current.setCountryEnglishName("N/A");
                }
                if (isNotNull(object, "provinceEnglishName")) {
                    current.setProvinceEnglishName(object.getString("provinceEnglishName"));
                } else {
                    current.setProvinceEnglishName("N/A");
                }
                if (isNotNull(object, "currentConfirmedCount")) {
                    current.setCurrentConfirmedCount(object.getInt("currentConfirmedCount"));
                } else {
                    current.setCurrentConfirmedCount(-1);
                }
                if (isNotNull(object, "confirmedCount")) {
                    current.setConfirmedCount(object.getInt("confirmedCount"));
                } else {
                    current.setConfirmedCount(-1);
                }
                if (isNotNull(object, "suspectedCount")) {
                    current.setSuspectedCount(object.getInt("suspectedCount"));
                } else {
                    current.setSuspectedCount(-1);
                }
                if (isNotNull(object, "curedCount")) {
                    current.setCuredCount(object.getInt("curedCount"));
                } else {
                    current.setCuredCount(-1);
                }
                if (isNotNull(object, "deadCount")) {
                    current.setDeadCount(object.getInt("deadCount"));
                } else {
                    current.setDeadCount(-1);
                }
                if (isNotNull(object, "updateTime")) {
                    current.setUpdateTime(object.getDouble("updateTime"));
                } else {
                    current.setUpdateTime(-1);
                }
                data.add(current);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
}
