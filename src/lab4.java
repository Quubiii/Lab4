import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class lab4 {

    public void bSort(int[] array) { //bubble sort algorithm for arrays
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

    public void bSort(LinkedList<Integer> list) { //bubble sort algorithm for LinkedList
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
        if (input.length() != 5 || !input.matches("[0-9]+")) { //java construction to check if something matches 0-9
            System.out.println("You MUST enter exactly 5 integers (digits 0-9).");
            return false;
        }
        return true;
    }

    public boolean checkListIntegers(String input) {
        if(!input.matches("[0-9]+")) {
            System.out.println("You MUST enter the list of INTEGERS (digits 0-9).");
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
                break; //unikac break
            }
            strings.add(input);
        }

        System.out.println(String.join("-", strings));
    }

    public void Exercise2() { //without built-in functions
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
            numbers[i] = input1.charAt(i) - '0'; //char => int
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
    }

    public void Exercise3() { //without built-in functions
        LinkedList<Integer> list3 = new LinkedList<>();
        System.out.println("Exercise 3.\nEnter the list you want to reverse: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!checkListIntegers(input)) {
            input = scanner.nextLine();
        }

        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0'; //char => int
            list3.add(digit);
        }

        reverseLinkedList(list3);
        System.out.println("Reversed list: " + list3);
    }

    public String Exercise4() {
        ArrayList<Character> list4 = new ArrayList<>();
        System.out.println("Exercise 4.\nEnter the list of characters: ");
        Scanner scanner = new Scanner(System.in);
        String list4s = scanner.nextLine();
        System.out.println("Enter the char you want to check for in the list: ");
        char checkChar = scanner.nextLine().charAt(0);

        for(char ch : list4s.toCharArray()){
            list4.add(ch);
        }

        if(list4.contains(checkChar)) {
            return checkChar + " is in the list.";
        }
        return checkChar + " is not in the list.";
    }

    public void Exercise5() {
        ArrayList<Character> list5 = new ArrayList<>();
        System.out.println("Exercise 5.\nEnter an array of characters: ");
        Scanner scanner = new Scanner(System.in);
        String list5s = scanner.nextLine();

        System.out.println("Which element of an array do you want to update? [1 for first, 2 for second, etc]: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the new value of chosen element: ");
        char value = scanner.nextLine().charAt(0);

        for(char ch : list5s.toCharArray()) {
            list5.add(ch);
        }

        list5.set(index - 1, value);
        System.out.println(list5);
    }

    public void Exercise6() {
        ArrayList<Integer> list6 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Exercise 6.\nEnter 6 numbers you want to add to the list (press Enter after each number): ");

        for (int i = 0; i < 6; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            int number = scanner.nextInt();
            list6.add(number);
        }

        System.out.println("Numbers in the list: " + list6);

        for (int i = 0; i < list6.size() - 1; i += 3) {
            int sum = list6.get(i) + list6.get(i + 1);
            list6.add(i + 2, sum);
        }

        System.out.println("Modified list: "+list6);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner tsetse = new Scanner(System.in);
        lab4 lab4 = new lab4();

        while (true) {
            System.out.println("Which exercise do you want me to start? Type [all/1/2/3/4/5/6/stop]");
            String choice = tsetse.nextLine();

            if (choice.equalsIgnoreCase("all")) {
                lab4.Exercise1();
                lab4.Exercise2();
                lab4.Exercise3();
                System.out.println(lab4.Exercise4());
                lab4.Exercise5();
                lab4.Exercise6();
            } else if (choice.equals("1")) {
                lab4.Exercise1();
            } else if (choice.equals("2")) {
                lab4.Exercise2();
            } else if (choice.equals("3")) {
                lab4.Exercise3();
            } else if (choice.equals("4")) {
                System.out.println(lab4.Exercise4());
            } else if (choice.equals("5")) {
                lab4.Exercise5();
            } else if (choice.equals("6")) {
                lab4.Exercise6();
            } else if (choice.equalsIgnoreCase("stop")) {
                System.out.println("Exiting the program...");
                break; //try to avoid break
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
