package ru.kriniz.counter.service;

import ru.kriniz.counter.store.Store;

/**
 * Counter abstract class.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 28.05.2021
 */
public abstract class AbstractCounter implements Counter {

    protected final Store store;
    protected final String fileName;

    public AbstractCounter(Store store, String fileName) {
        this.store = store;
        this.fileName = fileName;
    }

    public Info result() {
        return this.store.result();
    }
}
