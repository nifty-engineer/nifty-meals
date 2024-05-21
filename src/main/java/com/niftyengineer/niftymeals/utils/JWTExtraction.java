package com.niftyengineer.niftymeals.utils;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JWTExtraction {

    public static String extractJWTPayload(String token, String extraction) {

        String accessToken = token.replace("Bearer ", "");

        String[] chunks = accessToken.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        String payload = new String(decoder.decode(chunks[1]));

        String[] entries = payload.split(",");
        Map<String, String> map = new HashMap<>();

        for (String entry : entries) {
            String[] keyValue = entry.split(":");

            String key = keyValue[0].replace("{", "");

            String keyValue1 = keyValue[1].replace("}", "");
            String value = keyValue1.substring(0, keyValue1.length() - 1).replace("\"", "");

            map.put(key, value);
        }
        if (map.containsKey(extraction)) {
            return map.get(extraction);
        }
        return null;
    }
}
