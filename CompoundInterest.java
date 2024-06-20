import java.util.Arrays;

/**
 * This programs shows how to store tabular data in a 2D array
 * @author Cay Horstmann
 */
public class CompoundInterest {
    public static void main(String[] args){
        final double startRate = 10;
        final int nRates = 6;
        final int nYears = 10;
        // Set interest rate from 10 to 15%
        double[] interestRate = new double[nRates];
        for(int j = 0; j < interestRate.length; j++)
            interestRate[j] = (startRate + j) / 100.0;
        double[][] balances = new double[nYears][nRates];
        // Set initial balances to 10000
        Arrays.fill(balances[0], 10000);
        // Compute interest for future years
        for(int i = 1; i < balances.length; i++){
            for(int j = 0; j < balances[i].length; j++){
                // Get last year's balance from previous row
                double oldBalance = balances[i - 1][j];
                // Compute interest
                double interest = oldBalance * interestRate[j];
                // Compute this year's balance
                balances[i][j] = oldBalance + interest;
            }
        }
        // Print one row of interest rate
        for (double v : interestRate) System.out.printf("%9.0f%%", 100 * v);
        System.out.println();
        //Print balance table
        for(double[] row : balances){
            // Print table row
            for(double b : row)
                System.out.printf("%10.2f", b);

            System.out.println();
        }
    }
}
