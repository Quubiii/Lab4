import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class lab4 {

    public void bSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void bSort(LinkedList<Integer> list) {
        int size = list.size();

        for (int n = 0; n < size - 1; n++) {
            for (int i = 0; i < size - n - 1; i++) {
                int first = list.get(i);
                int second = list.get(i + 1);

                if (first > second) {
                    list.set(i, second);
                    list.set(i + 1, first);
                }
            }
        }
    }

    public boolean checkListValidity(String input) {
        if (input.length() != 5 || !input.matches("[0-9]+")) {
            System.out.println("You MUST enter exactly 5 integers (digits 0-9).");
            return false;
        }
        return true;
    }

    public void reverseLinkedList(LinkedList<Integer> list) {
        for(int i = 0; i < list.size() / 2; i++) {
            int index = list.size() - (i + 1);
            int temp1 = list.get(i);
            int temp2 = list.get(index);
            list.remove(index);
            list.add(i, temp2);
            list.remove(i + 1);
            list.add(index, temp1);
        }
    }

    public void Exercise1() {
        ArrayList<String> strings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Exercise 1.\nEnter strings, type 'stop' to finish.");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                break;
            }
            strings.add(input);
        }

        System.out.println(String.join("-", strings));
    }

    public LinkedList<Integer> Exercise2() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Exercise 2.\nEnter the first list of 5 integers (0-9):");
        String input1 = scanner.nextLine();

        while (!checkListValidity(input1)) {
            input1 = scanner.nextLine();
        }

        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = input1.charAt(i) - '0';
        }

        bSort(numbers);

        System.out.print("First sorted list: ");
        for (int num : numbers) {
            System.out.print(num);
            list1.add(num);
        }
        System.out.println();

        System.out.println("Enter the second list of 5 integers (0-9):");
        String input2 = scanner.nextLine();

        while (!checkListValidity(input2)) {
            input2 = scanner.nextLine();
        }

        int[] numbers2 = new int[5];
        for (int j = 0; j < 5; j++) {
            numbers2[j] = input2.charAt(j) - '0';
        }

        bSort(numbers2);

        System.out.print("Second sorted list: ");
        for (int nums2 : numbers2) {
            System.out.print(nums2);
            list2.add(nums2);
        }
        System.out.println();

        while (!list2.isEmpty()) {
            int numl = list2.getFirst();
            list1.add(numl);
            list2.removeFirst();
        }

        bSort(list1);

        System.out.println("Merged and sorted list: "+ list1);
        return list1;
    }

    public void Exercise3(LinkedList<Integer> list1) {
        System.out.println("Exercise 3:");
        reverseLinkedList(list1);
        System.out.println("Reversed list: "+ list1);
    }

    public static void main(String[] args) {
        lab4 lab4 = new lab4();
        lab4.Exercise1();
        LinkedList<Integer> list1 = lab4.Exercise2();
        lab4.Exercise3(list1);
    }
}
