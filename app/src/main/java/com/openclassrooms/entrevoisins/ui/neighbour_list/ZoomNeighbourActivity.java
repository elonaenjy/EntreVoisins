package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

/**
 *
 */
public class ZoomNeighbourActivity extends AppCompatActivity {
    int mId;
    String nom;
    ImageView mZoomAvatar;
    Boolean isFavorite;
    private Neighbour neighbour;
    private NeighbourApiService mFavApiService;
    private FloatingActionButton fab;
    private TextView mZoomNom2;
    private TextView mZoomLocalisation;
    private TextView mZoomPhone;
    private TextView mZoomReseau;
    private TextView mZoomAboutMe;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            mFavApiService = DI.getNeighbourApiService();
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_zoom_neighbour );
            Toolbar toolbar = findViewById( R.id.toolbar );
            setSupportActionBar( toolbar );
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );

            Neighbour neighbour = (Neighbour) getIntent().getSerializableExtra( "NEIGHBOUR" );

            mZoomAvatar = (ImageView) findViewById( R.id.zoom_avatar );
            mZoomNom2 = (TextView) findViewById( R.id.zoom_nom2 );
            mZoomLocalisation = (TextView) findViewById( R.id.zoom_localisation );
            mZoomPhone = (TextView) findViewById( R.id.zoom_phone );
            mZoomReseau = (TextView) findViewById( R.id.zoom_reseau );
            mZoomAboutMe = (TextView) findViewById( R.id.zoom_about_me );

            Glide.with( this )
                    .load( neighbour.getAvatarUrl() )
                    .into( mZoomAvatar );

            CollapsingToolbarLayout collapsingToolbar = findViewById( R.id.toolbar_layout_zoom );

            mZoomNom2.setText( neighbour.getName() );

            collapsingToolbar.setTitle( neighbour.getName() );

            mZoomLocalisation.setText( neighbour.getAddress() );
            mZoomPhone.setText( neighbour.getPhoneNumber() );
            mZoomAboutMe.setText( neighbour.getAboutMe() );
            nom = neighbour.getName();
            mZoomReseau.append("www.Facebook.com/"+nom);
            isFavorite = neighbour.isFavorit();
            Log.e("TAG3", "alimentation du booleen : "+isFavorite);

            fab = findViewById( R.id.fab );
            if (isFavorite) {
                fab.setImageResource( R.drawable.ic_baseline_star_24 );
                fab.hide();
                fab.show();
            } else {
                fab.setImageResource( R.drawable.ic_baseline_star_border_24 );
                fab.hide();
                fab.show();
            }
            fabOnclickListener();
        }

    private void fabOnclickListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_zoom) {
                Log.e("TAG3", "je rentre dans onclickListener "+isFavorite);

                if (!isFavorite) {
                    fab.setImageResource(R.drawable.ic_baseline_star_24);
                    fab.hide();
                    fab.show();
                    addFavoriteNeighbour(view_zoom);
                } else {
                    fab.setImageResource(R.drawable.ic_baseline_star_border_24);
                    fab.hide();
                    fab.show();

                    deleteFavoriteNeighbour(view_zoom);
                }
            }
        });
    }

    private void addFavoriteNeighbour(View view_zoom) {
        fab.setImageResource(R.drawable.ic_baseline_star_24);
        fab.hide();
        fab.show();
        Snackbar.make(view_zoom, "Ce voisin a été ajouté de vos favoris!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        mFavApiService.addFavoriteNeighbour(view_zoom);

        isFavorite = true;
        }

    private void deleteFavoriteNeighbour(View view_zoom) {
        fab.setImageResource(R.drawable.ic_baseline_star_border_24);
        fab.hide();
        fab.show();
        Snackbar.make(view_zoom, "Ce voisin a été supprimé de vos favoris!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        isFavorite = false;
        mFavApiService.deleteFavoriteNeighbour(view_zoom);
    }
}
