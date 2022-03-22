package academy.mindswap.services;

import academy.mindswap.commands.ActivityDto;
import academy.mindswap.persistance.models.Activity;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class BoredAPILookupService {

    private static final String BOREDAPI_URL = "https://www.boredapi.com/api/activity";

    private final RestTemplate restTemplate;

    public BoredAPILookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<ActivityDto> findActivity(){
        ActivityDto result = restTemplate.getForObject(BOREDAPI_URL, ActivityDto.class);
        return CompletableFuture.completedFuture(result);
    }
}
