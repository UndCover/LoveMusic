package com.undcover.lovemusic.support;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.undcover.lovemusic.util.UtilsScreen;

/**
 * Created by UndCover on 10/31/17.
 */

public class MarginDecoration extends RecyclerView.ItemDecoration {
    private int ml, mt, mr, mb;

    public MarginDecoration(Context context) {
        this(context, 0, 0, 0, 0);
    }

    public MarginDecoration(Context context, float margin) {
        this(context, margin, margin, margin, margin);
    }

    public MarginDecoration(Context context, float horizontal, float vertical) {
        this(context, horizontal, vertical, horizontal, vertical);
    }

    public MarginDecoration(Context context, float pl, float pt, float pr, float pb) {
        ml = UtilsScreen.dip2px(context, pl);
        mt = UtilsScreen.dip2px(context, pt);
        mr = UtilsScreen.dip2px(context, pr);
        mb = UtilsScreen.dip2px(context, pb);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(ml, mt, mr, mb);
    }
}
