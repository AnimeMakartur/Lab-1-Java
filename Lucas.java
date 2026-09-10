/**
 * Клас {@code Lucas} використовується для зберігання номера n
 * та значення числа Люка L(n). Клас також дозволяє обчислювати
 * число Люка і перевіряти виконання нерівності
 * n * L(n + 1) > (n + 1) * L(n).
 *
 * @author Шишков Єгор ОІ-21
 */
public class Lucas {
    private final int index;
    private final long lucasValue;

    /**
     * Конструктор класу {@code Lucas}.
     *
     * @param index номер числа Люка
     * @throws IllegalArgumentException якщо індекс є від'ємним
     */
    public Lucas(int index) {
        this.index = index;
        this.lucasValue = calculateLucas(index);
    }

    /**
     * Повертає номер числа Люка.
     *
     * @return значення поля {@code index}
     */
    public int getIndex() {
        return index;
    }

    /**
     * Повертає значення числа Люка для поточного індексу.
     *
     * @return значення поля {@code lucasValue}
     */
    public long getLucasValue() {
        return lucasValue;
    }

    /**
     * Обчислює n-те число Люка рекурсивно.
     *
     * @param n номер числа Люка
     * @return значення L(n)
     */
    public long calculateLucas(int n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 1;
        } else {
            return calculateLucas(n - 1) + calculateLucas(n - 2);
        }
    }

    /**
     * Перевіряє виконання нерівності:
     * n * L(n + 1) > (n + 1) * L(n).
     *
     * @return {@code true}, якщо нерівність виконується, інакше {@code false}
     */
    public boolean checkInequality() {
        long leftSide = (long) index * calculateLucas(index + 1);
        long rightSide = (long) (index + 1) * lucasValue;
        return leftSide > rightSide;
    }
}
