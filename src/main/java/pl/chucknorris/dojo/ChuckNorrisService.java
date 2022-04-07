package pl.chucknorris.dojo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChuckNorrisService {

    private final String EXTERNAL_URL = "https://api.chucknorris.io/jokes";
    private final RestTemplate restTemplate;

    public ChuckNorrisService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> getCategories() {
        return restTemplate.getForObject(EXTERNAL_URL + "/categories", ArrayList.class);
    }

    public String getRandomJokeByCategory(String category) throws BadCategoryException {
        if(category!=null) {
            List<String> categories = getCategories();
            if(!categories.contains(category)) {
                throw new BadCategoryException("This category does not exists");
            }
            return restTemplate.getForObject(EXTERNAL_URL + "/random?category=" + category, String.class);
        }
        return restTemplate.getForObject(EXTERNAL_URL + "/random", String.class);
    }
}
