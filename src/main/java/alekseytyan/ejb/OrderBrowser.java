package alekseytyan.ejb;

public interface OrderBrowser {
    void passivate();
    void activate();
    void shutdown();
}
