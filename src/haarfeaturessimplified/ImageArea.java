/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haarfeaturessimplified;

/**
 *
 * @author user
 */
public class ImageArea {

    public int[] CalculateArea(int winWidth, int winHeight, int sliderPosCol, int sliderPosRow, int count) {

        int[] rectValues = new int[4];
        int blackPortion = 0, whitePortion = 0, feature = 0;

        int a = winWidth;
        int b = winHeight;
        int c = sliderPosCol;
        int d = sliderPosRow;
        int counter = count;
        if (sliderPosCol == 1 || sliderPosRow == 1) {
            /**
             * Ignoring extreme left and extreme top values as they hold little
             * information when this is applied to image processing applications
             */

        } else {
            /**
             * Get the areas of the black and white portions of the filter and
             * subtract to find the features. for the white portion the window
             * width is added to the column section to shift the starting
             * position of the window to be subtracted
             */
            blackPortion = PointsCalculation(a, b, c, d, counter);
            whitePortion = PointsCalculation(a, b, c + winWidth, d, counter);

            feature = blackPortion - whitePortion;
            System.out.println(" ");
            System.out.println("FEATURE VALUE from the above two sections = " + feature);
            System.out.println(" ");
        }

        return rectValues;
    }

    public int PointsCalculation(int winWidth, int winHeight, int sliderPosCol, int sliderPosRow, int count) {

        int btmRgtX, btmRgtY, btmLftX, btmLftY, topRgtX, topRgtY, topLftX, topLftY, a, b, c, d;
        int[] areaValues = new int[90];

        int[][] integralValues = new int[5][5];

        IntegralImage integralImage = new IntegralImage();
        integralValues = integralImage.Integral();

        /**
         * My window width value is the 'i' from features loop which starts from
         * 1 hence, -1 for adjusting width since for window width 1, the window
         * itself should be considered or for window width 2 only one step
         * should be moved. Another -1 since the integral values array starts
         * form 0 - the desired value so subtraction of one more one to chose
         * the desired value. Hence, the -2 done in the section below!!
         */
        btmRgtX = sliderPosCol + winWidth - 2;
        btmRgtY = sliderPosRow + winHeight - 2;

        btmLftX = sliderPosCol - 2;
        btmLftY = sliderPosRow + winHeight - 2;

        topRgtX = sliderPosCol + winWidth - 2;
        topRgtY = sliderPosRow - 2;

        topLftX = sliderPosCol - 2;
        topLftY = sliderPosRow - 2;

        a = integralValues[btmRgtY][btmRgtX];                                   //a is the bottom Right section of integral image

        b = integralValues[topLftY][topLftX];                                   //b is the top left section of integral image

        c = integralValues[btmLftY][btmLftX];                                   //c is the bottom left section of integral image

        d = integralValues[topRgtY][topRgtX];                                   //d is the top right section of the integral image

        System.out.println("COUNT = " + count);
        System.out.println("btmRT " + a);
        System.out.println("topLFT " + b);
        System.out.println("btmLFT " + c);
        System.out.println("topRGT " + d);

        areaValues[count] = ((a + b) - (c + d));
        System.out.println("area at column: " + sliderPosCol + " row: " + sliderPosRow);
        System.out.println("With window width= " + winWidth + " window height= " + winHeight + " IS " + (areaValues[count]));
        System.out.println("");
        return areaValues[count];
    }

}
