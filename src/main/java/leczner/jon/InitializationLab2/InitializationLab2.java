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
        ColorfulThing blue2 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing red1 = new ColorfulThing(ColorfulThing.Color.RED);
        ColorfulThing green2 = new ColorfulThing(ColorfulThing.Color.GREEN);
        ColorfulThing purp1 = new ColorfulThing(ColorfulThing.Color.PURPLE);
        ColorfulThing yellow1 = new ColorfulThing(ColorfulThing.Color.YELLOW);
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

    public ThingContainer(int size) {
        things = new ColorfulThing[size];
    }

    public ColorfulThing[] getThings() {
        return things;
    }

    public void add(ColorfulThing ct) {
        for (int i = 0; i < things.length; i++) {
            if (things[i] == null) {
                things[i] = ct;
                return;
            }
        }
        System.out.println("ThingContainer is full");
    }

    public ColorfulThing remove(ColorfulThing.Color color) {
        ColorfulThing returnValue = null;
        for (int i = 0; i < things.length; i++) {
            ColorfulThing.Color thingColor = things[i].getColor();
            if (thingColor == color) {
                returnValue = things[i];
                things = removeHelper(i);
            }
        }
        return returnValue;
    }

    public ColorfulThing[] removeHelper(int removeIndex) {
        ColorfulThing[] newThings = new ColorfulThing[things.length - 1]; // one element less
        for (int i = 0; i < things.length; i++) {
            if (i != removeIndex)
                newThings[i] = things[i];
        }
        return newThings;
    }

    public void printThings() {
        for (int i = 0; i < things.length; i++)
            System.out.println("[" + i + "] " + things[i].getColor());
    }

}
