package com.lz.express.util;


import com.alibaba.fastjson.JSON;
import com.lz.mybatis.plugin.utils.t.Tuple2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 陈金虎 2017年1月16日 下午11:43:50
 * @类描述：字符串工具类
 * @注意：本内容仅限于杭州霖梓网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Slf4j
public class StringUtil extends StringUtils {

    public static final Long INVITE_START_VALUE = 16796251L;

    private static final String COMMA = ",";
    private static final String[] DUOTRIKEY = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V"};
    private static final String[] CARDINALNUM = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
    private static Pattern mobilePattern = Pattern.compile("^((1[3-9][0-9]))\\d{8}$");
    private static Pattern luanMaPattern = Pattern.compile("\\s*|t*|r*|n*");
    private static Pattern lzCodePattern = Pattern.compile("^[A-Z|_|0-9]{1,20}_LZ");

    /**
     * 通过StringBuffer来组装字符串
     *
     * @param strings
     * @return
     */
    public static String appendStrs(Object... strings) {
        StringBuffer sb = new StringBuffer();
        for (Object str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 判断所有传入参数是否非空，当传入参数长度为0，或者任意有一个为空，则返回false，所有都非空，则返回true
     *
     * @param strArr
     * @return
     */
    public static boolean isAllNotEmpty(String... strArr) {
        boolean isAllNotEmpty = true;
        if (strArr == null || strArr.length < 1) {
            isAllNotEmpty = false;
            return isAllNotEmpty;
        }

        for (String str : strArr) {
            if (str == null || str.length() == 0) {
                isAllNotEmpty = false;
                break;
            }
        }
        return isAllNotEmpty;
    }

    /**
     * 把list按分隔符转换成字符串
     *
     * @param strList   list数据
     * @param separator 分隔符
     * @return
     */
    public static String turnListToStr(Collection<String> strList, String separator) {
        String result = "";
        if (strList == null || strList.size() < 1) {
            return result;
        }
        if (separator == null) {
            separator = ",";
        }

        for (String item : strList) {
            result = result + separator + item;
        }
        return result.substring(separator.length());
    }

    /**
     * 把字符串数组按分隔符转化成字符串
     *
     * @param strArr    字符串数组
     * @param separator 分隔符
     * @return
     */
    public static String turnArrayToStr(String separator, String... strArr) {
        String result = "";
        if (strArr == null || strArr.length < 1) {
            return result;
        }
        if (separator == null) {
            separator = ",";
        }

        for (String item : strArr) {
            result = result + separator + item;
        }
        return result.substring(separator.length());
    }

    public static String strToSecret(String str, int left, int right) {
        if (isBlank(str)) {
            return str;
        }
        StringBuffer sb = new StringBuffer();
        int len = str.length() - left - right;
        if (len > 0) {
            sb.append(str.substring(0, left));
            for (int i = 0; i < len; i++) {
                sb.append("*");
            }
            sb.append(str.substring(str.length() - right));
        } else {
            return str;
        }
        return sb.toString();
    }

    /**
     * 把List拼接成String 并且添加分隔符
     *
     * @param <T>
     * @param list
     * @return
     */
    public static <T> String turnListToStr(List<T> list) {
        String result = StringUtils.EMPTY;
        if (CollectionUtil.isEmpty(list)) {
            return StringUtils.EMPTY;
        }
        for (T item : list) {
            result = result + item + COMMA;
        }
        return result.substring(0, result.length() - 1);
    }

    public static String getNotEmptyString(String str) {
        return StringUtils.isNotEmpty(str) ? str : StringUtils.EMPTY;
    }

    public static String getLastString(String str, int num) {
        int len = str.length();
        if (len <= num) {
            return str;
        } else {
            return str.substring(len - num);
        }
    }

    public static List<String> splitToList(String source, String sep) {
        List<String> result = new ArrayList<String>();
        if (isBlank(source)) {
            return result;
        }
        String[] tempResult = source.split(sep);
        for (String item : tempResult) {
            result.add(item);
        }
        return result;
    }

    /**
     * @param source 待处理字符串
     * @return
     * @方法描述：将字符串中的emoji符号转换为*
     * @author huyang 2017年4月6日下午12:38:04
     * @注意：本内容仅限于杭州霖梓网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
     */
    public static String filterEmoji(String source) {
        if (source != null) {
            Matcher emojiMatcher = emoji.matcher(source);
            if (emojiMatcher.find()) {
                source = emojiMatcher.replaceAll("*");
                return source;
            }
            return source;
        }
        return source;
    }

    public static String null2Str(Object str) {
        return (str != null) ? str.toString() : "";
    }

    public static String logisticsInfoDeal(String str) {
        if (str == null || "暂无".equals(str.trim())) {
            return "";
        }
        return str.trim();
    }

    /**
     * @param sStr
     * @return
     * @Title: UrlEncoder
     * @Description: 字符串编码
     */
    public final static String UrlEncoder(String sStr) {
        String sReturnCode = "";
        try {
            sReturnCode = URLEncoder.encode(null2Str(sStr), "utf-8");
        } catch (Exception ex) {
        }
        return sReturnCode;
    }

    /**
     * @param sStr
     * @return
     * @Title: UrlDecoder
     * @Description: 字符串解码
     */
    public static String UrlDecoder(String sStr) {
        if (isEmpty(sStr)) {
            return "";
        } else {
            String sReturnCode = sStr;
            try {
                sReturnCode = URLDecoder.decode(sStr, "utf-8");
            } catch (Exception e) {
            }
            return sReturnCode;
        }
    }


    public static String UrlDecoder2(String sStr) {
        if (isEmpty(sStr)) {
            return "";
        } else {
            String sReturnCode = sStr;
            try {

                String b = URLDecoder.decode(sReturnCode, "utf-8");
                sReturnCode = URLDecoder.decode(b, "utf-8");
            } catch (Exception e) {
            }
            return sReturnCode;
        }
    }


    /**
     * fmai
     * 获取第三方订单号
     *
     * @param type 类型标识（固定3位）如：强风控 type="qfk"
     * @Param thirdMark 第三方标识,比如风控R,ups为U,YiBao为Y，M為魔蝎
     */
    public static String getThirdNo(String type, String thirdMark, Long userId) {
		/*if (StringUtil.isBlank(type) || type.length() != 3) {
			throw new LtException(LtExceptionCode.UPS_ORDERNO_BUILD_ERROR);
		}*/
        if (userId != null) {
            return StringUtil.appendStrs(type, thirdMark, getTimeStr(), getUniqueCode(userId));
        } else {
            return StringUtil.appendStrs(type, thirdMark, getTimeStr(), getFiveRandomNum());
        }
    }


    /**
     * 获取唯一编码
     *
     * @param userId
     * @return
     */
    public static String getUniqueCode(Long userId) {
        return Long.toString((userId + INVITE_START_VALUE), 64);
    }

    /**
     * fmai 根据基数产生随机四位数
     *
     * @return
     */
    public static String getFourRandomNum() {
        StringBuilder randomNum = new StringBuilder();
        int length = CARDINALNUM.length;
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            randomNum.append(CARDINALNUM[random.nextInt(length)]);
        }
        return randomNum.toString();
    }


    /**
     * fmai 根据基数产生随机5位数
     *
     * @return
     */
    public static String getFiveRandomNum() {
        StringBuilder randomNum = new StringBuilder();
        int length = CARDINALNUM.length;
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            randomNum.append(CARDINALNUM[random.nextInt(length)]);
        }
        return randomNum.toString();
    }


