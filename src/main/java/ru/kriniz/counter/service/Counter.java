package ru.kriniz.counter.service;

/**
 * Counter interface.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 28.05.2021
 */
public interface Counter {

    /**
     * Counts the number of unique IP addresses.
     */
    void count() throws Exception;

    /**
     * The result of counting ip addresses.
     */
    Info result();
}
