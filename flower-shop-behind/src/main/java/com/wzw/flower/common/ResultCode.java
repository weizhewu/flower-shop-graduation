package com.wzw.flower.common;

/**
 * @author wzw
 */

public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(1, "成功"),

    /* 业务错误：10001-19999 */
    LOGIN_FAIL(10001,"登录失败"),

    /* 通用错误：20001-29999 */
    ADMIN_USER_DELETE_FAIL(2000,"管理员删除失败！"),
    ADMIN_USER_UPDATE_FAIL(2001,"管理员更新失败！"),

    TYPE_CATEGORY_REMOVE_FAIL(2010,"科目删除失败"),
    TYPE_CATEGORY_INSERT_FAIL(2011,"科目新增失败"),
    TYPE_CATEGORY_GET_FAIL(2012,"科目查询失败"),

    FLOWER_GET_FAIL(2020,"鲜花查询无数据"),
    FLOWER_INSERT_FAIL(2021,"鲜花新增失败"),
    FLOWER_UPDATE_FAIL(2022,"鲜花更新失败"),

    COVER_GET_FAIL(2030,"图片查询失败"),
    COVER_INSERT_FAIL(2031,"封面新增失败"),

    AREA_CATEGORY_REMOVE_FAIL(2040,"地区删除失败"),
    AREA_CATEGORY_INSERT_FAIL(2041,"地区新增失败"),
    AREA_CATEGORY_GET_FAIL(2042,"地区查询失败"),

    COLOR_CATEGORY_REMOVE_FAIL(2050,"颜色删除失败"),
    COLOR_CATEGORY_INSERT_FAIL(2051,"颜色新增失败"),
    COLOR_CATEGORY_GET_FAIL(2052,"颜色查询失败"),

    MEANING_CATEGORY_REMOVE_FAIL(2060,"特殊含义删除失败"),
    MEANING_CATEGORY_INSERT_FAIL(2061,"特殊含义新增失败"),
    MEANING_CATEGORY_GET_FAIL(2062,"特殊含义查询失败"),
    USER_INSERT_FAIL(2070,"用户新增失败"),
    USER_GET_FAIL(2071,"用户信息获取失败"),
    USER_DELETE_FAIL(2072,"用户销户失败"),
    USER_PHONE_EXCITED(2073,"用户手机号已被占用"),
    USER_IS_DELETED(2074,"该用户已注销"),
    USER_UPDATE_FAIL(2074,"用户更新失败");

    private final Integer code;

    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
