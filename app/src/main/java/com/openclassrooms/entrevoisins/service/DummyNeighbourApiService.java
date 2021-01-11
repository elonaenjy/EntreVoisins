package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public List<Neighbour> getFavoriteNeighbours() {
        List<Neighbour> favoriteList = new ArrayList<>();
        for (Neighbour neighbour : getNeighbours()) {
            if (neighbour.isFavorit()) {
                favoriteList.add(neighbour);
            }
        }
        return favoriteList;
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
    //@Override
    // public List<Neighbour> getFavoritNeighbours() {
    //    List<Neighbour> favoriteList = new ArrayList<>();
    //    for (Neighbour neighbour : getNeighbours()) {
    //         if (neighbour.isFavorit()) {
    //            favoriteList.add(neighbour);
    //        }
    //    }
    //    return favoriteList;
    //}

    /**
     * Add a favorite neighbour
     * {@param neighbour}
     */
    @Override
    public void addFavoriteNeighbour(Neighbour neighbour) {
        // for (Neighbour neighbour1 : getNeighbours()) {
        //    if (neighbour.getId().equals(neighbour1.getId())) {
        //        neighbour1.setFavorite(true);
            }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        // for (Neighbour favNeighbour : getNeighbours()) {
        //    if (neighbour.getId().equals(favNeighbour.getId())) {
        //        favNeighbour.setFavorite(false);
            }
        }
