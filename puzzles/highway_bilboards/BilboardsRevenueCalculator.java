/**
 * Check README to find description.
 * <br/>
 * To prevent storing the whole size of road array, we creating array
 * which has length KM_RESTRICTION + 1, so storing revenue in
 * restriction sections + 1 km as buffer.
 */
public class BilboardsRevenueCalculator {
    private static final int[] BILLBOARDS = {6, 7, 12, 13, 14};
    private static final int[] REVENUES = {5, 6, 5, 3, 1};
    private static final int KM_RESTRICTION = 5;

    private int calculate(int[] billboards, int[] revenues, 
            int restriction) {
        return calculate(0, 0, new int[restriction + 1],
                billboards, revenues, restriction);
    }

    private int calculate(int km, int nextInd, int[] kmTracker, 
            int[] availableBillboards, int[] availableRevenues, 
            int restriction) {
        if(km == availableBillboards[availableBillboards.length - 1] + 1) 
            return kmTracker[(km - 1) % kmTracker.length];
        int kmTrackerInd = km % kmTracker.length;
        if(availableBillboards[nextInd] == km) {
            int newValWithBillboard = kmTracker[kmTrackerInd] 
                + availableRevenues[nextInd];
            int prevInd = (km - 1) % kmTracker.length;
            int newValWithoutBillboard = 
                kmTracker[prevInd == -1 ? 0 : prevInd];
            kmTracker[kmTrackerInd] = Math.max(newValWithBillboard, 
                    newValWithoutBillboard);
            nextInd += 1;
        } else {
            int prevInd = (km - 1) % kmTracker.length;
            kmTracker[kmTrackerInd] = kmTracker[prevInd == -1 ? 0 : prevInd];
        }
        return calculate(km + 1, nextInd, kmTracker, availableBillboards, 
                availableRevenues, restriction);
    }

    public static void main(String[] args) {
        System.out.println("Maximum revenue is " + 
                new BilboardsRevenueCalculator().calculate(BILLBOARDS, 
                    REVENUES, KM_RESTRICTION));
    }
}
