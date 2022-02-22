package com.appium.manager;

/*This classe has method -> used for collecitng the Device capabilities using maven*/
public class GlobalParams {

	/* Common Capabilities for Android and iOS */
	private static ThreadLocal<String> platformName = new ThreadLocal<String>();
	private static ThreadLocal<String> udid = new ThreadLocal<String>();
	private static ThreadLocal<String> deviceName = new ThreadLocal<String>();

	/* Android specific */
	private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
	private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();

	/* iOS specific */
	private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<String>();
	private static ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<String>();

	public void setPlatformName(String platformName1) {
		platformName.set(platformName1);
	}

	public String getPlatformName() {
		return platformName.get();
	}

	public String getUDID() {
		return udid.get();
	}

	public void setUDID(String udid2) {
		udid.set(udid2);
	}

	public String getDeviceName() {
		return deviceName.get();
	}

	public void setDeviceName(String deviceName2) {
		deviceName.set(deviceName2);
	}

	public String getSystemPort() {
		return systemPort.get();
	}

	public void setSystemPort(String systemPort2) {
		systemPort.set(systemPort2);
	}

	public String getChromeDriverPort() {
		return chromeDriverPort.get();
	}

	public void setChromeDriverPort(String chromeDriverPort2) {
		chromeDriverPort.set(chromeDriverPort2);
	}

	public String getWdaLocalPort() {
		return wdaLocalPort.get();
	}

	public void setWdaLocalPort(String wdaLocalPort2) {
		wdaLocalPort.set(wdaLocalPort2);
	}

	public String getWebkitDebugProxyPort() {
		return webkitDebugProxyPort.get();
	}

	public void setWebkitDebugProxyPort(String webkitDebugProxyPort2) {
		webkitDebugProxyPort.set(webkitDebugProxyPort2);
	}

	public void initializeGlobalParams() {
		GlobalParams params = new GlobalParams();

		/*
		 * System.getProperty("platformName", "iOS") Setting default value for
		 * platformName as Android
		 * 
		 * This is done for running the test execution from Runner class instead of
		 * Maven command.
		 */
		
		/**
		iPhone 12 -> 7021E632-B569-4371-A010-97EDA4564DAD
		iPhone 13 -> 18FB4726-3A15-498D-8F7E-84965AB706EF
		iPhone XR -> 87BFA7A3-111F-4822-9632-5A4AA74EDC01
		*/
		
		params.setPlatformName(System.getProperty("platformName", "iOS"));
		params.setUDID(System.getProperty("udid", "18FB4726-3A15-498D-8F7E-84965AB706EF"));
		params.setDeviceName(System.getProperty("deviceName", "iPhone_13"));
		switch (params.getPlatformName()) {
		case "Android":
			params.setSystemPort(System.getProperty("systemPort", "10000"));
			params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
			break;
		case "iOS":
			params.setWdaLocalPort(System.getProperty("wdaLocalPort", "10001"));
			params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "11001"));
			break;
		default:
			throw new IllegalStateException("Invalid Platform Name!");
		}
	}

	
	public void initializeGlobalParamsOriginal() {
		GlobalParams params = new GlobalParams();

		/*
		 * System.getProperty("platformName", "Android") Setting default value for
		 * platformName as Android
		 * 
		 * This is done for running the test execution from Runner class instead of
		 * Maven command.
		 */
		params.setPlatformName(System.getProperty("platformName", "Android"));
		params.setUDID(System.getProperty("udid", "emulator-5554"));
		// params.setDeviceName(System.getProperty("deviceName", "OnePlus"));
		params.setDeviceName(System.getProperty("deviceName", "Pixel_3"));
		switch (params.getPlatformName()) {
		case "Android":
			params.setSystemPort(System.getProperty("systemPort", "10000"));
			params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
			break;
		case "iOS":
			params.setWdaLocalPort(System.getProperty("wdaLocalPort", "10001"));
			params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "11001"));
			break;
		default:
			throw new IllegalStateException("Invalid Platform Name!");
		}
	}
}
