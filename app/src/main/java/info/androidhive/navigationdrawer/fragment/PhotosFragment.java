package info.androidhive.navigationdrawer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.api.ApiService;
import info.androidhive.navigationdrawer.api.RestApi;
import info.androidhive.navigationdrawer.klasi.Photos;
import info.androidhive.navigationdrawer.klasi.PhotosModel;
import info.androidhive.navigationdrawer.other.RecycleViewPhotosAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosFragment extends Fragment {

    RestApi api = new RestApi();
    ApiService service;
    Photos photos;
    PhotosModel model;

    @BindView(R.id.recycler_photos)
    RecyclerView recycler;
    RecycleViewPhotosAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photos, container, false);

        ButterKnife.bind(this, view);


        RecyclerView.LayoutManager lm = new GridLayoutManager(getContext(), 2);
        recycler.setLayoutManager(lm);

        Call<PhotosModel> call = api.getPhotos("fresh_today");
        call.enqueue(new Callback<PhotosModel>() {
            @Override
            public void onResponse(Call<PhotosModel> call, Response<PhotosModel> response) {
                if (response.code() == 200) {

                    model = response.body();
                    adapter = new RecycleViewPhotosAdapter(getActivity(), model);
                    recycler.setAdapter(adapter);
                } else if (response.code() == 401) {

                    Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<PhotosModel> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_LONG).show();
            }

        });


       // adapter.setItems(getList());

//        recycler.setHasFixedSize(true);
//        recycler.setLayoutManager(new LinearLayoutManager(this));
//        recycler.setAdapter(adapter);

        return view;
    }

//                photosModel = response.body();
//                mAdapter = new ItemAdapter(getActivity(), photosModel);
//                mRecyclerView.setAdapter(mAdapter);
//                progressBar.setVisibility(View.INVISIBLE);


}
