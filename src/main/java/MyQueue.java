public class MyQueue {
    private Object[] elements;
    private int front;
    private int rear;
    private int size;

    public MyQueue() {
        elements = new Object[10]; // Початковий розмір масиву
        front = 0;
        rear = -1;
        size = 0;
    }

    public void add(Object value) {
        if (size == elements.length) {
            resizeArray(); // Збільшення розміру масиву, якщо досягнуто його меж
        }

        rear = (rear + 1) % elements.length; // Обчислення нового індексу rear
        elements[rear] = value; // Додавання елемента в кінець черги
        size++;
    }

    public void clear() {
        elements = new Object[10]; // Повторне створення масиву з початковим розміром
        front = 0;
        rear = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return elements[front]; // Повертає перший елемент черги
    }

    public Object poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        Object firstElement = elements[front]; // Запам'ятовуємо перший елемент черги
        elements[front] = null; // Встановлюємо початкове значення null для видаленого елемента
        front = (front + 1) % elements.length; // Обчислення нового індексу front
        size--;

        return firstElement;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void resizeArray() {
        Object[] newElements = new Object[elements.length * 2]; // Збільшення розміру масиву вдвічі
        int j = front;
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[j]; // Копіюємо елементи зі старого масиву в новий
            j = (j + 1) % elements.length;
        }
        elements = newElements;
        front = 0;
        rear = size - 1;
    }
}
