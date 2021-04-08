package com.openclassrooms.maReuV2.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Meeting implements Serializable {
        private final long mIdMeeting;
        private final long mIdRoomMeeting;
        private final String mSubjectMeeting;
        private final Date mDateDebMeeting;
        private final Date mDateEndMeeting;
        private final List<Integer> lGuestIdMeeting;




    public Meeting(long idMeeting, int idRoom, String meetingSubject, Date meetingStartDate, Date meetingEndDate, List<Integer> meetingGuestListId) {
        this.mIdMeeting = idMeeting;
        this.mIdRoomMeeting = idRoom;
        this.mSubjectMeeting = meetingSubject;
        this.mDateDebMeeting = meetingStartDate;
        this.mDateEndMeeting = meetingEndDate;
        this.lGuestIdMeeting =  meetingGuestListId;
    }

    private static final List<Meeting> lMeetings = new ArrayList<Meeting>();

    public static List<Meeting> generateMeeting() {
        List<Meeting> lMeetings = new ArrayList<Meeting>();
        lMeetings = initList();
        return lMeetings;
    }

    private static List<Meeting> initList() {
// Method used for technical test during the developpment
        Calendar mCalendarDeb = Calendar.getInstance();
        Calendar mCalendarFin = Calendar.getInstance();
        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        Date dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        Date dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        Meeting aMeeting = new Meeting( System.currentTimeMillis(),
                1,
                "Objet Reunion 1",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3,4,6 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 20, 10, 00 );
        mCalendarDeb.set( 2021, 02, 20, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                1,
                "Objet Reunion filtre sur date1",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3,4,6 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarDeb.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                2,
                "Objet Reunion 2",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 9, 5 ) );
        lMeetings.add( aMeeting );
        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                3,
                "Objet Reunion 3",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 6,7,8 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                4,
                "Objet Reunion 4",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3,4,5, 6 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                5,
                "Objet Reunion 5",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 1, 2 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                6,
                "Objet Reunion 6",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 5,6,7,8,10) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                7,
                "Objet Reunion 7",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 1,2,3,4,9, 5 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 13, 10, 00 );
        mCalendarFin.set( 2021, 02, 13, 11, 00 );
        dateDebMeeting = new Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                10,
                "Objet Reunion 8",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 1,2,3,4,9, 5 ) );
        lMeetings.add( aMeeting );
        return lMeetings;
    }


    public long getIdRoom() {
        return mIdRoomMeeting;
    }

    public String getMeetingSubject() {
        return mSubjectMeeting;
    }

    public Date getMeetingStartDate() {
        return mDateDebMeeting;
    }

    public Date getMeetingEndDate() {
        return mDateEndMeeting;
    }

    public List<Integer> getMeetingGuestListId() {
        return lGuestIdMeeting;
    }

}