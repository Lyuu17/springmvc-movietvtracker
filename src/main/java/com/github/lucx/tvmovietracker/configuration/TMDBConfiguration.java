package com.github.lucx.tvmovietracker.configuration;

import com.github.lucx.tvmovietracker.tmdb.TMDBService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Configuration
public class TMDBConfiguration {

    @Value("${tmdb.baseurl}")
    private String tmdbBaseUrl;

    @Value("${tmdb.version}")
    private Integer tmdbVersion;

    @Value("${tmdb.apikey}")
    private String tmdbApiKey;

    @Bean
    public TMDBService tmdbService() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("Authorization", "Bearer " + tmdbApiKey)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(tmdbBaseUrl + tmdbVersion + "/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        return retrofit.create(TMDBService.class);
    }
}
