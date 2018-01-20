package info.androidhive.navigationdrawer.api;

import android.content.ClipData;

import info.androidhive.navigationdrawer.klasi.Photos;
import info.androidhive.navigationdrawer.klasi.PhotosModel;
import info.androidhive.navigationdrawer.klasi.StarwarsPeopleModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Anti on 1/16/2018.
 */

public interface ApiService {


    @GET ("photos?" + ApiConstants.Consumer_key)
    Call<PhotosModel> getPhotos (@Query("feature")String featureString );


    @FormUrlEncoded
    @POST("photos")
    Call<Photos>  uploadPhoto(@Field("name") String stringName, @Body ClipData.Item photo);


    @GET ("people" + ApiConstants.baseURL)
    Call<StarwarsPeopleModel> getMovies (@Query("1") String peopleString );

}
