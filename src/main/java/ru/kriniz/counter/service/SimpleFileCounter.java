package ru.kriniz.counter.service;

import ru.kriniz.counter.store.Store;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Counting unique IP addresses in a simple text file.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 28.05.2021
 */
public class SimpleFileCounter extends AbstractCounter {

    public SimpleFileCounter(Store store, String fileName) {
        super(store, fileName);
    }

    @Override
    public void count() throws Exception {
        try (var stream = Files.lines(Path.of(this.fileName))) {
            stream.forEach(this.store::addIP);
        }
    }
}
