package info.androidhive.navigationdrawer.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.api.ApiService;
import info.androidhive.navigationdrawer.api.RestApi;
import info.androidhive.navigationdrawer.klasi.StarwarsPeopleModel;
import info.androidhive.navigationdrawer.other.RecycleViewMoviesAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesFragment extends Fragment {
    RestApi api = new RestApi();
    ApiService service;
    StarwarsPeopleModel model;

    @BindView(R.id.recycler_movies)
    RecyclerView recyclerView;
    RecycleViewMoviesAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        ButterKnife.bind(this,view);


        RecyclerView.LayoutManager lm = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);


        Call<StarwarsPeopleModel> call = api.getMovies("1");
        call.enqueue(new Callback<StarwarsPeopleModel>() {
            @Override
            public void onResponse(Call<StarwarsPeopleModel> call, Response<StarwarsPeopleModel> response) {
                if (response.code() == 200){
                    model = response.body();
                    adapter = new RecycleViewMoviesAdapter(getActivity(),model);
                    Toast.makeText(getContext(), "OK",Toast.LENGTH_LONG).show();
                } else if (response.code() == 401){
                    Toast.makeText(getContext(),"Something get wrong",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<StarwarsPeopleModel> call, Throwable t) {

            }
        });




        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
