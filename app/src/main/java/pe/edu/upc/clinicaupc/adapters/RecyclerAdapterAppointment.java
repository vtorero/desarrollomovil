package pe.edu.upc.clinicaupc.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.clinicaupc.R;
import pe.edu.upc.clinicaupc.models.Appointment;


public class RecyclerAdapterAppointment extends RecyclerView.Adapter<RecyclerAdapterAppointment.AppointmentViewHolder> {
    List<Appointment> listAppointment;

    @Override
    public AppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_card,parent,false);
        AppointmentViewHolder holder = new AppointmentViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(AppointmentViewHolder holder, int position) {
        holder.specialityTextView.setText(listAppointment.get(position).getSpeciality());
        holder.doctorTextView.setText(listAppointment.get(position).getDoctor());
    }

    @Override
    public int getItemCount() {
        return listAppointment.size();
    }

    public static class AppointmentViewHolder extends RecyclerView.ViewHolder {

        TextView specialityTextView;
        TextView doctorTextView;
        TextView localTextView;
            public AppointmentViewHolder(View itemView) {
            super(itemView);
                specialityTextView = (TextView) itemView.findViewById(R.id.specialityTextView);
                doctorTextView = (TextView) itemView.findViewById(R.id.doctorTextView);
                localTextView = (TextView) itemView.findViewById(R.id.localTextView);

        }
    }

}
