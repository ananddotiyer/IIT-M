import java.util.*;

interface Iterator {
    public boolean has_next();

    public Object get_next();
}

class Sequence {
    private final int maxLimit = 80;
    int[] iArr;
    int size;
    int indx = -1;

    public Sequence(int size_) {
        iArr = new int[80];
        size = 0;
    }

    public void addTo(int elem) {
        iArr[size] = elem;
        size++;
    }

    public boolean has_next() {
        if (indx < size - 1)
            return true;
        return false;
    }

    public Object get_next() {
        return iArr[++indx];
    }

    // private class SeqIterator implements Iterator {
    //     int indx;

    //     public SeqIterator() {
    //         indx = -1;
    //     }

    // }
}

class FClass {
    public static void main(String[] args) {
        Sequence sObj = new Sequence(5);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            sObj.addTo(sc.nextInt());
        }
        while (sObj.has_next())
            System.out.print(sObj.get_next() + ", ");
    }
}