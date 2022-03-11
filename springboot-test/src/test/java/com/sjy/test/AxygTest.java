package com.sjy.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sjy.common.utils.OkhttpUtils;
import org.springframework.util.StringUtils;

import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author: shijingyang
 * @date: 2021/12/13
 */
public class AxygTest {
    //        static String url = "http://localhost:8081/tianrun";
    static String url = "http://39.97.196.29/tianrun";
    //    static String url = "http://47.101.221.154:8089/tianrun";
//    static String appid = "5601853";
//    static String secret = "eaa165f89d21db95";
    static String appid = "5600970";
    static String secret = "8c89670fea49c1ba";

    public static void main(String[] args) throws UnknownHostException {

//        setTenantCallbackInfo();
//        operateGroup();
        bindAxyg();
//        unbindAxyg();
//        setYEncStatus();
//        batchGetYEncStatus();
//        setRingtone();

    }

    public static HashMap<String, String> setTenantCallbackInfo() {

        JSONObject map = new JSONObject();
        long l = System.currentTimeMillis() / 1000;
        map.put("app_id", appid);
        map.put("timestamp", l + "");
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        /**
         * {
         * 			"group_id": "G000001",
         * 			"decrypt_url": "https://www.baidu.com1",
         * 			"call_log_url": "http://www.baidu.com1"
         *                }
         */
        jsonObject.put("tenant_id", "T000003");
        jsonObject.put("call_log_url", "http://www.aaa.com");
//        jsonArray.add(jsonObject);
        jsonObject = new JSONObject();

        jsonObject.put("tenant_id", "T000002");
        jsonObject.put("decrypt_url", "https://www.ttt.com");
        jsonObject.put("call_log_url", "http://www.ttt.com");
        jsonObject.put("extra", "xxx");
        //jsonArray.add(jsonObject);
        jsonObject = new JSONObject();

        jsonObject.put("tenant_id", "G000004");
        jsonObject.put("decrypt_url", "https://www.tenant_id3.com");
        jsonObject.put("call_log_url", "http://www.tenant_id4.com");
        jsonObject.put("extra", "xxx1");
        jsonArray.add(jsonObject);
        map.put("callback_infos", jsonArray);
        map.put("signature", buildSign(map.getInnerMap(), appid, secret, l + ""));

        System.out.println(OkhttpUtils.createBatch(map.toJSONString(), url + "/axyg/set_tenant_callback_info"));

        return null;
    }

