package gameday;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 2/22/2019
 * GameDay
 *
 * https://www.lintcode.com/problem/lru-cache/description
 */
public class LRUCache {
    private Map<Integer, Integer> parent;
    private Map<Integer, Integer> next;
    private Map<Integer, Integer> cache;
    private final int dummy;
    private int recent;
    private final int CAPACITY;

    /*
     * @param capacity: An integer
     */public LRUCache(int capacity) {
        this.parent = new HashMap<>();
        this.next = new HashMap<>();
        this.cache = new HashMap<>();
        this.dummy = -1;
        this.recent = dummy;
        this.CAPACITY = capacity;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (cache.containsKey(key)) {

            return cache.get(key);
        } else {
            return -1;
        }
    }

    /**
     * if key exist, update its value and set it to most recent (edge case: alreay the most recent cache)
     * otherwise add it to most recent and if size > capacity then remove the oldest
     *
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);

            if (recent == key) {
                this.set(key, cache.get(key));
                return;
            }

            parent.put(next.get(key), parent.get(key));
            next.put(parent.get(key), next.get(key));

            parent.put(key, recent);
            next.put(recent, key);
            next.remove(key);
            this.recent = key;
        } else {
            cache.put(key, value);
            parent.put(key, recent);
            next.put(recent, key);
            recent = key;

            while (parent.size() > this.CAPACITY) {
                int expire = next.get(dummy);
                cache.remove(expire);
                next.put(parent.get(expire), next.get(expire));
                parent.put(next.get(expire), parent.get(expire));
                next.remove(expire);
                parent.remove(expire);
            }
        }
    }

    private void print() {
        System.out.println();
        System.out.println("parent: " + parent);
        System.out.println("next: " + next);
        System.out.println("cache: " + cache);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(2,1);
        cache.set(1,1);
        System.out.println(cache.get(2));
        cache.set(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
