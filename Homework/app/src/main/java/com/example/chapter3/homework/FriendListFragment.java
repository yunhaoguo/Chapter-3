package com.example.chapter3.homework;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

/**
 * Author: yunhaoguo
 * Date: 2019-07-25
 * Friend list fragment which will load before showing the friend list
 */

public class FriendListFragment extends Fragment implements ILoadingFragment{

    private static final int LOADING_TIME = 5000;

    private Handler handler = new Handler();
    private LinearLayout friendListView;
    private LottieAnimationView loadingView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friendlist, container, false);
        initView(view);
        loadAndShow();
        return view;
    }

    private void initView(View view) {
        friendListView = view.findViewById(R.id.ll_friends);
        loadingView = view.findViewById(R.id.load_view);
    }

    @Override
    public void loadAndShow() {
        friendListView.setVisibility(View.INVISIBLE);
        loadingView.setVisibility(View.VISIBLE);
        loadingView.setRepeatCount(LottieDrawable.INFINITE);
        loadingView.playAnimation();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingView.pauseAnimation();
                loadingView.setVisibility(View.INVISIBLE);
                ObjectAnimator animator = ObjectAnimator.ofFloat(friendListView, "alpha", 0, 1.0f);
                animator.setDuration(1000);
                animator.start();
                friendListView.setVisibility(View.VISIBLE);
            }
        }, LOADING_TIME);
    }
    
}
