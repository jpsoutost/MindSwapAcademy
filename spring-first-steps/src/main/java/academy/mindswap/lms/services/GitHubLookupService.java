package academy.mindswap.lms.services;

import academy.mindswap.lms.persistence.models.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class GitHubLookupService {

    private static final String GITHUB_URL = "https://api.github.com/users/%s";

    private final RestTemplate restTemplate;


    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getGitHubUrl(String user){
        return String.format(GITHUB_URL, user);
    }

    @Async
    public CompletableFuture<User> findUsr(String user){
        String url = getGitHubUrl(user);
        User result = restTemplate.getForObject(url, User.class);
        return CompletableFuture.completedFuture(result);
    }
}
