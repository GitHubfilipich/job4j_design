package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public final V get(K key) {
        V value = null;
        boolean load = false;
        SoftReference<V> sValue = cache.get(key);
        if (sValue == null) {
            load = true;
        } else {
            value = sValue.get();
            if (value == null) {
                load = true;
            }
        }
        if (load) {
            value = load(key);
            if (value != null) {
                put(key, value);
            }
        }
        return value;
    }

    protected abstract V load(K key);

}
