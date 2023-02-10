package com.example.queenvisionv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private DisplayInfo activity;
    private List<Model> mList;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();



    public MyAdapter(DisplayInfo activity, List<Model> mList){
        this.activity = activity;
        this.mList = mList;

    }

    public void updateData(int position){

        Model item = mList.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("uId", item.getId());
        bundle.putString("uName", item.getName());
        bundle.putString("uLastname", item.getLastname());
        bundle.putString("uAge", item.getAge());
        bundle.putString("uCellnumber", item.getCell());
        bundle.putString("uGrade", item.getGrade());
        bundle.putString("uCity", item.getCity());
        bundle.putString("uTopofinterest", item.getTopicofinterest());
        Intent intent = new Intent(activity, Enroll.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public void deleteData(int position){

        Model item = mList.get(position);
        db.collection("Documents").document(item.getId()).delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            notifyRemoved(position);
                            Toast.makeText(activity, "Booking has been successfully deleted", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(activity, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void notifyRemoved(int position){

        mList.remove(position);
        notifyItemRemoved(position);
        activity.showData();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(mList.get(position).getName());
        holder.lastname.setText(mList.get(position).getLastname());
        holder.age.setText(mList.get(position).getAge());
        holder.cell.setText(mList.get(position).getCell());
        holder.grade.setText(mList.get(position).getGrade());
        holder.city.setText(mList.get(position).getCity());
        holder.topicofinterest.setText(mList.get(position).getTopicofinterest());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, lastname, age, cell, grade, city, topicofinterest;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_text);
            lastname = itemView.findViewById(R.id.lastname_text);
            age = itemView.findViewById(R.id.age_text);
            cell = itemView.findViewById(R.id.cell_text);
            grade = itemView.findViewById(R.id.grade_text);
            city = itemView.findViewById(R.id.city_text);
            topicofinterest = itemView.findViewById(R.id.topofinterest_text);
        }
    }
}
