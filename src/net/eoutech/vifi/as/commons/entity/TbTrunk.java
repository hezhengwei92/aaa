package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbTrunk {
    private Integer keyTrunkID;

    private String idxTrunkName;

    private Boolean trusty;

    private Boolean dynamic;

    private String username;

    private String realm;

    private String host;

    private Integer expires;

    private Integer port;

    private String prefix;

    private Boolean replaceUsername;

    private Integer state;

    private Integer callingNum;

    private Integer maxCallNum;

    private Integer mcSupport;

    private String VPXID;

    private String idxSalerID;

    private Integer totalNumber;

    private Integer totalSuccess;

    private Integer totalFailure;

    private Integer continuityFailure;

    private String remarks;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public Integer getKeyTrunkID() {
        return keyTrunkID;
    }

    public void setKeyTrunkID(Integer keyTrunkID) {
        this.keyTrunkID = keyTrunkID;
    }

    public String getIdxTrunkName() {
        return idxTrunkName;
    }

    public void setIdxTrunkName(String idxTrunkName) {
        this.idxTrunkName = idxTrunkName == null ? null : idxTrunkName.trim();
    }

    public Boolean getTrusty() {
        return trusty;
    }

    public void setTrusty(Boolean trusty) {
        this.trusty = trusty;
    }

    public Boolean getDynamic() {
        return dynamic;
    }

    public void setDynamic(Boolean dynamic) {
        this.dynamic = dynamic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm == null ? null : realm.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public Integer getExpires() {
        return expires;
    }

    public void setExpires(Integer expires) {
        this.expires = expires;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix == null ? null : prefix.trim();
    }

    public Boolean getReplaceUsername() {
        return replaceUsername;
    }

    public void setReplaceUsername(Boolean replaceUsername) {
        this.replaceUsername = replaceUsername;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCallingNum() {
        return callingNum;
    }

    public void setCallingNum(Integer callingNum) {
        this.callingNum = callingNum;
    }

    public Integer getMaxCallNum() {
        return maxCallNum;
    }

    public void setMaxCallNum(Integer maxCallNum) {
        this.maxCallNum = maxCallNum;
    }

    public Integer getMcSupport() {
        return mcSupport;
    }

    public void setMcSupport(Integer mcSupport) {
        this.mcSupport = mcSupport;
    }

    public String getVPXID() {
        return VPXID;
    }

    public void setVPXID(String VPXID) {
        this.VPXID = VPXID == null ? null : VPXID.trim();
    }

    public String getIdxSalerID() {
        return idxSalerID;
    }

    public void setIdxSalerID(String idxSalerID) {
        this.idxSalerID = idxSalerID == null ? null : idxSalerID.trim();
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber( Integer totalNumber ) {
        this.totalNumber = totalNumber;
    }

    public Integer getTotalSuccess() {
        return totalSuccess;
    }

    public void setTotalSuccess( Integer totalSuccess ) {
        this.totalSuccess = totalSuccess;
    }

    public Integer getTotalFailure() {
        return totalFailure;
    }

    public void setTotalFailure( Integer totalFailure ) {
        this.totalFailure = totalFailure;
    }

    public Integer getContinuityFailure() {
        return continuityFailure;
    }

    public void setContinuityFailure( Integer continuityFailure ) {
        this.continuityFailure = continuityFailure;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getMdfTm() {
        return mdfTm;
    }

    public void setMdfTm(Date mdfTm) {
        this.mdfTm = mdfTm;
    }

    public String getMdfBy() {
        return mdfBy;
    }

    public void setMdfBy(String mdfBy) {
        this.mdfBy = mdfBy == null ? null : mdfBy.trim();
    }

    public Date getCrtTm() {
        return crtTm;
    }

    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }

    public String getCrtBy() {
        return crtBy;
    }

    public void setCrtBy(String crtBy) {
        this.crtBy = crtBy == null ? null : crtBy.trim();
    }
}