package net.eoutech.vifi.as.commons.utils;

import com.mysql.jdbc.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SUU on 2016/3/5.
 */
class IP {
    public static boolean enableFileWatch = false;

    private static int offset;
    private static int[] index = new int[256];
    private static ByteBuffer dataBuffer;
    private static ByteBuffer indexBuffer;
    private static Long lastModifyTime = 0L;
    private static File ipFile ;
    private static ReentrantLock lock = new ReentrantLock();

    public static void load(String filename) {
        ipFile = new File(filename);
        load();
        if (enableFileWatch) {
            watch();
        }
    }
    
    public static void load(String filename, boolean strict) throws Exception {
        ipFile = new File(filename);
        if (strict) {
            int contentLength = Long.valueOf(ipFile.length()).intValue();
            if (contentLength < 512 * 1024) {
                throw new Exception("ip data file error.");
            }
        }
        load();
        if (enableFileWatch) {
            watch();
        }
    }

    public static String[] find(String ip) {
        int ip_prefix_value = new Integer(ip.substring(0, ip.indexOf(".")));
        long ip2long_value  = ip2long(ip);
        int start = index[ip_prefix_value];
        int max_comp_len = offset - 1028;
        long index_offset = -1;
        int index_length = -1;
        byte b = 0;
        for (start = start * 8 + 1024; start < max_comp_len; start += 8) {
            if (int2long(indexBuffer.getInt(start)) >= ip2long_value) {
                index_offset = bytesToLong(b, indexBuffer.get(start + 6), indexBuffer.get(start + 5), indexBuffer.get(start + 4));
                index_length = 0xFF & indexBuffer.get(start + 7);
                break;
            }
        }

        byte[] areaBytes;

        lock.lock();
        try {
            dataBuffer.position(offset + (int) index_offset - 1024);
            areaBytes = new byte[index_length];
            dataBuffer.get(areaBytes, 0, index_length);
        } finally {
            lock.unlock();
        }

        return new String(areaBytes, Charset.forName("UTF-8")).split("\t", -1);
    }

    private static void watch() {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate( new Runnable() {
            @Override
            public void run() {
                long time = ipFile.lastModified();
                if (time > lastModifyTime) {
                    lastModifyTime = time;
                    load();
                }
            }
        }, 1000L, 5000L, TimeUnit.MILLISECONDS);
    }

    private static void load() {
        lastModifyTime = ipFile.lastModified();
        FileInputStream fin = null;
        lock.lock();
        try {
            dataBuffer = ByteBuffer.allocate(Long.valueOf(ipFile.length()).intValue());
            fin = new FileInputStream(ipFile);
            int readBytesLength;
            byte[] chunk = new byte[4096];
            while (fin.available() > 0) {
                readBytesLength = fin.read(chunk);
                dataBuffer.put(chunk, 0, readBytesLength);
            }
            dataBuffer.position(0);
            int indexLength = dataBuffer.getInt();
            byte[] indexBytes = new byte[indexLength];
            dataBuffer.get(indexBytes, 0, indexLength - 4);
            indexBuffer = ByteBuffer.wrap(indexBytes);
            indexBuffer.order( ByteOrder.LITTLE_ENDIAN);
            offset = indexLength;

            int loop = 0;
            while (loop++ < 256) {
                index[loop - 1] = indexBuffer.getInt();
            }
            indexBuffer.order(ByteOrder.BIG_ENDIAN);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            lock.unlock();
        }
    }

    private static long bytesToLong(byte a, byte b, byte c, byte d) {
        return int2long((((a & 0xff) << 24) | ((b & 0xff) << 16) | ((c & 0xff) << 8) | (d & 0xff)));
    }

    private static int str2Ip(String ip)  {
        String[] ss = ip.split("\\.");
        int a, b, c, d;
        a = Integer.parseInt(ss[0]);
        b = Integer.parseInt(ss[1]);
        c = Integer.parseInt(ss[2]);
        d = Integer.parseInt(ss[3]);
        return (a << 24) | (b << 16) | (c << 8) | d;
    }

    private static long ip2long(String ip)  {
        return int2long(str2Ip(ip));
    }

    private static long int2long(int i) {
        long l = i & 0x7fffffffL;
        if (i < 0) {
            l |= 0x080000000L;
        }
        return l;
    }
}

