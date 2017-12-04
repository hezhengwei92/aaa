package net.eoutech.vifi.as.commons.utils;

import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SUU on 2016/7/22.
 */
public class MyMatcherUtils {

    private static MyMatcherUtils instance = null;

    private MyMatcherUtils() {
    }

    public static MyMatcherUtils getInstance() {
        if ( instance == null ) {
            instance = new MyMatcherUtils();
        }
        return instance;
    }

    public String doMatcherReplace( String patternStr, Map< String, String > tokens ) {

        if ( tokens == null || tokens.isEmpty() ) {
            return patternStr;
        }

        // 创建正则
        String patternString = "\\$\\{(" + StringUtils.join( tokens.keySet(), "|" ) + ")\\}";
        Pattern pattern = Pattern.compile( patternString );

        Matcher matcher = pattern.matcher( patternStr );

        StringBuffer sb = new StringBuffer();

        while ( matcher.find() ) {
            matcher.appendReplacement( sb, tokens.get( matcher.group( 1 ) ) );
        }
        matcher.appendTail( sb );

        return sb.toString();
    }

}
