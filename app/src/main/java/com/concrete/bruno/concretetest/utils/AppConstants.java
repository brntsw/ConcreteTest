package com.concrete.bruno.concretetest.utils;

/**
 * Created by BRUNO on 25/02/2017.
 */

public class AppConstants {

    public static final int TIMEOUT = 300;
    public static final int NUMBER_OF_THREADS = 20;

    public static final String BASE_URL = "https://api.github.com/";
    public static final String REPOSITORIES_URL = "search/repositories";
    public static final String PULL_REQUESTS_URL = "repos/{name}/pulls";

    public static final int STATUS_CODE_SUCCESS = 200;
    public static final int STATUS_CODE_SUCCESS_NO_BODY = 204;
    public static final int STATUS_CODE_ERROR = 500;
    public static final int STATUS_CODE_NOT_FOUND = 404;

    public static final String DB_NAME = "concrete_github.db";

    public static final String BUNDLE_FULL_NAME = "fullName";

}
