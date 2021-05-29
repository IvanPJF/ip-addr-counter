package ru.kriniz.counter.service;

import java.util.StringJoiner;

/**
 * Info class.
 * Used to get information about the result of the {@link Counter}.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 28.05.2021
 */
public class Info {

    private final long numberAllIPs;
    private final long numberUniqIPs;

    public Info(long numberAllIPs, long numberUniqIPs) {
        this.numberAllIPs = numberAllIPs;
        this.numberUniqIPs = numberUniqIPs;
    }

    @Override
    public String toString() {
        return new StringJoiner(System.lineSeparator())
                .add("Number uniq IPs: " + numberUniqIPs)
                .add("Number all  IPs: " + numberAllIPs)
                .toString();
    }
}
