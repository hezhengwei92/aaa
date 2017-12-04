package net.eoutech.vifi.as.commons.utils;

import com.alibaba.fastjson.JSONObject;
import net.eoutech.vifi.as.commons.constant.VaConst;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2015/8/19.
 */
public class CommonUtils {

	private static ConfigUtils conUtil = ConfigUtils.getInstance();

    public static void sleep( long time ) {
        if ( time <= 0 ) {
            return;
        }
        try {
            Thread.sleep( time );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

//    public static ViFiUT viFiUT = null;

    /**
     * alg: 写死"MD5"
     * realm: 也就是domain
     * cnonce: 文档里少定义了（很多终端会产生这个值，也就是客户端的随机数）
     * qop: 我们服务器指定了是"auth"，所以你就写死这个值就可以了
     * method: 如果是注册消息，就是"REGISTER"，呼叫的话就是"MESSAGE"
     */

    public static String myExceptionString( Exception e ) {
        String myexception = "--Exception:" + e.getMessage() + "(" + e.toString() + ")";
        StackTraceElement[] stack = e.getStackTrace();
        for ( int i = 0; i < 10 && i < stack.length; i++ ) {
            String firstStack = stack[i].toString();
            int pos = firstStack.indexOf( '(' );
            myexception += ( pos > 0 ) ? firstStack.substring( pos )
                    : ( " " + firstStack );
        }

        return myexception + "--";
    }

    /**
     * 从json字符串中截出,指定参数的string值,  ,,第一层属性!
     * @param str  json 字符串
     * @param val  要获得的第一层的属性值
     * @return 属性值 string 类型
     */
    public static String getStrData( String str, String val ) {
        String valCC = "\"" + val + "\":\"";  //  "msg"

        int sInx = str.indexOf( valCC );
        if ( sInx < 0 ) {
            return null;
        }
        return str.substring( sInx + valCC.length(), str.indexOf( "\"", sInx + valCC.length() ) );
    }
    /**
     * 从json字符串中截出,指定参数的int值,  ,,第一层属性!
     * @param str  json 字符串
     * @param val  要获得的第一层的属性值
     * @return 属性值 int  类型
     */
    public static Integer getDataInt( String str, String val ) {
        String valCC = "\"" + val + "\":";
        int sInx = str.indexOf( valCC );
        if ( sInx < 0 ) {
            return null;
        }
        int valCo = str.indexOf( ",", sInx + valCC.length());
        String intager = "";
        if (valCo < 0) {
            intager = str.substring( sInx + valCC.length(), str.indexOf( "}", sInx + valCC.length()));
        }else {
            intager = str.substring( sInx + valCC.length(), valCo);
        }

        return Integer.valueOf( intager );
    }

    public static String getDataStr( String str ) {
        String valCC = "\"DATA\":";
        String valEE = "}";
        int sInx = str.indexOf( valCC );
        int eInx = str.indexOf( valEE );
        if ( sInx < 0 ) {
            return null;
        }
        return str.substring( sInx + valCC.length(), eInx+1 );
    }

    public static String getFIPStr( String str ) {
        String valCC = "\"FIP\":";
        int sInx = str.indexOf( valCC );
        if ( sInx < 0 ) {
            return null;
        }
        return str.substring( sInx + valCC.length() + 1, str.indexOf( ",", sInx + valCC.length() ) - 1 );
    }


    /**
     * 获得手机号的前缀集..
     *
     * @param phone 手机号 : "13266720440"
     * @return {String[]} 手机号的前缀集 ["1","13","132","1326","13266",...]
     */
    public static String[] getPhonePrefixs( String phone ) {
        String phonePrefixs[] = new String[phone.length()];
        for ( int i = 0; i < phone.length(); i++ ) {
            phonePrefixs[i] = phone.substring( 0, i + 1 );
        }
        return phonePrefixs;
    }

    /**
     * 注意在使用中split点是需要转译的
     * @param agentId
     * @return
     */
    public static List< String > domainStringFormat ( String agentId ) {
        if ( StringUtils.isEmpty( agentId ) || agentId.split( "\\." ).length - 1 <= 0 ) {
            return null;
        }
        List< String > list = new ArrayList< String >();

        String firstAgent = agentId.substring( 0, agentId.indexOf( VaConst.Symbol.POINT ) );
        do {
            list.add( agentId );

            int lastPoint = agentId.lastIndexOf( VaConst.Symbol.POINT );
            agentId = agentId.substring( 0, lastPoint );
        } while ( agentId.indexOf( VaConst.Symbol.POINT, firstAgent.length() ) != -1 );

        return list;
    }

    public static String hostNumberFormat ( String userId ) {
        if ( StringUtils.isEmpty( userId ) ) {
            return VaConst.Common.EMPTY;
        }
        return conUtil.getCfgStr("call.goip.in.prefix") + userId;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 根据分页对象,创建JSON分页视图数据,方便前端js 分页
     */
    public static JSONObject createPageView( Collection datas, Integer pageNum, Integer pageSizeNum, long totalElements ) {
        //region 视图数据填充
        Long totalPages = totalElements / pageSizeNum + ( totalElements % pageSizeNum > 0 ? 1 : 0 );
        JSONObject view = new JSONObject();
        view.put( "lastPage", totalPages >= pageNum ); // 是否是最后一页
        view.put( "hasPreviousPage", pageNum < totalPages  ); // 是否有上一页
        view.put( "hasNextPage", totalPages > pageNum ); // 是否有下一页
        view.put( "totalPages", totalPages ); // 总页数
        view.put( "totalElements", totalElements ); // 记录数量
        view.put( "number", pageNum ); // 页码
        view.put( "size", pageSizeNum ); // 页大小
        view.put( "contentList", datas ); // 数据集
        //endregion
        return view;
    }


    /**
     * 计算一个对象所占字节数
     *
     * @param o 对象，该对象必须继承Serializable接口即可序列化
     * @return
     * @throws IOException
     */
    public static int objSize( final Object o ) throws IOException {
        if ( o == null ) {
            return 0;
        }
        ByteArrayOutputStream buf = new ByteArrayOutputStream( 4096 );
        ObjectOutputStream out = new ObjectOutputStream( buf );
        out.writeObject( o );
        out.flush();
        buf.close();

        return buf.size();
    }

    /**
     * 赋值对象，返回对象的引用，如果参数o为符合对象，则内部每一个对象必须可序列化
     *
     * @param o 对象，该对象必须继承Serializable接口即可序列化
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object objCopy( final Object o ) throws IOException,
            ClassNotFoundException {
        if ( o == null ) {
            return null;
        }

        ByteArrayOutputStream outbuf = new ByteArrayOutputStream( 4096 );
        ObjectOutput out = new ObjectOutputStream( outbuf );
        out.writeObject( o );
        out.flush();
        outbuf.close();

        ByteArrayInputStream inbuf = new ByteArrayInputStream( outbuf.toByteArray() );
        ObjectInput in = new ObjectInputStream( inbuf );
        return in.readObject();
    }
    
    /**
     * 对于消息VOPEN-ACK使用 ...
     * @param slot
     * @param length
     * @return
     */
    public static String nsFormat ( int slot, int length ) {
    	
    	NumberFormat nf = NumberFormat.getInstance();
    	nf.setGroupingUsed( false );
    	nf.setMaximumIntegerDigits( length );
    	nf.setMinimumIntegerDigits( length );
    	
    	return nf.format( slot );
    	
    }
    
    public static String listFormat ( List<Integer> list ) {
    	StringBuilder sb = new StringBuilder();

    	for (int i = 0; i < list.size(); i++) {
			String s = String.valueOf( list.get(i) );
			sb.append( s );
			if ( i < list.size() - 1) {
				sb.append( "," );
			}
		}
    	
    	return sb.toString();
    }

    /**
     * @param str eg:1100
     * @return [1,1,0,0]
     */
    public static List<Integer> stringFormatList ( String str ) {
        if ( StringUtils.isEmpty( str ) ) {
            return null;
        }

        List<Integer> list = new ArrayList<Integer>();
        for ( int i = 0; i < str.length(); i ++ ) {
            list.add( Integer.parseInt( String.valueOf( str.charAt( i ) ), 16 ) );
        }

        return list;
    }

    /**
     * @param str eg:1100
     * @return {1:[0,1],0:[2,3]}
     */
    public static Map< Integer, List<Integer> > stringFormatMap ( String str ) {
        if ( StringUtils.isEmpty( str ) ) {
            return null;
        }

        Map< Integer, List<Integer> > map = new ConcurrentHashMap< Integer, List<Integer> >();
        for ( int i = 0; i < str.length(); i ++ ) {
            Integer key = Integer.parseInt( String.valueOf( str.charAt( i ) ), 16 );
            List<Integer> value = map.get( key );
            if ( !map.containsKey( key ) ) {
                value = new ArrayList<Integer>();
            }
            value.add( i + 1 );
            map.put( key, value );
        }

        return map;
    }

    public static Map< Integer, List< Integer > > stringCompare ( String oldStr, String newStr ) {
        if ( StringUtils.isEmpty( newStr ) ) {
            return null;
        }

        if ( StringUtils.isEmpty( oldStr ) || oldStr.length() != newStr.length() ) {
            return stringFormatMap( newStr );
        }

        Map< Integer, List<Integer> > map = new ConcurrentHashMap< Integer, List<Integer> >();
        int length = newStr.length();
        for ( int i = 0; i < length; i ++ ) {
            //000 111
            Integer oldKey = Integer.parseInt( String.valueOf( oldStr.charAt( i ) ), 16 );
            //000 000
            Integer newKey = Integer.parseInt( String.valueOf( newStr.charAt( i ) ), 16 );
            if ( oldKey != newKey )   {
                List<Integer> value = map.get( newKey );
                //
                if ( !map.containsKey( newKey ) ) {
                    value = new ArrayList< Integer >();
                }
                //把传进来的 进行比较  不同状态的卡槽  记录下来
                // 0 对应一类卡槽list   1 对应一类卡槽的list
                value.add( i + 1 );
                map.put( newKey, value );
            }
        }
        return map;
    }

    public static Map< String, String > phoneNumberFormat ( String phoneNumber, String countryCode, String callType ) {
        if ( StringUtils.isEmpty( phoneNumber ) ) {
            return null;
        }
        Map< String, String > map = new HashMap< String, String >();
        if ( phoneNumber.startsWith( VaConst.Symbol.PLUS ) ) {
            phoneNumber = phoneNumber.replace( VaConst.Symbol.PLUS, "00" );
        }
        if ( phoneNumber.startsWith( "00" ) ) {
            phoneNumber = phoneNumber.replaceFirst( "^0*", VaConst.Common.EMPTY );
        } else {
            if ( !VaConst.Common.CALL_TYPE_MT.equals( callType ) ) {
                phoneNumber = countryCode + phoneNumber;
            }
        }

        String isLocalCall = phoneNumber.startsWith( countryCode ) ? VaConst.SystemVariate.TRUE : VaConst.SystemVariate.FALSE;

        map.put( VaConst.SystemVariate.CALLEE, phoneNumber );
        map.put( VaConst.SystemVariate.LOCALCALL, isLocalCall );

        return map;
    }

    public static String phoneNumberPrefixChange ( String phoneNumber, int delDnisPrefixNum, String addDnisPrefixStr ) {
        if ( StringUtils.isEmpty( phoneNumber ) || phoneNumber.length() < delDnisPrefixNum ) {
            return phoneNumber;
        }
        return addDnisPrefixStr + phoneNumber.substring( delDnisPrefixNum );
    }

    public static String getCdrTypeByCallType ( String callType ) {
        String cdrType = VaConst.Tables.TBCDR_CDRTYPE_UNKNOWN;
        if ( VaConst.Common.CALL_TYPE_GMO.equals( callType ) ) {
            cdrType = VaConst.Tables.TBCDR_CDRTYPE_CALL_GOIP;
        } else if ( VaConst.Common.CALL_TYPE_MM.equals( callType ) ) {
            cdrType = VaConst.Tables.TBCDR_CDRTYPE_CALL_ONLINE;
        } else if ( VaConst.Common.CALL_TYPE_MT.equals( callType ) ) {
            cdrType = VaConst.Tables.TBCDR_CDRTYPE_CALL_GOIP;
        } else if ( VaConst.Common.CALL_TYPE_VMO.equals( callType ) ) {
            cdrType = VaConst.Tables.TBCDR_CDRTYPE_CALL_VOIP;
        }
        return cdrType;
    }

    public static int getTimeCot ( long times ) {
        if ( times <= 0 ) {
            return 0;
        }
        int costTime = ( int )( times / 60000 );
        if ( times % 60000 != 0) {
            costTime += 1;
        }
        return costTime;
    }
    //拼接数据 增加本地与远程的 IP Port
    public static String getMessageStr(String message,String servers,String remoteIpAndPort){

        String remoteIp = remoteIpAndPort.substring(remoteIpAndPort.indexOf("/")+1,remoteIpAndPort.indexOf(":"));
        String remotePort = remoteIpAndPort.substring(remoteIpAndPort.indexOf(":")+1,remoteIpAndPort.length());
        int remoPort=Integer.parseInt(remotePort);
        String messageOne=message.substring(0, message.length()-1)+",\"ip"+"\""+":"+"\""+remoteIp+"\""+",\"port\""+":"+remoPort+"}";

        String serveIp = servers.substring(servers.indexOf("/")+1,servers.indexOf(":"));
        String servePort = servers.substring(servers.indexOf(":")+1,servers.length());
        int serPort=Integer.parseInt(servePort);
        String newMessage = messageOne.substring(0,messageOne.length()-1)+",\"serveIp"+"\":"+"\""+serveIp+"\""+",\"servePort\""+":"+serPort+"}";

        return newMessage;
    }
    //解析数据
    public static String getMessage(byte[] bytes){
        String message="";
        char ch='0';
        int num=0;
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<bytes.length;i++){

            if(bytes[i]==58){
                num++;
                if(num==3){
                    ch=(char)bytes[i];
                    message+=ch;
                    i++;
                    Integer slot= bytes[i]&0xff;
                    message+=slot.toString();
                      i++;
                }
            }
            //如果ATR只有一位 这里会停止
            if(bytes[i]==91){
                for(int j=(i+1);j<bytes.length;j++){
                    i++;
                    j++;
                    if(bytes[j]==44){
                        list.add(bytes[j-1]&0xff);
                    }else if(bytes[j]==93){
                        list.add(bytes[j-1]&0xff);
                        i=j+1;
                        break;
                    }
                }
                message+=list.toString();
            }
            ch=(char) bytes[i];
            message+=ch;
        }
        return message;
    }
}
