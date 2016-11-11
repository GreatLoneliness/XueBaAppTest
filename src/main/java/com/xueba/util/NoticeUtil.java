package com.xueba.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.appium.java_client.AppiumDriver;

public class NoticeUtil {
	private static String TOKEN = "37f8b9b007294687ae93c2615706fdb1";
	private static String URL_SENDMESSAGE = "http://www.cnxfu.com/zhijin/admin-api/message";
	private static int USERID = 613;
	private static int index = 0;
	private static List idList = new ArrayList<Integer>();

	/**
	 * 发送会议通知接口
	 * 
	 * @return 返回是否发送成功
	 */
	public static boolean sendMeetingNotice() {
		String meetNotice = getMeetingNotice(getMessageId(), USERID);
		String response = postNotice(URL_SENDMESSAGE, meetNotice);
		try {
			JSONObject responseCode = new JSONObject(response);
			JSONArray array = responseCode.getJSONArray("success");
			if (array != null) {
				return true;
			} else {
				return false;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return false;
		}
	}

	// post方法实现：
	// 将请求的参数内容放在一个Map中，在发送之前需要解析它（在这用的是下面的getContent（）方法）
	private static String postNotice(String apiUrl, String messageJson) {
		String str = null;
		URL url;
		HttpURLConnection con;
		try {
			url = new URL(apiUrl);
			System.out.println(url);
			// 根据参数创建URL对象
			con = (HttpURLConnection) url.openConnection();//
			// 得到HttpURLConnection对象
			con.setRequestMethod("POST");
			con.setReadTimeout(5000);
			con.setDoInput(true);
			con.setDoOutput(true);// 指示应用程序要将数据写入 URL 连接。
			con.setRequestProperty("Content-Type", "application/json");// 设置内容
			OutputStream os = con.getOutputStream();
			os.write(messageJson.getBytes("utf-8"));// 发送参数内容
			os.flush();
			os.close();
			if (con.getResponseCode() == 200) {
				str = formatIsToString(con.getInputStream());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 生成不重复的messageID，区间为20000-30000
	 * 
	 * @return messageID
	 */
	public static int getMessageId() {
		int min = 20000;
		int count = 10000; // 记录数字存储到那个位置的下标
		boolean flag = true; // 总循环标记
		while (flag) {
			int number = new Random().nextInt(10000) + min; // 这是产生20000-30000的随机数
			// 判断这个数是否在数组中
			if (idList.indexOf(number) > -1) {
				continue;
			} else {
				if (idList.size() > count) {
					flag = false;
				} else {
					idList.add(number);
					return number;
				}
			}
		}
		return 0;

	}

	private static String formatIsToString(InputStream is) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int len = -1;
		try {
			while ((len = is.read(buf)) != -1) {
				baos.write(buf, 0, len);
			}
			baos.flush();
			baos.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(baos.toByteArray(), "utf-8");
	}

	/**
	 * 获取会议通知
	 * 
	 * @param messageId
	 *            生成的通知id
	 * @param toUserID
	 *            发送给谁userid
	 * @return 服务器返回的发送结果
	 */
	private static String getMeetingNotice(int messageId, int toUserID) {
		String meetNotice = "{\n" + "  \"sourceMsgId\":\"" + messageId + "\",\n" + "  \"fromId\":\"" + toUserID
				+ "\",\n" + "  \"toIds\":[\"" + toUserID + "\"" + "  ],\n" + "  \"title\": \"会议通知\",\n"
				+ "  \"summary\": \"毕业论文说明会将在地质大学举行，请准时参加\\r\\n地质大学论文说明会\\r\\n10月31日（本周六）上午1:30\\r\\n朝阳门学习中心\\r\\n毕业论文说明会，讲解高校政策\",\n"
				+ "  \"type\":0,\n" + "  \"userDynamic\": {\n" + "    \"userName\": \"[姓名]\",\n"
				+ "    \"identityCard\": \"[身份证号]\",\n" + "    \"studentNum\": \"[学号]\",\n"
				+ "    \"enrollBatch\": \"[入学批次]\",\n" + "    \"studyCenterName\":\"[授权学习中心]\",\n"
				+ "    \"enrollSchool\":\"[学校]\",\n" + "    \"major\": \"[专业]\",\n"
				+ "    \"enrollArrangement\": \"[层次]\"\n" + "  },\n" + "  \"content\":{\n" + "    \"sourceMsgId\" : \""
				+ messageId + "\",\n" + "    \"name\" : \"毕业论文说明会-地质大学\",\n"
				+ "    \"templateId\": \"template_meeting\",\n" + "    \"version\" : 1,\n"
				+ "    \"wechatTemplateType\" :2,\n" + "    \"type\":0,\n" + "    \"sendDate\": \"\",\n"
				+ "    \"title\": \"会议通知\",\n" + "    \"summary\": \"summary\",\n"
				+ "    \"body\": \"[姓名]，你好:  我是知金教育付老师。请于10月31日（本周六）上午1:30，准时到朝阳门学习中心参加地质大学毕业论文说明会。要讲解高校政策。 \\n\\n * 地址：朝阳门华普大厦525室。 \\n\\n * 乘车路线：地铁2号线朝阳门站A口出，直走50米，马路左侧。 若不能按时参加，请及时与我联系。谢谢!\\n\\n 如有疑问，请联系我的手机号13321312312 \\n\\n发送日期[SEND_DATE]\",\n"
				+ "    \"ossBucket\": \"zhijin\",\n" + "    \"attachments\":[\n" + "    ],\n" + "    \"feedbacks\": [\n"
				+ "      {\n" + "        \"id\": \"meeting_yes\",\n" + "        \"type\": \"button\",\n"
				+ "        \"value\": \"确认参会\",\n" + "        \"submitValue\": \"确认参会\",\n"
				+ "        \"submitVisible\": true,\n" + "        \"visibleMode\": 0,\n"
				+ "        \"submitHideLogic\":1,\n" + "        \"submitDisabled\": true\n" + "      },\n" + "      {\n"
				+ "        \"id\": \"meeting_no\",\n" + "        \"type\": \"button\",\n"
				+ "        \"value\": \"确认不参会\",\n" + "        \"submitValue\": \"确认不参会\",\n"
				+ "        \"submitVisible\": true,\n" + "        \"visibleMode\": 0,\n"
				+ "        \"submitHideLogic\":1,\n" + "        \"submitDisabled\": true\n" + "      }\n" + "    ]\n"
				+ "  },\n" + "  \"dueDate\": 1479974359333,\n" + "  \"loopPush\" :0\n" + "}";
		return meetNotice;
	}

}