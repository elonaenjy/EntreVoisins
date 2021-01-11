package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

public class ZoomNeighbourActivity extends AppCompatActivity {
    private ImageView mZoomAvatar;
    private TextView mZoomNom;
    Toolbar toolbar;
    Menu zoom_menu;
    AppBarLayout appBarLayoutZoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_zoom_neighbour );
        Neighbour neighbour = (Neighbour) getIntent().getSerializableExtra( "NEIGHBOUR" );
        Log.e( "TAG3", "nom : " + neighbour.getName() );

        mZoomAvatar = findViewById( R.id.zoom_avatar );
        Glide.with( this )
                .load( neighbour.getAvatarUrl() )
                .into( mZoomAvatar );

        appBarLayoutZoom = findViewById( R.id.app_bar_zoom );
        toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled( false );

        toolbar.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.zoom_menu = menu;
        getMenuInflater().inflate( R.menu.zoom_menu, menu );
        hideShowFAB();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.favorit_zoom) {
            return true;
        }
        return super.onOptionsItemSelected( item );
    }

    public void hideShowFAB() {
        appBarLayoutZoom.addOnOffsetChangedListener( new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                MenuItem menuItem = zoom_menu.findItem( R.id.favorit_zoom );
                if (Math.abs( verticalOffset ) == appBarLayout.getTotalScrollRange()) {
                    menuItem.setVisible( true );
                } else if (verticalOffset == 0) {
                    menuItem.setVisible( false );
                }
            }
        } );

    }
}



