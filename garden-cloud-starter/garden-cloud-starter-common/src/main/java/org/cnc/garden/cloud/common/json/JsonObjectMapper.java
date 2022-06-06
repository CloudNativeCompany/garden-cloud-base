package org.cnc.garden.cloud.common.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.PackageVersion;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

/**
 * org.cnc.garden.cloud.common.json - JsonObjectMapper
 *
 * @author tony-is-coding
 * @date 2022/6/6 21:49
 */
public class JsonObjectMapper {

    public static ObjectMapper getObjectMapper() {
        return Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .locale(Locale.CHINA)
                .timeZone(TimeZone.getTimeZone("GMT+8"))
                .modules(new JavaTimeSimpleModule())
                .build();
    }

    static class JavaTimeSimpleModule extends SimpleModule {
        public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
        public static final String PATTERN_DATE = "yyyy-MM-dd";
        public static final String PATTERN_TIME = "HH:mm:ss";

        public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(PATTERN_DATETIME);
        public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(PATTERN_DATE);
        public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(PATTERN_TIME);

        public JavaTimeSimpleModule() {
            super(PackageVersion.VERSION);
            this.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DATETIME_FORMATTER));
            this.addDeserializer(LocalDate.class, new LocalDateDeserializer(DATE_FORMATTER));
            this.addDeserializer(LocalTime.class, new LocalTimeDeserializer(TIME_FORMATTER));

            this.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DATETIME_FORMATTER));
            this.addSerializer(LocalDate.class, new LocalDateSerializer(DATE_FORMATTER));
            this.addSerializer(LocalTime.class, new LocalTimeSerializer(TIME_FORMATTER));
        }
    }
}
