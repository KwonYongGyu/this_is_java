public class guguDan {
    public static void main(String[] args) {
        int i, k;

        for (i = 2; i <= 9; i++) {

            System.out.println(i + "단 출력");

            for (k = 1; k <= 9; k++) {

                System.out.println(i + " " + "*" + " " + k + " " + "=" + " " + (i * k));

            }


        }

        for (int digit = 2; digit < 9; digit += 3) {
            for (int n = 0; n < 10; n++) {
                System.out.println(
                        (
                                (n == 0)
                                        ? String.format("%d단 출력       %d단 출력       %d단 출력", digit, digit + 1, digit + 2)
                                        : ((digit < 8) ? String.format("%d * %d = %d     %d * %d = %d     %d * %d = %d"
                                        , digit, n, digit * n
                                        , digit + 1, n, (digit + 1) * n
                                        , digit + 2, n, (digit + 2) * n)
                                        : String.format("%d * %d = %d     %d * %d = %d"
                                        , digit, n, digit * n
                                        , digit + 1, n, (digit + 1) * n))
                        )
                );
            }
            System.out.println(" ");
        }

    }
}

