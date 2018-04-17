package workshop.testing.data.model;

import org.junit.Test;

import java.io.InputStream;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class RecipeTest {
    @Test
    public void i_can_read_data_from_water() {
        InputStream stream
                = RecipeTest.class.getResourceAsStream("/recipes/water.txt");
        Recipe recipe = Recipe.readFromStream(stream);

        assertNotNull(recipe);
        assertEquals("water", recipe.id);
        assertEquals("Water", recipe.title);
        assertEquals("Water", "Put glass under tao.Open tap.Close tap.Drink.", recipe.description);
    




    }


}