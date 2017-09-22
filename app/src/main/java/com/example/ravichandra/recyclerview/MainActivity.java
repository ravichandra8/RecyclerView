package com.example.ravichandra.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CustomAdapter.ClickListener{

    RecyclerView rv;
    private RecyclerView.LayoutManager mLayoutManager;
    public CustomAdapter mAdapter;
   // String[] values={"ravi","suri","mani","karthik","praveen"};
    ArrayList<String> val=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val.add("ravi");
        val.add("srivani");
        val.add("pooja");
        val.add("chandra");
        val.add("pandu");

        rv=(RecyclerView)findViewById(R.id.rv);
        //doesnot change the layout size
        rv.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new CustomAdapter(val,this);
        mAdapter.setClickListener(this);
        rv.setAdapter(mAdapter);
    }


    @Override
    public void itemClicked(View v, int position) {
     Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();
    }
}
