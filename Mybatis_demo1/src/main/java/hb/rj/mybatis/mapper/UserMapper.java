package hb.rj.mybatis.mapper;


import hb.rj.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * mybatis面向接口的两个一致
     * 1.映射文件的namespace要和mapper接口的全类名保持一致
     * 2.映射文件中的SQL语句的id要和mapper接口中的方法各一致
     * <p>
     * 表--实体类--mapper接口--映射文件
     */


    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询表里所有信息
     */
    List<User> getAllUser();
}
