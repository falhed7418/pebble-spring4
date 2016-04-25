/**
 *
 */
package com.mitchellbosecke.pebble.spring4.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Utility class for view
 *
 * @author Eric Bussieres
 */
public class ViewUtils {

    /**
     * Desactivate constructor
     */
    private ViewUtils() {
    }

    /**
     * Get current http request
     *
     * @return http request
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest();
    }

    /**
     * Get current http session
     *
     * @return http session
     */
    public static HttpSession getSession() {
        return getRequest().getSession(true);
    }
}
