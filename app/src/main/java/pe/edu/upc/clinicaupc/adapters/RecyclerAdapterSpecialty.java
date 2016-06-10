package pe.edu.upc.clinicaupc.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.clinicaupc.R;
import pe.edu.upc.clinicaupc.models.Appointment;
import pe.edu.upc.clinicaupc.models.Specialty;

/**
 * Created by vjimenez on 10/06/2016.
 */

public class RecyclerAdapterSpecialty extends RecyclerView.Adapter<RecyclerAdapterSpecialty.SpecialtyViewHolder> {
    List<Specialty> listSpecialty;

    public void setListSpecialty(List<Specialty> listSpecialty) {
        this.listSpecialty = listSpecialty;
    }

    @Override
    public SpecialtyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_specialty,parent,false);
        SpecialtyViewHolder holder = new SpecialtyViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(SpecialtyViewHolder holder, int position) {
        holder.co_espcialty.setText(listSpecialty.get(position).getCo_especilidad());
        holder.de_specialty.setText(listSpecialty.get(position).getDe_especialidad());
    }

    @Override
    public int getItemCount() {
        return listSpecialty.size();
    }

    public static class SpecialtyViewHolder extends RecyclerView.ViewHolder {

        TextView co_espcialty;
        TextView de_specialty;

        public SpecialtyViewHolder(View itemView) {
            super(itemView);
            co_espcialty = (TextView) itemView.findViewById(R.id.coEspecialidad);
            de_specialty = (TextView) itemView.findViewById(R.id.de_especialidad);


        }
    }

}
