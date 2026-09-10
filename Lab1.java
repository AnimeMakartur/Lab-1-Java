import java.util.Scanner;

class Lucas {
    private int index;
    private long lucasValue;
    public Lucas(int index) {
        this.index = index;
        this.lucasValue = calculateLucas(index);
    }
    public long getLucasValue() {
        return lucasValue;
    }
    public int getIndex() {
        return index;
    }
    public long calculateLucas(int n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {

            return 1;

        }  else {
            return calculateLucas(n - 1) + calculateLucas(n - 2);
        }
        
    }
    public boolean checkInequality() {
        long leftSide = index * calculateLucas(index + 1);
        long rightSide = (index + 1) * calculateLucas(index);
        return leftSide > rightSide;
    }
}

public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        } else {
            System.out.println("Please input index for Lucas number:");
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