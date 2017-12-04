package net.eoutech.vifi.as.commons.nettyserver;


import net.eoutech.vifi.as.commons.nettyserver.entity.MsgContent;
import net.eoutech.vifi.as.commons.utils.DataProcess;
import net.eoutech.vifi.as.commons.utils.LogUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by WangY on 2017/3/8 0008.
 */
public class EouData implements Serializable{

    private static final String head = "SONP";//帧头
    private byte sender;//发送者
    private byte receiver;//接收者
    private byte circle;//循环码
    private short length;//包组总长度
    private byte pkgNum;//包个数
    private List<MsgContent> msgList;//包序列
    private short crc;//CRC的值
    private static final String end = "EONP";//帧尾


    public EouData(byte[] bytes) {
        msgList = new ArrayList<>();
        byte message = bytes[4];
        //获取发送者
        sender = (byte) ((message >> 4) & 0x0F);
        //获取接收者
        receiver = (byte) (message & 0x0F);
        //获取帧循环码
        circle = bytes[5];
        int highLen = DataProcess.byteToInt(bytes[6]);
        int lowLen = DataProcess.byteToInt(bytes[7]);
        //获取包组数据的总长度
        length = (short) ((highLen << 8) + lowLen);
        //获取包的个数
        pkgNum = bytes[8];
        int count = 0;
        for (int i = 0; i < pkgNum; i++) {
            MsgContent content = new MsgContent();
            int highPkgLen = DataProcess.byteToInt(bytes[9 + count]);
            int lowPkgLen = DataProcess.byteToInt(bytes[10 + count]);
            //获取单包的长度
            short pkgLen = (short) ((highPkgLen << 8) + lowPkgLen);
            //获取动作标识符
            byte action = bytes[11 + count];
            byte[] contents = new byte[pkgLen - 1];
            //获取内容
            for (int j = 0; j < pkgLen - 1; j++) {
                contents[j] = bytes[j + 12];
            }
            content.setPkgLen(pkgLen);
            content.setAction(action);
            content.setContent(contents);
            msgList.add(content);
            count = count + pkgLen + 2;
        }

//        int highPkgLen = DataProcess.byteToInt(bytes[9]);
//        int lowPkgLen = DataProcess.byteToInt(bytes[10]);
//        //获取单包的长度
//        pkgLen = (short) ((highPkgLen * 256) + lowPkgLen);
//        //获取动作标识符
//        action = bytes[11];
//        content = new byte[pkgLen-1];
//        //获取内容
//        for (int i = 0; i < pkgLen - 1; i++) {
//            content[i] = bytes[i + 12];
//        }
        int highCrc = DataProcess.byteToInt(bytes[bytes.length - 6]);
        int lowCrc = DataProcess.byteToInt(bytes[bytes.length - 5]);
        //获取CRC的内容
        crc = (short) ((highCrc << 8) + lowCrc);

        String str = "";
        for (int i=0;i<bytes.length;i++){
            str += DataProcess.IntToHex(DataProcess.byteToInt(bytes[i]));
            str += " ";
        }
        System.out.println("接收到的值："+str);
        LogUtils.info("接收到的值："+str);
    }

    public EouData() {
    }

    public EouData(EouData eouData) {
        sender = eouData.getSender();
        receiver = eouData.getReceiver();
        circle = eouData.getCircle();
        length = eouData.getLength();
        pkgNum = eouData.getPkgNum();
        msgList = eouData.getMsgList();
        crc = eouData.getCrc();
    }

    //生成CRC的值
    public static short creatCRC(EouData eouData) {
        byte[] bytes = new byte[4 + eouData.getLength()];
        bytes[0] = eouData.getMessage(eouData.getSender(), eouData.getReceiver());
        bytes[1] = eouData.getCircle();
        bytes[2] = (byte) ((eouData.getLength() >> 8) & 0xff);
        bytes[3] = (byte) (eouData.getLength() & 0xff);
        bytes[4] = eouData.getPkgNum();
        int count = 5;
        for (int i = 0; i < eouData.getPkgNum(); i++) {
            byte[] content = eouData.getMsgList().get(i).createByte();
            for (int j = 0; j < content.length; j++) {
                bytes[count] = content[j];
                count++;
            }
        }
        String str = "";
        for (int i=0;i<bytes.length;i++){
            str += DataProcess.IntToHex(DataProcess.byteToInt(bytes[i]));
            str += " ";
        }
        System.out.println("发送的值："+"53 4F 4E 50 "+str+"CRC 45 4F 4E 50");
        LogUtils.info("发送的值："+"53 4F 4E 50 "+str+"CRC 45 4F 4E 50");
        return (short) DataProcess.CRC_XModem(bytes, 0, bytes.length);
    }

    public static byte[] eouDataByte(EouData eouData) {
        int dataLen = eouData.getLength() + 14;
        byte[] data = new byte[dataLen];
        byte[] head = eouData.getHead().getBytes();
        for (int i = 0; i < 4; i++) {
            data[i] = head[i];
        }
        data[4] = eouData.getMessage(eouData.getSender(), eouData.getReceiver());
        data[5] = eouData.getCircle();
        data[6] = (byte) (eouData.getLength() >> 8);
        data[7] = (byte) (eouData.getLength() & 0xFF);
        data[8] = eouData.getPkgNum();
        int msgLen = 0;
        for (int i = 0; i < eouData.getPkgNum(); i++) {
            MsgContent content = eouData.getMsgList().get(i);
            byte[] msg = content.createByte();
            for (int j = 0; j < msg.length; j++) {
                data[9 + j + msgLen] = msg[j];
            }
            msgLen += content.getPkgLen() + 2;
        }
        data[dataLen - 6] = (byte) (eouData.getCrc() >> 8);
        data[dataLen - 5] = (byte) (eouData.getCrc() & 0xFF);
        byte[] end = eouData.getEnd().getBytes();
        for (int i = 0; i < 4; i++) {
            data[dataLen - 4 + i] = end[i];
        }

        return data;
    }

    public static int listByteSize(List<MsgContent> msg) {
        int count = 0;
        for (int i = 0; i < msg.size(); i++) {
            count = count + msg.get(i).createByte().length;
        }
        return count;
    }

    //生成通信主体
    public byte getMessage(byte sender, byte receiver) {
        byte message = (byte) ((sender << 4) + receiver);
        return message;
    }

    public byte getCircle() {
        return circle;
    }

    public void setCircle(byte circle) {
        this.circle = circle;
    }

    public short getCrc() {
        return crc;
    }

    public void setCrc(short crc) {
        this.crc = crc;
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public List<MsgContent> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<MsgContent> msgList) {
        this.msgList = msgList;
    }

    public byte getPkgNum() {
        return pkgNum;
    }

    public void setPkgNum(byte pkgNum) {
        this.pkgNum = pkgNum;
    }

    public byte getReceiver() {
        return receiver;
    }

    public void setReceiver(byte receiver) {
        this.receiver = receiver;
    }

    public byte getSender() {
        return sender;
    }

    public void setSender(byte sender) {
        this.sender = sender;
    }

    public static String getEnd() {
        return end;
    }

    public static String getHead() {
        return head;
    }

    @Override
    public String toString() {
        return "EouData{" +
                "circle=" + circle +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", length=" + length +
                ", pkgNum=" + pkgNum +
                ", msgList=" + Arrays.toString(msgList.get(0).createByte()) +
                ", crc=" + crc +
                '}';
    }
}
