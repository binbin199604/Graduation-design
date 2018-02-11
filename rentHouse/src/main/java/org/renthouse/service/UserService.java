package org.renthouse.service;

import org.renthouse.common.ServerResponse;
import org.renthouse.pojo.User;

/**
 * <dl>
 * <dt>UserService</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2017/10/10</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
public interface UserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user,Integer type);

    ServerResponse<String> checkValid(String str,String type);

    ServerResponse selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username,String question,String answer);

    ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);

    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer userId);

    ServerResponse checkAdminRole(User user);
}
