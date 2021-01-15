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

    /**
     * Get all favorites neighbours
     * @return
     */
    List<Neighbour> getFavoriteNeighbours();

    /**
     * ajout d'un voisin à la liste des favoris
     * @param neighbour
     */
    void addFavoriteNeighbour(Neighbour neighbour);

    /**
     * suppression d'un voisin à la liste des favoris
     * @param neighbour
     */
    void deleteFavoriteNeighbour(Neighbour neighbour);
}
