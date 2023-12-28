import java.util.*;

interface Mammal{
    int getLifeSpan();
}
class Whale implements Mammal{
    private int lifespan;
    Whale (int l){
        lifespan = l;
    }
    public int getLifeSpan() {
        return lifespan;
    }
}

class Elephant implements Mammal{
    private int lifespan;
    Elephant(int l){
        lifespan = l;
    }
    public int getLifeSpan() {
        return lifespan;
    }
}
public class ET304<T>{
    public static <S extends Mammal> void pickLongLspan(List<Object> tgt, List<S> src) {
        for (S animal: src)
            if (animal.getLifeSpan() > 50)
                tgt.add(animal);
    }
    public static void main(String[] args) {
        ArrayList<Elephant> el = new ArrayList<>();
        ArrayList<Whale> wh = new ArrayList<>();
        ArrayList<Mammal> long_lspan = new ArrayList<>();
        el.add(new Elephant(48));
        el.add(new Elephant(56));
        wh.add(new Whale(180));
        wh.add(new Whale(200));

        pickLongLspan(long_lspan, el);
        pickLongLspan(long_lspan, wh);
    }
}
