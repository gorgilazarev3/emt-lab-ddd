package mk.ukim.finki.emt.rentmanagement.xport.client;


import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.Vehicle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class VehicleClient {

    private final RestTemplate restTemplate;
    private  final String serverUrl;

    public VehicleClient(@Value("${app.vehicle-catalog.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Vehicle> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/vehicle").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Vehicle>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public Vehicle findById(String id) {
        try {
            return restTemplate.exchange(uri().path("/api/vehicle/" + id).build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<Vehicle>() {
            }).getBody();
        } catch (Exception e) {
            return null;
        }
    }

}
