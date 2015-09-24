/**
 * Created by Ling on 2015-09-09.
 */
/* PixImage.java */

/**
 *  The PixImage class represents an image, which is a rectangular grid of
 *  color pixels.  Each pixel has red, green, and blue intensities in the range
 *  0...255.  Descriptions of the methods you must implement appear below.
 *  They include a constructor of the form
 *
 *      public PixImage(int width, int height);
 *
 *  that creates a black (zero intensity) image of the specified width and
 *  height.  Pixels are numbered in the range (0...width - 1, 0...height - 1).
 *
 *  All methods in this class must be implemented to complete Part I.
 *  See the README file accompanying this project for additional details.
 */

public class PixImage {

    /**
     *  Define any variables associated with a PixImage object here.  These
     *  variables MUST be private.
     */
    private int pwidth;
    private int pheight;
    private int psize;
    private pixel[][] RGB ;

    static class pixel {
        public short R;
        public short G;
        public short B;
    }

    /**
     * PixImage() constructs an empty PixImage with a specified width and height.
     * Every pixel has red, green, and blue intensities of zero (solid black).
     *
     * @param width the width of the image.
     * @param height the height of the image.
     */
    public PixImage(int width, int height) {
        // Your solution here.
        pwidth = width;
        pheight = height;
        psize = pwidth*pheight;
        RGB = new pixel[pwidth][pheight];
        for (int i = 0; i < pwidth; i++) {
            for (int j = 0; j < pheight; j++) {
                RGB[i][j] = new pixel();
            }
        }
    }

    /**
     * getWidth() returns the width of the image.
     *
     * @return the width of the image.
     */
    public int getWidth() {
        // Replace the following line with your solution.
        return pwidth;
    }

    /**
     * getHeight() returns the height of the image.
     *
     * @return the height of the image.
     */
    public int getHeight() {
        // Replace the following line with your solution.
        return pheight;
    }

    /**
     * getRed() returns the red intensity of the pixel at coordinate (x, y).
     *
     * @param x the x-coordinate of the pixel.
     * @param y the y-coordinate of the pixel.
     * @return the red intensity of the pixel at coordinate (x, y).
     */
    public short getRed(int x, int y) {
        // Replace the following line with your solution.
        pixel getpixel = RGB[x][y];
        return getpixel.R;
    }

    /**
     * getGreen() returns the green intensity of the pixel at coordinate (x, y).
     *
     * @param x the x-coordinate of the pixel.
     * @param y the y-coordinate of the pixel.
     * @return the green intensity of the pixel at coordinate (x, y).
     */
    public short getGreen(int x, int y) {
        // Replace the following line with your solution.
        pixel getpixel = RGB[x][y];
        return getpixel.G;
    }

    /**
     * getBlue() returns the blue intensity of the pixel at coordinate (x, y).
     *
     * @param x the x-coordinate of the pixel.
     * @param y the y-coordinate of the pixel.
     * @return the blue intensity of the pixel at coordinate (x, y).
     */
    public short getBlue(int x, int y) {
        // Replace the following line with your solution.
        pixel getpixel = RGB[x][y];
        return getpixel.B;
    }

    /**
     * setPixel() sets the pixel at coordinate (x, y) to specified red, green,
     * and blue intensities.
     *
     * If any of the three color intensities is NOT in the range 0...255, then
     * this method does NOT change any of the pixel intensities.
     *
     * @param x the x-coordinate of the pixel.
     * @param y the y-coordinate of the pixel.
     * @param red the new red intensity for the pixel at coordinate (x, y).
     * @param green the new green intensity for the pixel at coordinate (x, y).
     * @param blue the new blue intensity for the pixel at coordinate (x, y).
     */
    public void setPixel(int x, int y, short red, short green, short blue) {
        // Your solution here.
        if ((red >= 0 && red <= 255) && (green >= 0 && red <= 255) && (blue >= 0 && red <= 255) ) {
            pixel currentpixel = RGB [x][y];
            currentpixel.R = red;
            currentpixel.G = green;
            currentpixel.B = blue;
        }
    }

