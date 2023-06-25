public class MyStack {
    private Object[] elements;
    private int top;

    public MyStack() {
        elements = new Object[10]; // Початковий розмір масиву
        top = -1;
    }

    public void push(Object value) {
        if (top == elements.length - 1) {
            resizeArray(); // Збільшення розміру масиву, якщо досягнуто його меж
        }

        elements[++top] = value; // Додавання елемента в кінець стеку
    }

    public void remove(int index) {
        if (index < 0 || index > top) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        for (int i = index; i < top; i++) {
            elements[i] = elements[i + 1]; // Зсув елементів вліво
        }

        elements[top--] = null; // Видалення останнього елемента
    }

    public void clear() {
        elements = new Object[10]; // Повторне створення масиву з початковим розміром
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return elements[top]; // Повертає останній елемент стеку
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        Object topElement = elements[top]; // Запам'ятовуємо останній елемент стеку
        elements[top--] = null; // Видалення останнього елемента
        return topElement;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private void resizeArray() {
        Object[] newElements = new Object[elements.length * 2]; // Збільшення розміру масиву вдвічі
        System.arraycopy(elements, 0, newElements, 0, elements.length); // Копіювання елементів в новий масив
        elements = newElements;
    }
}

