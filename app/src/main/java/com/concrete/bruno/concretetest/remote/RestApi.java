package com.concrete.bruno.concretetest.remote;

import com.concrete.bruno.concretetest.model.ListRepository;
import com.concrete.bruno.concretetest.model.Repository;
import com.concrete.bruno.concretetest.utils.AppConstants;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/**
 * Created by BRUNO on 26/02/2017.
 */

public interface RestApi {

    @Headers({"Accept: application/json", "Content-type: application/json"})
    @GET(AppConstants.REPOSITORIES_URL)
    Call<ListRepository> getRepositories(@QueryMap Map<String, String> params);

    class Builder{
        private static HttpLoggingInterceptor getLoggingInterceptor(){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            return interceptor;
        }

        private static OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor){
            return new OkHttpClient.Builder()
                    .dispatcher(new Dispatcher(Executors.newFixedThreadPool(AppConstants.NUMBER_OF_THREADS)))
                    .addInterceptor(httpLoggingInterceptor)
                    .readTimeout(AppConstants.TIMEOUT, TimeUnit.SECONDS)
                    .connectTimeout(AppConstants.TIMEOUT, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
        }

        public static RestApi build(){
            OkHttpClient client = getOkHttpClient(getLoggingInterceptor());

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(client)
                    .build();

            return retrofit.create(RestApi.class);
        }
    }

}