    /**
     * toString() returns a String representation of this PixImage.
     *
     * This method isn't required, but it should be very useful to you when
     * you're debugging your code.  It's up to you how you represent a PixImage
     * as a String.
     *
     * @return a String representation of this PixImage.
     */
    public String toString() {
        // Replace the following line with your solution.
        String result = "The size of PixImage is: " + psize + ". Its RGB is:[ ";
        for (int i = 0; i < pwidth; i++) {
            for (int j = 0; j < pheight; j++) {
                result = result + RGB[i][j].R + "&" + RGB[i][j].G + "&" + RGB[i][j].B + " ";
            }
        }

        return result + "]";
    }
    /**
     * boxBlur() returns a blurred version of "this" PixImage.
     *
     * If numIterations == 1, each pixel in the output PixImage is assigned
     * a value equal to the average of its neighboring pixels in "this" PixImage,
     * INCLUDING the pixel itself.
     *
     * A pixel not on the image boundary has nine neighbors--the pixel itself and
     * the eight pixels surrounding it.  A pixel on the boundary has six
     * neighbors if it is not a corner pixel; only four neighbors if it is
     * a corner pixel.  The average of the neighbors is the sum of all the
     * neighbor pixel values (including the pixel itself) divided by the number
     * of neighbors, with non-integer quotients rounded toward zero (as Java does
     * naturally when you divide two integers).
     *
     * Each color (red, green, blue) is blurred separately.  The red input should
     * have NO effect on the green or blue outputs, etc.
     *
     * The parameter numIterations specifies a number of repeated iterations of
     * box blurring to perform.  If numIterations is zero or negative, "this"
     * PixImage is returned (not a copy).  If numIterations is positive, the
     * return value is a newly constructed PixImage.
     *
     * IMPORTANT:  DO NOT CHANGE "this" PixImage!!!  All blurring/changes should
     * appear in the new, output PixImage only.
     *
     * @param numIterations the number of iterations of box blurring.
     * @return a blurred version of "this" PixImage.
     */
    public PixImage boxBlur(int numIterations) {
        // Replace the following line with your solution.
        int[][] neighbor_array = null;
        short num_neighbor;
        short redsofar = 0;
        short greensofar = 0;
        short bluesofar = 0;
        int redavg = 0;
        int greenavg = 0;
        int blueavg = 0;
        if (numIterations <= 0) {
            return this;
        } else {
            PixImage current_image = new PixImage(pwidth,pheight);
            current_image.RGB = this.RGB;
            for (int k = 0; k < numIterations; k++){
                PixImage blur_image = new PixImage(pwidth,pheight);
                for (int i = 0; i < pwidth; i++) {
                    for (int j = 0; j < pheight; j++) {
                        if ((j == 0 || j == pheight-1) && (i == 0 || i == pwidth-1)) {
                            if (neighbor_array == null) {
                                neighbor_array = new int[4][];
                            }
                            neighbor_array = four_neighbor(i, j);
                            num_neighbor = 4;
                        }
                        else if (i == 0 || i == pwidth-1 || j == 0 || j == pheight-1) {
                            if (neighbor_array == null) {
                                neighbor_array = new int[6][];
                            }
                            neighbor_array = six_neighbor(i, j);
                            num_neighbor = 6;
                        } else {
                            if (neighbor_array == null) {
                                neighbor_array = new int[9][];
                            }
                            neighbor_array = nine_neighbor(i, j);

                            num_neighbor = 9;
                        }
                        redsofar = 0;
                        greensofar = 0;
                        bluesofar = 0;
                        for (int[] cell : neighbor_array) {
                            redsofar += current_image.getRed(cell[0],cell[1]);
                            greensofar += current_image.getGreen(cell[0],cell[1]);
                            bluesofar += current_image.getBlue(cell[0],cell[1]);
                        }
                        redavg = redsofar / num_neighbor;
                        greenavg = greensofar / num_neighbor;
                        blueavg = bluesofar / num_neighbor;
                        blur_image.setPixel(i, j, (short)redavg, (short)greenavg, (short)blueavg);
                    }
                }
                current_image = blur_image;
            }
            return current_image;
        }
    }
    public int[][] four_neighbor (int x, int y)  {
        int[][] neighbors = new int[4][2];
        if (x == 0 && y == 0) {
            neighbors [0] = new int[]{x,y};
            neighbors [1] = new int[]{x+1, y};
            neighbors [2] = new int[]{x, y+1};
            neighbors [3] = new int[]{x+1, y+1};
        }
        else if (x == 0 && y == pheight-1) {
            neighbors [0] = new int[]{x,y};
            neighbors [1] = new int[]{x+1, y};
            neighbors [2] = new int[]{x, y-1};
            neighbors [3] = new int[]{x+1, y-1};
        }
        else if (x == pwidth-1 && y == 0) {
            neighbors [0] = new int[]{x,y};
            neighbors [1] = new int[]{x-1, y};
            neighbors [2] = new int[]{x, y+1};
            neighbors [3] = new int[]{x-1, y+1};
        } else {
            neighbors [0] = new int[]{x,y};
            neighbors [1] = new int[]{x-1, y};
            neighbors [2] = new int[]{x, y-1};
            neighbors [3] = new int[]{x-1, y-1};
        }
        return neighbors;

    }
    public int[][] six_neighbor (int x, int y) {
        int [][] neighbors = new int[6][2];
        if (x == 0) {
            neighbors [0] = new int[]{x,y};
            neighbors [1] = new int[]{x+1, y};
            neighbors [2] = new int[]{x, y+1};
            neighbors [3] = new int[]{x+1, y+1};
            neighbors [4] = new int[]{x, y-1};
            neighbors [5] = new int[]{x+1, y-1};
        }
        else if (y == 0) {
            neighbors [0] = new int[]{x,y};
            neighbors [1] = new int[]{x-1,y};
            neighbors [2] = new int[]{x+1,y};
            neighbors [3] = new int[]{x,y+1};
            neighbors [4] = new int[]{x-1,y+1};
            neighbors [5] = new int[]{x+1,y+1};
        }
        else if (x == pwidth-1) {
            neighbors [0] = new int[]{x,y};
            neighbors [1] = new int[]{x-1, y};
            neighbors [2] = new int[]{x, y+1};
            neighbors [3] = new int[]{x-1, y+1};
            neighbors [4] = new int[]{x,y-1};
            neighbors [5] = new int[]{x-1,y-1};
        } else {
            neighbors [0] = new int[]{x,y};
            neighbors [1] = new int[]{x-1,y};
            neighbors [2] = new int[]{x+1,y};
            neighbors [3] = new int[]{x,y-1};
            neighbors [4] = new int[]{x-1,y-1};
            neighbors [5] = new int[]{x+1,y-1};
        }
        return neighbors;
    }
    public int[][] nine_neighbor (int x, int y) {
        int [][] neighbors = new int[9][2];
        neighbors [0] = new int[]{x,y};
        neighbors [1] = new int[]{x-1,y};
        neighbors [2] = new int[]{x+1,y};
        neighbors [3] = new int[]{x,y-1};
        neighbors [4] = new int[]{x-1,y-1};
        neighbors [5] = new int[]{x+1,y-1};
        neighbors [6] = new int[]{x, y+1};
        neighbors [7] = new int[]{x-1,y+1};
        neighbors [8] = new int[]{x+1,y+1};
        return neighbors;
    }
    /**
     * mag2gray() maps an energy (squared vector magnitude) in the range
     * 0...24,969,600 to a grayscale intensity in the range 0...255.  The map
     * is logarithmic, but shifted so that values of 5,080 and below map to zero.
     *
     * DO NOT CHANGE THIS METHOD.  If you do, you will not be able to get the
     * correct images and pass the autograder.
     *
     * @param mag the energy (squared vector magnitude) of the pixel whose
     * intensity we want to compute.
     * @return the intensity of the output pixel.
     */
    private static short mag2gray(long mag) {
        short intensity = (short) (30.0 * Math.log(1.0 + (double) mag) - 256.0);

        // Make sure the returned intensity is in the range 0...255, regardless of
        // the input value.
        if (intensity < 0) {
            intensity = 0;
        } else if (intensity > 255) {
            intensity = 255;
        }
        return intensity;
    }

