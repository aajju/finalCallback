package com.choisroyalfamily.massivcode.finalcallback;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by massivcode@gmail.com on 2017. 3. 13. 15:47
 */

public class MemoFragment extends Fragment implements RecyclerItemClickListener {

    private FragmentToActivityListener mListener;
    private MemoAdapter mAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (FragmentToActivityListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_memo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new MemoAdapter(this);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);

        view.findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onAddButtonClicked();
                }
            }
        });
    }

    public void onMemoAdded(Memo memo) {
        mAdapter.addMemo(memo);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(getContext(), "클릭한 아이템의 위치: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onImageViewClicked(View view, int position) {
        Toast.makeText(getContext(), "클릭한 이미지뷰의 위치: " + position, Toast.LENGTH_SHORT).show();
    }
}
