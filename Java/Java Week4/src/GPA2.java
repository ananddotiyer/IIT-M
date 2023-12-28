import java.util.*;

interface Iterator {
    public boolean has_next();

    public Object get_next();
}

class Sequence {
    private final int maxLimit = 80;
    private SeqIterator _iter = null;
    int[] iArr;
    int size;
    int currentIndex = 0;

    public Sequence(int size) {
        this.size = size;
        this.iArr = new int[size];
    }

    public void addTo(int elem) {
        if (currentIndex < size) {
            iArr[currentIndex] = elem;
            currentIndex++;
        }
    }

    public Iterator get_Iterator() {
        if (_iter == null) {
            _iter = new SeqIterator();
        }
        return _iter;
    }

    private class SeqIterator implements Iterator {
        int indx;

        public SeqIterator() {
            indx = 0;
        }

        public boolean has_next() {
            return indx < size;
        }

        public Object get_next() {
            if (has_next()) {
                return iArr[indx++];
            }
            return null;
        }
    }
}

class GPA2 {
    public static void main(String[] args) {
        Sequence sObj = new Sequence(5);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int n = sc.nextInt();
            sObj.addTo(n);
        }
        Iterator i = sObj.get_Iterator();
        while (i.has_next())
            System.out.print(i.get_next() + ", ");
    }
}
