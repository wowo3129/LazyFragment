package per.goweii.android.lazyfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import per.goweii.lazyfragment.LazyFragment;

public class Test2Fragment extends LazyFragment {

    public static final String TAG = Test2Fragment.class.getSimpleName();
    private String name;

    public static Test2Fragment newInstance(String name) {
        Test2Fragment fragment = new Test2Fragment();
        Bundle args = new Bundle(1);
        args.putString("name", name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_test2;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = getArguments().getString("name");
        TextView tv_name = findViewById(R.id.tv_name);
        tv_name.setText(name);
    }

    @Override
    public void onVisible(boolean isFirstVisible) {
        super.onVisible(isFirstVisible);
        MainActivity.log(name + " onVisible : isFirstVisible=" + isFirstVisible);
    }

    @Override
    public void onInvisible() {
        super.onInvisible();
        MainActivity.log(name + " onInvisible");
    }
}
