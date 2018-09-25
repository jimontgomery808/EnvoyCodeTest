package com.example.josh.envoycodetest;

import java.io.Serializable;
import java.util.List;

// Class which holds all data related to a Gist
public class Gist implements Serializable{
    private String url;
    private String forks_url;
    private String commits_url;
    private String id;
    private String node_id;
    private String git_pull_url;
    private String git_push_url;
    private String html_url;
    private boolean isPublic;
    private String created_at;
    private String updated_at;
    private String description;
    private float comments;
    private String user = null;
    private String comments_url;
    private boolean isTruncated;
     List<GistFile> fileList;
    private Owner owner;

    public Gist(String url, String forks_url, String commits_url, String id, String node_id, String git_pull_url, String git_push_url, String html_url, boolean isPublic, String created_at, String updated_at, String description, float comments, String user, String comments_url, boolean isTruncated, List<GistFile> filelist, Owner owner)
    {
        this.url = url;
        this.forks_url = forks_url;
        this.commits_url = commits_url;
        this.id = id;
        this.node_id = node_id;
        this.git_pull_url = git_pull_url;
        this.git_push_url = git_push_url;
        this.html_url = html_url;
        this.isPublic = isPublic;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description = description;
        this.comments = comments;
        this.user = user;
        this.comments_url = comments_url;
        this.isTruncated = isTruncated;
        this.fileList= filelist;
        this.owner = owner;
    }

// Getter Methods

    public String getUrl() {
        return url;
    }

    public String getForks_url() {
        return forks_url;
    }

    public String getCommits_url() {
        return commits_url;
    }

    public String getId() {
        return id;
    }

    public String getNode_id() {
        return node_id;
    }

    public String getGit_pull_url() {
        return git_pull_url;
    }

    public String getGit_push_url() {
        return git_push_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public boolean getPublic() {
        return isPublic;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getDescription() {
        return description;
    }

    public float getComments() {
        return comments;
    }

    public String getUser() {
        return user;
    }

    public String getComments_url() {
        return comments_url;
    }

    public boolean getTruncated() {
        return isTruncated;
    }

    public Owner getOwner(){
        return owner;
    }

    public List<GistFile> getFiles(){
        return fileList;
    }

    public int getNumberOfFiles(){
        return fileList.size();
    }
    // Setter Methods

    public void setUrl( String url ) {
        this.url = url;
    }

    public void setForks_url( String forks_url ) {
        this.forks_url = forks_url;
    }

    public void setCommits_url( String commits_url ) {
        this.commits_url = commits_url;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public void setNode_id( String node_id ) {
        this.node_id = node_id;
    }

    public void setGit_pull_url( String git_pull_url ) {
        this.git_pull_url = git_pull_url;
    }

    public void setGit_push_url( String git_push_url ) {
        this.git_push_url = git_push_url;
    }

    public void setHtml_url( String html_url ) {
        this.html_url = html_url;
    }

    public void setPublic( boolean isPublic ) {
        this.isPublic = isPublic;
    }

    public void setCreated_at( String created_at ) {
        this.created_at = created_at;
    }

    public void setUpdated_at( String updated_at ) {
        this.updated_at = updated_at;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public void setComments( float comments ) {
        this.comments = comments;
    }

    public void setUser( String user ) {
        this.user = user;
    }

    public void setComments_url( String comments_url ) {
        this.comments_url = comments_url;
    }

    public void setTruncated( boolean isTruncated ) {
        this.isTruncated = isTruncated;
    }

    public void setGitfileList(List<GistFile> fileList){
        this.fileList = fileList;
    }
}