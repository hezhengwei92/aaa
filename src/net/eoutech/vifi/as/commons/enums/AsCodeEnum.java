package net.eoutech.vifi.as.commons.enums;

/**
 * Created by Administrator on 2015/9/19.
 */

public enum AsCodeEnum {

    AS_SUCCESS( 0, "success" ),
    AS_FAILURE( 1, "failure" );


    public int code;
    public String desc;


    AsCodeEnum( int code, String desc ) {
        this.code = code;
        this.desc = desc;
    }
    }
