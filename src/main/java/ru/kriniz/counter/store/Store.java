package ru.kriniz.counter.store;

import ru.kriniz.counter.service.Info;

/**
 * Store interface.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 28.05.2021
 */
public interface Store {

    /**
     * Adds an IP address to the storage.
     * @param ipAddress The IP address in the text view.
     */
    void addIP(String ipAddress);

    /**
     * Counting result.
     */
    Info result();
}
