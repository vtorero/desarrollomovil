package pe.edu.upc.clinicaupc.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.clinicaupc.R;
import pe.edu.upc.clinicaupc.models.Schedule;

/**
 * Created by weval_000 on 12/06/2016.
 */
public class RecyclerAdapterDate extends RecyclerView.Adapter<RecyclerAdapterDate.DateScheduleViewHolder> {

    List<Schedule> listDatesSchedule;

    public void setListDatesSchedule(List<Schedule> listDatesSchedule) {
        this.listDatesSchedule = listDatesSchedule;
    }

    @Override
    public DateScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_card,parent,false);
        DateScheduleViewHolder holder = new DateScheduleViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(DateScheduleViewHolder holder, final int position) {
        holder.dateScheduleTextView.setText(listDatesSchedule.get(position).getFe_atencion());
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
        return listDatesSchedule.size();
    }

    public static class DateScheduleViewHolder extends RecyclerView.ViewHolder {

        TextView dateScheduleTextView;
        public DateScheduleViewHolder(View itemView) {
            super(itemView);
            dateScheduleTextView = (TextView) itemView.findViewById(R.id.dateScheduleTextView);
        }
    }

}
