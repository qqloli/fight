package com.zj.redis.conf;


import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class RedisObjectSerializer implements RedisSerializer {
    private Converter<Object,byte[]> serializer = new SerializingConverter();
    private Converter<byte[],Object> deserializer1 = new DeserializingConverter();
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (o == null){
            return EMPTY_BYTE_ARRAY;
        }
        return  this.serializer.convert(o);

    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0){
            return null;
        }
        return this.deserializer1.convert(bytes);
    }
}
