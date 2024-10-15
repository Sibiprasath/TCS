import java.util.Scanner;

public class OrchardProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ashokRow = scanner.next();
        String anandRow = scanner.next();

        if (!isValidInput(ashokRow, anandRow)) {
            System.out.println("Invalid input");
            return;
        }

        int ashokPossibilities = countPossibilities(ashokRow);
        int anandPossibilities = countPossibilities(anandRow);

        if (ashokPossibilities > anandPossibilities) {
            System.out.println("Ashok");
        } else if (anandPossibilities > ashokPossibilities) {
            System.out.println("Anand");
        } else {
            System.out.println("Draw");
        }
    }

    public static boolean isValidInput(String ashokRow, String anandRow) {
        // Check if strings contain only 'M' and 'L'
        for (char c : ashokRow.toCharArray()) {
            if (c != 'M' && c != 'L') {
                return false;
            }
        }
        for (char c : anandRow.toCharArray()) {
            if (c != 'M' && c != 'L') {
                return false;
            }
        }
        return true;
    }

    public static int countPossibilities(String row) {
        int n = row.length();
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            if (row.charAt(i) != row.charAt(i + 1) && row.charAt(i + 1) != row.charAt(i + 2)) {
                for (int j = i + 3; j < n; j++) {
                    if (row.charAt(i) != row.charAt(j) && row.charAt(j - 1) != row.charAt(j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}


