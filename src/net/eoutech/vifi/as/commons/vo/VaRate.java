package net.eoutech.vifi.as.commons.vo;

import net.eoutech.vifi.as.commons.constant.VaConst;
import net.eoutech.vifi.as.commons.entity.TbRate;

/**
 * Created by SUU on 2016/5/26.
 */
public class VaRate {

    private Integer rateId;
    private String rateMode;
    private String agentId;
    private String countryCode;
    private Integer price;

    public VaRate( TbRate tbRate, String callType ) {
        this.rateId = tbRate.getKeyRateID();
        this.rateMode = tbRate.getRateMode();
        this.agentId = tbRate.getIdxAgentID();
        this.countryCode = tbRate.getCountryCode();

        if ( VaConst.Tables.TBRATE_RATEMODE_CALL.equals( tbRate.getRateMode() ) ) {
            if ( VaConst.Common.CALL_TYPE_GMO.equals( callType ) ) {
                this.price = tbRate.getPriceCallGoIP();
            } else if ( VaConst.Common.CALL_TYPE_MM.equals( callType ) ) {
                this.price = tbRate.getPriceCallOnline();
            } else if ( VaConst.Common.CALL_TYPE_VMO.equals( callType ) ) {
                this.price = tbRate.getPriceCallOffline();
            } else if ( VaConst.Common.CALL_TYPE_MT.equals( callType ) ) {
                this.price = 0;
            } else {
                this.price = 0;
            }
        } else if ( VaConst.Tables.TBRATE_RATEMODE_DATA.equals( tbRate.getRateMode() ) ) {
            this.price = tbRate.getPriceNET();
        } else if ( VaConst.Tables.TBRATE_RATEMODE_DATA_DAILY.equals( tbRate.getRateMode() ) ) {
            this.price = tbRate.getDayDataPrice();
        } else if ( VaConst.Tables.TBRATE_RATEMODE_SMS.equals( tbRate.getRateMode() ) ) {
            this.price = tbRate.getPriceSMS();
        }

    }

    public Integer getRateId() {
        return rateId;
    }

    public void setRateId( Integer rateId ) {
        this.rateId = rateId;
    }

    public String getRateMode() {
        return rateMode;
    }

    public void setRateMode( String rateMode ) {
        this.rateMode = rateMode;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId( String agentId ) {
        this.agentId = agentId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode( String countryCode ) {
        this.countryCode = countryCode;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice( Integer price ) {
        this.price = price;
    }
}
