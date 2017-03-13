package com.choisroyalfamily.massivcode.finalcallback;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by massivcode@gmail.com on 2017. 3. 13. 15:53
 */

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.MemoViewHolder> {

    private List<Memo> mData = new ArrayList<>();
    private RecyclerItemClickListener mListener;

    public MemoAdapter(RecyclerItemClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public MemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memo, parent, false);
        return new MemoViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(MemoViewHolder holder, int position) {
        Memo item = mData.get(position);

        holder.mTitleTextView.setText(item.getTitle());
        holder.mContentsTextView.setText(item.getContents());
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void addMemo(Memo memo) {
        mData.add(memo);
        notifyItemInserted(mData.size());
    }

    public class MemoViewHolder extends RecyclerView.ViewHolder {
        TextView mTitleTextView, mContentsTextView;
        ImageView mImageView;

        public MemoViewHolder(View itemView, final RecyclerItemClickListener listener) {
            super(itemView);

            mTitleTextView = (TextView) itemView.findViewById(R.id.item_title_tv);
            mContentsTextView = (TextView) itemView.findViewById(R.id.item_contents_tv);
            mImageView = (ImageView) itemView.findViewById(R.id.item_iv);

            if (listener != null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onItemClicked(getAdapterPosition());
                    }
                });

                mImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onImageViewClicked(view, getAdapterPosition());
                    }
                });
            }
        }
    }
}
