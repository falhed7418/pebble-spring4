package com.mitchellbosecke.pebble.spring4.extension.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.mitchellbosecke.pebble.extension.Function;
import com.mitchellbosecke.pebble.spring4.util.ViewUtils;

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
     * Constructeur
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

        // Add context path
        if (this.contextPath == null) {
            this.contextPath = ViewUtils.getRequest().getContextPath();
        }
        result.append(this.contextPath);

        // Add url parameter
        String url = (String) args.get(PARAM_URL);
        if (StringUtils.hasText(url)) {
            result.append(url);
        }

        return result.toString();
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
