package io.dropwizard.logging.layout;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.contrib.jackson.JacksonJsonFormatter;
import io.dropwizard.logging.JsonStacktraceLayout;

import java.util.TimeZone;

/**
 * Created by pei971 on 2/6/16.
 */
public class JsonLayoutFactory {

    public JsonStacktraceLayout build(LoggerContext context, TimeZone timeZone,boolean includeStackTrace, boolean prettyPrint)
    {
        JacksonJsonFormatter jsonFormatter = new JacksonJsonFormatter();
        jsonFormatter.setPrettyPrint(prettyPrint);
        JsonStacktraceLayout jsonLayout = new JsonStacktraceLayout();
        jsonLayout.setJsonFormatter(jsonFormatter);
        jsonLayout.setIncludeStacktrace(includeStackTrace);
        jsonLayout.setContext(context);
        jsonLayout.setTimestampFormatTimezoneId(timeZone.getID());

        return  jsonLayout;
    }
}
