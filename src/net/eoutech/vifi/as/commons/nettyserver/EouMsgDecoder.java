package net.eoutech.vifi.as.commons.nettyserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import net.eoutech.vifi.as.commons.utils.DataProcess;
import net.eoutech.vifi.as.commons.utils.LogUtils;
import net.eoutech.vifi.as.commons.utils.StaticMsg;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by WangY on 2017/3/8 0008.
 */
public class EouMsgDecoder extends ByteToMessageDecoder {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private ByteBuffer buffer = null;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> list) throws Exception {
        try {
            LogUtils.info("进入DECODER，START-----" + ctx.channel());
            if (in == null) {// 判断有没有收到数据
                LogUtils.info("ByteBuf is NULL");
            } else {
                byte[] arr = new byte[in.readableBytes()];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = in.getByte(i);
                }
                LogUtils.info("数据：" + Arrays.toString(arr));
                LogUtils.info("ButeBuf has the right data" + in);
//            if (StaticMsg.getCtx2Circle().get(ctx.channel()) != null) {//有循环码
//                if (in.readableBytes() >= 5 && in.getByte(5) == StaticMsg.getCtx2Circle().get(ctx.channel())) {//字节传输收到大于5的数据，并且上一条有数据
//                    in.clear();
//                    LogUtils.info("循环码相同，丢弃信息");
//                    return;
//                }
//                LogUtils.info("循环码不相同，继续");
//            }
                if (StaticMsg.getCtx2Buf().get(ctx.channel()) == null) {
                    buffer = ByteBuffer.allocate(4096);
//                StaticMsg.getCtx2Buf().put(ctx.channel(),buffer);
                } else {
                    buffer = StaticMsg.getCtx2Buf().get(ctx.channel());
                }
                LogUtils.info("ButeBuf got the right data?---" + buffer);
                int count = 0;
                boolean flag = true;
                char[] cha = new char[]{'S', 'O', 'N', 'P'};
                int size = in.readableBytes();
                do {
//                buffer.flip();
                    if (size > 14) {
//                    StaticMsg.getCtx2Circle().put(ctx.channel(), in.getByte(5));//保存循环码
                        if (cha[0] == (char) in.getByte(count)) {
                            if (cha[1] == (char) in.getByte(count + 1) && cha[2] == (char) in.getByte(count + 2) && cha[3] == (char) in.getByte(count + 3)) {
                                if (size - count >= 8) {
                                    int highLen = DataProcess.byteToInt(in.getByte(count + 6));
                                    int lowLen = DataProcess.byteToInt(in.getByte(count + 7));
                                    // 获取包组数据的总长度
                                    int length = (short) ((highLen << 8) + lowLen);

                                    int dataLen = length + 14;
                                    if (dataLen > size) {// 数据不完整，等接下来的数据
//                                    buffer.put(in.nioBuffer());
//                                    buffer.compact();
//                                    in.clear();
                                        StaticMsg.getCtx2Buf().put(ctx.channel(), buffer);
                                        return;
                                    }

                                    for (int i = 0; i < count; i++) {//废掉的数据
                                        in.readByte();
                                    }

                                    for (int i = 0; i < dataLen; i++) {
                                        buffer.put(in.readByte());
                                    }

                                    size -= dataLen;

                                    buffer.flip();

                                    byte[] bytes = new byte[dataLen];
                                    for (int i = 0; i < dataLen; i++) {
                                        bytes[i] = buffer.get();
                                    }

                                    String head = "";
                                    String end = "";
                                    for (int i = 0; i < 4; i++) {// 获取读到数据的头部
                                        head += (char) bytes[i];
                                    }

                                    for (int i = bytes.length - 4; i < bytes.length; i++) {// 获取读到数据的尾部
                                        end += (char) bytes[i];
                                    }

                                    if ("SONP".equals(head) && "EONP".equals(end)) {// 判断数据是不是完整的
                                        int checkCRC = DataProcess.CRC_XModem(bytes, 4, bytes.length - 10);// 获取校验的CRC的值
                                        // 获取CRC校验的高位值
                                        int crcHigh = DataProcess.byteToInt(bytes[bytes.length - 6]);
                                        // 获取CRC校验的地位值
                                        int crcLow = DataProcess.byteToInt(bytes[bytes.length - 5]);
                                        // 计算CRC的值
                                        int crc = (crcHigh << 8) + crcLow;
                                        // 验证CRC的计算值和传递值是否正确
                                        if (checkCRC == crc) {
//                                        System.out.println("Time:"+format.format(new Date())+",Data:"+Arrays.toString(bytes));
                                            LogUtils.info("Time:({0}),Data:({1})", format.format(new Date()), Arrays.toString(bytes));
                                            EouData data = new EouData(bytes);
                                            list.add(data);
                                            buffer.clear();
//                                        in.clear();
                                            StaticMsg.getCtx2Buf().put(ctx.channel(), buffer);
                                        } else {
                                            LogUtils.info("ByteBuf has the wrong crc");
                                            flag = false;
                                        }
                                    } else {
                                        in.clear();
                                        buffer.clear();
                                        LogUtils.info("^^^^^^^^^^^^^^^^^^^^^^^");
                                        StaticMsg.getCtx2Buf().put(ctx.channel(), buffer);
                                        return;
                                    }
                                } else {
                                    LogUtils.info("00000000000000000000000000000000");
                                    return;
                                }
                            } else {//读到S后，后三位读出不能组成SONP
                                LogUtils.info("---------------------------------");
                                count++;
                                if (count == size - 2) {
                                    in.clear();
                                    flag = false;
                                    LogUtils.info("Cant read the ONP");
                                }
                            }
                        } else {//读不到S
                            count++;
                            if (count == size - 2) {
                                in.clear();
                                flag = false;
                                LogUtils.info("Cant read the S");
                            }
                        }
                    } else if (size == 0) {
                        LogUtils.dbg("We have no date to process");
                        buffer.clear();
                        in.clear();
                        flag = false;
                        StaticMsg.getCtx2Buf().put(ctx.channel(), buffer);
                    } else {//数据不正确
                        LogUtils.dbg("We have no enough date to process");
                        flag = false;
//                    buffer.compact();
                    }
                } while (flag);

                LogUtils.info("size:({0})", list.size());
            }
        }catch (Exception e){
            e.printStackTrace();
            LogUtils.error("EouMsgDecoder异常："+e.getMessage());
        }
    }
}
