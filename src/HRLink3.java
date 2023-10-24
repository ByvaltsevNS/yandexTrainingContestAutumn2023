public class HRLink3 {
    public static void main(String[] args) {
        System.out.println(calculate(4, 1, 3));
        System.out.println(calculate(4, 4, 1));
        System.out.println(calculate(4, 4, 3));
        System.out.println(calculate(3, 3, 1));
    }

    public static int calculate(int n, int left, int right) {
        int lenght = n, ant1_position = left, ant2_position = right;
        int ant1_direction = -1, ant2_direction = 1;
        int ant1_next_position, ant2_next_position;

        for (int i = 1; ; i++) {
            ant1_next_position = ant1_position + ant1_direction;

            if (ant1_next_position == ant2_position) {
                ant1_direction *= -1;
                ant2_direction *= -1;
                ant1_next_position = ant1_position + ant1_direction;
            }

            if (ant1_next_position > lenght || ant1_next_position < 0) {
                return i;
            }

            ant1_position += ant1_direction;
            ant2_next_position = ant2_position + ant2_direction;

            if (ant2_next_position == ant1_position) {
                ant1_direction *= -1;
                ant2_direction *= -1;
                ant2_next_position = ant1_position + ant1_direction;
            }

            if (ant2_next_position > lenght || ant2_next_position < 0) {
                return i;
            }

            ant2_position += ant2_direction;
        }
    }
}
