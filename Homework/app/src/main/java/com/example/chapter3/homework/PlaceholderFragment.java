package com.example.chapter3.homework;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment{

    private ListView friendListView;
    private LottieAnimationView loadingView;
    private List<String> friendList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        friendListView = view.findViewById(R.id.lv_friends);
        for (int i = 0; i < 20; i++) {
            friendList.add("好友" + i);
        }
        friendListView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, friendList));
        loadingView = view.findViewById(R.id.load_view);
        friendListView.setVisibility(View.INVISIBLE);
        loadingView.setVisibility(View.VISIBLE);
        loadingView.setRepeatCount(LottieDrawable.INFINITE);
        loadingView.playAnimation();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                loadingView.pauseAnimation();
                ObjectAnimator animFadeOut = ObjectAnimator.ofFloat(loadingView, "alpha", 1.0f, 0);
                animFadeOut.setDuration(1000);
                animFadeOut.start();
                ObjectAnimator animFadeIn = ObjectAnimator.ofFloat(friendListView, "alpha", 0, 1.0f);
                animFadeIn.setDuration(1000);
                animFadeIn.start();
                friendListView.setVisibility(View.VISIBLE);
            }
        }, 5000);
    }
}
