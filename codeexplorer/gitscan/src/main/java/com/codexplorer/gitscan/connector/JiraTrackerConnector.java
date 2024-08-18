package com.codexplorer.gitscan.connector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class JiraTrackerConnector implements TaskTrackerConnector {
	
	private HttpClient httpClient;

	public JiraTrackerConnector() {
		this.httpClient = HttpClient.newHttpClient();
	}
	
	public JiraTrackerConnector(HttpClient client) {
		if (client == null) {
			this.httpClient = HttpClient.newHttpClient();
		}
		else {
			this.httpClient = client;
		}
		
	}
	
	private HttpRequest createRequest(String taskId, String connectionUrl) throws URISyntaxException {
		String jiraTicketUrl = connectionUrl + "/"+ taskId;
		HttpRequest getRequest = HttpRequest.newBuilder()
      		  .uri(new URI(jiraTicketUrl))
      		  .header("key1", "value1")
      		  .header("key2", "value2")
      		  .GET()
      		  .build();
		
		return getRequest;
	}
	
	@Override
	public String getDescription(String taskId, String connectionUrl) {
        // Jira ticket URL
        
        String description = "";
        try {

            // Fetch the HTML content of the Jira ticket page
            
            HttpResponse<String> response = httpClient.send(createRequest(taskId, connectionUrl), BodyHandlers.ofString());
            // Extract the ticket description
            //Document document = Jsoup.parse(url, 3000);
            Document document = Jsoup.parse(response.body());
            Element descriptionElement = document.selectFirst("#description-val.user-content-block");
            description = descriptionElement.text();


        } catch (IOException e) {
        	System.out.println(e.getMessage());
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        // Return the ticket description        
        return description;
    }

}
