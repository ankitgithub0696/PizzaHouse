package com.pizzahouse.pizzahouse;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>{

    ArrayList<RecyclerviewStructure> arrayList;

    public RecyclerviewAdapter(ArrayList<RecyclerviewStructure> arrayList,Context context) {

        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public RecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.pizzahousestructure, parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.ViewHolder holder,int position) {

        RecyclerviewStructure clicked=arrayList.get(position);

            int image=arrayList.get(position).getImageicon();
            String nametext=arrayList.get(position).getProductname();
            String pricetext=arrayList.get(position).getProductprice();

            holder.setdata(image,nametext,pricetext);


           holder.cardView.setOnClickListener(new View.OnClickListener() {
               @Override

               public void onClick(View view) {
                    Context context=view.getContext();
                    Intent intent=new Intent();

                    switch(position)
                    {
                        case 0:
                            intent=new Intent(context,PizzalistActivity.class);
                            intent.putExtra("Imagename",clicked.getImageicon());
                            intent.putExtra("name",clicked.getProductname());
                            intent.putExtra("price",clicked.getProductprice());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                            break;

                        case 1:
                            intent =new Intent(context,Puddingprice.class);
                            intent.putExtra("Imagename",clicked.getImageicon());
                            intent.putExtra("name",clicked.getProductname());
                            intent.putExtra("price",clicked.getProductprice());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                            break;
                    }
               }
           });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.icon);
            text1=itemView.findViewById(R.id.name);
            text2=itemView.findViewById(R.id.price);
            cardView=itemView.findViewById(R.id.cardview);


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context=view.getContext();
                    Intent intent=new Intent();
                    {

                    }
                }
            });

        }

        public void setdata(int image, String nametext, String pricetext)
        {
            imageView.setImageResource(image);
            text1.setText(nametext);
            text2.setText(pricetext);
        }
    }
}
