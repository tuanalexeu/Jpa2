package alekseytyan.ejb;

// @Local - Optional, indicates the interface implementations is for clients only
// Since we want to build EE java bean interface, we don't need this
public interface HelloService {
    public String sayHello(String name);
}
