package com.icai.practicas;

import com.icai.practicas.controller.ProcessController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProcessControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void given_app_when_login_using_right_credentials_then_ok() {

        // Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";

        // Le tenemos que pasar al controlador => El multivalue map
        String nombre = "Javier Gonzalez";
        String dni = "12345678Z";
        String telefono = "677817580";

        ProcessController.DataRequest data1 = new ProcessController.DataRequest(nombre, dni, telefono);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(data1, headers);

        // When
        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        //Then
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    public void given_app_when_login_using_right_credentials_then_ok_legacy() {
        
        // Given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";

        //DATOS BIEN
        MultiValueMap<String, String> data1 = new LinkedMultiValueMap<>();
        data1.add("fullName", "Javier Gonzalez");
        data1.add("dni", "12345678Z");
        data1.add("telefono", "677817580");

        //NOMBRE INCORRECTO
        MultiValueMap<String, String> data2 = new LinkedMultiValueMap<>();
        data2.add("fullName", "Hola2982");
        data2.add("dni", "12345678Z");
        data2.add("telefono", "677817580");

        //DNI INCORRECTO
        MultiValueMap<String, String> data3 = new LinkedMultiValueMap<>();
        data3.add("fullName", "Javier Gonzalez");
        data3.add("dni", "00000001R");
        data3.add("telefono", "677817580");

        //TELÉFONO INCORRECTO
        MultiValueMap<String, String> data4 = new LinkedMultiValueMap<>();
        data4.add("fullName", "Javier Gonzalez");
        data4.add("dni", "12345678Z");
        data4.add("telefono", "0000000000000");


        //REQUEST
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request1 = new HttpEntity<>(data1, headers);
        HttpEntity<MultiValueMap<String, String>> request2 = new HttpEntity<>(data2, headers);
        HttpEntity<MultiValueMap<String, String>> request3 = new HttpEntity<>(data3, headers);
        HttpEntity<MultiValueMap<String, String>> request4 = new HttpEntity<>(data4, headers);
        
        // When
        ResponseEntity<String> result1 = this.restTemplate.postForEntity(address, request1, String.class);
        ResponseEntity<String> result2 = this.restTemplate.postForEntity(address, request2, String.class);
        ResponseEntity<String> result3 = this.restTemplate.postForEntity(address, request3, String.class);
        ResponseEntity<String> result4 = this.restTemplate.postForEntity(address, request4, String.class);

        then(result1.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result2.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result3.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result4.getStatusCode()).isEqualTo(HttpStatus.OK);

    }
}
