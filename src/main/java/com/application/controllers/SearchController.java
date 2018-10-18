/**
 * author: Alhajras Algdairy
 * 
 * Controller for serving the request of the user in the chatbot
 */

package com.application.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.application.exceptions.authorityException;

@RestController
public class SearchController {

//	Key to use for the API
	@Value("${security.key}")
	private String key;

	@Value("${elasticsearch.host}")
	private String elasticSearchHost;

	@GetMapping("{authinticationKey}/search/{text}")
	public String search(@PathVariable String text, @PathVariable String authinticationKey)
			throws authorityException, IOException, JSONException {
		String URL = "https://www.haw-hamburg.de/";
		StringBuffer content = new StringBuffer();
		if (!authinticationKey.equals(key)) {
			throw new authorityException("Security exception, the key is invalid!");
		}
		text.replaceAll("[^a-zA-Z0-9\\s+]", "");
		URL url;
		try {
			url = new URL(elasticSearchHost + text.replaceAll(" ", "%20"));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			if (content.toString().contains("url")) {
				JSONObject obj = new JSONObject(content.toString());
				String objString = obj.getJSONObject("hits").getJSONArray("hits").get(0).toString();
				obj = new JSONObject(objString);
				obj = new JSONObject(obj.getJSONObject("_source").toString());
				System.out.println(obj);
				URL = obj.toString().split("data\":\"")[1].split("url\":\"")[1].replaceAll("\\\\", "")
						.replaceAll("}", "").replaceAll("\"", "");
			}

//						.split("\"url\":\"")[1].split("\\\",\"data\"")[0];
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return URL;
	}

}