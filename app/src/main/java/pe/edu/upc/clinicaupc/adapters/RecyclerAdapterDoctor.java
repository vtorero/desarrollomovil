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
import pe.edu.upc.clinicaupc.activities.DateActivity;
import pe.edu.upc.clinicaupc.activities.LocalActivity;
import pe.edu.upc.clinicaupc.models.Doctor;


/**
 * Created by vjimenez on 01/06/2016.
 */
public class RecyclerAdapterDoctor extends RecyclerView.Adapter<RecyclerAdapterDoctor.DoctorViewHolder> {
    List<Doctor> listadoctor;

    public void setListaDoctor(List<Doctor> listadoctor) {
        this.listadoctor= listadoctor;
    }
    @Override

    public DoctorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_doctor,parent,false);
        DoctorViewHolder holder = new DoctorViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(DoctorViewHolder holder, final int position) {
        holder.nombredoctor.setText(listadoctor.get(position).getDe_nombreCompleto());
        holder.codigo.setText(listadoctor.get(position).getCo_medico());
        holder.especialidad.setText(listadoctor.get(position).getCo_especialidad());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.printf("Selected position: %d%n", position);
                Intent itemIntent = new Intent(view.getContext(), LocalActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("coDoctor", listadoctor.get(position).getCo_medico());
                itemIntent.putExtras(bundle);
                view.getContext().startActivity(itemIntent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listadoctor.size();
    }

    public static class DoctorViewHolder extends RecyclerView.ViewHolder {

        TextView nombredoctor;
        TextView codigo;
        TextView especialidad;
        public DoctorViewHolder(View itemView) {
            super(itemView);
            nombredoctor = (TextView) itemView.findViewById(R.id.nameTextView);
            codigo = (TextView) itemView.findViewById(R.id.codigo);
            especialidad = (TextView) itemView.findViewById(R.id.especialidad);


        }
    }

}
