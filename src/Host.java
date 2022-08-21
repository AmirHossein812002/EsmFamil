public class Host {
    private String hostName;
    private int port;
    private GameModule gameModule;
    private HostCard hostCard;

    public Host(String hostName, int port, GameModule gameModule) {
        this.hostName = hostName;
        this.port = port;
        this.gameModule = gameModule;
        this.hostCard = new HostCard(hostName, port, gameModule);
    }

    public String getHostName() {
        return hostName;
    }

    public int getPort() {
        return port;
    }

    public GameModule getGameModule() {
        return gameModule;
    }

    public HostCard getHostCard() {
        return hostCard;
    }
}
