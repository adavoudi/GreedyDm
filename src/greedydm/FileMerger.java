/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package greedydm;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author alireza
 */
public class FileMerger {

    public static boolean mergeFiles(File[] files, File output) {
        try {
            RandomAccessFile out = new RandomAccessFile(output, "rw");

            for (File file : files) {
                RandomAccessFile in = new RandomAccessFile(file, "r");
                int size = (int) file.length();
                int wrote = 0;
                while (size - wrote > 0) {
                    byte buffer[];
                    if (size - wrote > 10000) {
                        buffer = new byte[10000];
                    } else {
                        buffer = new byte[size - wrote];
                    }

                    int read = in.read(buffer);

                    if (read == -1) {
                        break;
                    }
                    out.write(buffer, 0, read);
                    wrote += read;
                }
            }

            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
