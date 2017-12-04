package net.eoutech.vifi.as.commons.vo;

import net.eoutech.vifi.as.commons.entity.TbUserSuite;

/**
 * Created by SUU on 2016/5/26.
 */
public class VaUserSuite {

    private Integer suiteId;
    private String userId;
    private String suiteType;
    private Integer value;

    public VaUserSuite( TbUserSuite tbUserSuite ) {
        this.suiteId = tbUserSuite.getKeyID();
        this.userId = tbUserSuite.getIdxPhoneNumber();
        this.suiteType = tbUserSuite.getSuiteType();
        this.value = tbUserSuite.getRemainValue();
    }

    public Integer getSuiteId() {
        return suiteId;
    }

    public void setSuiteId( Integer suiteId ) {
        this.suiteId = suiteId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId( String userId ) {
        this.userId = userId;
    }

    public String getSuiteType() {
        return suiteType;
    }

    public void setSuiteType( String suiteType ) {
        this.suiteType = suiteType;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue( Integer value ) {
        this.value = value;
    }
}
