package org.renthouse.common;

/**
 * <dl>
 * <dt>UserConst</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2017/10/10</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
public class UserConst {

    public static final String CURRENT_USER = "currentUser";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface Role {
        int ROLE_ADMIN = 0; //管理员用户
        int ROLE_OWNER = 1; //房主用户
        int ROLE_RENTER = 2;//租客
    }
}