    public static HashMap<String, String> operateGroup() {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                JSONObject map = new JSONObject();
                long l = System.currentTimeMillis() / 1000;
                int i1 = new Random().nextInt(10);
                l = l + i1;
                map.put("app_id", appid);
                map.put("timestamp", l);
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                /**
                 * "group_id": "G000002",
                 * 	"numbers": [
                 * 		"17733974999",
                 * 		"17733974998"
                 * 	],
                 * 	"operate_type": "0",
                 * 	"is_encrypted": "0"
                 */
                map.put("group_id", "tr_test_g_0001" + i1);
                JSONArray jsonArray1 = new JSONArray();
                jsonArray1.add("09162315883");
                map.put("numbers", jsonArray1);
                map.put("operate_type", 0);
                map.put("is_encrypted", 0);
                map.put("tenant_id", "tr_test_t_0001");
                map.put("signature", buildSign(map, appid, secret, l + ""));

                System.out.println(map.toJSONString());
                System.out.println(OkhttpUtils.createBatch(map.toJSONString(), url + "/axyg/operate_group"));
            }).start();
        }


        return null;
    }

    public static HashMap<String, String> bindAxyg() {

        JSONObject map = new JSONObject();
        long l = System.currentTimeMillis() / 1000;
        map.put("app_id", appid);
        map.put("timestamp", l + "");
        /**
         * {
         * 	"expect_city": "0411",
         * 	"expiration": "2021-12-13 16:10:00",
         * 	"extra": "extra test",
         * 	"group_id": "G000001",
         * 	"is_encrypted": 0,
         * 	"is_transparent": 0,
         * 	"phone_a": "17733974933",
         * 	"phone_y": "18511589046",
         * 	"request_id": "request_id test",
         * }
         */
        map.put("expect_city", "");
        map.put("group_id", "666666");
//        map.put("expiration", "2022-08-15 14:49:31");
        map.put("extra", "");
        map.put("is_encrypted", 0);
        map.put("is_transparent", 0);
        map.put("phone_a", "18251931799");
        map.put("phone_y", "15518548757");
        map.put("request_id", "7065196168581484556");
        map.put("tenant_id", "03_sssssa");

        map.put("signature", buildSign(map, appid, secret, l + ""));

        System.out.println(OkhttpUtils.createBatch(map.toJSONString(), url + "/axyg/bind_axyg"));
        return null;
    }


    public static HashMap<String, String> setYEncStatus() {

        JSONObject map = new JSONObject();
        long l = System.currentTimeMillis() / 1000;
        map.put("app_id", appid);
        map.put("timestamp", l + "");
        map.put("phone_y", "18659614382");
        map.put("encrypt_status", 0);
        map.put("tenant_id", "T000001");

        map.put("signature", buildSign(map, appid, secret, l + ""));

        System.out.println(OkhttpUtils.createBatch(map.toJSONString(), url + "/axyg/set_y_enc_status"));
        return null;
    }

    public static HashMap<String, String> batchGetYEncStatus() {

        JSONObject map = new JSONObject();
        long l = System.currentTimeMillis() / 1000;
        map.put("app_id", appid);
        map.put("timestamp", l + "");
        JSONArray jsonArray1 = new JSONArray();
        jsonArray1.add("18511589046");
        jsonArray1.add("15534073148");
        map.put("phone_y_list", jsonArray1);

        map.put("signature", buildSign(map, appid, secret, l + ""));

        System.out.println(OkhttpUtils.createBatch(map.toJSONString(), url + "/axyg/batch_get_y_enc_status"));
        return null;
    }

    public static HashMap<String, String> unbindAxyg() {

        JSONObject map = new JSONObject();
        long l = System.currentTimeMillis() / 1000;
        map.put("app_id", appid);
        map.put("timestamp", l + "");
        /**
         * "group_id": "G000002",
         * 	"numbers": [
         * 		"17733974999",
         * 		"17733974998"
         * 	],
         * 	"operate_type": "0",
         * 	"is_encrypted": "0"
         */
        JSONArray jsonArray1 = new JSONArray();
        jsonArray1.add(1457207654744097L);
        jsonArray1.add(2691261478494600L);
        map.put("bind_ids", jsonArray1);
        map.put("signature", buildSign(map, appid, secret, l + ""));

        System.out.println(OkhttpUtils.createBatch(map.toJSONString(), url + "/axyg/unbind_axyg"));
        return null;
    }

    public static HashMap<String, String> setRingtone() {

        JSONObject map = new JSONObject();
        long l = System.currentTimeMillis() / 1000;
        map.put("app_id", appid);
        map.put("timestamp", l + "");
        /**
         * "group_id": "G000002",
         * 	"numbers": [
         * 		"17733974999",
         * 		"17733974998"
         * 	],
         * 	"operate_type": "0",
         * 	"is_encrypted": "0"
         */

        map.put("group_id", "G000001");
        map.put("ringtone_type", "DCD-Y1");
        map.put("file_name", "DCD-Y1-tmp.mp3");
        map.put("signature", buildSign(map, appid, secret, l + ""));

        System.out.println(OkhttpUtils.createBatch(map.toJSONString(), url + "/axyg/set_ringtone"));
        return null;
    }

    public static String buildSign(Map<String, Object> params, String appId, String secret, String timestamp) {
        StringBuilder stringBuilder = new StringBuilder();
        TreeMap<String, Object> treeMap = new TreeMap<>(params);
        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
            String key = entry.getKey();
            StringBuilder sb = new StringBuilder();
            Object v = entry.getValue();
            if ("app_id".equals(key) || "timestamp".equals(key) || !StringUtils.hasText(v.toString())) {
                continue;
            }
            String value;
            if (v instanceof JSONArray) {
                JSONArray array = (JSONArray) v;
                for (Object o : array) {
                    if (o instanceof JSONObject) {
                        JSONObject object = (JSONObject) o;
                        Map map = JSONObject.parseObject(object.toJSONString(), Map.class);
                        TreeMap<String, String> treeMap1 = new TreeMap<>(map);
                        for (Map.Entry<String, String> entry2 : treeMap1.entrySet()) {
                            if (!StringUtils.hasText(entry2.getValue())) {
                                continue;
                            }
                            sb.append(entry2.getKey()).append(entry2.getValue());
                        }
                    } else {
                        sb.append(o.toString());
                    }
                }
                value = sb.toString();
            } else {
                value = entry.getValue().toString();
            }


            stringBuilder.append(key).append(value.trim());
        }
        stringBuilder.append(appId).append(timestamp).append(secret);
        System.out.println(stringBuilder.toString());
        return encode(stringBuilder.toString()).toUpperCase();
    }

    public static String encode(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
