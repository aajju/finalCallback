package com.choisroyalfamily.massivcode.finalcallback;

import android.view.View;

/**
 * Created by massivcode@gmail.com on 2017. 3. 13. 15:56
 */

public interface RecyclerItemClickListener {
    void onItemClicked(int position);

    void onImageViewClicked(View view, int position);
}
