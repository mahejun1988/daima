package org.openkoala.warehouse.facade.dao;
 
import com.ware.token.warehouse.facade.model.User;
 
 
public interface UserDAO {
 
    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);
     
     
}