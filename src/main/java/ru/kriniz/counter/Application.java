package ru.kriniz.counter;

import ru.kriniz.counter.service.*;
import ru.kriniz.counter.store.*;

/**
 * A class for launching the application.
 *
 * @author IvanPJF (teaching-light@yandex.ru)
 * @version 0.1
 * @since 28.05.2021
 */
public class Application {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new RuntimeException("Please enter a file name with ip addresses");
        }
        String fileName = args[0];
        Counter counter = getCounter(fileName);
        counter.count();
        Info info = counter.result();
        System.out.println(info);
    }

    /**
     * Determines which {@link Counter} will be used.
     * @param fileName The name of the file containing the ip addresses.
     */
    private static Counter getCounter(String fileName) {
        Store store = BitSetStore.getInstance();
        if (isZipFile(fileName)) {
            return new ZipFileCounter(store, fileName);
        }
        return new SimpleFileCounter(store, fileName);
    }

    /**
     * Determines whether the file is a zip archive.
     * @param fileName The name of the file containing the ip addresses.
     */
    private static boolean isZipFile(String fileName) {
        return fileName.endsWith(".zip");
    }
}
