package com.openclassrooms.entrevoisins.service;

import android.view.View;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favoriteList = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        for (Neighbour neighbour : getNeighbours())
            if (neighbour.isFavorit()) {
                favoriteList.add( neighbour );
            }
        return favoriteList;
    }

    /**
     * Add a favorite neighbour
     * {@param neighbour}
     */
    @Override
    public void addFavoriteNeighbour(Neighbour neighbour) {
        favoriteList.add(neighbour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        favoriteList.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void modifyNeighbour(Neighbour neighbour) {
        neighbours.set(neighbours.indexOf(neighbour),neighbour);
    }
}
