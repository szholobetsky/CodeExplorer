package com.codexplorer.gitscan.connector;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JiraTrackerConnectorTest extends JiraTrackerConnector {

	JiraTrackerConnector target;
	
	@Mock HttpClient client;

	@BeforeEach
	public void setup() {
		client = mock(HttpClient.class);
		target = new JiraTrackerConnector(client);
		
		//if we don't call below, we will get NullPointerException
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testGetDescriptionSuccess() {
		
		assertNotNull(target.getDescription("some-task","some-url"));
	}
	
    @Test
    public void testGetDescriptionFromRemoteUrl() throws IOException, InterruptedException {
        // Arrange
        String url = "http://example.com";
        String task = "task";
        String expectedDescription = "This is a test description";
        HttpResponse<Object> mockResponse = mock(HttpResponse.class);
        when(mockResponse.body()).thenReturn("<html><body><div id='description-val' class='user-content-block'>" + expectedDescription + "</div></body></html>");
        when(client.send(any(), any())).thenReturn(mockResponse); // Assuming a generic send method

        // Act
        String actualDescription = target.getDescription(task, url); // Call the method to test

        // Assert
        assertEquals(expectedDescription, actualDescription);
    }

}
