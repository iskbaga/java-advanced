package info.kgeorgiy.ja.bagautdinov.arrayset;

import java.util.*;

public class ArraySet<E> extends AbstractSet<E> implements NavigableSet<E> {
    private final List<E> list;
    private final Comparator<? super E> comparator;

    public ArraySet() {
        this(Collections.emptyList(), null);
    }

    public ArraySet(Collection<? extends E> collection) {
        this(collection, null);
    }

    public ArraySet(Collection<? extends E> collection, Comparator<? super E> comparator) {
        this.comparator = comparator;
        TreeSet<E> treeSet = new TreeSet<>(comparator);
        treeSet.addAll(collection); // NOTE: what if collection was sorted
        this.list = new ArrayList<>(treeSet);
    }


    private ArraySet(Comparator<? super E> comparator, List<E> collection) {
        this.list = collection;
        this.comparator = comparator;
    }

    @Override
    public E lower(E e) {
        int index = lowerIndex(e);
        return getHelper(index);
    }

    @Override
    public E floor(E e) {
        int index = floorIndex(e);
        return getHelper(index);
    }

    @Override
    public E ceiling(E e) {
        int index = ceilingIndex(e);
        return getHelper(index);
    }

    @Override
    public E higher(E e) {
        int index = higherIndex(e);
        return getHelper(index);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return true;
        }
        E e = (E) o;
        int index = Collections.binarySearch(list, e, comparator);
        return index >= 0;
    }


    @Override
    public E pollFirst() {
        throw new UnsupportedOperationException("ArraySet is immutable");
    }

    @Override
    public E pollLast() {
        throw new UnsupportedOperationException("ArraySet is immutable");
    }


    @Override
    public Iterator<E> iterator() {
        return Collections.unmodifiableList(list).iterator();
    }

    @Override
    public NavigableSet<E> descendingSet() {
        List<E> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        return new ArraySet<>(reversedList, Collections.reverseOrder(comparator));
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            private int index = list.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return list.get(index--);
            }
        };
    }

    @SuppressWarnings("unchecked")
    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        Comparator<? super E> comp = comparator != null ? comparator : (Comparator<? super E>) Comparator.naturalOrder(); // NOTE: unchecked cast
        if (comp.compare(fromElement, toElement) > 0) {
            throw new IllegalArgumentException("fromKey > toKey");
        }

        int fromIndex = fromInclusive ? ceilingIndex(fromElement) : higherIndex(fromElement);
        int toIndex = toInclusive ? floorIndex(toElement) : lowerIndex(toElement);
        if (fromIndex > toIndex) {
            return new ArraySet<>(comparator, Collections.emptyList());
        }
        if (toIndex < 0) {
            toIndex = -(toIndex + 1);
        }
        return new ArraySet<>(comparator, list.subList(fromIndex, toIndex + 1));
    }

    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        int toIndex = inclusive ? floorIndex(toElement) : lowerIndex(toElement);
        if (toIndex == -1)
            return new ArraySet<>(comparator, Collections.emptyList());
        return new ArraySet<>(comparator, list.subList(0, toIndex + 1));
    }

    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        int fromIndex = inclusive ? ceilingIndex(fromElement) : higherIndex(fromElement);
        if (fromIndex == -1) {
            return new ArraySet<>(comparator, Collections.emptyList());
        }
        return new ArraySet<>(comparator, list.subList(fromIndex, list.size()));
    }

    @Override
    public Comparator<? super E> comparator() {
        return comparator;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return subSet(fromElement, true, toElement, false);
    }


    @Override
    public SortedSet<E> headSet(E toElement) {
        return headSet(toElement, false);
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        return tailSet(fromElement, true);
    }


    @Override
    public E first() {
        if (list.size() == 0) throw new NoSuchElementException();
        return list.get(0);
    }

    @Override
    public E last() {
        if (list.size() == 0) throw new NoSuchElementException();
        return list.get(list.size() - 1);
    }

    @Override
    public int size() {
        return list.size();
    }

    private E getHelper(int index) {
        if (index >= 0 && index < list.size())
            return list.get(index);
        return null;
    }

    private int indexHelper(E e, int a, int b) {
        int index = Collections.binarySearch(list, e, comparator);
        return index >= 0 ? index + a : -(index + 1) + b;
    }

    private int ceilingIndex(E e) {
        return indexHelper(e, 0, 0);
    }

    private int higherIndex(E e) {
        return indexHelper(e, 1, 0);
    }

    private int floorIndex(E e) {
        return indexHelper(e, 0, -1);
    }

    private int lowerIndex(E e) {
        return indexHelper(e, -1, -1);
    }
}