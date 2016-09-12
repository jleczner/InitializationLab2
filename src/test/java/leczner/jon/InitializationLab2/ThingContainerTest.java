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
    public void emptyAddTest() {
        System.out.println("emptyAddTest");
        assertEquals(0, tcEmpty.getThings().length);
        tcEmpty.add(new ColorfulThing(ColorfulThing.Color.BLUE));
        tcEmpty.printThings();
        assertEquals(0, tcEmpty.getThings().length); // add should fail
    }

    @Test
    public void addTest() {
        System.out.println("addTest");
        ColorfulThing[] things = tc1.getThings();
        assertEquals(null, things[0]);
        ColorfulThing ct1 = new ColorfulThing(ColorfulThing.Color.GREEN);
        tc1.add(ct1); // heehee
        tc1.printThings();
        assertEquals(ColorfulThing.Color.GREEN, things[0].getColor());
    }

    @Test
    public void overflowTest() {
        System.out.println("overflowTest");
        ColorfulThing[] things = tc5.getThings();
        ColorfulThing ct1 = new ColorfulThing(ColorfulThing.Color.YELLOW);
        ColorfulThing ct2 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing ct3 = new ColorfulThing(ColorfulThing.Color.GREEN);
        ColorfulThing ct4 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing ct5 = new ColorfulThing(ColorfulThing.Color.RED);
        ColorfulThing ct6 = new ColorfulThing(ColorfulThing.Color.PURPLE);
        tc5.add(ct1);
        tc5.add(ct2);
        tc5.add(ct3);
        tc5.add(ct4);
        tc5.add(ct5);
        tc5.add(ct6);
        tc5.printThings();
        assertEquals(ct5, things[4]);
        assertEquals(ct1, things[0]);
    }

    @Test
    public void removeEmptyTest() {
        System.out.println("removeEmptyTest");
        tcEmpty.printThings();
        ColorfulThing shouldBeNull = tcEmpty.remove(ColorfulThing.Color.BLUE);
        assertEquals(null, shouldBeNull);
    }

    @Test
    public void removeTest() {
        System.out.println("removeTest");
        ColorfulThing ct1 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing ct2 = new ColorfulThing(ColorfulThing.Color.YELLOW);
        tc1.add(ct1);
        tc1.printThings();
        ColorfulThing blueThing = tc1.remove(ColorfulThing.Color.BLUE);
        tc1.printThings();
        assertEquals(ct1, blueThing); // right?
        ColorfulThing shouldBeNull = tc1.remove(ColorfulThing.Color.BLUE);
        tc1.printThings();
        assertEquals(null, shouldBeNull);
        tc1.add(ct2);
        tc1.printThings();
        ColorfulThing shouldAlsoBeNull = tc1.remove(ColorfulThing.Color.BLUE);
        assertEquals(null, shouldAlsoBeNull);
    }

    @Test
    public void removeSameTest() {
        System.out.println("removeSameTest");
        ColorfulThing ct1 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing ct2 = new ColorfulThing(ColorfulThing.Color.BLUE);
        tc1.add(ct1);
        tc1.add(ct2);
        tc1.printThings();
        ColorfulThing shouldBeCT1 = tc1.remove(ColorfulThing.Color.BLUE);
        tc1.printThings();
    }

    @Test
    public void removeEmptyTest2() {
        System.out.println("removeEmptyTest");
        tcEmpty.printThings();
        ColorfulThing ct1 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing shouldBeNull = tcEmpty.remove(ct1);
        assertEquals(null, shouldBeNull);
    }

    @Test
    public void removeTest2() {
        System.out.println("removeTest");
        ColorfulThing ct1 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing ct2 = new ColorfulThing(ColorfulThing.Color.YELLOW);
        tc1.add(ct1);
        tc1.printThings();
        ColorfulThing blueThing = tc1.remove(ct1);
        tc1.printThings();
        assertEquals(ct1, blueThing); // right?
        ColorfulThing shouldBeNull = tc1.remove(ct1);
        tc1.printThings();
        assertEquals(null, shouldBeNull);
        tc1.add(ct2);
        tc1.printThings();
        ColorfulThing shouldAlsoBeNull = tc1.remove(ct1);
        assertEquals(null, shouldAlsoBeNull);
    }

    @Test
    public void removeSameTest2() {
        System.out.println("removeSameTest");
        ColorfulThing ct1 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing ct2 = new ColorfulThing(ColorfulThing.Color.BLUE);
        tc1.add(ct1);
        tc1.add(ct2);
        tc1.printThings();
        ColorfulThing shouldBeCT1 = tc1.remove(ct1);
        tc1.printThings();
        assertEquals(ct1, shouldBeCT1);
        assertNotEquals(ct2, shouldBeCT1);
    }

}
