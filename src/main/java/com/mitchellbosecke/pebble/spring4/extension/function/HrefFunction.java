package com.mitchellbosecke.pebble.spring4.extension.function;

import com.mitchellbosecke.pebble.extension.Function;
import com.mitchellbosecke.pebble.spring4.util.ViewUtils;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Pebble function which adds the context path to the given url
 *
 * @author Eric Bussieres
 */
public class HrefFunction implements Function {

  public static final String FUNCTION_NAME = "href";

  protected static final String PARAM_URL = "url";

  protected List<String> argumentNames;
  private String contextPath;

  /**
   * Constructor
   */
  public HrefFunction() {
    this.argumentNames = new ArrayList<>();
    this.argumentNames.add(PARAM_URL);
  }

  /**
   * {@inheritDoc}
   *
   * @see com.mitchellbosecke.pebble.extension.Function#execute(java.util.Map)
   */
  @Override
  public Object execute(Map<String, Object> args) {
    StringBuffer result = new StringBuffer();

    result.append(this.getContextPath());
    this.addUrlParameter(args, result);

    return result.toString();
  }

  private void addUrlParameter(Map<String, Object> args, StringBuffer result) {
    String url = (String) args.get(PARAM_URL);
    if (StringUtils.hasText(url)) {
      result.append(url);
    }
  }

  private String getContextPath() {
    if (this.contextPath == null) {
      this.contextPath = ViewUtils.getRequest().getContextPath();
    }

    return this.contextPath;
  }

  /**
   * {@inheritDoc}
   *
   * @see com.mitchellbosecke.pebble.extension.NamedArguments#getArgumentNames()
   */
  @Override
  public List<String> getArgumentNames() {
    return this.argumentNames;
  }
}
