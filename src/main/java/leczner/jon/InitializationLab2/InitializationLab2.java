package leczner.jon.InitializationLab2;

/**
 * Created by jonathanleczner on 9/11/16.
 */
public class InitializationLab2 {
    public static void main(String[] args) {
        ThingContainer tc1 = new ThingContainer(0);
        ThingContainer tc2 = new ThingContainer(1);
        ThingContainer tc3 = new ThingContainer(5);

        
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

    public void printThings() {
        for (int i = 0; i < things.length; i++)
            System.out.println("[" + i + "] " + things[i]);
    }

}
