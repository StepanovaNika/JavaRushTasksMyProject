package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;
import java.util.Objects;

public class FileStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public FileStorageStrategy() {
        for (int i = 0; i < table.length; i++) {
            table[i] = new FileBucket();
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    private int hash(Long k) {
        return k.hashCode();
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private Entry getEntry(Long key) {
        final int hash = (key == null) ? 0 : hash(key);
        final int index = indexFor(hash, table.length);
        try {
            for (Entry e = table[index].getEntry(); e != null; e = e.next) {
                Object k;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
                    return e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void resize(final int newCapacity) {
        final FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;

    }

    private void transfer(FileBucket[] newTable) {
        for (final FileBucket bucket : table) {
            Entry e = null;
            try {
                e = bucket.getEntry();
                while (e != null) {
                    final Entry next = e.next;
                    final int index = indexFor(e.hash, newTable.length);
                    e.next = newTable[index].getEntry();
                    newTable[index].putEntry(e);
                    e = next;
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            bucket.remove();
        }

    }

    private void addEntry(final int hash, final Long key, final String value, final int bucketIndex) {
        try {
            final Entry e = table[bucketIndex].getEntry();
            table[bucketIndex].putEntry(new Entry(hash, key, value, e));
            size++;
            final long currentBucketSize = table[bucketIndex].getFileSize();
            maxBucketSize = currentBucketSize > maxBucketSize ? currentBucketSize : maxBucketSize;
            if (maxBucketSize > bucketSizeLimit) resize(2 * table.length);
        } catch (Exception e) {

        }
    }

    private void createEntry(final int hash, final Long key, final String value, final int bucketIndex) {
        try {
            table[bucketIndex].putEntry(new Entry(hash, key, value, null));
            size++;
            final long currentBucketSize = table[bucketIndex].getFileSize();
            maxBucketSize = currentBucketSize > maxBucketSize ? currentBucketSize : maxBucketSize;
        } catch (Exception e) {

        }
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return false;
        try {
            for (FileBucket aTable : table) {
                for (Entry e = aTable.getEntry(); e != null; e = e.next)
                    if (value.equals(e.value))
                        return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        addEntry(hash(key), key, value, indexFor(hash(key), table.length));
    }

    @Override
    public Long getKey(String value) {
        try {
            for (final FileBucket bucket : table) {
                for (Entry e = bucket.getEntry(); e != null; e = e.next) {
                    if (Objects.equals(e.value, value))
                        return e.getKey();
                }
            }
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return getEntry(key) == null ? null : getEntry(key).getValue();
    }
}