    /**
     * helper function for sobelEdges()
     * @param color
     * @param x
     * @param y
     * @return
     */
    public short getColor (String color, int x, int y) {
        if (color.equalsIgnoreCase("red")) {
            return getRed(x, y);
        }
        else if (color.equalsIgnoreCase("green")) {
            return getGreen(x, y);
        } else {
            return getBlue(x, y);
        }
    }
    /**
     * helper function for sobelEdges(). For each pixel (x, y), you will compute an approximate gradient (gx, gy) for
     * each of the three colors. Compute the gradient (gx, gy) for requested color with given _convolutions_.
     *
     * @param x x-coordinate of the pixel.
     * @param y y-coordinate of the pixel.
     * @param color requested color
     * @param vector x or y, the gradient convolutions is different
     * @return gradient
     */
    public int get_gradient (int x, int y, String color, String vector) {
        int gradient;
        int[][] cells = getcells4gradient(x, y);
        if (vector.equalsIgnoreCase("x")) {
            gradient = getColor(color, cells[3][0], cells[3][1]) + 2 * getColor(color, cells[4][0],cells[4][1])
                    + getColor(color, cells[5][0], cells[5][1]) - getColor(color, cells[6][0], cells[6][1])
                    - 2 * getColor(color, cells[7][0], cells[7][1])- getColor(color, cells[8][0], cells[8][1]);
        } else {
            gradient = getColor(color, cells[3][0], cells[3][1]) + 2 * getColor(color, cells[0][0], cells[0][1])
                    + getColor(color, cells[6][0], cells[6][1]) - getColor(color, cells[5][0], cells[5][1])
                    - 2 * getColor(color, cells[2][0], cells[2][1]) - getColor(color, cells[8][0], cells[8][1]);
        }
        return gradient;
    }
    /**
     * helper function for sobelEdges(). to get the neighbors of (i, j) in "this" input
     * PixImage (including itself).
     *
     * Pixels on the boundary of the output image require special treatment, because they do not have nine neighbors.
     * We treat them by _reflecting_ the image across each image boundary.
     * eg. we treat the pixel (-1, 2) as if it had the same RGB intensities as (0, 2),
     * and the pixel (1, height) as if it had the same RGB intensities as (1, height - 1).
     *
     * @param i x-coordinate of the pixel.
     * @param j y-coordinate of the pixel.
     * @return the nine neighbors (including itself)
     */
    public int[][] getcells4gradient (int i, int j) {
        int[][] cells = new int[9][2];
        if(j == 0) {
            if (i == 0) {
                cells[0] = new int[]{i,j};
                cells[1] = new int[]{i,j};
                cells[2] = new int[]{i,j+1};
                cells[3] = new int[]{i,j};
                cells[4] = new int[]{i,j};
                cells[5] = new int[]{i,j+1};
                cells[6] = new int[]{i+1,j};
                cells[7] = new int[]{i+1,j};
                cells[8] = new int[]{i+1,j+1};
            }
            else if ( i == pwidth-1) {
                cells[0] = new int[]{i,j};
                cells[1] = new int[]{i,j};
                cells[2] = new int[]{i,j+1};
                cells[3] = new int[]{i-1,j};
                cells[4] = new int[]{i-1,j};
                cells[5] = new int[]{i-1,j+1};
                cells[6] = new int[]{i,j};
                cells[7] = new int[]{i,j};
                cells[8] = new int[]{i,j+1};
            } else {
                cells[0] = new int[]{i,j};
                cells[1] = new int[]{i,j};
                cells[2] = new int[]{i,j+1};
                cells[3] = new int[]{i-1,j};
                cells[4] = new int[]{i-1,j};
                cells[5] = new int[]{i-1,j+1};
                cells[6] = new int[]{i+1,j};
                cells[7] = new int[]{i+1,j};
                cells[8] = new int[]{i+1,j+1};
            }
        }
        else if (j == pheight-1) {
            if (i == 0) {
                cells[0] = new int[]{i,j-1};
                cells[1] = new int[]{i,j};
                cells[2] = new int[]{i,j};
                cells[3] = new int[]{i,j-1};
                cells[4] = new int[]{i,j};
                cells[5] = new int[]{i,j};
                cells[6] = new int[]{i+1,j-1};
                cells[7] = new int[]{i+1,j};
                cells[8] = new int[]{i+1,j};
            }
            else if ( i == pwidth-1) {
                cells[0] = new int[]{i,j-1};
                cells[1] = new int[]{i,j};
                cells[2] = new int[]{i,j};
                cells[3] = new int[]{i-1,j-1};
                cells[4] = new int[]{i-1,j};
                cells[5] = new int[]{i-1,j};
                cells[6] = new int[]{i,j-1};
                cells[7] = new int[]{i,j};
                cells[8] = new int[]{i,j};
            } else {
                cells[0] = new int[]{i,j-1};
                cells[1] = new int[]{i,j};
                cells[2] = new int[]{i,j};
                cells[3] = new int[]{i-1,j-1};
                cells[4] = new int[]{i-1,j};
                cells[5] = new int[]{i-1,j};
                cells[6] = new int[]{i+1,j-1};
                cells[7] = new int[]{i+1,j};
                cells[8] = new int[]{i+1,j};
            }
        }
        else if (i == 0) {
            cells[0] = new int[]{i,j-1};
            cells[1] = new int[]{i,j};
            cells[2] = new int[]{i,j+1};
            cells[3] = new int[]{i,j-1};
            cells[4] = new int[]{i,j};
            cells[5] = new int[]{i,j+1};
            cells[6] = new int[]{i+1,j-1};
            cells[7] = new int[]{i+1,j};
            cells[8] = new int[]{i+1,j+1};
        }
        else if (i == pwidth-1) {
            cells[0] = new int[]{i,j-1};
            cells[1] = new int[]{i,j};
            cells[2] = new int[]{i,j+1};
            cells[3] = new int[]{i-1,j-1};
            cells[4] = new int[]{i-1,j};
            cells[5] = new int[]{i-1,j+1};
            cells[6] = new int[]{i,j-1};
            cells[7] = new int[]{i,j};
            cells[8] = new int[]{i,j+1};
        }
        return cells;
    }
    /**
     * gradient class. having four members: gradient for red, gradient for green, gradient for blue, and energy.
     *
     */
    static class gradient {
        public static int[] red_gradient = new int[2];
        public static int[] green_gradient = new int[2];
        public static int[] blue_gradient = new int[2];
        public static int energy = 0;
    }
    /**
     * helper function for sobelEdges() to get the square calculation for x
     */
    public int square (int x) {
        return x*x;
    }
    /**
     * sobelEdges() applies the Sobel operator, identifying edges in "this"
     * image.  The Sobel operator computes a magnitude that represents how
     * strong the edge is.  We compute separate gradients for the red, blue, and
     * green components at each pixel, then sum the squares of the three
     * gradients at each pixel.  We convert the squared magnitude at each pixel
     * into a grayscale pixel intensity in the range 0...255 with the logarithmic
     * mapping encoded in mag2gray().  The output is a grayscale PixImage whose
     * pixel intensities reflect the strength of the edges.
     *
     * See http://en.wikipedia.org/wiki/Sobel_operator#Formulation for details.
     *
     * energy(x, y) = gx(red)^2 + gy(red)^2 + gx(green)^2 + gy(green)^2 + gx(blue)^2 + gy(blue)^2.
     *
     * @return a grayscale PixImage representing the edges of the input image.
     * Whiter pixels represent stronger edges.
     */
    public PixImage sobelEdges() {
        // Replace the following line with your solution.
        // Don't forget to use the method mag2gray() above to convert energies to
        // pixel intensities.
        PixImage sobel_edge_image = new PixImage(pwidth,pheight);
        gradient[][] gradient4image = new gradient[pwidth][pheight];
        for (int i = 0; i < pwidth; i++) {
            for (int j = 0; j < pheight; j++) {
                gradient4image[i][j] = new gradient();
            }
        }
        for (int x = 0; x < pwidth; x++) {
            for (int y = 0; y < pheight; y++) {
                gradient.red_gradient[0] = get_gradient ( x, y, "red", "x");
                gradient.red_gradient[1] = get_gradient ( x, y, "red", "y");
                gradient.green_gradient[0] = get_gradient ( x, y, "green", "x");
                gradient.green_gradient[1] = get_gradient ( x, y, "green", "y");
                gradient.blue_gradient[0] = get_gradient ( x, y, "blue", "x");
                gradient.blue_gradient[1] = get_gradient ( x, y, "blue", "y");
                gradient.energy = square(gradient.red_gradient[0]) + square(gradient.red_gradient[1])
                                + square(gradient.green_gradient[0]) + square(gradient.green_gradient[1])
                                + square(gradient.blue_gradient[0]) + square(gradient.blue_gradient[1]);
                sobel_edge_image.setPixel(x, y, mag2gray(gradient.energy), mag2gray(gradient.energy), mag2gray(gradient.energy));
            }
        }
        return sobel_edge_image;
    }

