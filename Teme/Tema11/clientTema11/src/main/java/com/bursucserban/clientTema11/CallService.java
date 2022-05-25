package com.bursucserban.clientTema11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CallService {
    final Logger log = LoggerFactory.getLogger(CallService.class);
    final String uri = "http://localhost:8081/users";
    @GetMapping("/call")
    public List<User> getProducts() {
        log.info("Start");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> response = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>(){});
        List<User> result = response.getBody();
        result.forEach(p -> log.info(p.toString()));
        log.info("Stop");
        return result;
    }
}
