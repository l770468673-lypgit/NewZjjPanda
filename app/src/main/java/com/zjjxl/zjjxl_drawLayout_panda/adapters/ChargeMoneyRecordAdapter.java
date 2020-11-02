package com.zjjxl.zjjxl_drawLayout_panda.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zjjxl.zjjxl_drawLayout_panda.R;
import com.zjjxl.zjjxl_drawLayout_panda.beans.ChargeMoneyRecordbean;
import com.zjjxl.zjjxl_drawLayout_panda.drawlay.ChargeMoneyRecord;
import com.zjjxl.zjjxl_drawLayout_panda.utils.LUtils;
import com.zjjxl.zjjxl_drawLayout_panda.utils.ToastUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ChargeMoneyRecordAdapter extends RecyclerView.Adapter<ChargeMoneyRecordAdapter.ViewHolder> {

    private List<ChargeMoneyRecordbean.DataBean> Mextra;
    private Context mContext;
    private SkuInterface myItemClick;

    public interface SkuInterface {
        //
        void setdatestate(int pos, int state);

        //
        void setdatecircleState(int pos, int state);

    }

    public void setOnItemClick(SkuInterface myItemClick) {
        this.myItemClick = myItemClick;
    }

    public ChargeMoneyRecordAdapter(ChargeMoneyRecord drivact) {
        mContext = drivact;
    }

    public void setDate(List<ChargeMoneyRecordbean.DataBean> recordList) {
        this.Mextra = recordList;
    }


    @NonNull
    @Override
    public ChargeMoneyRecordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chargemoneyrecordadapteritem, parent, false);
        return new ChargeMoneyRecordAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChargeMoneyRecordAdapter.ViewHolder holder, int position) {
        ChargeMoneyRecordbean.DataBean dataBean = Mextra.get(position);
        int state = dataBean.getState();
        int circleState = dataBean.getCircleState();
        //"state": 1, // 1待付款、2已付款、3已付款待写卡、4付款成功、5退款中、6退款成功、7退款失败
//        circleState -1 未知 1 圈存成功 2圈存失败
        if (state == 1) {
            holder.charge_type_tv.setText("待付款");
            holder.charge_type_cir.setVisibility(View.GONE);
        } else if (state == 2) {
            holder.charge_type_tv.setText("已付款");
            holder.charge_type_cir.setVisibility(View.VISIBLE);
            if (circleState == -1) {
                holder.charge_type_cir.setText("未圈存");
            } else if (circleState == 1) {
                holder.charge_type_cir.setText("圈存成功");
                holder.charge_type_tv.setVisibility(View.GONE);

            } else if (circleState == 2) {
                holder.charge_type_cir.setText("圈存失败");
            }
        } else if (state == 6) {
            holder.charge_type_tv.setText("退款成功");
            holder.charge_type_cir.setVisibility(View.GONE);
        }


        holder.charge_type_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LUtils.d("tag", "charge_type_tv==" + position + state + "");
                //支付状态
                if (state == 1) {
                    // 去支付
                    myItemClick.setdatestate(position, 1);
                } else if (state == 2) {
                    // 退款
                    myItemClick.setdatestate(position, 2);
                }
            }
        });
        holder.charge_type_cir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (circleState == -1 || circleState == 2) {
                    myItemClick.setdatecircleState(position, 1);
                }else {
                    ToastUtils.showToast(mContext, "订单已关闭");
                }

            }
        });
        holder.charge_money_tv.setText(dataBean.getTradeAmount() + "元");
        holder.charge_card_tv.setText(dataBean.getCardNo().length() > 0 ? dataBean.getCardNo() : "暂无卡号");
        holder.charge_date_tv.setText(dataBean.getCreateTime());
        holder.charge_money_tv.setTextColor(Color.parseColor("#313335"));
        holder.charge_type_cir.setTextColor(Color.parseColor("#0064FF"));
        holder.charge_type_tv.setTextColor(Color.parseColor("#0064FF"));


    }

    @Override
    public int getItemCount() {
        return Mextra != null ? Mextra.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView charge_money_tv;
        private TextView charge_date_tv;
        private TextView charge_type_tv;
        private TextView charge_type_cir;
        private TextView charge_card_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            charge_type_cir = itemView.findViewById(R.id.charge_type_cir);
            charge_money_tv = itemView.findViewById(R.id.charge_money_tv);
            charge_date_tv = itemView.findViewById(R.id.charge_date_tv);
            charge_type_tv = itemView.findViewById(R.id.charge_type_tv);
            charge_card_tv = itemView.findViewById(R.id.charge_card_tv);
        }
    }
}
