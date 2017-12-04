package net.eoutech.vifi.as.commons.nettyserver.entity;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
public class MsgContent {
    private short pkgLen;//单包长度
    private byte action;//动作判断标识
    private byte[] content;//具体内容

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public short getPkgLen() {
        return pkgLen;
    }

    public void setPkgLen(short pkgLen) {
        this.pkgLen = pkgLen;
    }

    public byte[] createByte(){
        byte[] bytes = new byte[this.pkgLen+2];
        bytes[0] = (byte)(this.pkgLen >> 8);
        bytes[1] = (byte)(this.pkgLen & 0x00ff);
        bytes[2] = action;
        for (int i = 0; i < this.content.length; i++) {
            bytes[i+3] = this.content[i];
        }
        return bytes;
    }
}
