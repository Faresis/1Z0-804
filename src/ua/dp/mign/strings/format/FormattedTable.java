package ua.dp.mign.strings.format;

class FormattedTable {
    private static void printLine() {
        System.out.println("--------------------------------------------------------------------------------");
    }

    private static void printHeader() {
        System.out.printf("%-15s \t %s \t %s \t %s \n", "Player", "Matches", "Goals", "Goals per match");
    }

    private static void printRow(String player, int matches, int goals) {
        System.out.printf("%-15s \t  %5d \t %d \t %.1f \n", player, matches, goals, ((float)goals/(float)matches));
    }
    public static void main(String[] args) {
        FormattedTable.printLine();
        FormattedTable.printHeader();
        FormattedTable.printLine();
        FormattedTable.printRow("Demando", 100, 122);
        FormattedTable.printRow("Mushi", 80, 100);
        FormattedTable.printRow("Peale", 150, 180);
        FormattedTable.printLine();
    }
}
