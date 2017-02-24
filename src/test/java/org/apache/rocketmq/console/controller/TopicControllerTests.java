/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.console.controller;

import org.apache.rocketmq.console.App;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by songyongzhong on 2017/2/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration // 使用@WebIntegrationTest注解需要将@WebAppConfiguration注释掉
@WebIntegrationTest("server.port:8080")
public class TopicControllerTests {

    private TestRestTemplate template = new TestRestTemplate();
    @Value("${server.port}")// 注入端口号
    private int port;


    @Test
    public void testListQuery() throws Exception {
        String url = "http://localhost:"+port+"/topic/list.query";
        String result = template.getForObject(url, String.class);
        System.out.println(result);
        assertNotNull(result);
        assertThat(result, Matchers.containsString("status"));

    }


    @Test
    public void testStats() throws Exception {
        String url = "http://localhost:"+port+"/topic/stats.query";
        String result = template.getForObject(url, String.class);
        System.out.println(result);
        assertNotNull(result);
        assertThat(result, Matchers.containsString("status"));

    }
}
