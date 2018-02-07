package chandu.oyo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Chandu on 2/7/2018.
 */

public class AnimationUtil {

    public static void animate(RecyclerView.ViewHolder holder, boolean goesdown){
        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(holder.itemView,"translationY",goesdown == true ? 200 : -200,0);
        objectAnimator.setDuration(1000);

        animatorSet.playTogether(objectAnimator);
        animatorSet.start();
    }
}
