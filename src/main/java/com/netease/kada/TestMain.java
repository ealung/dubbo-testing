package com.netease.kada;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;

/**
 * Created by zhangchanglu on 2017/12/4
 * email hzzhangchanglu@corp.netease.com
 *
 * @author zhangchanglu
 */
public class TestMain {
    public static void main(String[] args) {
        JavaSamplerContext javaSamplerContext = new JavaSamplerContext(new Arguments());
        ProjectInfoTest projectInfoTest = new ProjectInfoTest();
        projectInfoTest.setupTest(javaSamplerContext);
        projectInfoTest.runTest(javaSamplerContext);
    }
}
