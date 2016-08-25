package cc.openhome;

public class WorkerThread extends Thread {
    private Request request;
    private boolean isContinue = true;
    public boolean isIdle() {
        return request == null;
    }
    public void setRequest(Request request) {
        synchronized(this) {
            if(isIdle()) {
                this.request = request;
                notify();
            }
        }
    }
    public void run() {
        while(isContinue) {
            synchronized(this) {
                try {
                    wait();
                }
                catch(InterruptedException e) {
                    throw new RuntimeException(e);
                }
                request.execute();
                request = null;
            }
        }
    }
    public void terminate() {
        isContinue = false;
        setRequest(new Request() {
            public void execute() { /* do nothing */ }
        });
    }
}
