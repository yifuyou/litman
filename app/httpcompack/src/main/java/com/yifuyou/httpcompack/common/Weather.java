package com.yifuyou.httpcompack.common;

import org.json.JSONException;
import org.json.JSONObject;

public class Weather extends JSONObject {
    String reason;
    String result;
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        String s = super.toString();
        try {
            reason = getString("reason");
            result = getString("result");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "Weather{" +
                "reason='" + reason + '\'' +
                ", result='" + result + '\'' +
                '}'+" all : "+s;
    }
}
