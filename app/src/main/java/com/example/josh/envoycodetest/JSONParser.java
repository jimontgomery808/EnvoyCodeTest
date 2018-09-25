package com.example.josh.envoycodetest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Parse a JSON String and store List of Gist objects
public class JSONParser {
    private String jsonString;
    private JSONArray jsonArray = null;
    private ArrayList<Gist> gistList;

    public JSONParser(String jsonString) {
        this.jsonString = jsonString;
        gistList = new ArrayList<>();
    }

    public int getListSize(){
        return gistList.size();
    }

    public ArrayList<Gist> getList(){
        return gistList;
    }

    public void read() throws JSONException {
        try {
            jsonArray = new JSONArray(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject obj = jsonArray.getJSONObject(i);

            String url = obj.getString("url");
            String forksUrl = obj.getString("forks_url");
            String commitsUrl = obj.getString("commits_url");
            String id = obj.getString("id");
            String nodeId = obj.getString("node_id");
            String gitPullUurl = obj.getString("git_pull_url");
            String gitPushUrl = obj.getString("git_push_url");
            String htmlUrl = obj.getString("html_url");
            boolean isPublic = obj.getBoolean("public");
            String createdAt = obj.getString("created_at");
            String updatedAt = obj.getString("updated_at");
            String description = obj.getString("description");
            int comments = obj.getInt("comments");
            String user = obj.getString("user");
            String commentsUrl = obj.getString("comments_url");
            boolean isTruncated = obj.getBoolean("truncated");



            JSONObject fileObject = obj.getJSONObject("files");
            List<GistFile> fileList = new ArrayList<>();
            Iterator<?> keys = fileObject.keys();
            while(keys.hasNext() ) {
                String key = (String)keys.next();
                if ( fileObject.get(key) instanceof JSONObject ) {
                    JSONObject currentFile = new JSONObject(fileObject.get(key).toString());
                    String fileName = currentFile.getString("filename");
                    String type = currentFile.getString("type");
                    String language = currentFile.getString("language");
                    String rawUrl = currentFile.getString("raw_url");
                    int fileSize = currentFile.getInt("size");
                    GistFile file = new GistFile(fileName, type, language, rawUrl, fileSize);
                    fileList.add(file);
                }
            }

            JSONObject ownerObject = obj.getJSONObject("owner");
            String login = ownerObject.getString("login");
            int ownerId = ownerObject.getInt("id");
            String ownerNodeId = ownerObject.getString("node_id");
            String avatarUrl = ownerObject.getString("avatar_url");
            String gravatarId = ownerObject.getString("gravatar_id");
            String ownerUrl = ownerObject.getString("url");
            String ownerHtmlUrl = ownerObject.getString("html_url");
            String followersUrl = ownerObject.getString("followers_url");
            String followingUrl = ownerObject.getString("following_url");
            String gistsUrl = ownerObject.getString("gists_url");
            String starredUrl = ownerObject.getString("starred_url");
            String subscriptionsUrl = ownerObject.getString("subscriptions_url");
            String organizationsUrl = ownerObject.getString("organizations_url");
            String reposUrl = ownerObject.getString("repos_url");
            String eventsUrl = ownerObject.getString("events_url");
            String receivedEventsUrl = ownerObject.getString("received_events_url");
            String ownerType = ownerObject.getString("type");
            boolean siteAdmin = ownerObject.getBoolean("site_admin");

            Owner owner = new Owner(login, ownerId, ownerNodeId, avatarUrl, gravatarId, ownerUrl, ownerHtmlUrl, followersUrl, followingUrl, gistsUrl,
                    starredUrl, subscriptionsUrl, organizationsUrl, reposUrl, eventsUrl, receivedEventsUrl, ownerType, siteAdmin);

            Gist gist = new Gist(url, forksUrl, commitsUrl, id, nodeId, gitPullUurl, gitPushUrl, htmlUrl, isPublic, createdAt, updatedAt, description, comments, user, commentsUrl, isTruncated, fileList, owner);
            gistList.add(gist);
        }
    }
}
