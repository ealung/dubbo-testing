package com.netease.kada;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.netease.kada.itemcenter.bo.project.ProjectSimpleBO;
import com.netease.kada.itemcenter.compose.project.ProjectSimpleCompose;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by zhangchanglu on 2017/11/10
 * email hzzhangchanglu@corp.netease.com
 *
 * @author zhangchanglu
 */
public class ProjectInfoTest extends AbstractJavaSamplerClient {
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult sr = new SampleResult();
        sr.sampleStart();
        String profile=javaSamplerContext.getParameter("spring.profiles.active");
        System.getProperties().setProperty("spring.profiles.active",null==profile?"test":profile);
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:application.xml"});
        ProjectSimpleCompose projectSimpleCompose = classPathXmlApplicationContext.getBean("projectSimpleCompose", ProjectSimpleCompose.class);
        List<ProjectSimpleBO> list= projectSimpleCompose.findProjectByIds(Lists.newArrayList(107004L, 72020L, 72027L, 74001L, 103002L, 107004L, 119001L, 103002L));
        sr.setSuccessful(list.size()>0);
        sr.setResponseData(JSON.toJSONString(list),"utf-8");
        sr.sampleEnd();
        return sr;
    }

    @Override
    public Arguments getDefaultParameters() {
        Arguments params = new Arguments();
        params.addArgument("spring.profiles.active","test");
        return params;
    }
}
