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
 * Created by weval_000 on 13/06/2016.
 */
public class RecyclerAdapterHour extends RecyclerView.Adapter<RecyclerAdapterHour.HourScheduleViewHolder>  {

    List<Schedule> listHoursSchedule;

    public void setListHoursSchedule(List<Schedule> listHoursSchedule) {
        this.listHoursSchedule = listHoursSchedule;
    }

    @Override
    public HourScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hour_card,parent,false);
        HourScheduleViewHolder holder = new HourScheduleViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(HourScheduleViewHolder holder, final int position) {
        holder.hourScheduleTextView.setText(listHoursSchedule.get(position).getHo_atencion());
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
        return listHoursSchedule.size();
    }

    public static class HourScheduleViewHolder extends RecyclerView.ViewHolder {

        TextView hourScheduleTextView;
        public HourScheduleViewHolder(View itemView) {
            super(itemView);
            hourScheduleTextView = (TextView) itemView.findViewById(R.id.hourScheduleTextView);
        }
    }


}
