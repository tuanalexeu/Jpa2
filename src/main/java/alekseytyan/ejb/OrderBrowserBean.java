package alekseytyan.ejb;

import org.hibernate.cfg.NotYetImplementedException;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.ejb.Stateful;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;


@Stateful
public class OrderBrowserBean implements OrderBrowser {

    private DataSource dataSource;
    private Connection connection;


    @PostConstruct
    public void init() {
        acquireConnection();
    }

    public Collection<Order> listOrders() {
        throw new NotYetImplementedException();
    }
    @Override
    public void passivate() {
        releaseConnection();
    }

    @Override
    public void activate() {
        acquireConnection();
    }

    @Override
    public void shutdown() {
        releaseConnection();
    }

    private void acquireConnection() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new EJBException(e);
        }
    }

    private void releaseConnection() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException ignored) {
        }
    }
}
