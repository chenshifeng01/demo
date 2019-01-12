package com.csf.common.serialization.msgpack;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.msgpack.jackson.dataformat.MessagePackFactory;

/**
 * 在使用msgpack序列化最好的（ 如果是map中有Date反序列化会装换成long类型时间戳）
 * Created by hand on 2019/1/8.
 */
public class MsgPackKit {

    private static ObjectMapper msgPackObjectMapper = new ObjectMapper(new MessagePackFactory());

    static {
        msgPackObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        msgPackObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @SneakyThrows
    public static byte[] toMsgPack(Object value) {
        return msgPackObjectMapper.writeValueAsBytes(value);
    }

    @SneakyThrows
    public static <T> T fromMsgPack(byte[] content, Class<T> valueType) {
        return msgPackObjectMapper.readValue(content, valueType);
    }

//    @SneakyThrows
//    public static String toJson(Object value) {
//        return msgPackObjectMapper.writeValueAsString(value);
//    }


}
