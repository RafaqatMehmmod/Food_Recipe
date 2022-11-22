package com.example.recipiapi;

import android.content.Context;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class ReadApi {

    Context context;
    Retrofit retrofit = new Retrofit.Builder().
            baseUrl("https://api.spoonacular.com/").
            addConverterFactory(GsonConverterFactory.create()).
            build();

    public ReadApi(Context context) {
        this.context = context;
    }

    public interface CallNewsApi {

        @GET("/recipes/complexSearch?")

        Call<ApiResponse> callHeadlines(

                @Query("number") String number,
                @Query("apiKey") String api_key
        );

    }
    public void getNewsHeadlines (OnFetchDataListener listener)
    {
        CallNewsApi callNewsApi = retrofit.create(CallNewsApi.class);
        Call<ApiResponse> call = callNewsApi.callHeadlines("10", context.getString(R.string.api_key));

        try {

            call.enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                    if (!response.isSuccessful()) { // Si on a pas réussis à récuperé les données
                        Toast.makeText(context, "Fail ", Toast.LENGTH_LONG).show(); // on dit qu'une erreur s'est produite

                    }
                    listener.didFetch(response.body(), response.message());
                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                    listener.didError("Requete failled");

                }
            });
        }
        catch (Exception e) {

            e.printStackTrace();
        }

    }




}

