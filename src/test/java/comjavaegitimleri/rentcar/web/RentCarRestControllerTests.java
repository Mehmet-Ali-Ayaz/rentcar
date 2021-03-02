package comjavaegitimleri.rentcar.web;

import com.javaegitimleri.rentcar.model.Renter;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;


public class RentCarRestControllerTests {
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }
    @Test
    public void testDeleteRenter() {
        restTemplate.delete("http://localhost:8080/rest/renter/4");

        try {
            restTemplate.getForEntity("http://localhost:/8080/rest/renter/4", Renter.class);
            Assert.fail("should have not returned renter");
        } catch (HttpClientErrorException exception) {
         MatcherAssert.assertThat(exception.getStatusCode().value(), Matchers.equalTo(404));
        }
    }
        @Test
        public void testUpdateRenter(){
         Renter renter = restTemplate.getForObject("http://localhost:8080/rest/renter/4", Renter.class);
         MatcherAssert.assertThat(renter.getRenterName(), Matchers.equalTo(("Murat Can")));
         renter.setRenterName("Umut Can");
         restTemplate.put("http://localhost:8080/rest/renter/4", renter);
         renter = restTemplate.getForObject("http://localhost:8080/rest/renter/4", Renter.class);
            MatcherAssert.assertThat(renter.getRenterName(), Matchers.equalTo(("Umut Can")));
        }

    @Test
    public void testCreateRenter(){
        Renter renter = new Renter();
        renter.setRenterName("Mete Yücel");
        URI location = restTemplate.postForLocation("http://localhost:8080/rest/renter", renter);
          Renter renter5 = restTemplate.getForObject(location, Renter.class );
          MatcherAssert.assertThat(renter5.getRenterName(), Matchers.equalTo(renter.getRenterName()));

    }

    @Test
    public void testGetRenterById(){
        ResponseEntity<Renter> response=restTemplate.getForEntity("http://localhost:8080/rest/renter/4",Renter.class);

        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        MatcherAssert.assertThat(response.getBody().getRenterName(), Matchers.equalTo("Murat Can"));

    }
    @Test
    public void testGetRentersByRenterName(){
      ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/renter?ln=Murat Can", List.class);
        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
    }
    @Test
    public void testGetRenters(){
         ResponseEntity<List> response =  restTemplate.getForEntity("http://localhost:8080/rest/renters", List.class);

         MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));


    }
}
