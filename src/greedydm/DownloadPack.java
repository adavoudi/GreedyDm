package greedydm;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author alireza
 */
public class DownloadPack extends Observable implements Observer {

    private int numberOfThreads;
    private URL url;
    private ArrayList<Download> downloads;
    private String name;
    private int size;
    private Download.STATUS downloadStatus;
    private File output;
    private boolean mereged = false;

    public DownloadPack(URL url, int from, int to, int numberOfThreads, File output) {

        this.url = url;
        this.numberOfThreads = numberOfThreads;
        this.name = url.getFile().substring(url.getFile().lastIndexOf("/"));
        this.size = to - from + 1;
        this.output = output;

        downloads = new ArrayList<Download>();

        int partSize = size / numberOfThreads;

        for (int i = 1, index = 1; i <= numberOfThreads; i++, index++) {
            int f = (i - 1) * partSize + from;
            int t = i * partSize - 1 + from;
            if (i == numberOfThreads) {
                t = to;
            }

            File out = new File(output.getAbsolutePath() + "/" + name + ".th" + index);
            Download dl = new Download(url, f, t, out);
            dl.addObserver(this);
            downloads.add(dl);
        }

        downloadStatus = Download.STATUS.PAUSED;

    }

    public void start() {
        downloadStatus = Download.STATUS.CONNECTING;
        for (Download dl : downloads) {
            dl.start();
        }
        stateChanged();
    }

    public void pause() {
        downloadStatus = Download.STATUS.PAUSED;
        for (Download dl : downloads) {
            dl.pause();
        }
        stateChanged();
    }

    public void cancel() {
        downloadStatus = Download.STATUS.CANCELLED;
        for (Download dl : downloads) {
            dl.cancel();
        }

    }

    @Override
    public void update(Observable o, Object o1) {
        int dl = downloads.indexOf(o);
        switch (downloads.get(dl).getStatus()) {
            case ERROR:
                pause();
                downloadStatus = Download.STATUS.ERROR;
                break;
        }
        stateChanged();
    }

    public URL getUrl() {
        return url;
    }

    public int getSize() {
        return size;
    }

    public float getProgress() {
        float progress = 0;
        for (Download dl : downloads) {
            progress += ((float) dl.getDownloaded() / size);
        }
        return progress * 100;
    }

    public Download.STATUS getStatus() {

        boolean flag = false;
        for (Download dl : downloads) {
            if (dl.getStatus() == Download.STATUS.DOWNLOADING) {
                flag = true;
                break;
            }
        }
        if (flag) {
            downloadStatus = Download.STATUS.DOWNLOADING;
            return Download.STATUS.DOWNLOADING;
        }
        flag = true;
        for (Download dl : downloads) {
            if (dl.getStatus() != Download.STATUS.COMPLETE) {
                flag = false;
                break;
            }
        }
        if (flag) {
            downloadStatus = Download.STATUS.COMPLETE;
            if (!mereged) {
                mergeFiles();
                mereged = true;
            }
            return Download.STATUS.COMPLETE;
        }
        return downloadStatus;
    }

    private boolean mergeFiles() {
        File[] files = new File[downloads.size()];
        for (int i = 0; i < files.length; i++) {
            files[i] = downloads.get(i).getFile();
        }

        File out = new File(output.getAbsoluteFile() + "/" + name);

        return FileMerger.mergeFiles(files, out);
    }

    public String getSpeed() {
        float speed = 0;
        for (Download dl : downloads) {
            speed += dl.getDownloadSpeed();
        }
        return speed + "";
    }

    private void stateChanged() {
        setChanged();
        notifyObservers();
    }
}
