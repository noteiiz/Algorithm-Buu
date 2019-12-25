
import java.util.*;

public class HomeWorkWeek03 {

    public static void main(String[] args) {
        getdata();

    }
    public static int[] midArray(int[] arr) {
        int extra = arr.length % 2 == 0 ? 1 : 0;
        int[] a = new int[1 + extra];
        int startIndex = arr.length / 2 - extra;
        int endIndex = arr.length / 2;
        for (int i = 0; i <= endIndex - startIndex; i++) {
            a[i] = arr[startIndex + i];
        }
        return a;

    }

    public static void getdata() {
        Scanner kb = new Scanner(System.in);
        int[] data = new int[0];
        int[] tmp;
        int num;

        System.out.println("Enter number [-999 to stop] : ");
        do {
            num = kb.nextInt();
            if (num != -999) {
                tmp = new int[data.length + 1];
                System.arraycopy(data, 0, tmp, 0, data.length);
                data = tmp;
                data[data.length - 1] = num;
            }
        } while (num != -999);
        
        showManu(data);
        picknumber(data);
    }

    public static void showManu(int[] input) {
        System.out.println("------------------");
        System.out.println("Your Number is : "+Arrays.toString(input));
        System.out.println("------------------");
        System.out.println("    Menu");
        System.out.println("------------------");
        System.out.println("1. Summation");
        System.out.println("2. Average");
        System.out.println("3. Median");
        System.out.println("4. Quit");
        System.out.println("------------------");

    }

    public static void picknumber(int[] input) {

        System.out.println("Enter your choice: ");
        int menu;
        Scanner kb = new Scanner(System.in);
        do {
        menu = kb.nextInt();
        switch (menu) {
            case 1:
                Summation(input);
                break;
            case 2:
                Average(input);
                break;
            case 3:
                Median(input);
                break;
            case 4:
                Quit();
                break;
            default:
                System.out.println("We have only 1-2-3-4 choice for you. Pick again.");
}
        }while(menu !=4);
    }

    public static void Summation(int[] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        System.out.println("Summary = " + sum);
    }

    public static void Average(int[] input) {
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        avg = (double) sum / input.length;
        System.out.println("Average = "+ avg);
    }

    public static void Median(int[] input) {
        int extra = input.length % 2 == 0 ? 1 : 0;

        int[] mid = new int[1 + extra];

        int startIndex = input.length / 2 - extra;
        int endIndex = input.length / 2;

        for (int i = 0; i <= endIndex - startIndex; i++) {
            mid[i] = input[startIndex + i];
        }
        Arrays.sort(input);
        System.out.println("This is middle number after sort :" + Arrays.toString(midArray(input)));
    }

    public static void Quit() {
        System.err.println("Good bye !!");
        System.exit(0);
    }
}
