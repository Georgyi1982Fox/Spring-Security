package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDAO;
import web.dao.RoleHibernateDAO;
import web.dao.UserDAO;
import web.model.Role;

@Service
public class RoleService {
    @Autowired
    private RoleHibernateDAO roleHibernateDAO;
    @Transactional
    public Role findByName(String name){
        return roleHibernateDAO.getByName(name);
    }
}
