package leczner.jon.InitializationLab2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jonathanleczner on 9/11/16.
 */
public class ThingContainerTest {
    ThingContainer tcEmpty = new ThingContainer(0);
    ThingContainer tc1 = new ThingContainer(1);
    ThingContainer tc5 = new ThingContainer(5);


    @Test
    public void ThingContainerAddTest() {
        assertEquals(0, tcEmpty.getThings().length);
        tcEmpty.add(new ColorfulThing(ColorfulThing.Color.BLUE));
        assertEquals(1, tcEmpty.getThings().length);

    }

}
