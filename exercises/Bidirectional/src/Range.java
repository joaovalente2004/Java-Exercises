import java.util.Iterator;

public class Range implements Iterable<Integer>{

    private int min;

    private int max;




    public Range(int min, int max){
        this.min = min;
        this.max = max;
    }


    public void setReversed(boolean reversed){

        if (reversed){
            Iterator<Integer> it = iterator();
            while (it.hasNext()) {
                it.next();
            }


        }
        else {
            Iterator<Integer> it = iterator();
            while (it.hasNext()) {
                it.next();
            }

        }
    }




    public Iterator<Integer> iterator(){

        return new Iterator() {

            private int current = min;


            @Override
            public boolean hasNext() {
                return current <= max;
            }

            @Override
            public Integer next() {
                return current++;
            }

            @Override
            public void remove() {
                while (hasNext()) {
                    current++;
                }
            }

            public void forwardIterator() {
                while (hasNext()) {
                    current++;
                }
            }
            public void backWardIterator() {
                while (hasNext()) {
                    current--;
                }
            }



        };


    }















}
