package com.levik.hw3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {

    static class LruLinkedHasMap<K, V> extends LinkedHashMap<K, V> {
        private static final float LOAD_FACTOR = 0.75f;

        private final int maxSize;

        public LruLinkedHasMap(int capacity) {
            super(capacity, LOAD_FACTOR, true);
            this.maxSize = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return this.size() > maxSize;
        }
    }

    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LruLinkedHasMap<>(capacity);
    }

    public int get(int key) {
        Integer value = cache.get(key);
        return Objects.nonNull(value) ? value : -1;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
