package info.androidhive.navigationdrawer.other;

import android.animation.RectEvaluator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.klasi.StarwarsPeople;
import info.androidhive.navigationdrawer.klasi.StarwarsPeopleModel;

/**
 * Created by Marko on 1/19/2018.
 */

public class RecycleViewMoviesAdapter extends RecyclerView.Adapter<RecycleViewMoviesAdapter.ViewHolder> {

    List<StarwarsPeople> peopleList = new ArrayList<>();
    Context context;

    public RecycleViewMoviesAdapter(Context context, StarwarsPeopleModel results){
        this.context = context;
        peopleList = results.results;
    }


    @Override
    public RecycleViewMoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_movies,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleViewMoviesAdapter.ViewHolder holder, int position) {

        StarwarsPeople people = peopleList.get(position);
        holder.name.setText(people.getName());
        holder.year.setText(people.getBirth_year());
        holder.films.setText(people.getFilms());


    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.year)
        TextView year;
        @BindView(R.id.films)
        TextView films;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
