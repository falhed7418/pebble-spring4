/**
 *
 */
package com.mitchellbosecke.pebble.spring4.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Utility class for view
 *
 * @author Eric Bussieres
 */
public class ViewUtils {

  /**
   * Deactivate constructor
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
