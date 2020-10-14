import java.util.HashMap;
import java.util.Scanner;

public class Pair {

    private static final String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
            "eighty", "ninety" };

    private static final String[] names = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen" };

    private static String convert(int number) {
        String numberInWord;

        if (number % 100 < 20) {
            numberInWord = names[number % 100];
            number /= 100;
        } else {
            numberInWord = names[number % 10];
            number /= 10;

            numberInWord = tens[number % 10] + numberInWord;
            number /= 10;
        }
        if (number == 0)
            return numberInWord;
        return "hundred";
    }

    public static int numberOfVowel(int n) {
        int v = 0;

        for (char ch : convert(n).toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                v++;
            }
        }
        return v;
    }

    public static String countPairSum(int arr[], int sum) {

        int count = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);

            hm.put(arr[i], hm.get(arr[i]) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (hm.get(sum - arr[i]) != null)
                count += hm.get(sum - arr[i]);
            if (sum - arr[i] == arr[i])
                count--;
        }

        return convert(count / 2);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int sum = 0;

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            sum += numberOfVowel(arr[i]);
        }

        System.out.println(countPairSum(arr, sum));
        scan.close();

    }
}