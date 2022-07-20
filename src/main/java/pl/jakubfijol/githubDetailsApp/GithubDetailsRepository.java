package pl.jakubfijol.githubDetailsApp;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Repository
public class GithubDetailsRepository {

    public String getData(String owner, String repositoryname) throws IOException, JSONException {

        String command = "curl -X GET https://api.github.com/repos/" + owner + "/" + repositoryname;
        Process process = Runtime.getRuntime().exec(command);
        String result = IOUtils.toString(process.getInputStream(), StandardCharsets.UTF_8);

        JSONObject obj = new JSONObject(result);
        String full_name = obj.getString("full_name");
        String description = obj.getString("description");
        String clone_url = obj.getString("clone_url");
        int stargazers_count = obj.getInt("stargazers_count");
        String created_at = obj.getString("created_at");

        String jsonString = new JSONObject()
                .put("fullname", full_name)
                .put("description", description)
                .put("clone_url", clone_url)
                .put("stargazers_count", stargazers_count)
                .put("created_at", created_at)
                .toString();

        return jsonString;
    }
}
