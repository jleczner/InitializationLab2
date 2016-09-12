package leczner.jon.InitializationLab2;

/**
 * Created by jonathanleczner on 9/11/16.
 */
public class InitializationLab2 {
    public static void main(String[] args) {
        ThingContainer tc1 = new ThingContainer(0);
        ThingContainer tc2 = new ThingContainer(1);
        ThingContainer tc3 = new ThingContainer(5);
        ColorfulThing blue1 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing green1 = new ColorfulThing(ColorfulThing.Color.GREEN);
        ColorfulThing red1 = new ColorfulThing(ColorfulThing.Color.RED);
        ColorfulThing green2 = new ColorfulThing(ColorfulThing.Color.GREEN);
        ColorfulThing purp1 = new ColorfulThing(ColorfulThing.Color.PURPLE);
        ColorfulThing yellow1 = new ColorfulThing(ColorfulThing.Color.YELLOW);
        ThingContainer things = new ThingContainer(new ColorfulThing[]{blue1, green1, red1, purp1, yellow1});

        System.out.println("tc1");
        tc1.add(blue1);
        tc1.printThings();
        System.out.println("tc2");
        tc2.add(blue1);
        tc2.add(green1);
        tc2.printThings();
        tc3.add(blue1);
        tc3.add(green1);
        tc3.add(blue1);
        tc3.pop();
        tc3.add(green2);
        tc3.remove(green1);
        tc3.add(red1);
        tc3.add(yellow1);
        tc3.add(yellow1);
        tc3.remove(ColorfulThing.Color.YELLOW);
        tc3.add(purp1);
        tc3.printThings();
        things.printThings();
    }
}

class ColorfulThing {
    private Color color;

    public enum Color {BLUE, RED, GREEN, YELLOW, PURPLE}

    public ColorfulThing(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

class ThingContainer {
    private ColorfulThing[] things;
    private int lastElementIndex;

    public ThingContainer(int size) {
        things = new ColorfulThing[size];
        lastElementIndex = -1; // add will make 0
    }

    public ThingContainer(ColorfulThing[] things) {
        this.things = things;
    }

    public ColorfulThing[] getThings() {
        return things;
    }
    public int getLastElementIndex() { return lastElementIndex; }

    public void add(ColorfulThing ct) {
        for (int i = 0; i < things.length; i++) {
            if (things[i] == null) {
                things[i] = ct;
                lastElementIndex++;
                return;
            }
        }
        System.out.println("ThingContainer is full");
    }

    public ColorfulThing pop() {
        ColorfulThing last = null;
        int lastElementIndex = getLastElementIndex();
        if (things.length > 0) {
            last = things[lastElementIndex];
            remove(last);
        }
        System.out.println("You done popped em ALL!");
        return last;
    }

    public ColorfulThing remove(ColorfulThing.Color color) {
        ColorfulThing returnValue = null;
        for (int i = 0; i <= lastElementIndex; i++) {
            ColorfulThing.Color thingColor = things[i].getColor();
            if (thingColor == color) {
                returnValue = things[i];
                things = removeHelper(i);
                return returnValue;
            }
        }
        return returnValue;
    }

    public ColorfulThing remove(ColorfulThing ct) {
        ColorfulThing returnValue = null;
        for (int i = 0; i < things.length; i++) {
            if (things[i] == ct) {
                returnValue = things[i];
                things = removeHelper(i);
            }
        }
        return returnValue;
    }

    public ColorfulThing[] removeHelper(int removeIndex) {
        ColorfulThing[] newThings  = new ColorfulThing[things.length];
        ThingContainer temp = new ThingContainer(newThings);
        for (int i = 0; i <= this.lastElementIndex; i++)
            if (i != removeIndex)
                temp.add(things[i]);
        this.lastElementIndex--;
        return newThings;
    }

    public void printThings() {
        if (things.length > 0)
            for (int i = 0; i < lastElementIndex; i++)
                System.out.println("[" + i + "] " + things[i].getColor());
        else
            System.out.println("No space in this container, bruh");
        System.out.println(); // for prettiness
    }

}
