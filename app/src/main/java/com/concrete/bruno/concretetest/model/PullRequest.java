package com.concrete.bruno.concretetest.model;

/**
 * Created by BRUNO on 23/02/2017.
 */

public class PullRequest {

    //TODO Utilizar o Jackson

    private String title;
    private String url; //"html_url"
    private String login;
    private String avatarUrl; //"user" -> "avatar_url"
    private String body; //"body"
    private int openIssuesCount; //Faz um count de quantos estão com "closed_at" como null
    private int closedIssuesCount; //É o count do "closed_at" != null

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getOpenIssuesCount() {
        return openIssuesCount;
    }

    public void setOpenIssuesCount(int openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public int getClosedIssuesCount() {
        return closedIssuesCount;
    }

    public void setClosedIssuesCount(int closedIssuesCount) {
        this.closedIssuesCount = closedIssuesCount;
    }
}
