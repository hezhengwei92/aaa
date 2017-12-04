package net.eoutech.vifi.as.commons.nettyserver.utils;

import net.eoutech.vifi.as.commons.nettyserver.EouData;
import net.eoutech.vifi.as.commons.nettyserver.entity.MsgContent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by WangY on 2017/5/24 0024.
 * 对于设备操作的各种命令
 */
public class OrderUtil {
    /**
     * @param sender   发送者
     * @param reveiver 接收者
     * @param circle   循环码
     * @param pkgNum   包个数
     * @param action   动作
     * @param con      内容
     * @return EouData对象
     */
    private static EouData OrderBase(byte sender, byte reveiver, byte circle, byte pkgNum, byte action, byte[] con) {
        EouData data = new EouData();
        data.setSender(sender);
        data.setReceiver(reveiver);
        data.setCircle(circle);
        data.setPkgNum(pkgNum);
        List<MsgContent> list = Collections.synchronizedList(new ArrayList<MsgContent>());
        int length = 0;
        for (int i = 0; i < pkgNum; i++) {
            MsgContent msgContent = new MsgContent();
            msgContent.setPkgLen((short) (con.length + 1));
            msgContent.setAction(action);
            msgContent.setContent(con);
            list.add(msgContent);
            length += msgContent.createByte().length;
        }
        data.setMsgList(list);
        data.setLength((short) (length + 1));
        data.setCrc(EouData.creatCRC(data));
        return data;
    }

    /**
     * 设备定位信息
     *
     * @param circle 循环码
     * @return EouData对象
     */
    public static EouData DevicePosition(byte circle) {
        byte sender = 0x04;
        byte receiver = 0x01;
        byte pkgNUm = 0x01;
        byte action = 0x0B;
        byte[] content = new byte[]{0x00};
        return OrderBase(sender, receiver, circle, pkgNUm, action, content);
    }

    /**
     * 重置设备
     *
     * @param circle 循环码
     * @return EouData对象
     */
    public static EouData ResetDevice(byte circle) {
        byte sender = 0x04;
        byte receiver = 0x01;
        byte pkgNUm = 0x01;
        byte action = 0x08;
        byte[] content = new byte[]{0x00};
        return OrderBase(sender, receiver, circle, pkgNUm, action, content);
    }

    /**
     * 重启设备
     *
     * @param circle 循环码
     * @return EouData对象
     */
    public static EouData RebootDevice(byte circle) {
        byte sender = 0x04;
        byte receiver = 0x01;
        byte pkgNUm = 0x01;
        byte action = 0x07;
        byte[] content = new byte[]{0x00};
        return OrderBase(sender, receiver, circle, pkgNUm, action, content);
    }

    /**
     * 初始化设备上卡
     *
     * @param circle  循环码
     * @param content 分配卡的ATR信息
     * @return EouData对象
     */
    public static EouData InitializeDevice(byte circle, byte[] content) {
        byte sender = 0x04;
        byte receiver = 0x01;
        byte pkgNUm = 0x01;
        byte action = 0x0C;
        return OrderBase(sender, receiver, circle, pkgNUm, action, content);
    }

    /**
     * 修改设备密码
     *
     * @param circle  循环码
     * @param content 修改的密码
     * @return EouData对象
     */
    public static EouData ChangePassword(byte circle, byte[] content) {
        byte sender = 0x04;
        byte receiver = 0x01;
        byte pkgNUm = 0x01;
        byte action = 0x09;
        return OrderBase(sender, receiver, circle, pkgNUm, action, content);
    }

    /**
     * 更新固件
     *
     * @param circle  循环码
     * @param content 文件中读到的固件更新命令
     * @return EouData对象
     */
    public static EouData UpdateFirmware(byte circle, byte[] content) {
        byte sender = 0x04;
        byte receiver = 0x01;
        byte pkgNUm = 0x01;
        byte action = 0x0D;
        return OrderBase(sender, receiver, circle, pkgNUm, action, content);
    }

    /**
     * 允许此MAC地址上网
     *
     * @param circle  循环码
     * @param content MAC地址
     * @return EouData对象
     */
    public static EouData AllowMAC(byte circle, byte[] content) {
        byte sender = 0x04;
        byte receiver = 0x01;
        byte pkgNUm = 0x01;
        byte action = 0x0A;
        return OrderBase(sender, receiver, circle, pkgNUm, action, content);
    }

    /**
     * 查询流量
     *
     * @param circle 循环码
     * @return EouData对象
     */
    public static EouData SearchFlow(byte circle) {
        byte sender = 0x04;
        byte receiver = 0x01;
        byte pkgNUm = 0x01;
        byte action = 0x11;
        byte[] content = new byte[]{0x00};
        return OrderBase(sender, receiver, circle, pkgNUm, action, content);
    }

    /**
     * 复位卡池中的卡
     *
     * @param circle circle 循环码
     * @return EouData对象
     */
    public static EouData RestCard(byte circle, byte[] content) {
        byte sender = 0x04;
        byte receiver = 0x01;
        byte pkgNUm = 0x01;
        byte action = 0x1F;
        return OrderBase(sender, receiver, circle, pkgNUm, action, content);
    }

    /**
     * 心跳使用
     *
     * @param circle circle 循环码
     * @return EouData对象
     */
    public static EouData WakeData(byte circle, byte[] content) {
        byte sender = 0x04;
        byte receiver = 0x04;
        byte pkgNUm = 0x01;
        byte action = 0x00;
        return OrderBase(sender, receiver, circle, pkgNUm, action, content);
    }

    /**
     * 打通通道特有数据
     *
     * @param circle circle 循环码
     * @return EouData对象
     */
    public static EouData PassChannel(byte circle) {
        byte sender = 0x04;
        byte receiver = 0x04;
        byte pkgNUm = 0x01;
        byte action = 0x10;
        byte[] content = new byte[]{0x10,0x00};
        return OrderBase(sender, receiver, circle, pkgNUm, action, content);
    }
}
