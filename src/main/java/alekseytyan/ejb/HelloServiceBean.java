package alekseytyan.ejb;

import javax.ejb.Stateless;

@Stateless // Indicates that bean doesn't have any state for a current session
public class HelloServiceBean implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
