package com.kasiengao.ksgframe.ui.trainee;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.kaisengao.mvvm.base.activity.BaseVmActivity;
import com.kaisengao.mvvm.viewmodel.ToolbarViewModel;
import com.kasiengao.ksgframe.BR;
import com.kasiengao.ksgframe.R;
import com.kasiengao.ksgframe.databinding.ActivityTraineeBinding;
import com.kasiengao.ksgframe.ui.trainee.gesture.GestureActivity;
import com.kasiengao.ksgframe.ui.trainee.grid.TouchGridActivity;
import com.kasiengao.ksgframe.ui.trainee.loadpage.LoadPageActivity;
import com.kasiengao.ksgframe.ui.trainee.mvp.MvpActivity;
import com.kasiengao.ksgframe.ui.trainee.mvvm.MvvmActivity;
import com.kasiengao.ksgframe.ui.trainee.player.PlayerActivity;
import com.kasiengao.ksgframe.ui.trainee.retrofit.RxRetrofitActivity;
import com.kasiengao.ksgframe.ui.trainee.staggered.StaggeredGridActivity;

/**
 * @ClassName: TraineeActivity
 * @Author: KaiSenGao
 * @CreateDate: 2021/12/14 15:30
 * @Description: 长达好几年的练习生页面
 */
public class TraineeActivity extends BaseVmActivity<ActivityTraineeBinding, ToolbarViewModel> {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, TraineeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_trainee;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        // Toolbar Title
        this.setTitle(R.string.bar_trainee);
        // Mvp
        this.findViewById(R.id.trainee_mvp).setOnClickListener(this::onClick);
        // MvVM
        this.findViewById(R.id.trainee_mvvm).setOnClickListener(this::onClick);
        // Rx+Retrofit
        this.findViewById(R.id.trainee_rx_retrofit).setOnClickListener(this::onClick);
        // Staggered
        this.findViewById(R.id.trainee_staggered).setOnClickListener(this::onClick);
        // Player
        this.findViewById(R.id.trainee_player).setOnClickListener(this::onClick);
        // TouchGrid
        this.findViewById(R.id.trainee_touch_grid).setOnClickListener(this::onClick);
        // GestureView
        this.findViewById(R.id.trainee_gesture).setOnClickListener(this::onClick);
        // loadpage
        this.findViewById(R.id.trainee_loadpage).setOnClickListener(this::onClick);
    }

    /**
     * onClick
     *
     * @param v View
     */
    private void onClick(View v) {
        int id = v.getId();
        if (id == R.id.trainee_mvp) {
            this.startActivity(new Intent(this, MvpActivity.class));
        } else if (id == R.id.trainee_mvvm) {
            this.startActivity(new Intent(this, MvvmActivity.class));
        } else if (id == R.id.trainee_rx_retrofit) {
            this.startActivity(new Intent(this, RxRetrofitActivity.class));
        } else if (id == R.id.trainee_staggered) {
            this.startActivity(new Intent(this, StaggeredGridActivity.class));
        } else if (id == R.id.trainee_player) {
            this.startActivity(new Intent(this, PlayerActivity.class));
        } else if (id == R.id.trainee_touch_grid) {
            this.startActivity(new Intent(this, TouchGridActivity.class));
        } else if (id == R.id.trainee_gesture) {
            this.startActivity(new Intent(this, GestureActivity.class));
        } else if (id == R.id.trainee_loadpage) {
            this.startActivity(new Intent(this, LoadPageActivity.class));
        }
    }


}
