package alekseytyan.ejb;

import javax.ejb.Remote;

@Remote // equivalent to extend java.rmi.Remote interface
public interface HelloServiceRemote {
    String sayHello(String name);
}
