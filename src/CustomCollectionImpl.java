/**
 * метод add - добавляет значение.
 * метод addAll - добавляет все значения.
 * метод delete - удаляет значение по индексу и по значению.
 * метод get - получает значение по индексу.
 * метод contains - проверяет список на содержание какого-либо обьекта.
 * метод clear - удаляет все значения в списке;
 * метод size - получает размер списка.
 * метод trim - true.
 */
public class CustomCollectionImpl implements CustomCollection {
    private Node head;
    private Node tail;
    private int size;

    public CustomCollectionImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        if (size != 0) {
            Node firstElement = new Node(value);
            tail.next = firstElement;
            firstElement.previous = tail;
            tail = firstElement;
        } else {
            tail = new Node(value);
            head = tail;
        }
        size++;
        return true;
    }

    @Override
    public boolean addAll(Collection strColl) {
        if (strColl == null || strColl.size() == 0) {
            return false;
        }
        for (int i = 0; i < strColl.size(); i++) {
            add(strColl.get(i));
        }
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index == 0) {
            Node node = head;
            head = node.next;
            node.previous = null;
            node.next = null;
            node.data = null;
        } else if (size == index + 1) {
            Node node = tail;
            tail = node.previous;
            tail.next = null;
            node.previous = null;
            node.data = null;
        } else {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
        size--;
        return true;
    }

    @Override
    public boolean delete(String str) {
        Node element = head;
        int index = 0;
        while (!element.data.equals(str)) {
            index++;
            element = element.next;
        }
        delete(index);

        return true;
    }

    @Override
    public String get(int index) {
        isOutOfBound(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public boolean contains(String str) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        head = null;
        tail = null;
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean trim() {
        return true;
    }

    private void isOutOfBound(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Incorrect index entry");

        }
    }
}

