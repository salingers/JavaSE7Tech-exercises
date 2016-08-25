package cc.openhome;

import java.util.*;

/**
 *
 * @author Justin
 */
public class WorkerThreadPool {
    private List<WorkerThread> workerThreads;
    public WorkerThreadPool() {
        workerThreads = new ArrayList<WorkerThread>();
    }
    public synchronized void service(Request request) {
        boolean idleNotFound = true;
        for(WorkerThread workerThread : workerThreads) {
            if(workerThread.isIdle()) {
                workerThread.setRequest(request);
                idleNotFound = false;
                break;
            }
        }
        if(idleNotFound) {
            WorkerThread workerThread = createWorkerThread();
            workerThread.setRequest(request);
        }
    }
    public synchronized void cleanIdle() {
        for(WorkerThread workerThread : workerThreads) {
            if(workerThread.isIdle()) {
                workerThreads.remove(workerThread);
                workerThread.terminate();
            }
        }
    }
    private WorkerThread createWorkerThread() {
        WorkerThread workerThread = new WorkerThread();
        workerThread.start();
        workerThreads.add(workerThread);
        try {
            Thread.sleep(1000); // 給點時間進入 Runnable
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        return workerThread;
    }
}
