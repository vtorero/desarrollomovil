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
import pe.edu.upc.clinicaupc.activities.DoctorActivity;
import pe.edu.upc.clinicaupc.models.Appointment;


public class RecyclerAdapterAppointment extends RecyclerView.Adapter<RecyclerAdapterAppointment.AppointmentViewHolder> {
    List<Appointment> listAppointment;

    public void setListAppointment(List<Appointment> listAppointment) {
        this.listAppointment = listAppointment;
    }
    @Override
    public AppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_card,parent,false);
        AppointmentViewHolder holder = new AppointmentViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(AppointmentViewHolder holder, final int position) {
        holder.specialityTextView.setText(listAppointment.get(position).getDe_especialidad());
        holder.fechaTextView.setText(listAppointment.get(position).getFe_reserva());
        holder.localTextView.setText(listAppointment.get(position).getDe_sede());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 System.out.printf("Selected position: %d%n", position);
                 Intent itemIntent = new Intent(view.getContext(), CancelActivity.class);
                 Bundle bundle = new Bundle();
                 bundle.putString("co_reserva", listAppointment.get(position).getCo_reserva());
                 itemIntent.putExtras(bundle);
                 view.getContext().startActivity(itemIntent);
                 **/
            }
        });
    }

    @Override
    public int getItemCount() {
        return listAppointment.size();
    }

    public static class AppointmentViewHolder extends RecyclerView.ViewHolder {

        TextView specialityTextView;
        TextView fechaTextView;
        TextView localTextView;
        public AppointmentViewHolder(View itemView) {
            super(itemView);
            specialityTextView = (TextView) itemView.findViewById(R.id.specialityTextView);
            fechaTextView = (TextView) itemView.findViewById(R.id.fechaTextView);
            localTextView = (TextView) itemView.findViewById(R.id.localTextView);

        }
    }

}
