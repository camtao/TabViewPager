package com.lianqi.union.tabviewpager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * Created by Administrator on 2016/6/22.
 */
public class PageFragment extends BasePageFragment{

    private String title;
    private TextView tv;

    public static PageFragment newInstance(String title){
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putString("key_fragment_title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("key_fragment_title");
        Log.d("test",title + ":onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("test",title + ":onCreateView");
        View view = inflater.inflate(R.layout.fragment_layout, null);
        tv = (TextView) view.findViewById(R.id.tv);
        tv.setText(title);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("test",title + ":onResume");
    }

    @Override
    public void fetchData() {
        /** * 在这里请求网络。 */
        Log.i("test",title+"请求网络");
    }

}
