import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskA {
    final static String delimiter = ",";
    final static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        try {
            N = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                String[] record = bufferedReader.readLine().split(delimiter);
                int fioValue = getFIOValue(record[0], record[1], record[2]);
                int digitSum = getDigitSum(record[3], record[4]);
                int alphabetValue = getAlphabetValue(record[0].toLowerCase());
                int sum = fioValue + digitSum * 64 + alphabetValue * 256;
                String result = "000" + Integer.toHexString(sum).toUpperCase();
                System.out.print(result.substring(Math.max(result.length() - 3, 0)) + " ");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static int getFIOValue(String surname, String name, String patronymic) {
        String commonString = surname + name + patronymic;
        return (int) commonString.chars().distinct().count();
    }

    private static int getDigitSum(String day, String month) {
        String commonString = day + month;
        char[] digitsArray = commonString.toCharArray();
        int digitSum = 0;
        for (char i : digitsArray) {
            digitSum += Integer.parseInt(String.valueOf(i));
        }
        return digitSum;
    }

    private static int getAlphabetValue(String surname) {
        return alphabet.indexOf(surname.charAt(0)) + 1;
    }
}
