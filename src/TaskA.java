import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskA {
    public static void main(String[] args) throws IOException {
        final String delimiter = ",";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] record;
        for (int i = 0; i < N; i++) {
            record = bufferedReader.readLine().split(delimiter);
            long fioValue = getFIOValue(record[0], record[1], record[2]);
            int digitSum = getDigitSum(record[3], record[4]);
            digitSum *= 64;
            int alphabetValue = getAlphabetValue(record[0].toLowerCase());
            alphabetValue *= 256;
            int sum = (int) (fioValue + digitSum + alphabetValue);
            String s1 = "000" + Integer.toHexString(sum).toUpperCase();
            System.out.print(s1.substring(Math.max(s1.length() - 3, 0), s1.length()) + " ");
        }
    }

    public static long getFIOValue(String surname, String name, String patronymic) {
        String commonString = surname + name + patronymic;
        return commonString.chars().distinct().count();
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
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.indexOf(surname.charAt(0)) + 1;
    }
}
