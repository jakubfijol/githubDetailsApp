package pl.jakubfijol.githubDetailsApp;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/repositories")

public class GithubDetailsController {

    @Autowired
    GithubDetailsRepository githubDetailsRepository;

    @GetMapping("/{owner}/{repositoryname}")
    public String getData(@PathVariable("owner") String owner, @PathVariable("repositoryname") String repositoryname) throws IOException, JSONException {
        return githubDetailsRepository.getData(owner,repositoryname);
    }
}
