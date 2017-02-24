import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
	Queue<Integer> quene = new LinkedList<Integer>();
	
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    while(iterator.hasNext()){
	    	quene.offer(iterator.next());
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return quene.peek();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return quene.poll();
	}

	@Override
	public boolean hasNext() {
	    return !quene.isEmpty();
	}
}