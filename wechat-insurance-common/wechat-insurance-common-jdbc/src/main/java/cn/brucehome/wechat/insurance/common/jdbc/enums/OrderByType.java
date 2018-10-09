package cn.brucehome.wechat.insurance.common.jdbc.enums;

/**
 * @author Bruce.Z(80021681)
 * @description OrderByType, 排序方式
 * @return
 * @email wenhui.zhang@szhittech.com
 * @date 17:40 2018/9/13
 **/
public enum OrderByType {
    DESC(" desc"),
    ASC(" asc"),;

    private final String value;

    private OrderByType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
