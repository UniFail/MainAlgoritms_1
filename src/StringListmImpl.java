import java.util.Arrays;

public class StringListmImpl implements StringList {
    private int size;
    private String[] storage;

    public StringListmImpl() {
        storage = new String[10];
    }

    public StringListmImpl(int initSize) {
        storage = new String[initSize];
    }


    public String add(String item) {
        validatorSize();
        validatorItem(item);
        storage[size++] = item;
        return item;
    }

    public String add(int index, String item) {
        validatorSize();
        validatorItem(item);
        validatorIndex(index);
        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;

        return item;
    }

    public String set(int index, String item) {
        validatorIndex(index);
        validatorItem(item);
        storage[index] = item;
        return item;
    }

    public String remove(String item) {
        validatorItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    public String remove(int index) {
        validatorIndex(index);
        String item = storage[index];
        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }

    public boolean contains(String item) {
        return indexOf(item) == -1;
    }

    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public String get(int index) {
        validatorIndex(index);
        return storage[index];
    }

    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    public int size() {
        return 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    public void getAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(storage[i]);
        }
    }

    private void validatorItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validatorSize() {
        if (size == storage.length) {
            throw new FullStorageException();
        }
    }

    private void validatorIndex(int index) {
        if (index < 0 || index > size) {
            throw new NotFoundExceprion();
        }
    }


}
