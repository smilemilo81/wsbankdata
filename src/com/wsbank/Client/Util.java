package com.wsbank.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.wsbank.Client.Bean.*;
import com.uxun.commauth.JfyMallAuth;

public class Util {
	private static Logger log = Logger.getLogger(Util.class);

	/**
	 * ǩ������
	 * 
	 * @param resString
	 *            ��Ҫ���ܵ��ַ���
	 * @param serverPrivateKeyFile
	 *            �����ļ�
	 * @param serverEncodeKey
	 *            ����key
	 * @return
	 */
	public static String signEncode(String resString,
			String serverPrivateKeyFile, String serverEncodeKey) {
		String signData = "";
		try {
			signData = JfyMallAuth.genDataSignNoNeedInit(resString,
					serverPrivateKeyFile, serverEncodeKey);
		} catch (Exception e) {
			log.error("ǩ��ʱ�������󣡣���" + e.toString(), e);
		}
		return signData;
	}

	/**
	 * ǩ������
	 * 
	 * @param signData
	 *            //ǩ��
	 * @param resString
	 *            //��������
	 * @param clientpublicKeyFile
	 *            �����ļ�
	 * @return false ǩ������ true ǩ����ȷ
	 */
	public static boolean signDecode(String signData, String resString,
			String clientpublicKeyFile) {
		log.debug(clientpublicKeyFile);
		boolean signState = false;
		// ȷ������ĺϷ��ԣ��������£�
		// 1�������̻���ţ���ø��̻����õ� ��Կ�ļ�
		// 2������˫��Լ������֯ǩ�����ݵĹ��򣬻��ǩ�������ݣ�������rsp.toString()
		// 3���ù�Կ�ļ��Ĺ�Կ��ǩ�����ݽ�����ǩ����֤ͨ����OK

		// ��֤����ǩ�� �÷��������¼������� �� ǩ��������(2����),ǩ��(signData), �̻���Կ·�� ���̻����
		// (��Կ�ļ���������Ϊ�̻����.dat)
		// �̻���Կ·�����̻�ƽ̨���Ǹ��̶��ġ��ڻ�����Ӧ�����أ�Ӧ�ø�·���ڻ���·���ϼ����̻����ڵĻ�����ţ�ʵ��·��Ӧ����
		// f:/0001/uxun.dat�ĸ�ʽ
		// ����ָ���Ĺ�Կ�ļ������ǩ�������Ƿ���ȷ������Ԥ�ȳ�ʼ��
		try {
			signState = JfyMallAuth.verifyNoNeedInit(resString, signData,
					clientpublicKeyFile);
		} catch (Exception e) {
			log.error("ǩ����֤���󣡣���");
		}
		return signState;
	}

	public ConfigBean LoadConfig() {
		String configPath = "";
		try {
			configPath = java.net.URLDecoder.decode(this.getClass()
					.getClassLoader().getResource("").getPath(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("beanConfig.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ConfigBean ret = new ConfigBean();
		ret.setAesIv(p.getProperty("aesIv"));
		ret.setAesKey(p.getProperty("aesKey"));
		ret.setNamespace(p.getProperty("namespace"));
		ret.setPath(p.getProperty("path"));
		ret.setSource(p.getProperty("source"));

		ret.setClientPrivateKeyFile(configPath
				+ p.getProperty("clientPrivateKeyFile"));
		ret.setServerPublicKeyFile(configPath
				+ p.getProperty("serverPublicKeyFile"));
		ret.setEncodKey(p.getProperty("encodeKey"));

		return ret;
	}

}
