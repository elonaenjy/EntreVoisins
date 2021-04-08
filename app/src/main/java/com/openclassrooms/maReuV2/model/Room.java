package com.openclassrooms.maReuV2.model;

import com.openclassrooms.entrevoisins.R;

import java.util.Arrays;
import java.util.List;

public class Room {

    private final int mId;
    private final String mRoomName;
    private final int mImage;
    private static final List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room( 1, "Etretat", R.drawable.ic_etretat_background),
            new Room( 2, "Himalaya",  R.drawable.ic_himalaya_background ),
            new Room( 3, "Laponie",  R.drawable.ic_laponie_background),
            new Room( 4, "Guadeloupe", R.drawable.ic_guadeloupe_background ),
            new Room( 5, "Italie", R.drawable.ic_rome_background ),
            new Room( 6, "Madagascar" , R.drawable.ic_madagascar_background),
            new Room( 7, "Asie",  R.drawable.ic_asie_background ),
            new Room( 8, "Tahiti", R.drawable.ic_tahiti_background ),
            new Room( 9, "Thaïlande",R.drawable.ic_thailande_background ),
            new Room( 10, "Vietnam",R.drawable.ic_vietnam_background),
            new Room( 11, "Russie", R.drawable.ic_kremlin_background)
    );

    public static List<Room> generateRooms() {
        return DUMMY_ROOMS;
    }

    public Room(int id, String mName, int image) {
        mId = id;
        mRoomName = mName;
        mImage = image;
    }

    public int getId() {
        return mId;
    }

    public String getRoomName() {
        return mRoomName;
    }

    public int getRoomImage() {
        return mImage;
    }

}