public class EuIPUtils {

    private static Map<String, String> map = new ConcurrentHashMap<String, String>();

    private static EuIPUtils instance = null;

    /**
     * 英国、法国、德国、意大利、荷兰、比利时、卢森堡、丹麦、爱尔兰、希腊、葡萄牙、西班牙、奥地利、瑞典、芬兰、马耳他、塞浦路斯、波兰、匈牙利、捷克、斯洛伐克、斯洛文尼亚、爱沙尼亚、拉脱维亚、立陶宛、罗马尼亚、保加利亚
     美国、加拿大、墨西哥、日本、韩国、香港、台湾、马来西亚、泰国、新加坡、老挝、越南、柬埔寨、马尔代夫、阿联酋、澳大利亚、埃及、新西兰、巴西、
     */

    private EuIPUtils () {
//        IP.load( EuIPUtils.class.getClassLoader().getResource( "ipDataBase.dat" ).getPath() );
//    	IP.load( "/opt/uuwifi/jar/ipDataBase.dat" );

        map.put( "中国香港", "852" );
        map.put( "中国澳门", "853" );
        map.put( "中国台湾", "886" );
        map.put( "香港", "852" );
        map.put( "台湾", "886" );
        map.put( "中国", "86" );

        map.put( "英国", "44" );
        map.put( "法国", "33" );
        map.put( "德国", "49" );
        map.put( "意大利", "39" );
        map.put( "荷兰", "31" );
        map.put( "比利时", "32" );
        map.put( "卢森堡", "352" );
        map.put( "丹麦", "45" );
        map.put( "爱尔兰", "353" );
        map.put( "希腊", "30" );
        map.put( "葡萄牙", "351" );
        map.put( "西班牙", "34" );
        map.put( "奥地利", "43" );
        map.put( "瑞典", "46" );
        map.put( "芬兰", "358" );
        map.put( "马耳他", "356" );
        map.put( "塞浦路斯", "357" );
        map.put( "波兰", "48" );
        map.put( "匈牙利", "36" );
        map.put( "捷克", "420" );
        map.put( "斯洛伐克", "421" );
        map.put( "斯洛文尼亚", "386" );
        map.put( "爱沙尼亚", "372" );
        map.put( "拉脱维亚", "371" );
        map.put( "立陶宛", "370" );
        map.put( "罗马尼亚", "40" );
        map.put( "保加利亚", "359" );
        map.put( "美国", "1" );
        map.put( "加拿大", "1" );
        map.put( "墨西哥", "52" );
        map.put( "日本", "81" );
        map.put( "韩国", "82" );
        map.put( "马来西亚", "60" );
        map.put( "泰国", "66" );
        map.put( "新加坡", "65" );
        map.put( "老挝", "856" );
        map.put( "越南", "84" );
        map.put( "柬埔寨", "855" );
        map.put( "马尔代夫", "960" );
        map.put( "阿联酋", "971" );
        map.put( "澳大利亚", "61" );
        map.put( "埃及", "20" );
        map.put( "新西兰", "64" );
        map.put( "巴西", "55" );
    }

    public static EuIPUtils getInstance () {
        if ( instance == null ) {
            instance = new EuIPUtils();
        }
        return instance;
    }

    public String get ( String ipAddress ) {

        if ( StringUtils.isNullOrEmpty( ipAddress ) || ipAddress.length()<7 ) {
            return "";
        }

        String[] areaNames = IP.find( ipAddress );
        String areaName = areaNames == null || areaNames.length == 0 ? "" : areaNames[0];

        if ( map.containsKey( areaName ) ) {
            return map.get( areaName );
        }

        if (areaName.startsWith( "中国台湾" )) {
            return "886";
        }

        if (areaName.startsWith( "中国" )) {
            return "86";
        }

        return "";
    }
    
    public String getName ( String ipAddress ) {
    	if ( StringUtils.isNullOrEmpty( ipAddress ) || ipAddress.length()<7 ) {
            return "";
        }
    	String[] areaNames = IP.find( ipAddress );
        String areaName = areaNames == null || areaNames.length == 0 ? "" : areaNames[0];
        return areaName;
    }


}
