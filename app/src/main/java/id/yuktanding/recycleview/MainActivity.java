package id.yuktanding.recycleview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    /*  Step Ketiga RecyclerView: Buat Kumpulan data      */

    ArrayList<item> itemArrayList; //1. Buat Variabel Array list

    /*  Step Ketiga RecyclerView*/
    private int i=0;
    private static String[] dataNama = {"Akise1","Akise2","Lontong"};


    /*  Step Keempat RecyclerView: findViewById-kan RecyclerView */

    RecyclerView recyclerView; //1. Buat Variabel recyclerView

    /*  Step Keempat RecyclerView: findViewById-kan RecyclerView */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.d(TAG, "App Started");

        /*  Step Ketiga RecyclerView
        Buat Kumpulan data
        2. Buat data seperti dibawah*/
//        dataNama[2]="Petis";
        itemArrayList = new ArrayList<>();
        for (String nama:dataNama){
            itemArrayList.add(new item(""+dataNama[i], "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
            i++;
            Log.d(TAG, nama);
        }

//        itemArrayList.add(new item("Akise2", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise3", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise4", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise5", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise6", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise7", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise8", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise9", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise10", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise11", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise12", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise13", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise14", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise15", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise16", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise17", "Terimakasih Untuk Segalanya", R.drawable.yuklogo));
//        itemArrayList.add(new item("Akise18", "Terimakasih Untuk Segalanya", R.mipmap.ic_launcher_round));
        /*  Step Ketiga RecyclerView*/

        /*  Step Keempat RecyclerView: findViewById-kan RecyclerView */
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view); // 2
        /*  Step Keempat RecyclerView: findViewById-kan RecyclerView */

        /*  Step Kelima RecyclerView: Buat Layout Manager */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        /*  Step Kelima RecyclerView: Buat Layout Manager */

        /*  Step Keenam RecyclerView: setLayoutManager ke recycleView*/
        recyclerView.setLayoutManager(linearLayoutManager);
        /*  Step Keenam RecyclerView: setLayoutManager ke recycleView*/

        /*  Step Kedelapan RecyclerView: buat objek dari adapter yang telah dibuat*/
        ItemAdapter itemAdapter = new ItemAdapter(itemArrayList, this);
        /*  Step Kedelapan RecyclerView: buat objek dari adapter yang telah dibuat*/

        /*  Step Kesembilan RecyclerView: Set objek adapter yang sudah dibuat*/
        recyclerView.setAdapter(itemAdapter);
        /*  Step Kesembilan RecyclerView: Set objek adapter yang sudah dibuat*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_settings:
                Log.d(TAG, "setting");
                return true;
            case R.id.action_faq:
                Log.d(TAG, "FAQ");
                return true;
            case R.id.action_logout:
                Log.d(TAG, "Logout");
                return true;
            default: break;
        }

//        if (id == R.id.action_settings) {
//            return true;
//        }
//        else if (id == R.id.action_faq){
//
//        }

        return super.onOptionsItemSelected(item);
    }


}
