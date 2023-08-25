import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- USING ENHANCED FOR WITH FORWARD ITERATOR ---");
        Range r = new Range(3,9);
        r.setReversed(false);

        for (Integer i : r) {
            System.out.println(i);
        }

        System.out.println("--- USING FORWARD ITERATOR ---");
        Iterator<Integer> it = r.iterator();

        while (it.hasNext()) {
           int i = it.next();
           System.out.println(i);

           if (i == 8 || i == 9) {
               System.out.println("Removing " + i);
               it.remove();
           }
        }
        System.out.println("--- USING NEW FORWARD ITERATOR ---");
        it = r.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("--- USING REVERSE ITERATOR ---");
        r.setReversed(true);
        it = r.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
