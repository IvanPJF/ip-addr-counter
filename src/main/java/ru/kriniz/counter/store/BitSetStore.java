package ru.kriniz.counter.store;

import ru.kriniz.counter.service.Info;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Storage of IP addresses.
 * IP addresses are stored in the data structure-BitSet.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 28.05.2021
 */
public class BitSetStore implements Store {

    private static final int RANGE_SECTOR = 256;
    private static final Store INSTANCE = new BitSetStore();

    private final List<BitSet> store;
    private long numberAllIPs;

    private BitSetStore() {
        this.store = createFilledStore();
    }

    public static Store getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a filled list.
     * The number of list items is equal to
     * the maximum possible number of values of the first sector of the ip address.
     */
    private List<BitSet> createFilledStore() {
        return IntStream.range(0, RANGE_SECTOR)
                .mapToObj(el -> new BitSet())
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public void addIP(String ipAddress) {
        String[] ipAddrAll = ipAddress.split("\\.");
        int ipAddr1 = Integer.parseInt(ipAddrAll[0]);
        BitSet bitSet = store.get(ipAddr1);
        bitSet.set(Integer.parseInt(ipAddrAll[1]) * RANGE_SECTOR * RANGE_SECTOR
                + Integer.parseInt(ipAddrAll[2]) * RANGE_SECTOR
                + Integer.parseInt(ipAddrAll[3]));
        this.numberAllIPs++;
    }

    @Override
    public Info result() {
        long numUniq = store.stream()
                .mapToLong(BitSet::cardinality)
                .sum();
        return new Info(this.numberAllIPs, numUniq);
    }
}
