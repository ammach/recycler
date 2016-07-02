package com.example.ammach.recycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        List<String> data;
        LayoutInflater layoutInflater;

        public MyAdapter(List<String> data) {
            layoutInflater=LayoutInflater.from(MainActivity.this);
            this.data=data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View row=layoutInflater.inflate(R.layout.row,parent,false);
            MyViewHolder myViewHolder=new MyViewHolder(row);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            holder.textView.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> countries=new ArrayList<>();
        countries.add("maroc");
        countries.add("tunis");
        countries.add("lybie");
        countries.add("alger");
        countries.add("mauritanie");

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        MyAdapter myAdapter=new MyAdapter(countries);
        recyclerView.setAdapter(myAdapter);

    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.txt);
        }
    }
}
