package com.csf.common.serialization.hessian;


import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import lombok.SneakyThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * hessian的两种序列化和反序列化方式
 * Created by hand on 2019/1/7.
 */
public class HessianKit {

    @SneakyThrows
    public static byte[] toHessian1(Object value) {
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream(2048);
            HessianOutput out = new HessianOutput(bos);
            out.writeObject(value);
            out.close(); //注意，要先close，否则会失败
            return bos.toByteArray();
        } finally {
            if (bos != null) {
                bos.close();
            }
        }
    }

    @SuppressWarnings("all")
    @SneakyThrows
    public static <T> T fromHessian1(byte[] bytes, Class<T> valueType) {
        ByteArrayInputStream bin = null;
        HessianInput in = null;
        try {
            bin = new ByteArrayInputStream(bytes);
            in = new HessianInput(bin);
            return (T) in.readObject();
        } finally {
            if (in != null) {
                in.close();
            }
            if (bin != null) {
                bin.close();
            }
        }
    }

    @SneakyThrows
    public static byte[] toHessian2(Object value) {
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream(2048);
            Hessian2Output out = new Hessian2Output(bos);
            out.writeObject(value);
            out.close(); //注意，要先close，否则会失败
            return bos.toByteArray();
        } finally {
            if (bos != null) {
                bos.close();
            }
        }
    }

    @SuppressWarnings("all")
    @SneakyThrows
    public static <T> T fromHessian2(byte[] bytes, Class<T> valueType) {
        ByteArrayInputStream bin = null;
        Hessian2Input in = null;
        try {
            bin = new ByteArrayInputStream(bytes);
            in = new Hessian2Input(bin);
            return (T) in.readObject();
        } finally {
            if (in != null) {
                in.close();
            }
            if (bin != null) {
                bin.close();
            }
        }
    }


}
