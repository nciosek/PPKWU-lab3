package com.ppwku.lab3.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Html2ICSService {

    public String convert(final String URL) throws IOException {
        String line = "", all = "";
        URL myUrl = null;
        BufferedReader in = null;

        try {
            myUrl = new URL(URL);
            in = new BufferedReader(new InputStreamReader(myUrl.openStream()));

            while ((line = in.readLine()) != null) {
                all += line;
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return all;
    }
}
