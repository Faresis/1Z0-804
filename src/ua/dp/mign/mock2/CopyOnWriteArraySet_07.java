package ua.dp.mign.mock2;

import java.util.Set;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/*
 * Usually if a collection is modified after
 * iterator is retrieved any usage of such
 * iterator will cause ConcurrentModificationException.
 * But CopyOnWriteArraySet is a thread safe
 * collection which provides iterator over
 * a snapshot of a collection state at the
 * moment when iterator was created. So any
 * further modifications don't affect iterator
 * state.
 */
class CopyOnWriteArraySet_07 {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<String>();
        set.add("2");
        set.add("1");
        Iterator<String> iter = set.iterator();
        set.add("3");
        set.add("-1");
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
