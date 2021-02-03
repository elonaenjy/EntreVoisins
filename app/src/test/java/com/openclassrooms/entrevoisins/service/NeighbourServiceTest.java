package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat( neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder( expectedNeighbours.toArray() ) );
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get( 0 );
        service.deleteNeighbour( neighbourToDelete );
        assertFalse( service.getNeighbours().contains( neighbourToDelete ) );
    }

    @Test
    public void createNeighbourWithSuccess() {
        Neighbour neighbourToCreate = new Neighbour( (long) service.getNeighbours().size(), "New_test_neighbour", "https://i.pravatar.cc/150", "", "", "", false );
        service.createNeighbour( neighbourToCreate );
        assertTrue( service.getNeighbours().contains( neighbourToCreate ) );
    }

    /**
     * Adds a neighbour to favorites and checks it is in favorites list
     */
    @Test
    public void addNeighbourToFavoritesWithSuccess() {
        Neighbour neighbourToAddToFavorites = service.getNeighbours().get( 0 );
        /// modification de la valeur du booleen et modification dans la liste des voisins
        neighbourToAddToFavorites.setIsFavorit( true);
        service.modifyNeighbour(neighbourToAddToFavorites);
        // Le voisin modifié est présent dans les deux listes
        assertTrue(service.getFavoriteNeighbours().contains(neighbourToAddToFavorites));
    }

    /**
     * Adds then removes a neighbour to favorites and checks it is not in favorites list
     */
     @Test public void removeNeighbourFromFavoritesWithSuccess() {
         Neighbour neighbourToRemoveToFavorites = service.getNeighbours().get( 0 );
         /// modification de la valeur du booleen et modification dans la liste des voisins
         neighbourToRemoveToFavorites.setIsFavorit( false);
         service.modifyNeighbour(neighbourToRemoveToFavorites);
         // Le voisin modifié est présent dans la liste des favoris deux listes
         assertFalse(service.getFavoriteNeighbours().contains(neighbourToRemoveToFavorites));
      }

    /**
     * Adds a neighbour to favorites and removes it from neighbours list
     * then checks that the neighbour is not part of favorites or neighbours list
     */
     @Test
     public void deleteNeighbourAddedToFavoritesWithSuccess() {
          Neighbour neighbourToAddToFavoritesAndToDelete = service.getNeighbours().get(0);
         /// modification de la valeur du booleen et modification dans la liste des voisins
          neighbourToAddToFavoritesAndToDelete.setIsFavorit( true);
          service.modifyNeighbour(neighbourToAddToFavoritesAndToDelete);
          // Le voisin modifié est présent dans les deux listes
          assertTrue(service.getFavoriteNeighbours().contains(neighbourToAddToFavoritesAndToDelete));
          assertTrue(service.getNeighbours().contains(neighbourToAddToFavoritesAndToDelete));
         /// modification de la valeur du booleen pour le passer en non favoris et modification dans la liste des voisins
         neighbourToAddToFavoritesAndToDelete.setIsFavorit( false);
         service.modifyNeighbour(neighbourToAddToFavoritesAndToDelete);
         // Le voisin modifié est supprimé de la liste des favoris et toujours présent dans la liste complète
         assertFalse(service.getFavoriteNeighbours().contains(neighbourToAddToFavoritesAndToDelete));
         assertTrue(service.getNeighbours().contains(neighbourToAddToFavoritesAndToDelete));

      }
}

