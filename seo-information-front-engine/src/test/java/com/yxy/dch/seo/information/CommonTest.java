package com.yxy.dch.seo.information;

import com.yxy.dch.seo.information.config.pros.FrontEngineProperties;
import com.yxy.dch.seo.information.vo.ColumnVO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTest {
    @Autowired
    private Configuration configuration;
    @Autowired
    private FrontEngineProperties frontEngineProperties;

    @Test
    public void test() throws IOException, TemplateException {
        Template template = configuration.getTemplate("channel.ftl");
        File file = new File(frontEngineProperties.getHtmlPath() + "/" + "test.html");
        Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        List<ColumnVO> columnList = new ArrayList<>();
        ColumnVO columnVO = new ColumnVO();
        columnVO.setName("栏目1");
        columnVO.setNamePinyin("lanmu1");
        columnList.add(columnVO);
        Map<String, List<ColumnVO>> model = new HashMap<>();
        model.put("columnList", columnList);
        template.process(model, writer);
    }
}
