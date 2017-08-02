package id.yuktanding.recycleview;

/*  Step Ketujuh RecyclerView: Buat Class Adapter untuk RecyclerView*/
/*  1. Buat Class ItemAdapter*/

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Akise on 01/08/2017.
 */
    /*  2. extends RecyclerView.Adapter<NamaAdapter.NamaViewHolder>*/
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder>{

    /*  2. extends RecyclerView.Adapter*/

    private Context context;
    public static final String PROFIL = "PROFIL";
    public static final String NAMA = "NAMA";
    public static final String PESAN = "PESAN";

    /*  3. Buat Variabel untuk menyimpan data dari activity utama*/
    private ArrayList<item> items;
    /*  3. Buat Variabel untuk menyimpan data dari activity utama*/


    /*  4. Buat Constructor Adapter*/
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 6. Set data Nama ViewHolder, onBindViewHolder, getItemCount
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        // fungsi inflate => buat objek view baru ngambil data dari parent
        // 6. Set data Nama ViewHolder, onBindViewHolder, getItemCount


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // 6. Set data Nama ViewHolder, onBindViewHolder, getItemCount
        item item2 = items.get(position);
        holder.name.setText(item2.getNama());
        holder.lastMesage.setText(item2.getPesan_terakhir());
        holder.profile.setImageResource(item2.getIdImage());
        // 6. Set data Nama ViewHolder, onBindViewHolder, getItemCount

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Adapter", "Clicked Position: " + position);
                nextScreen(position);

            }
        });

        holder.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Adapter", "Profile Clicked " + position);
                profileScreen(position);
            }
        });
    }

    @Override //pengulangan sebanyak data yang terdapat di arraylist
    public int getItemCount() {
        return items.size();// 6. Set data Nama ViewHolder, onBindViewHolder, getItemCount
    }
    /*  4. Buat Constructor Adapter*/


    /*  5. Buat class nama ViewHolder*/
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, lastMesage;
        ImageView profile;

        public MyViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.contact_name);
            lastMesage = (TextView) view.findViewById(R.id.last_message);
            profile = (ImageView) view.findViewById(R.id.contact_image);
        }
    }
    /*  5. Buat class nama ViewHolder*/

    public ItemAdapter(ArrayList<item> itemArrayList, Context context){
        Log.d("Item Adapter", "Item Adapter");
        this.items = itemArrayList;
        this.context = context; // Tambah Context karena class ini tidak memiliki Contex
    }

    public void nextScreen(int position){
        Intent intent = new Intent(context, NextScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("ITM", items.get(position));
        Log.d("Item Adapter", "Open Next Screen: " + position);
        context.startActivity(intent);
    }

    public void profileScreen(int position){
        Intent intent = new Intent(context, ProfileScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        Log.d("Item Adapter", "Open Profile Screen: " + position);
        context.startActivity(intent);
    }
}

/*  Step Ketujuh RecyclerView: Buat Class Adapter untuk RecyclerView*/
/*  1. Buat Class ItemAdapter*/