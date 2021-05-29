package ru.kriniz.counter.service;

import ru.kriniz.counter.store.Store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.zip.ZipInputStream;

/**
 * Counting unique IP addresses in a zip file.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 28.05.2021
 */
public class ZipFileCounter extends AbstractCounter {

    public ZipFileCounter(Store store, String fileName) {
        super(store, fileName);
    }

    @Override
    public void count() throws Exception {
        File file = new File(this.fileName);
        try (var zip = new ZipInputStream(new FileInputStream(file));
             var reader = new BufferedReader(new InputStreamReader(zip))
        ) {
            while (Objects.nonNull(zip.getNextEntry())) {
                reader.lines()
                        .forEach(this.store::addIP);
            }
        }
    }
}
