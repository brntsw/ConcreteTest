package com.concrete.bruno.concretetest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by BRUNO on 23/02/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequest {

    @JsonProperty("title")
    private String title;
    @JsonProperty("html_url")
    private String url;
    @JsonProperty("user")
    private UserPullRequest userPullRequest;
    @JsonProperty("body")
    private String body;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("closed_at")
    private String closedAt;
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

    public UserPullRequest getUserPullRequest() {
        return userPullRequest;
    }

    public void setUserPullRequest(UserPullRequest userPullRequest) {
        this.userPullRequest = userPullRequest;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
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
