import java.util.Scanner;
/**
 * Головний клас програми. Приймає номер n або через командний рядок,
 * або з клавіатури, обчислює число Люка та перевіряє нерівність.
 *
 * @author Шишков Єгор ОІ-21
 */
public class Lab1 {
    /**
     * Точка входу в програму.
     *
     * @param args аргументи командного рядка; якщо передано один аргумент,
     *             його трактують як номер n
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        } else {
            System.out.print("Please input index for Lucas number: ");
            n = scanner.nextInt();
        }

        if (n < 0) {
            System.out.println("Index must be non-negative");
            scanner.close();
            return;
        }

        Lucas lucas = new Lucas(n);

        System.out.println("Lucas number details:");
        System.out.println("n = " + lucas.getIndex());
        System.out.println("L(" + lucas.getIndex() + ") = " + lucas.getLucasValue());

        if (lucas.checkInequality()) {
            System.out.println("Inequality holds:");
            System.out.println(lucas.getIndex() + " * L(" + (lucas.getIndex() + 1) + ") > "
                    + (lucas.getIndex() + 1) + " * L(" + lucas.getIndex() + ")");
        } else {
            System.out.println("Inequality does not hold:");
            System.out.println(lucas.getIndex() + " * L(" + (lucas.getIndex() + 1) + ") <= "
                    + (lucas.getIndex() + 1) + " * L(" + lucas.getIndex() + ")");
        }

        scanner.close();
    }
}