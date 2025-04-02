public class HolidayBonus {
    private static final double HIGH_BONUS = 5000;
    private static final double LOW_BONUS = 1000;
    private static final double OTHER_BONUS = 2000;

    public static double[] calculateHolidayBonus(double[][] salesData) {
        double[] bonuses = new double[salesData.length];

        int maxCols = 0;
        for (double[] row : salesData) maxCols = Math.max(maxCols, row.length);

        for (int col = 0; col < maxCols; col++) {
            int highestIndex = -1, lowestIndex = -1;
            double highest = Double.NEGATIVE_INFINITY, lowest = Double.POSITIVE_INFINITY;

            for (int row = 0; row < salesData.length; row++) {
                if (col < salesData[row].length && salesData[row][col] >= 0) {
                    if (salesData[row][col] > highest) {
                        highest = salesData[row][col];
                        highestIndex = row;
                    }
                    if (salesData[row][col] < lowest) {
                        lowest = salesData[row][col];
                        lowestIndex = row;
                    }
                }
            }

            for (int row = 0; row < salesData.length; row++) {
                if (col < salesData[row].length && salesData[row][col] >= 0) {
                    if (row == highestIndex) {
                        bonuses[row] += HIGH_BONUS;
                    } else if (row == lowestIndex) {
                        bonuses[row] += LOW_BONUS;
                    } else {
                        bonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] salesData) {
        double totalBonus = 0;
        for (double bonus : calculateHolidayBonus(salesData)) {
            totalBonus += bonus;
        }
        return totalBonus;
    }
}