    /**
     * fmai 根据时间数据生产相应的字符串
     *
     * @return
     */
    public static String getTimeStr() {
        StringBuilder timeStr = new StringBuilder();
        timeStr.append(toBinaryByTime());
        timeStr.append(DateUtil.formatDate(new Date(), "mmssSSS"));
        return timeStr.toString();
    }

    /**
     * fmai 根据日期年月日时生成对应的32进制字符串
     *
     * @return
     */
    public static String toBinaryByTime() {
        StringBuilder binary = new StringBuilder();
        Calendar cal = Calendar.getInstance();
        int year = (cal.get(Calendar.YEAR) - 2000) % 32;
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        binary.append(DUOTRIKEY[year]).append(DUOTRIKEY[month]).append(DUOTRIKEY[day]).append(DUOTRIKEY[hour]);
        return binary.toString();
    }


    /**
     * 首字母大写
     *
     * @param s
     * @return
     */
    public static String firstCharUpperCase(String s) {
        StringBuffer sb = new StringBuffer(s.substring(0, 1).toUpperCase());
        sb.append(s.substring(1, s.length()));
        return sb.toString();
    }


    /**
     * 字符串空处理，去除首尾空格 如果str为null，返回"",否则返回str
     *
     * @param str
     * @return
     */
    public static String isNull(String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }



