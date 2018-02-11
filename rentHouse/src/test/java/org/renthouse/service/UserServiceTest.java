package org.renthouse.service;

import org.junit.Test;
import org.renthouse.common.ServerResponse;
import org.renthouse.test.TestBase;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * <dl>
 * <dt>UserServiceTest</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/2/9</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
public class UserServiceTest extends TestBase{

    @Autowired
    private UserService userService;
    @Test
    public void login() throws Exception {
            String username = "admin";
            String password ="admin";
            ServerResponse serverResponse = userService.login(username,password);
            System.out.println(serverResponse.toString());
    }

    @Test
    public void register() throws Exception {
    }

    @Test
    public void checkValid() throws Exception {
    }

    @Test
    public void selectQuestion() throws Exception {
    }

    @Test
    public void checkAnswer() throws Exception {
    }

    @Test
    public void forgetResetPassword() throws Exception {
    }

    @Test
    public void resetPassword() throws Exception {
    }

    @Test
    public void updateInformation() throws Exception {
    }

    @Test
    public void getInformation() throws Exception {
    }

    @Test
    public void checkAdminRole() throws Exception {
    }

}