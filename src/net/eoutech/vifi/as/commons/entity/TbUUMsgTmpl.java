package net.eoutech.vifi.as.commons.entity;

import java.util.Date;

public class TbUUMsgTmpl {
    private Integer keyTmplId;

    private String name;

    private String lang;

    private String msgTmpl;

    private Date mdfTm;

    private String mdfBy;

    private Date crtTm;

    private String crtBy;

    public Integer getKeyTmplId() {
        return keyTmplId;
    }

    public void setKeyTmplId(Integer keyTmplId) {
        this.keyTmplId = keyTmplId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang == null ? null : lang.trim();
    }

    public String getMsgTmpl() {
        return msgTmpl;
    }

    public void setMsgTmpl(String msgTmpl) {
        this.msgTmpl = msgTmpl == null ? null : msgTmpl.trim();
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