    public static boolean isBoolNull(Object object)
    {
        return object == null;
    }


    /**
     * 将对象转为字符串
     *
     * @param o
     * @return
     */
    public static String isNull(Object o) {
        if (o == null) {
            return "";
        }
        String str = "";
        if (o instanceof String) {
            str = (String) o;
        } else {
            str = o.toString();
        }
        return str.trim();
    }

    public static String removeDoubleChar(String str) {
        if (str.indexOf("\"") == 0) {
            str = str.substring(1, str.length());   //去掉第一个 "
        }
        if (str.lastIndexOf("\"") == (str.length() - 1)) {
            str = str.substring(0, str.length() - 1);  //去掉最后一个 "
        }
        return str;
    }


    /**
     * 通过请求参数获取键值对
     *
     * @param requestParams
     * @return
     */
    public static Map<String, String> getRequestParams(Map requestParams) {
        Map<String, String> params = new HashMap<String, String>();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        return params;
    }


    /**
     * 除去数组中的空值和签名参数
     *
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }


        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || "".equals(value) || "sign".equalsIgnoreCase(key) || "signInfo".equalsIgnoreCase(key)
                    || "sign_type".equalsIgnoreCase(key)) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }


    /**
     * 以逗号隔开的元素
     *
     * @param value
     * @param i
     * @return
     */
    public static String getSpitStr(String value, int i) {
        String[] values = value.split(",", value.length());
        if (i == 0) {
            i = i + 1;
        }
        if (values.length >= i) {
            return values[i - 1];
        } else {
            return values[0];
        }
    }

    /**
     * fmai 根据时间数据生产相应的字符串
     *
     * @return
     */
    public static String getTimeLongStr() {
        StringBuilder timeStr = new StringBuilder();
        timeStr.append(DateUtil.formatDate(new Date(), "yyyyMMddHHmmssSSS"));
        return timeStr.toString();
    }

    /**
     * 拼接get请求的url请求地址
     */
    public static String getRqstUrl(String url, Map<String, String> params) {
        StringBuilder builder = new StringBuilder(url);
        boolean isFirst = true;
        for (String key : params.keySet()) {
            if (key != null && params.get(key) != null) {
                if (isFirst) {
                    isFirst = false;
                    builder.append("?");
                } else {
                    builder.append("&");
                }
                builder.append(key)
                        .append("=")
                        .append(params.get(key));
            }
        }
        return builder.toString();
    }


    public static StringBuffer appendSb(String... strs) {
        StringBuffer stringBuffer = new StringBuffer();
        if (strs != null && strs.length > 0) {
            for (int i = 0; i < strs.length; i++) {
                stringBuffer.append(strs[i]);
            }
        }
        return stringBuffer;
    }

    public static boolean getClassName(String className) {
        return false;
    }

