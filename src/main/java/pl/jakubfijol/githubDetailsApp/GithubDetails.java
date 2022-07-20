package pl.jakubfijol.githubDetailsApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubDetails {

    private String owner;
    private String repositoryname;

}
