package com.levik.hw3;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void testCase1() {
        var lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);


        Integer value = lruCache.get(2);

        lruCache.put(3, 3);

        assertEquals(Integer.valueOf(2), value);
        assertNull(lruCache.get(1));
        assertEquals(2, lruCache.get(2));
        assertEquals(3, lruCache.get(3));
    }
}