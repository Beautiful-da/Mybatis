package hb.rj.mybatis;

import hb.rj.mybatis.mapper.UserMapper;
import hb.rj.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author:Beautiful_da
 * @Date:2022/4/20 9:27
 * @Descripiton:
 */

public class MybatisTest {
    /**
     * sqlSession默认不自动提交事务，诺需要自动提交事务
     * 可以使用sqlSessionFactory.openSession()里面加true。
     *
     */


    @Test
    public void testMyBatis() throws IOException {
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlSession方法
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//代理模式

        //添加数据
        mapper.insertUser();
        //提交事务
//        sqlSession.commit();
    }
    //修改sql语句
    @Test
    public void testUpdate() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
    }

    //删除语句
    @Test
    public void testDelete() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
    }

    //综合
    @Test
    public void testCRUD() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        //根据id显示数据
//        User user = mapper.getUserById();
//        System.out.println(user);

        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }
}