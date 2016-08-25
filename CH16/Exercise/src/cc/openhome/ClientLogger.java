package cc.openhome;
public class ClientLogger {
    @ClientAdded
    public void clientAdded(ClientEvent event) {
        System.out.println(event.getIp() + " added...");
    }
	
    @ClientRemoved
    public void clientRemoved(ClientEvent event) {
        System.out.println(event.getIp() + " removed...");
    }
}