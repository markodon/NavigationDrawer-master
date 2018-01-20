package info.androidhive.navigationdrawer.other;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.klasi.Photos;
import info.androidhive.navigationdrawer.klasi.PhotosModel;

/**
 * Created by Anti on 1/17/2018.
 */

public class RecycleViewPhotosAdapter  extends RecyclerView.Adapter<RecycleViewPhotosAdapter.ViewHolder> {

    List<Photos> photosList = new ArrayList<>();

    Context context;


    public RecycleViewPhotosAdapter (List<Photos> photosList ){

         this.photosList = photosList;
    }

    public RecycleViewPhotosAdapter(Context context, PhotosModel photos) {

        this.context = context;
        photosList=photos.photos;
    }

    public void setItems (List<Photos> photos) {
        photosList = photos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_photos,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Photos photos = photosList.get(position);
        holder.ime.setText(photos.getName());
        Picasso.with(context).load(photos.getImage_url()).centerInside().fit().into(holder.slika);


    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ime)
        TextView ime;

        @BindView(R.id.slika)
        ImageView slika;


        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);


        }
    }
}
