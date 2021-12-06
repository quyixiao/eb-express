
package com.lz.express.util;


import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author 陈金虎 2017年1月16日 下午11:39:50
 * @类描述：集合工具类
 * @注意：本内容仅限于杭州霖梓网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class CollectionUtil {

    /**
     * To judge whether the List is empty
     * if the list is null or the size of this list is 0, then return true;
     *
     * @param list
     * @return
     */
    public static <T> boolean isEmpty(List<T> list) {
        if (list == null || list.size() < 1) {
            return true;
        }
        return false;
    }

    /**
     * To judge whether the List is not empty
     * if the list is not null or the size of this list > 0, then return true;
     *
     * @param list
     * @return
     */
    public static <T> boolean isNotEmpty(List<T> list) {
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * To judge whether the map is empty
     * if the list is null or the size of this list is 0, then return true;
     *
     * @param <K>
     * @param list
     * @return
     */
    public static <K, V> boolean isEmpty(Map<K, V> maps) {
        if (maps == null || maps.size() < 1) {
            return true;
        }
        return false;
    }

    /**
     * To judge whether the map is not empty
     * if the list is not null or the size of this list > 0, then return true;
     *
     * @param list
     * @return
     */
    public static <K, V> boolean isNotEmpty(Map<K, V> maps) {
        if (maps != null && maps.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * To parse List to T,T,T,T,T
     */
    public static <T> String parseListToString(List<T> list) {
        if (isEmpty(list)) {
            return StringUtils.EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (T t : list) {
            System.out.println(list.indexOf(t));
            if (list.indexOf(t) != list.size() - 1) {
                sb.append(t.toString()).append(",");
            } else {
                sb.append(t.toString());
            }
        }
        return sb.toString();
    }
}
