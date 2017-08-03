package id.yuktanding.recycleview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NextScreen extends AppCompatActivity {
    TextView txtMessage, txtNama;
    ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtNama = (TextView) findViewById(R.id.txt_nama);
        txtMessage = (TextView) findViewById(R.id.txt_message);
        imgProfile = (ImageView) findViewById(R.id.profil);

        item item = getIntent().getParcelableExtra("ITM");
        imgProfile.setImageResource(item.getIdImage());
        txtMessage.setText(item.getPesan_terakhir());
        txtNama.setText(item.getNama());



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
