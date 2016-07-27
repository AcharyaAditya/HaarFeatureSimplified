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
public class HaarFeaturesSimplified {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * calculate integral values calling the Integral Image class
         */
        IntegralImage integralImage = new IntegralImage();
        int[][] integralValues = integralImage.Integral();
        /**
         * The feature class mentioned below produces a sliding window and
         * generates a position to lay down the window for further calculations
         */
        Features features = new Features();
        features.FeatureA();
        /**
         * This just prints out the integral image values
         */
        System.out.println("CALCULATED INTEGRAL VALUES");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(integralValues[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

}
