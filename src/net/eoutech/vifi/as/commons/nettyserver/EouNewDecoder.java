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
 * Created by WangY on 2017/6/6 0006.
 */
public class EouNewDecoder extends ByteToMessageDecoder {
    private ByteBuffer buffer = null;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> list) throws Exception {

        LogUtils.info("进入DECODER，START" + " 所用通道" + ctx.channel());
        if (in == null) {
            System.out.println("ByteBuf is NULL");
            LogUtils.info("ByteBuf is NULL");
            LogUtils.info("バッファは、データではない");
            return;
        } else {
            LogUtils.info("ButeBuf has the right data");
            byte[] arr = new byte[in.readableBytes()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.getByte(i);
            }
            LogUtils.info("数据：" + Arrays.toString(arr));
            if (StaticMsg.getCtx2Buf().get(ctx.channel()) == null) {
                buffer = ByteBuffer.allocate(2048);
//                StaticMsg.getCtx2Buf().put(ctx.channel(),buffer);
            } else {
                buffer = StaticMsg.getCtx2Buf().get(ctx.channel());
                if (buffer.limit() == 0) {
                    buffer.limit(buffer.capacity());
                }
            }
            LogUtils.info("buffer======" + buffer);
            int count = 0;
            boolean flag = true;
            char[] cha = new char[]{'S', 'O', 'N', 'P'};
            int size = in.readableBytes();
            boolean passport = false;
            Integer position = buffer.position();
            if (position > 0) {
                passport = true;
                size += position;
            }
            System.out.println("size=" + size);
            LogUtils.info("size=" + size + " -----passport:" + passport);
            LogUtils.info("in:" + in);
            do {
                if (size > 14) {//长度不够，无需处理
                    if (cha[0] == (char) in.getByte(count) || passport) {//处理ByteBuf中的数据，或者ByteBuffer中有数据需要处理
                        if ((cha[1] == (char) in.getByte(count + 1) && cha[2] == (char) in.getByte(count + 2) && cha[3] == (char) in.getByte(count + 3)) || passport) {
                            for (int i = 0; i < count; i++) {//废掉的数据
                                in.readByte();
                            }

                            if (passport) {
                                size -= position;
                            }
                            int lengths = size - count;//获取所需处理的数据长度

                            LogUtils.info(lengths+"-----------------" + in.isReadable());
                            LogUtils.info(in.readerIndex() + "-----------------" + in.writerIndex());
                            try {
                                if (in.isReadable()) {//是否有数据可读
                                    for (int i = 0; i < lengths; i++) {
                                        buffer.put(in.readByte());
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                LogUtils.dbg("EouNewDecoder异常：" + e.getMessage());
                            }
                            LogUtils.info("buffer0:" + buffer);
                            buffer.flip();
                            if (passport) {
                                size = buffer.limit();
                            }
                            if (size - count >= 8 && buffer.limit() != 0) {
                                int highLen = DataProcess.byteToInt(buffer.get(6));
                                int lowLen = DataProcess.byteToInt(buffer.get(7));
                                // 获取包组数据的总长度
                                int length = (short) ((highLen << 8) + lowLen);

                                int dataLen = length + 14;

                                LogUtils.info("buffer1:" + buffer + "**********");// + Arrays.toString(buffer.array());
                                if (dataLen > size) {// 数据不完整，等接下来的数据
                                    buffer.position(buffer.limit());
                                    buffer.limit(buffer.capacity());
//                                    buffer.clear();
                                    System.out.println(buffer);
                                    LogUtils.info("buffer2:" + buffer);
                                    StaticMsg.getCtx2Buf().put(ctx.channel(), buffer);
                                    return;
                                }
                                LogUtils.info("buffer3:" + buffer);

                                byte[] bytes = new byte[dataLen];

                                Integer readIndex = buffer.position();
                                Integer writeIndex = buffer.limit();
                                LogUtils.info("read:{0} and write:{1}", readIndex, in.writerIndex());

                                if (dataLen <= writeIndex) {
                                    for (int i = 0; i < dataLen; i++) {
                                        bytes[i] = buffer.get();
                                    }
                                    LogUtils.info("buffer4:" + buffer);
                                    LogUtils.info("Arrays:" + Arrays.toString(bytes));

                                    if (readIndex < writeIndex) {
                                        buffer.compact();
                                    } else {
                                        buffer.clear();
                                    }
                                    LogUtils.info("buffer5:" + buffer);

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
                                            LogUtils.info("Time:({0}),Data:({1})", format.format(new Date()), Arrays.toString(bytes));
                                            EouData data = new EouData(bytes);
                                            list.add(data);
//                                        buffer.clear();
//                                        in.clear();
                                            LogUtils.info("buffer6:" + buffer);
                                            StaticMsg.getCtx2Buf().put(ctx.channel(), buffer);
                                        } else {
                                            System.out.println("ByteBuf has the wrong crc");
                                            LogUtils.info("ByteBuf has the wrong crc");
                                            flag = false;
                                        }
                                    } else {
                                        LogUtils.info("Time:" + format.format(new Date()) + ",Data:" + Arrays.toString(bytes));
                                        in.clear();
                                        buffer.clear();
                                        System.out.println("^^^^^^^^数据错误^^^^^^^^^^^^^^^");
                                        LogUtils.info("^^^^^^^^^^^^^^^^^^^^^^^");
                                        StaticMsg.getCtx2Buf().put(ctx.channel(), buffer);
                                        return;
                                    }
                                } else {
                                    buffer.compact();
                                    LogUtils.info("不需要继续处理了");
                                    flag = false;
                                }

                            } else {
                                System.out.println("00000000000000000000000000000000");
                                LogUtils.info("00000000000000000000000000000000");
                                return;
                            }
                        } else {//读到S后，后三位读出不能组成SONP
                            System.out.println("---------------------------------");
                            LogUtils.info("---------------------------------");
                            count++;
                            if (count == size - 2) {
                                LogUtils.info("Cant read the ONP---" + in);
                                in.clear();
                                flag = false;
                            }
                        }
                    } else {//读不到S
                        count++;
                        if (count == size) {
                            LogUtils.info("Cant read the S---" + in);
                            in.clear();
                            flag = false;
                            System.out.println("Cant read the S");
//                            ByteBuf buf = in.copy();
//                            byte[] arr = new byte[buf.readableBytes()];
//                            for (int i = 0; i < arr.length; i++) {
//                                arr[i] = buf.readByte();
//                            }
//                            LogUtils.info("数据：" + Arrays.toString(arr));
                        }
                    }
                } else if (size == 0) {
                    LogUtils.dbg("We have no date to process");
                    System.out.println("We have no date to process：数据接收解析成功");
//                    buffer.clear();
//                    in.clear();
                    flag = false;
                } else {//数据不正确
                    LogUtils.dbg("We have no enough date to process" + in);
                    System.out.println("We have no enough date to process");
                    flag = false;
//                    buffer.compact();
                }
            } while (flag);

            LogUtils.info("size:({0})", list.size());
        }
    }
}
