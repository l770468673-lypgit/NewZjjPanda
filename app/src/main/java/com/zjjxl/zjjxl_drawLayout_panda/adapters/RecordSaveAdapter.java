package com.zjjxl.zjjxl_drawLayout_panda.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.heyue.adpu_manager.module.BalanceRecordBean;
import com.zjjxl.zjjxl_drawLayout_panda.R;
import com.zjjxl.zjjxl_drawLayout_panda.drawlay.Drive_RecordActivty;

import java.util.List;


public class RecordSaveAdapter extends RecyclerView.Adapter<RecordSaveAdapter.ViewHolder> {

    private List<BalanceRecordBean> Mextra;
    private Context mContext;

    public RecordSaveAdapter(Drive_RecordActivty drivact) {
        mContext = drivact;
    }

    public void setDate(List<BalanceRecordBean> recordList) {
        this.Mextra = recordList;
    }

    @NonNull
    @Override
    public RecordSaveAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recordsaveadapteritem, parent, false);
        return new RecordSaveAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordSaveAdapter.ViewHolder holder, int position) {
        BalanceRecordBean balanceRecordBean = Mextra.get(position);

        String money = balanceRecordBean.money;
        int type = balanceRecordBean.type;
        String cardIndex = balanceRecordBean.cardIndex;
        String time = balanceRecordBean.time;
        if (type == 0) {
            holder.type.setText("存入");
            holder.money.setTextColor(Color.parseColor("#FF0000"));
        } else {
            holder.type.setText("支出");
            holder.money.setTextColor(Color.parseColor("#00FBFF"));
        }

        holder.time.setText(time);
        holder.money.setText(money);
    }

    @Override
    public int getItemCount() {
        return Mextra != null ? Mextra.size() : 0;
    }

    public void setData(List<BalanceRecordBean> recordList) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView type;
        private TextView money;
        private TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            money = itemView.findViewById(R.id.money);
            time = itemView.findViewById(R.id.time);

        }
    }
}