    /**
     * 校验是否存在为"null"或"NULL"的字符串
     *
     * @param strArr
     * @return
     */
    public static boolean checkParamsNullStr(String... strArr) {
        boolean flag = true;
        for (int i = 0; i < strArr.length; i++) {
            if (null == strArr[i] || "null".equalsIgnoreCase(strArr[i])) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 截取一个字符串中两个字符串中间的字符串
     *
     * @param str
     * @param strStart
     * @param strEnd
     * @return
     */
    public static String subMidString(String str, String strStart, String strEnd) {

        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex = str.indexOf(strStart);
        int strEndIndex = str.indexOf(strEnd);

        /* index 为负数 即表示该字符串中 没有该字符 */
        if (strStartIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
        }
        if (strEndIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
        }
        /* 开始截取 */
        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
        return result;

    }

    public static boolean matchString(String srcString, String regex) {

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(srcString);
        return m.matches();
    }

    public static boolean isMobileNO(String mobiles) {
        Matcher m = mobilePattern.matcher(mobiles);
        return m.matches();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//		System.out.println(matchString("欧阳蓝天白云朵", "^(?!\\s+$)([\\s\\x{4e00}-\\x{9fa5}]+[\\·]{0,1}[\\x{4e00}-\\x{9fa5}]+|[\\s\\.a-z]+)$"));
//		String m = "2010150001"+"20201021"+"b703c7564908a95b43cd1f24aab1b841";
//		System.out.println(MD5.encode(m));
//		String s = "eyJ0aXRsZSI6IuW_q-adpeS9k-mqjOaYk-WAn-mAn-i0tyIsImNvbnRlbnQiOiLlv6vmnaXkvZPpqozmmJPlgJ_pgJ_otLciLCJpY29uVXJsIjoiaHR0cHM6Ly9sdGYubGR4aW55b25nLmNvbS9vbmxpbmUveWpfbG9nby5wbmciLCJzaGFyZVVybCI6Imh0dHBzOi8vbHRoNS5sZHhpbnlvbmcuY29tL3VuaWNvbS93eGRvd25sb2FkIn0";
//		try {
//			System.out.println(new String(Base64.decode(s),"UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		System.out.println("abc".substring(0, "abc".length() - 1));
//
//		System.out.println(getLzChannelCode("MSA_APP21_LZ_sdas", ""));

//		String decode = URLDecoder.decode("", "UTF-8");
//		System.out.println("==============");

        byte[] decode = Base64.getUrlDecoder().decode("eyJ0aXRsZSI6IuW_q-adpeS9k-mqjOaYk-WAn-mAn-i0tyIsImNvbnRlbnQiOiLlv6vmnaXkvZPpqozmmJPlgJ_pgJ_otLciLCJpY29uVXJsIjoiaHR0cHM6Ly9sdGYubGR4aW55b25nLmNvbS9vbmxpbmUveWpfbG9nby5wbmciLCJzaGFyZVVybCI6Imh0dHBzOi8vbHRoNS5sZHhpbnlvbmcuY29tL3VuaWNvbS93eGRvd25sb2FkP3R5cGU9c2hhcmUifQ==");
        byte[] encode = Base64.getUrlEncoder().encode("{\"title\":\"快来体验易借速贷\",\"content\":\"快来体验易借速贷\",\"iconUrl\":\"https://ltf.ldxinyong.com/online/yj_logo.png\",\"shareUrl\":\"https://lth5.ldxinyong.com/unicom/wxdownload?type=share\"}".getBytes());
        System.out.println(new String(decode));
        System.out.println(new String(encode));

        System.out.println(split("3,6,12", ",", Integer.class));
        System.out.println(removeLast("18458195149"));
        System.out.println(JSON.toJSONString(getUriMap("http://localhost:8080?xxa=1&bb=2")));


        System.out.println(removeRepite("channelRegisterCount,channelBorrowSucCount,channelBorrowSucAmount,channelRegisterCount,channelBorrowSucCount,channelBorrowSucAmount"));
    }

    /**
     * 判断字符串是否是乱码
     *
     * @param strName 字符串
     * @return 是否是乱码
     */
    public static boolean isMessyCode(String strName) {
        Matcher m = luanMaPattern.matcher(strName);
        String after = m.replaceAll("");
        String temp = after.replaceAll("\\p{P}", "");
        char[] ch = temp.trim().toCharArray();
        float chLength = ch.length;
        float count = 0;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!Character.isLetterOrDigit(c)) {
                if (!isChinese(c)) {
                    count = count + 1;
                }
            }
        }
        float result = count / chLength;
        if (result > 0.4) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 判断字符是否是中文
     *
     * @param c 字符
     * @return 是否是中文
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 获取出生日期
     *
     * @param idcard
     * @return
     */
    public static String getBirthday(String idcard) {
        if (StringUtils.isBlank(idcard)) {
            return null;
        }
        String birthday = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = idcard.substring(6, 14);
            Date birthdate = new SimpleDateFormat("yyyyMMdd").parse(birthday);
            birthday = sdf.format(birthdate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return birthday;
    }

    /**
     * 获取渠道码
     *
     * @param cnlCode
     * @return
     */
    public static String getLzChannelCode(String cnlCode, String defaultCode) {
        if (isBlank(cnlCode)) {
            return defaultCode;
        }
        Matcher matcher = lzCodePattern.matcher(cnlCode);
        while (matcher.find()) {
            return matcher.group();
        }
        return defaultCode;
    }

    public static Tuple2 getCnlCodeChannelCode(String cnlCode, String defaultCode) {
        try {
            String lzChannelCode = StringUtil.getLzChannelCode(cnlCode, defaultCode);
            String channelCode = cnlCode.replaceAll(lzChannelCode, "");
            if (channelCode.length() > 1) {
                channelCode = channelCode.substring(1);
            }
            return new Tuple2(lzChannelCode, channelCode);
        } catch (Exception e) {

        }
        return new Tuple2("未知channelCode", "");
    }

    public static String mergeUrl(String domainName, String urlSuffix) {
        if (isBlank(domainName) || isBlank(urlSuffix)) {
            return null;
        }
        while (domainName.endsWith("/")) {
            domainName = domainName.substring(0, domainName.length() - 1);
        }
        if (!urlSuffix.startsWith("/")) {
            urlSuffix = "/" + urlSuffix;
        }
        return domainName + urlSuffix;
    }

    public static <T> List<T> split(String value, String split, Class<T> clazz) {
        if (StringUtil.isBlank(value)) {
            return null;
        }
        String vs[] = value.split(split);
        List<T> list = new ArrayList<>();
        for (String v : vs) {
            if (StringUtil.isNotBlank(v)) {
                list.add((T) JSONObjectUtil.parseBasicTypeWrapper(clazz, v));
            }
        }

        return list;

    }


    public static String removeRegex(String source, String regex) {
        if (source == null) {
            return null;
        }
        return source.replaceAll(regex, "");
    }

    public static String removeLast(String userName) {
        if (StringUtil.isBlank(userName)) {
            return "";
        }
        return userName.substring(1);
    }

    public static Map<String, String> getUriMap(String skipUrl) {
        Map<String, String> map = new HashMap<>();
        if (StringUtil.isBlank(skipUrl)) {
            return map;
        }
        if (skipUrl.contains("?")) {
            String url = skipUrl.substring(skipUrl.indexOf("?") + 1);
            String xx[] = url.split("&");
            if (xx != null && xx.length > 0) {
                for (String x : xx) {
                    if (StringUtil.isNotBlank(x) && x.contains("=")) {
                        String kv[] = x.split("=");
                        map.put(kv[0], kv[1]);
                    }
                }
            }
        }
        return map;
    }


    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isObjectNull(Object object)
    {
        return object == null;
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object)
    {
        return !isObjectNull(object);
    }

    public static String tuoming(String mobileEn) {
        if (StringUtil.isEmpty(mobileEn)) {
            return "";
        }
        if (mobileEn.length() > 7) {
            return mobileEn.substring(0, 3) + "****" + mobileEn.substring(7, mobileEn.length());
        }
        return mobileEn;
    }


    public static boolean isEmpty(Object[] objects)
    {
        return isObjectNull(objects) || (objects.length == 0);
    }

    public static boolean inStringIgnoreCase(String str, String... strs)
    {
        if (str != null && strs != null)
        {
            for (String s : strs)
            {
                if (str.equalsIgnoreCase(trim(s)))
                {
                    return true;
                }
            }
        }
        return false;
    }


    public static String removeRepite(String columnNames) {
        if(StringUtil.isBlank(columnNames)){
            return "";
        }
        String[] columnNamex  = columnNames.split(",");
        Set<String> strings = new LinkedHashSet<>();
        for(String column : columnNamex){
            if(StringUtil.isNotBlank(column)){
                strings.add(column);
            }
        }
        StringBuilder sb = new StringBuilder("");

        if(strings.size()>0 ){
            int i = 0 ;
            for(String s : strings){
                if(i == strings.size() -1){
                    sb.append(s);
                }else{
                    sb.append(s).append(",");
                }
                i ++ ;
            }

        }
        return sb.toString();
    }



}
