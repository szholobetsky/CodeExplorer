package com.codexplorer.gitscan.connector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;

public class JiraTrackerConnector implements TaskTrackerConnector {

	@Override
	public String getDescription(String taskId, String connectionUrl){
        // Jira ticket URL
        String jiraTicketUrl = connectionUrl + "/"+ taskId;
        String description = "";
        try {
            // Create a URL object for the Jira ticket
            URL url = new URL(jiraTicketUrl);

            // Fetch the HTML content of the Jira ticket page
            Document document = Jsoup.parse(url, 3000);

            // Extract the ticket description
            Element descriptionElement = document.selectFirst("#description-val .user-content-block");
            description = descriptionElement.text();


        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return the ticket description        
        return description;
    }

}
