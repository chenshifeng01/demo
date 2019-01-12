package com.csf.common.serialization.msgpack;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hand on 2019/1/8.
 */
public class MsgPackKitTest {

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();
        Map map1 = new HashMap();

        System.out.println(map1);
        byte[] bytes = MsgPackKit.toMsgPack(map1);
        System.out.println(bytes.length);
        Map map = MsgPackKit.fromMsgPack(bytes, Map.class);
        System.out.println(map);

    }


}
