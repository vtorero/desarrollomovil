package pe.edu.upc.clinicaupc.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.clinicaupc.R;
import pe.edu.upc.clinicaupc.activities.LocalActivity;
import pe.edu.upc.clinicaupc.models.Schedule;
import pe.edu.upc.clinicaupc.models.Local;

/**
 * Created by weval_000 on 12/06/2016.
 */
public class RecyclerAdapterLocal extends RecyclerView.Adapter<RecyclerAdapterLocal.LocalViewHolder> {

    List<Local> listlocal;

    public void setListLocal(List<Local> listlocal) {
        this.listlocal = listlocal;
    }

    @Override
    public LocalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.local_card,parent,false);
        LocalViewHolder holder = new LocalViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(LocalViewHolder holder, final int position) {
        holder.localTextView.setText(listlocal.get(position).getDe_sede());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            /*    System.out.printf("Selected position: %d%n", position);
                Intent itemIntent = new Intent(view.getContext(), DateActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("coDate", listDatesSchedule.get(position).getFe_atencion());
                itemIntent.putExtras(bundle);
                view.getContext().startActivity(itemIntent);*/

            }
        });
    }

    @Override
    public int getItemCount() {
        return listlocal.size();
    }

    public static class LocalViewHolder extends RecyclerView.ViewHolder {

        TextView localTextView;
        public LocalViewHolder(View itemView) {
            super(itemView);
            localTextView = (TextView) itemView.findViewById(R.id.localTextView);
        }
    }

}