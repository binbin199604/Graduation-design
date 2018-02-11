package org.renthouse.dao;

import org.junit.Test;
import org.renthouse.test.TestBase;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * <dl>
 * <dt>UserMapperTest</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/2/9</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
public class UserMapperTest extends TestBase {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void checkUsername() throws Exception {
        String username = "admin";
        int count = userMapper.checkUsername(username);
        System.out.println("conut = "+count);
    }

    @Test
    public void checkEmail() throws Exception {
    }

    @Test
    public void selectLogin() throws Exception {
    }

    @Test
    public void selectQuestionByUsername() throws Exception {
    }

    @Test
    public void checkAnswer() throws Exception {
    }

    @Test
    public void updatePasswordByUsername() throws Exception {
    }

    @Test
    public void checkPassword() throws Exception {
    }

    @Test
    public void checkEmailByUserId() throws Exception {
    }

}