package com.openclassrooms.maReuV2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guest {
    private final int mId;
    private final String mGuestName;
    private final String mGuestUrl;
    private final String mGuestMail;

    public Guest(int id, String guestName, String avatarUrl, String guestMail) {
        mId = id;
        mGuestName = guestName;
        mGuestUrl = avatarUrl;
        mGuestMail = guestMail;
    }

    private static final List<Guest> DUMMY_GUESTS = Arrays.asList(
            new Guest(1, "Paul", "http://clipart-library.com/data_images/163977.jpg", "Paul@lamzone.com.fr"),
            new Guest(2, "Phil", "http://clipart-library.com/newhp/kAibeA8c4.png", "Phil@lamzone.com"),
            new Guest(3, "Guillaume", "http://clipart-library.com/data_images/163960.png", "Guillaume@lamzone.com"),
            new Guest(4, "Francis", "http://clipart-library.com/data_images/163956.jpg", "Francis@lamzone.com"),
            new Guest(5, "George", "http://clipart-library.com/data_images/163966.jpg", "Georges@lamzone.com"),
            new Guest(6, "Louis", "http://clipart-library.com/data_images/163932.jpg", "Louis@lamzone.com"),
            new Guest(7, "Mateo", "http://clipart-library.com/data_images/163926.jpg", "Mateo@lamzone.com"),
            new Guest(8, "April", "http://clipart-library.com/data_images/163935.jpg", "April@lamzone.com"),
            new Guest(9, "Louise", "http://clipart-library.com/data_images/163948.png", "Louise@lamzone.com"),
            new Guest(10, "Elodie", "http://clipart-library.com/data_images/163932.jpg", "elodie@lamzone..com"),
            new Guest(11, "Helene", "http://clipart-library.com/data_images/79663.png", "helene@lamzone.com"),
            new Guest(12, "Fanny", "http://clipart-library.com/data_images/163914.jpg", "fanny@lamzone.com"),
            new Guest(13, "Laura", "http://clipart-library.com/data_images/19601.png", "laura@lamzone.com"),
            new Guest(14, "Gertrude", "http://clipart-library.com/data_images/163892.jpg", "gertrude@lamzone.com"),
            new Guest(15, "Chloé", "http://clipart-library.com/data_images/163914.jpg", "chloé@lamzone.com"),
            new Guest(16, "Dominique", "http://clipart-library.com/images/ziXp7E7iB.png", "Dominique@lamzone.com"),
            new Guest(17, "Marie", "http://clipart-library.com/new_gallery/1-15826_free-gold-christmas-ornaments-png-png-download.png", "marie@lamzone.com"),
            new Guest(18, "Henri", "https://thumbs.dreamstime.com/b/funny-christmas-reindeer-cartoon-holding-wooden-pa-22253100.jpg", "henri@lamzone.com"),
            new Guest(19, "Rémi", "https://thumbs.dreamstime.com/b/dachshund-christmas-santa-cute-cartoon-character-vector-illustration-happy-dog-wearing-claus-beanie-ready-celebrate-156337318.jpg", "remi@lamzone.com")
    );


    public static List<Guest> generateGuests() {
        return new ArrayList<>(DUMMY_GUESTS);
    }

    public int getId() {
        return mId;
    }

    public String getGuestName() {
        return mGuestName;
    }

    public String getGuestUrl() {
        return mGuestUrl;
    }

    public String getGuestMail() {
        return mGuestMail;
    }
}
