/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rest;


import com.ryno.retailwarehouseweb3.domain.Appliance;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Ryno
 */
public class ApplianceRestController {
        private final RestTemplate restTemplate = new RestTemplate();
    private final static String URL = "http://localhost:8084/retailWarehouse/";
    
    public ApplianceRestController() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
       @Test
    public void testCreate() {
        Appliance app = new Appliance.Builder("samTv003").brand("samsung").descrip("HDTV").Build();
        HttpEntity<Appliance> requestEntity = new HttpEntity<>(app, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL + "api/club/create", HttpMethod.POST, requestEntity, String.class);
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
        System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

    //@Test
    public void testApplianceUpdate() {
        // LEFT AS AN EXERCISE FOR YOU
        // GET THE CLUB and THEN CHANGE AND MAKE A COPY
        //THEN SEND TO THE SERVER USING A PUT OR POST
        // THEN READ BACK TO SEE IF YOUR CHANGE HAS HAPPENED
        Appliance app = new Appliance.Builder("samTv003").brand("samsung").descrip("UHDTV").Build();
        HttpEntity<Appliance> requestEntity = new HttpEntity<>(app, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL + "api/appliance/create", HttpMethod.POST, requestEntity, String.class);
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
        System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders());
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

    public void testreadApplianceByNameName() {
        String clubName = "samsung";
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Appliance> responseEntity = restTemplate.exchange(URL + "api/app/name/" + clubName, HttpMethod.GET, requestEntity, Appliance.class);
        Appliance app = responseEntity.getBody();

        Assert.assertNotNull(app);

    }

    @Test
    public void testreadApplianceById() {
        String clubId = "1";
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Appliance> responseEntity = restTemplate.exchange(URL + "api/app/id/" + clubId, HttpMethod.GET, requestEntity, Appliance.class);
        Appliance app = responseEntity.getBody();

        Assert.assertNotNull(app);

    }

    @Test
    public void testgetAllAppliances() {
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Appliance[]> responseEntity = restTemplate.exchange(URL + "api/app/allapps", HttpMethod.GET, requestEntity, Appliance[].class);
        Appliance[] apps = responseEntity.getBody();
        for (Appliance app : apps) {
            System.out.println("The Appliance brand is " + app.getBrand());

        }

        Assert.assertTrue(apps.length > 0);
    }

    private HttpEntity<?> getHttpEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }

    private HttpHeaders getContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;

    }

}