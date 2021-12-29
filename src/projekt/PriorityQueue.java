package projekt;

/**
 * Ett interface för prioritetskö
 * @author Oskar Persson
 *
 * @param <T> Element som sparas i kön
 */
public interface PriorityQueue<T extends Comparable<? super T>>{
	public void clear();
	public boolean isEmpty();
	public boolean isFull();
	public int size();
	public void enqueue(T element);
	public T dequeue();
	public T getFront();
}
