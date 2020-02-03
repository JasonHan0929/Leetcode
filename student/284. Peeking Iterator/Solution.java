// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

	Iterator<Integer> iterator;
    Integer cache;
    
    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        Integer cache = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (cache == null)
            cache = iterator.next();
        return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (cache != null) {
            int temp = cache;
            cache = null;
            return temp;
        } else
            return iterator.next();
	}

	@Override
	public boolean hasNext() {
	    return iterator.hasNext() || cache != null;
	}
}

/*
Generic class could not pass the OJ but I test it and the result is correct.

public class Test implements Runnable {
    class PeekingIteratorGeneric<T> implements Iterator<T> {
        Iterator<T> iterator;
        T cache;

        public PeekingIteratorGeneric(Iterator<T> iterator) {
            // initialize any member here.
            cache = null;
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public T peek() {
            if (cache == null)
                cache = iterator.next();
            return cache;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public T next() {
            if (cache != null) {
                T temp = cache;
                cache = null;
                return temp;
            } else
                return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext() || cache != null;
        }
    }

    class PeekingIterator implements Iterator<Integer> {

        Iterator<Integer> iterator;
        Integer cache;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            Integer cache = null;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (cache == null)
                cache = iterator.next();
            return cache;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (cache != null) {
                int temp = cache;
                cache = null;
                return temp;
            } else
                return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext() || cache != null;
        }
    }

    @Override
    public void run() {
        List<Integer> test = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        PeekingIteratorGeneric<Integer> iterA = new PeekingIteratorGeneric<>(test.iterator());
        PeekingIterator iterB = new PeekingIterator(test.iterator());
        //Random random = new Random();
        List<Integer> operation = new ArrayList<>(Arrays.asList(0,1,1,2,2,1,1,2,0,1,0,2,0));
        for (int i = 0; i < 13; i++) {
            if (!iterA.hasNext() && !iterB.hasNext()) {
                System.out.println("over");
                return;
            }
            switch (operation.get(i)) {
                case 0:
                    if(iterA.hasNext() && iterB.hasNext()) {
                        int a = iterA.peek(), b = iterB.peek();
                        if (a == b)
                            System.out.println("peek(): OK");
                        else
                            System.out.println(String.format("peek(): Fail    a: %d   b: %d", a, b));
                    } else
                        System.out.println("One of them is ended first");
                    break;
                case 1:
                    if(iterA.hasNext() && iterB.hasNext()) {
                        int a = iterA.next(), b = iterB.next();
                        if (a == b)
                            System.out.println("next(): OK");
                        else
                            System.out.println(String.format("next(): Fail    a: %d   b: %d", a, b));
                    } else
                        System.out.println("One of them is ended first");
                    break;
                case 2:
                    if(iterA.hasNext() && iterB.hasNext()) {
                        boolean a = iterA.hasNext(), b = iterB.hasNext();
                        if (a == b)
                            System.out.println("hasNext(): OK");
                        else
                            System.out.println(String.format("hasNext(): Fail    a: %d   b: %d", a, b));
                    } else
                        System.out.println("One of them is ended first");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Test());
        thread.run();
    }
}
*/