    /**
     * TEST CODE:  YOU DO NOT NEED TO FILL IN ANY METHODS BELOW THIS POINT.
     * You are welcome to add tests, though.  Methods below this point will not
     * be tested.  This is not the autograder, which will be provided separately.
     */


    /**
     * doTest() checks whether the condition is true and prints the given error
     * message if it is not.
     *
     * @param b the condition to check.
     * @param msg the error message to print if the condition is false.
     */
    private static void doTest(boolean b, String msg) {
        if (b) {
            System.out.println("Good.");
        } else {
            System.err.println(msg);
        }
    }

    /**
     * array2PixImage() converts a 2D array of grayscale intensities to
     * a grayscale PixImage.
     *
     * @param pixels a 2D array of grayscale intensities in the range 0...255.
     * @return a new PixImage whose red, green, and blue values are equal to
     * the input grayscale intensities.
     */
    private static PixImage array2PixImage(int[][] pixels) {
        int width = pixels.length;
        int height = pixels[0].length;
        PixImage image = new PixImage(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setPixel(x, y, (short) pixels[x][y], (short) pixels[x][y],
                        (short) pixels[x][y]);
            }
        }

        return image;
    }

    /**
     * equals() checks whether two images are the same, i.e. have the same
     * dimensions and pixels.
     *
     * @param image a PixImage to compare with "this" PixImage.
     * @return true if the specified PixImage is identical to "this" PixImage.
     */
    public boolean equals(PixImage image) {
        int width = getWidth();
        int height = getHeight();

        if (image == null ||
                width != image.getWidth() || height != image.getHeight()) {
            return false;
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (! (getRed(x, y) == image.getRed(x, y) &&
                        getGreen(x, y) == image.getGreen(x, y) &&
                        getBlue(x, y) == image.getBlue(x, y))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * main() runs a series of tests to ensure that the convolutions (box blur
     * and Sobel) are correct.
     */
    public static void main(String[] args) {
        // Be forwarned that when you write arrays directly in Java as below,
        // each "row" of text is a column of your image--the numbers get
        // transposed.
        PixImage image1 = array2PixImage(new int[][] { { 0, 10, 240 },
                { 30, 120, 250 },
                { 80, 250, 255 } });
        System.out.println("Testing getWidth/getHeight on a 3x3 image.  " +
                "Input image:");
        System.out.print(image1);
        doTest(image1.getWidth() == 3 && image1.getHeight() == 3,
                "Incorrect image width and height.");

        System.out.println("Testing blurring on a 3x3 image.");
        doTest(image1.boxBlur(1).equals(
                        array2PixImage(new int[][] { { 40, 108, 155 },
                                { 81, 137, 187 },
                                { 120, 164, 218 } })),
                "Incorrect box blur (1 rep):\n" + image1.boxBlur(1));
        doTest(image1.boxBlur(2).equals(
                        array2PixImage(new int[][] { { 91, 118, 146 },
                                { 108, 134, 161 },
                                { 125, 151, 176 } })),
                "Incorrect box blur (2 rep):\n" + image1.boxBlur(2));
        doTest(image1.boxBlur(2).equals(image1.boxBlur(1).boxBlur(1)),
                "Incorrect box blur (1 rep + 1 rep):\n" +
                        image1.boxBlur(2) + image1.boxBlur(1).boxBlur(1));
//
//        System.out.println("Testing edge detection on a 3x3 image.");
//        doTest(image1.sobelEdges().equals(
//                        array2PixImage(new int[][] { { 104, 189, 180 },
//                                { 160, 193, 157 },
//                                { 166, 178, 96 } })),
//                "Incorrect Sobel:\n" + image1.sobelEdges());
//
//
        PixImage image2 = array2PixImage(new int[][] { { 0, 100, 100 },
                { 0, 0, 100 } });
        System.out.println("Testing getWidth/getHeight on a 2x3 image.  " +
                "Input image:");
        System.out.print(image2);
        doTest(image2.getWidth() == 2 && image2.getHeight() == 3,
                "Incorrect image width and height.");

        System.out.println("Testing blurring on a 2x3 image.");
        doTest(image2.boxBlur(1).equals(
                        array2PixImage(new int[][] { { 25, 50, 75 },
                                { 25, 50, 75 } })),
                "Incorrect box blur (1 rep):\n" + image2.boxBlur(1));

//        System.out.println("Testing edge detection on a 2x3 image.");
//        doTest(image2.sobelEdges().equals(
//                        array2PixImage(new int[][] { { 122, 143, 74 },
//                                { 74, 143, 122 } })),
//                "Incorrect Sobel:\n" + image2.sobelEdges());
    }
}
