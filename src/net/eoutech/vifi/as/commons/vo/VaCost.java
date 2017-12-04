package net.eoutech.vifi.as.commons.vo;

import java.util.List;

/**
 * 记账实体
 * Created by SUU on 2016/5/26.
 */
public class VaCost {

    private String userId;
    private Integer balanceCost;

    private String suiteIds;
    private List< VaUserSuite > suiteCosts;

    public VaCost( String userId, Integer balanceCost, String suiteIds, List< VaUserSuite > suiteCosts ) {
        this.userId = userId;
        this.balanceCost = balanceCost;
        this.suiteIds = suiteIds;
        this.suiteCosts = suiteCosts;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId( String userId ) {
        this.userId = userId;
    }

    public Integer getBalanceCost() {
        return balanceCost;
    }

    public void setBalanceCost( Integer balanceCost ) {
        this.balanceCost = balanceCost;
    }

    public String getSuiteIds() {
        return suiteIds;
    }

    public void setSuiteIds( String suiteIds ) {
        this.suiteIds = suiteIds;
    }

    public List< VaUserSuite > getSuiteCosts() {
        return suiteCosts;
    }

    public void setSuiteCosts( List< VaUserSuite > suiteCosts ) {
        this.suiteCosts = suiteCosts;
    }
}
