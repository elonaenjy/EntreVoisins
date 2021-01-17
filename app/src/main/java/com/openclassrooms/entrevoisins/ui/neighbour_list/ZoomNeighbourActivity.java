package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
    String nom;
    long idNeighbour;
    Boolean isFavorite;
    Neighbour neighbour;
    private ImageView mZoomAvatar;
    private FloatingActionButton fab;
    private TextView mZoomNom2;
    private TextView mZoomLocalisation;
    private TextView mZoomPhone;
    private TextView mZoomReseau;
    private TextView mZoomAboutMe;
    private Menu menu;
    private NeighbourApiService mFavApiService;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            mFavApiService = DI.getNeighbourApiService();
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_zoom_neighbour );
            Toolbar toolbar = findViewById( R.id.toolbar );
            setSupportActionBar( toolbar );
            getSupportActionBar().setDisplayHomeAsUpEnabled( true );

            AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
            mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                boolean isShow = false;
                int scrollRange = -1;
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                    if (scrollRange == -1) {
                        scrollRange = appBarLayout.getTotalScrollRange();
                    }
                    if (scrollRange + verticalOffset == 0) {
                        isShow = true;
                        showOption(R.id.favorit_zoom);
                    } else if (isShow) {
                        isShow = false;
                        if (isFavorite) {
                            fab.setImageResource( R.drawable.ic_baseline_star_24 );
                        } else {
                            fab.setImageResource( R.drawable.ic_baseline_star_border_24 );
                        }
                        hideOption(R.id.favorit_zoom);
                    }
                }
            });

            neighbour = (Neighbour) getIntent().getSerializableExtra( "NEIGHBOUR" );

            mZoomAvatar = (ImageView) findViewById( R.id.zoom_avatar );
            mZoomNom2 = (TextView) findViewById( R.id.zoom_nom2 );
            mZoomLocalisation = (TextView) findViewById( R.id.zoom_localisation );
            mZoomPhone = (TextView) findViewById( R.id.zoom_phone );
            mZoomReseau = (TextView) findViewById( R.id.zoom_reseau );
            mZoomAboutMe = (TextView) findViewById( R.id.zoom_about_me );

            Glide.with( this )
                    .load( neighbour.getAvatarUrl() )
                    .into( mZoomAvatar );

            mZoomLocalisation.setText( neighbour.getAddress() );
            mZoomPhone.setText( neighbour.getPhoneNumber() );
            mZoomAboutMe.setText( neighbour.getAboutMe() );
            nom = neighbour.getName();
            mZoomReseau.append( "www.Facebook.com/" + nom );
            isFavorite = neighbour.isFavorit();
            idNeighbour = neighbour.getId();
            fab = findViewById( R.id.fab );
            System.out.println("isFavorite :"+isFavorite);
            if (isFavorite) {
                fab.setImageResource( R.drawable.ic_baseline_star_24 );
            } else {
                fab.setImageResource( R.drawable.ic_baseline_star_border_24 );
            }

            CollapsingToolbarLayout collapsingToolbar = findViewById( R.id.toolbar_layout_zoom );

            mZoomNom2.setText( neighbour.getName() );

            collapsingToolbar.setTitle( neighbour.getName() );

            fabOnclickListener();
        }

        private void fabOnclickListener() {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view_zoom) {
                    if (!isFavorite) {
                        fab.setImageResource(R.drawable.ic_baseline_star_24);
                        Snackbar.make(view_zoom, "Ce voisin a été ajouté de vos favoris!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        addFavorit(neighbour);

                    } else {
                        fab.setImageResource(R.drawable.ic_baseline_star_border_24);
                         Snackbar.make(view_zoom, "Ce voisin a été supprimé de vos favoris!", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                         deleteFavorit( neighbour );
                    }
                }
            });
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
            this.menu = menu;
            getMenuInflater().inflate(R.menu.zoom_menu, menu);
            hideOption(R.id.favorit_zoom);
            return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
            case R.id.favorit_zoom : {
                if (!isFavorite) {
                    item.setIcon( R.drawable.ic_baseline_star_24 );
                    addFavorit( neighbour );
                } else {
                    item.setIcon( R.drawable.ic_baseline_star_border_24 );
                    deleteFavorit( neighbour );
                }
                return true;
            }
        }
        return super.onOptionsItemSelected( item );
    }

    private void hideOption(int id) {
        MenuItem item = menu.findItem(id);

        item.setVisible(false);
    }

    private void showOption(int id) {
        MenuItem item = menu.findItem(id);
        if (!isFavorite) {
            item.setIcon( R.drawable.ic_baseline_star_border_24 );
            } else {
                item.setIcon( R.drawable.ic_baseline_star_24 );
            }
        item.setVisible(true);
    }

    private void addFavorit(Neighbour neighbour) {
            isFavorite= true;
//            neighbour.setIsFavorit( isFavorite);
//            mFavApiService.modifyNeighbour(neighbour);
            mFavApiService.addFavoriteNeighbour(neighbour );

    };

    private void deleteFavorit(Neighbour neighbour) {
        isFavorite = false;
        neighbour.setIsFavorit( isFavorite);
 //       mFavApiService.modifyNeighbour(neighbour);
 //       mFavApiService.deleteFavoriteNeighbour(neighbour );
    };
}
