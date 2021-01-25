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
        service.addFavoriteNeighbour( neighbourToAddToFavorites );
        assertTrue( service.getFavoriteNeighbours().contains( neighbourToAddToFavorites ) );
    }

    /**
     * Adds then removes a neighbour to favorites and checks it is not in favorites list
     */
     @Test public void removeNeighbourFromFavoritesWithSuccess() {
        Neighbour neighbourToRemoveFromFavorites = service.getNeighbours().get( 0 );
        service.addFavoriteNeighbour(neighbourToRemoveFromFavorites);
        assertTrue(service.getFavoriteNeighbours().contains(neighbourToRemoveFromFavorites));
        service.deleteFavoriteNeighbour( neighbourToRemoveFromFavorites);
        assertFalse(service.getFavoriteNeighbours().contains(neighbourToRemoveFromFavorites));
      }

    /**
     * Adds a neighbour to favorites and removes it from neighbours list
     * then checks that the neighbour is not part of favorites or neighbours list
     */
     @Test
     public void deleteNeighbourAddedToFavoritesWithSuccess() {
          Neighbour neighbourToAddToFavoritesAndToDelete = service.getNeighbours().get(0);
          service.addFavoriteNeighbour( neighbourToAddToFavoritesAndToDelete);
          assertTrue(service.getFavoriteNeighbours().contains(neighbourToAddToFavoritesAndToDelete));
          assertTrue(service.getNeighbours().contains(neighbourToAddToFavoritesAndToDelete));
          service.deleteNeighbour(neighbourToAddToFavoritesAndToDelete);
          assertFalse(service.getNeighbours().contains(neighbourToAddToFavoritesAndToDelete));
          assertFalse(service.getFavoriteNeighbours().contains(neighbourToAddToFavoritesAndToDelete));
      }
}

