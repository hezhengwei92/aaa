package net.eoutech.vifi.as.commons.vo;

import net.eoutech.vifi.as.commons.entity.TbAgent;

/**
 * Created by SUU on 2016/5/26.
 */
public class VaAgent {

    private String id;
    private Integer balance;
    private Integer discount;
    private Integer agentLevel;

    public VaAgent( TbAgent tbAgent ) {
        this.id = tbAgent.getIdxAgentId();
        this.balance = tbAgent.getBalance() + tbAgent.getCredit();
        this.discount = tbAgent.getDiscount();
        this.agentLevel = tbAgent.getAgentLevel();
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance( Integer balance ) {
        this.balance = balance;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount( Integer discount ) {
        this.discount = discount;
    }

    public Integer getAgentLevel() {
        return agentLevel;
    }

    public void setAgentLevel( Integer agentLevel ) {
        this.agentLevel = agentLevel;
    }
}
