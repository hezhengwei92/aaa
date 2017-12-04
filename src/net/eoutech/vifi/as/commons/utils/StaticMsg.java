package net.eoutech.vifi.as.commons.utils;

import io.netty.channel.Channel;

import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by WangY on 2017/3/28 0028.
 */
public class StaticMsg {
    //存储卡池IP+PORT和卡池连接通道的映射
    private static Map<String, Channel> ipPort2Pipe = new ConcurrentHashMap<>();

    //存储WS->AAA虚拟通道和卡池连接通道的映射
    private static Map<Channel, Channel> virtual2Pipe = new ConcurrentHashMap<>();

    //存储卡池卡槽号和设备号的映射
    private static Map<String, String> slot2Vid = new ConcurrentHashMap<>();

    //存储设备号和卡槽号的映射
    private static Map<String, String> vid2Slot = new ConcurrentHashMap<>();

    //存储设备号和AAA->WS虚拟通道的映射
    private static Map<String, Channel> vid2Virtual = new ConcurrentHashMap<>();

    //WS连接AAA的通道号和设备号的映射，以及AAA连接WS的通道号和设备号的映射
    private static Map<Channel, String> virtual2Vid = new ConcurrentHashMap<>();

    //存储通道和buffer的映射
    private static Map<Channel, ByteBuffer> ctx2Buf = new ConcurrentHashMap<>();

    //存储通道和循环码
    private static Map<Channel, Byte> ctx2Circle = new ConcurrentHashMap<>();

    public static Map<String, Channel> getIpPort2Pipe() {
        return ipPort2Pipe;
    }

    public static Map<String, String> getSlot2Vid() {
        return slot2Vid;
    }

    public static Map<String, String> getVid2Slot() {
        return vid2Slot;
    }

    public static Map<Channel, Channel> getVirtual2Pipe() {
        return virtual2Pipe;
    }

    public static Map<String, Channel> getVid2Virtual() {
        return vid2Virtual;
    }

    public static Map<Channel, String> getVirtual2Vid() {
        return virtual2Vid;
    }

    public static Map<Channel, ByteBuffer> getCtx2Buf() {
        return ctx2Buf;
    }

    public static Map<Channel, Byte> getCtx2Circle() {
        return ctx2Circle;
    }
}
