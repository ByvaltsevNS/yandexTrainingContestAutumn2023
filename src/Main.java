import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void TaskA() throws IOException {
        final String delimiter = ",";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] record;
       for (int i = 0; i < N; i++) {
            record = bufferedReader.readLine().split(delimiter);
            long fioValue = getFIOValue(record[0], record[1], record[2]);
            int digitSum = getDigitSum(record[3], record[4]);
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

    public static void changeStr(String s) {
        s = "323";
    }

    public static void changeInt(int value) {
        value = 4;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bufferedReader.readLine();
            System.out.println(s.chars().distinct().count());
            changeStr(s);
            System.out.println(s);
            int value = 5;
            changeInt(value);
            System.out.println(value);
            System.out.println(getDigitSum("11", "2"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}