package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

public class ZoomNeighbourActivity extends AppCompatActivity {
    private ImageView mZoomAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        Log.e( "TAG", "Je rentre dans zoomActivity" );
        setContentView( R.layout.activity_zoom_neighbour );
        Neighbour neighbour = (Neighbour) getIntent().getSerializableExtra( "NEIGHBOUR" );
        Log.e( "TAG3", "nom : " + neighbour.getName() );


        mZoomAvatar = (ImageView) findViewById( R.id.zoom_avatar );
        Glide.with(this)
                .load(neighbour.getAvatarUrl())
                .into(mZoomAvatar);
    }

    public void Back(View v) {
        //pour retourner a l’activite principale il suffit seulement d’appler la methode finish() qui va tuer cette activite
        finish() ;

    }
}