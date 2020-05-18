package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Role;

@Repository
public class RoleHibernateDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Role getByName(String name) {
        Role role = (Role) sessionFactory.getCurrentSession().createQuery("SELECT r FROM  Role r  WHERE r.name=:name")
                .setParameter("name", name)
                .uniqueResult();
        return role;
    }
}
