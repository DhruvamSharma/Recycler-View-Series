package com.dhruvam.recyclerviewseries.data;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable mDivider;

    public DividerItemDecoration(Drawable divider) {
        mDivider = divider;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        //We do not want to add any padding for the first child
        //Because we do not want to have any unwanted space above the
        //Recycler view
        if(parent.getChildAdapterPosition(view) == 0) {
            return;
        }

        //For every child, add some padding on the top
        //Intrinsic height method returns the actual size of the image
        //If the image size is 500*345 and you set in the XML
        //That the image view height and width is 200*200.
        //The when you call getIntrinsicHeight you get 500 and not 200
        //But when you call getHeight, you'll get 200.
        outRect.top = mDivider.getIntrinsicHeight();
    }

    /**
     * Called only once.
     * This method is used for deciding the bounds of the divider. Meaning
     * We decide where the divider is to be drawn and how.
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);

        //Divider Left is the distance of the child view from the parent
        //And dividerRight is the distance from the parent's left to the
        //right and -32 because we want the divider to be drawn with a padding
        // of 32 on the right too.
        int dividerLeft = 32;
        int dividerRight = parent.getWidth() - 32;

        //this is done for top and bottom divider for every view
        //This is because it is different for each view
        for (int i = 0; i < parent.getChildCount() ;i ++) {
            //This is done so that at the bottom of the last child
            //We don't want a divider there.
            if( i != parent.getChildCount() - 1) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                //Calculating the distance of the divider to be drawn from top
                int dividerTop = child.getBottom() + params.bottomMargin;
                int dividerBottom = dividerTop + mDivider.getIntrinsicHeight();

                mDivider.setBounds(dividerLeft, dividerTop, dividerRight,dividerBottom);
                mDivider.draw(c);
            }

        }
    }
}
