public class Queue {
    private int length;
    private String[] elements;
    private int numberOfElements;
    private int nextElementIndex;

    public Queue(int length) {
        this.length = length;
        elements = new String[length];
        numberOfElements = 0;
        nextElementIndex = 0;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean isFull() {
        return numberOfElements == length;
    }

    public boolean addElement(String element) {
        int endOfQueue = (numberOfElements + nextElementIndex) % length;

        if (isFull()) {
            return false;
        }

        elements[endOfQueue] = element;
        numberOfElements++;

        return true;
    }

    public String removeElement() {
        String element = null;

        if (isEmpty()) {
            return element;
        }

        element = elements[nextElementIndex];

        nextElementIndex = (nextElementIndex + 1) % length;
        numberOfElements--;

        return element;
    }
}
