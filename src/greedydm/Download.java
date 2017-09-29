package greedydm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/**
 *
 * @author alireza
 */
public class Download extends Observable implements Runnable {

    //max size of download buffer.
    private static final int MAX_BUFFER_SIZE = 1024;
    //strat download from ...
    private int from;
    //stop download at ...
    private int to;
    //how much downloaded
    private int downloaded;
    //size to download
    private int size;
    //the url to download
    private URL url;
    //address of the local file in which the downloaded file should be stored
    private File output;
    //download thread
    private Thread downloadThread;
    //current download speed
    private double downloadSpeed;

    //diffrent download status
    public static enum STATUS {

        CONNECTING,
        DOWNLOADING,
        PAUSED,
        COMPLETE,
        CANCELLED,
        ERROR
    };
    //download's status
    private STATUS myStatus;

    public Download(URL url, int from, int to, File output) {
        this.from = from;
        this.to = to;
        this.url = url;

        this.output = output;
        if (output.exists()) {
            this.downloaded = (int) output.length();
        } else {
            this.downloaded = 0;
        }

        this.size = to - from + 1;


    }

    public int getSize() {
        return size;
    }

    public double getDownloadSpeed() {
        return downloadSpeed;
    }

    //return the status
    public STATUS getStatus() {
        return myStatus;
    }

    public void cancel() {
        myStatus = STATUS.CANCELLED;
        stateChanged();
    }

    public void pause() {
        myStatus = STATUS.PAUSED;
        stateChanged();
    }

    public void start() {
        downloadThread = new Thread(this);
        downloadThread.start();
    }

    // Get this download's progress.
    public float getProgress() {
        return ((float) downloaded / size) * 100;
    }

    public int getDownloaded() {
        return downloaded;
    }

    @Override
    public void run() {

        RandomAccessFile file = null;
        InputStream stream = null;

        try {

            myStatus = STATUS.CONNECTING;
            stateChanged();
            // Open connection to URL.
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Specify what portion of file to download.
            connection.setRequestProperty("Range", "bytes=" + from + "-");

            // Connect to server.
            connection.connect();

            // Make sure response code is in the 200 range.
            if (connection.getResponseCode() / 100 != 2) {
                myStatus = STATUS.ERROR;
                stateChanged();
                return;
            }

            // Open file and seek to the end of it.
            file = new RandomAccessFile(output, "rw");
            file.seek(downloaded);

            stream = connection.getInputStream();

            //a temp variable for calculating amount of bytes downloaded. i use it for calculating DL speed
            int downed = 0;

            myStatus = STATUS.DOWNLOADING;
            stateChanged();

            long startTime = System.nanoTime();


            while (myStatus == STATUS.DOWNLOADING) {
                /* Size buffer according to how much of the
                 file is left to download. */
                byte buffer[];
                if (size - downloaded > MAX_BUFFER_SIZE) {
                    buffer = new byte[MAX_BUFFER_SIZE];
                } else {
                    buffer = new byte[size - downloaded];
                }

                // Read from server into buffer.
                int read = stream.read(buffer);

                downloadSpeed = 1000000000.0 * downed / (System.nanoTime() - startTime + 1);

                if (read == -1) {
                    break;
                }

                // Write buffer to file.
                file.write(buffer, 0, read);
                downloaded += read;
                downed += read;

                if (downloaded == size) {
                    break;
                }
                //to show download progress
                stateChanged();
            }

            if (myStatus == STATUS.DOWNLOADING) {
                myStatus = STATUS.COMPLETE;
                stateChanged();
            }

        } catch (IOException ex) {
            myStatus = STATUS.ERROR;
        } finally {
            // Close file.
            if (file != null) {
                try {
                    file.close();
                } catch (Exception e) {
                }
            }

            // Close connection to server.
            if (stream != null) {
                try {
                    stream.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public File getFile() {
        return output;
    }

    private void stateChanged() {
        setChanged();
        notifyObservers();
    }
}
