package patika.dev.schoolmanagementsystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/get-currency-conversion")
public class FromCurrencyConversionController {

    private final static String CURRENCY_ENDPOINT ="http://localhost:8100/currency-conversion/from/{from}/to/{to}";

    @Autowired
    RestTemplate restTemplate;


@GetMapping("/{id}")
    public ResponseEntity<String>  getCurrencyEndpoint(@PathVariable long id) {
    ResponseEntity<String>   response= restTemplate.getForEntity(CURRENCY_ENDPOINT + id, String.class);
    return response;
}
}
