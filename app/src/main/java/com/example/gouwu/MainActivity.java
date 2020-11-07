package com.example.gouwu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<animal> mList = new ArrayList();
    private String[] name = { "小猫", "哈士奇", "小黄鸭","小鹿","老虎"};
    private int[]  imageId= { R.drawable.cat,R.drawable.siberiankusky,
            R.drawable.yellowduck,R.drawable.fawn, R.drawable.tiger};
    private String[] introduce = {
            "猫，属于猫科动物，分家猫、野猫，是全世界家庭中较为广泛的宠物。",
            "西伯利亚雪橇犬，常见别名哈士奇，昵称为二哈。",
            "鸭的体型相对较小，颈短，一些属的嘴要大些。腿位于身体后方，因而步态蹒跚。",
            "鹿科是哺乳纲偶蹄目下的一科动物。体型大小不等，为有角的反刍类。",
            "虎，大型猫科动物；毛色浅黄或棕黄色，满有黑色横纹；头圆、耳短，耳背面黑色，中央有一白斑甚显著；四肢健壮有力；尾粗长，具黑色环纹，尾端黑色。"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        init();
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new HomeAdapter(mList));
    }

    private void init(){
        for (int i = 0;i < 5;i++){
           animal animal = new animal(imageId[i],name[i],introduce[i]);
            mList.add(animal);
        }
    }


    class HomeAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private List<animal> mList;
        public HomeAdapter(List<animal> list){
            this.mList = list;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.recycler_item,null));

            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.iv.setImageResource(imageId[position]);
            holder.name.setText(name[position]);
            holder.introduce.setText(introduce[position]);
        }

        @Override
        public int getItemCount() {
            return name.length;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView introduce;
        ImageView iv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            introduce = itemView.findViewById(R.id.introduce);
            iv = itemView.findViewById(R.id.iv);

        }
    }
}