package alekseytyan.dependency;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
@EJB(name = "audit", beanInterface = AuditService.class)
public class DeptServiceBean implements DeptService {

    @EJB
    private AuditService audit;

    @PostConstruct
    public void init() {
        try {
            Context ctx = new InitialContext();
            audit = (AuditService) ctx.lookup("java:comp/env/audit");
        } catch (NamingException e) {
            throw new EJBException(e);
        }
    }
}
