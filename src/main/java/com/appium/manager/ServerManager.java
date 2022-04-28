/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Appium Mobile Automation - Android & iOS + Frameworks + CICD (https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package com.appium.manager;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.util.HashMap;

import com.appium.utils.TestUtils;
import com.appium.utils.UsernameUtils;

/**
 * We are creating different server instances for all devices
 * <p>
 * We are not using the Server URL from config.properties file
 */
public class ServerManager {

    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();

    TestUtils utils = new TestUtils();

    public AppiumDriverLocalService getServer() {
        return server.get();
    }

    public void startServer() {
        utils.log().info("starting appium server");

        /* Windows */
        // AppiumDriverLocalService server = getAppiumServiceForWindows();

        /* MAC */
        AppiumDriverLocalService server = getAppiumServiceForMac();
        server.start();

        if (server == null || !server.isRunning()) {
            utils.log().fatal("Appium server not started. ABORT!!!");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
        /* This will not print the Appium server Logs in IDE console */
        server.clearOutPutStreams();
        this.server.set(server);
        utils.log().info("Appium server started");
    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }

    public AppiumDriverLocalService getAppiumServiceForWindows() {

        // GlobalParams params = new GlobalParams();
//		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
//				.withAppiumJS(new File("C:\\Users\\rajatverma01\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).usingPort(4723)
//				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//				//.withLogFile(new File("ServerLogs/server.log")));
//				.withLogFile(new File(params.getPlatformName() + "_" + params.getDeviceName() + File.separator + "Server.log")));

        GlobalParams params = new GlobalParams();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE).withLogFile(new File(
                        params.getPlatformName() + "_" + params.getDeviceName() + File.separator + "Server.log")));
    }

    public AppiumDriverLocalService getAppiumServiceForMac() {
        GlobalParams params = new GlobalParams();
        HashMap<String, String> environment = new HashMap<String, String>();
        environment.put("PATH",
                "/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin:/Users"
						+ UsernameUtils.getUserName() + "/Library/Android/sdk/tools:/Users/"
						+ UsernameUtils.getUserName() + "/Library/Android/sdk/platform-tools:/opt/homebrew/bin:/opt/homebrew/sbin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin"
                        + System.getenv("PATH"));
        environment.put("ANDROID_HOME", "/Users/" + UsernameUtils.getUserName() + "/Library/Android/sdk");
        // environment.put("JAVA_HOME",
        // "/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home");
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js")).usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE).withEnvironment(environment).withLogFile(new File(
                        params.getPlatformName() + "_" + params.getDeviceName() + File.separator + "Server.log")));

    }
}
