package workshop.testing.ui.recipe;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import workshop.testing.R;
import workshop.testing.data.local.RecipeStore;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class RecipeActivityTest {
    @Test
    public void number_of_recipe() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(1, store.recipes.size());
    }
        @Rule
                public ActivityTestRule<RecipeActivity> activityRule
                =new ActivityTestRule<>(
                        RecipeActivity.class,true,false);


@Test
public void show_detail_of_chocolate_pudding(){
    Intent intent=new Intent();
    intent.putExtra(RecipeActivity.KEY_ID,"Chocolate Pudding");
    activityRule.launchActivity(intent);

    onView(withId(R.id.title))
            .check(matches(withText("Chocolate Pudding")));
    onView(withId(R.id.description))
            .check(matches((withText("id=chocolate_pudding\n" +
                    "title=Chocolate Pudding\n" +
                    "2 tablespoons chocolate\n" +
                    "yolks of 4 eggs\n" +
                    "1 cup sugar\n" +
                    "1 quart milk\n" +
                    "1 whole egg\n" +
                    "2 tablespoons corn starch\n" +
                    "\n" +
                    "Cook until it thickens, beat whites of eggs and put on top, put in oven to brown. Serve with cream, if preferred."))));


}}