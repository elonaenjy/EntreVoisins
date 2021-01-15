package com.openclassrooms.entrevoisins.service;

import android.view.View;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {
    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();


    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    List<Neighbour> getFavoritNeighbours();

    /**
     * Liste des voisins favoris
     * @return {@link List}
     */
    void addFavoriteNeighbour(Neighbour neighbour);

    void deleteFavoriteNeighbour(Neighbour neighbour);
}
