package com.wsbank.Client.Bean;

public class ConfigBean {
	
	String source;
	String aesIv;
	String aesKey;
	String namespace;
	String path;
	String clientPrivateKeyFile;
	String serverPublicKeyFile;
	String encodKey;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAesIv() {
		return aesIv;
	}
	public void setAesIv(String aesIv) {
		this.aesIv = aesIv;
	}
	public String getAesKey() {
		return aesKey;
	}
	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getClientPrivateKeyFile() {
		return clientPrivateKeyFile;
	}
	public void setClientPrivateKeyFile(String clientPrivateKeyFile) {
		this.clientPrivateKeyFile = clientPrivateKeyFile;
	}
	public String getServerPublicKeyFile() {
		return serverPublicKeyFile;
	}
	public void setServerPublicKeyFile(String serverPublicKeyFile) {
		this.serverPublicKeyFile = serverPublicKeyFile;
	}
	public String getEncodKey() {
		return encodKey;
	}
	public void setEncodKey(String encodKey) {
		this.encodKey = encodKey;
	}

}
