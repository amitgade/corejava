package constructor_chaining;

/**
 * Created by amit on 27-Dec-2020
 */
public class Rectangle {
    private int y;
    private int x;
    private int width;
    private int height;

    // BAD way
//    public Rectangle() {
//        this.y = 0;
//        this.x = 0;
//        this.height = 0;
//        this.width = 0;
//    }
//    public Rectangle(int width, int height) {
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//    }
//
//    public Rectangle(int x, int y, int width, int height) {
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//    }


    // GOOD way
    // 1st constructor
    public Rectangle() {    // calls 2nd constructor
        this(0, 0);
    }

    // 2nd constructor
    public Rectangle(int width, int height) {   // calls 3rd constructor
        this(0, 0, width, height);
    }

    // 3rd constructor
    public Rectangle(int x, int y, int width, int height) {
        // initialize variables
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}





