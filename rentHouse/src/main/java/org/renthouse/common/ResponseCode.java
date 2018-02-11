package org.renthouse.common;

/**
 * <dl>
 * <dt>ResponseCode</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2017/10/10</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}
