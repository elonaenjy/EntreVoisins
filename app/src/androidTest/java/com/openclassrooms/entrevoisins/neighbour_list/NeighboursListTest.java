package com.openclassrooms.entrevoisins.neighbour_list;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.utils.DeleteViewAction;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.core.IsNull.notNullValue;


/**
 * Test class for list of neighbours
 */
@RunWith(AndroidJUnit4.class)
public class NeighboursListTest {

    // This is fixed
    private static final int ITEMS_COUNT = 12;
    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityRule =
            new ActivityTestRule(ListNeighbourActivity.class);
    private ListNeighbourActivity mActivity;

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(withId(R.id.list_neighbours))
                .check(matches(hasMinimumChildCount(1)));
    }

    /**
     * When we add a neighbour, there is one neighbour added to the neighbours list
     */
    @Test
    public void myNeighboursList_addNeighbourAction_shouldAddTheNeighbourToNeighboursList() {
        // Given : We check that the count of items is equal to ITEMS_COUNT
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
        // Click on the popup button for adding a neighbour
        onView(withId(R.id.add_neighbour))
                .perform(click());
        // Click on the creation button for a new neighbour
        onView(withId(R.id.name))
                .perform(click());
        onView(withId(R.id.name))
                .perform(clearText(), typeText("New_Neighbour"), closeSoftKeyboard());
        // Click on the creation button for a new neighbour
        onView(withId(R.id.create))
                .perform(click());
        // Result : We check that the count of items is equal to ITEMS_COUNT+1
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT + 1));
    }

    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void myNeighboursList_deleteAction_shouldRemoveItem() {
        // Given : We have ITEMS_COUNT+1 neighbours in the list (because of the myNeighboursList_addNeighbourAction_shouldAddTheNeighbourToNeighboursList test)
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT + 1));
        // When perform a click on a delete icon on the second neighbour in the list
        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is ITEMS_COUNT
        onView(withId(R.id.list_neighbours)).check(withItemCount(ITEMS_COUNT));
    }

    /**
     * When we click on a neighbour in the list, the neighbour profile is opened
     */
    @Test
    public void myNeighboursList_clickOnNeighbourAction_shouldOpenNeighbourProfile() {
        // Click on the second item in the neighbour list:
        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        // Neighbour profile screen should be opened:
        onView(withId(R.id.neighbour_zoom)).check(matches(isDisplayed()));
    }

    /**
     * When we click on a neighbour in the list, the neighbour profile is opened and the Neighbour name should be casted to the Profile view
     */
    @Test
    public void myNeighboursList_clickOnNeighbourAction_shouldCastNeighbourNameToZoomView() {
        // Click on the second item in the neighbour list:
        onView(withId(R.id.list_neighbours))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        // Neighbour name is casted to the Detailed View's TextView
        Neighbour neighbourPosition = DI.getNeighbourApiService().getNeighbours().get(1);
        onView(withId(R.id.zoom_nom2)).check(matches(withText(neighbourPosition.getName())));
    }
    /**
     * When we click on the popup button "Add a neighbour", the layout for adding a neighbour opens
     */
    @Test
    public void myNeighboursList_openTheAddANeighbourMenuAction_shouldOpenTheViewForAddingANeighbour() {
        // Click on the popup button for adding a neighbour
        onView(withId(R.id.add_neighbour))
                .perform(click());
        // Add the neighbour to favorites
        onView(withId(R.id.add_a_neighbour)).check(matches(isDisplayed()));
    }

    /**
     * When we add a neighbour to the favorites, the neighbour appears in the favorites list
     */
      @Test
      public void myNeighboursList_addNeighbourToFavoritesAction_shouldAddTheNeighbourToFavorites() {
        // Click on the second item in the neighbour list:
         onView(withId(R.id.list_neighbours))
                 .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        // Add the neighbour to favorites
          onView((withId(R.id.fab)))
                 .perform(click());
         // Go back on neighbour list view and to favorites list view
         // TODO ne fonctionne : à corriger
                  onView(withId(R.id.toolbar))
                 .perform(click());
        // Neighbour should appear in the list of favorites neighbours
          onView(withId(R.id.favorite_list_neighbours))
                .check(withItemCount(1));
     }

}