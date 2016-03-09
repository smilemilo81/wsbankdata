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
	 * 签名加密
	 * 
	 * @param resString
	 *            需要加密的字符串
	 * @param serverPrivateKeyFile
	 *            加密文件
	 * @param serverEncodeKey
	 *            加密key
	 * @return
	 */
	public static String signEncode(String resString,
			String serverPrivateKeyFile, String serverEncodeKey) {
		String signData = "";
		try {
			signData = JfyMallAuth.genDataSignNoNeedInit(resString,
					serverPrivateKeyFile, serverEncodeKey);
		} catch (Exception e) {
			log.error("签名时候发生错误！！！" + e.toString(), e);
		}
		return signData;
	}

	/**
	 * 签名验密
	 * 
	 * @param signData
	 *            //签名
	 * @param resString
	 *            //解密数据
	 * @param clientpublicKeyFile
	 *            解密文件
	 * @return false 签名有误 true 签名正确
	 */
	public static boolean signDecode(String signData, String resString,
			String clientpublicKeyFile) {
		log.debug(clientpublicKeyFile);
		boolean signState = false;
		// 确认请求的合法性，流程如下：
		// 1、根据商户编号，获得该商户配置的 公钥文件
		// 2、根据双方约定的组织签名数据的规则，获得签名的数据，比如是rsp.toString()
		// 3、用公钥文件的公钥对签名数据进行验签，验证通过就OK

		// 验证数字签名 该方法有以下几个参数 ， 签名的数据(2做的),签名(signData), 商户公钥路径 ，商户编号
		// (公钥文件命名规则为商户编号.dat)
		// 商户公钥路径在商户平台，是个固定的。在积分易应用网关，应该改路径在基本路径上加上商户对于的机构编号，实际路径应该是
		// f:/0001/uxun.dat的格式
		// 根据指定的公钥文件，检查签名数据是否正确，无需预先初始化
		try {
			signState = JfyMallAuth.verifyNoNeedInit(resString, signData,
					clientpublicKeyFile);
		} catch (Exception e) {
			log.error("签名认证错误！！！");
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
