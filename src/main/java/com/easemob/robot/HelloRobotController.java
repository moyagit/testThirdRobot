package com.easemob.robot;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
public class HelloRobotController {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public RobotResponse helloHtml(@RequestBody RobotQuestion robotQuestion) {
       log.info("robot question {}", robotQuestion);
        atomicInteger.incrementAndGet();
        if(atomicInteger.get()%4==1){
            log.info("go into robot best answer");
            // 最佳答案
            RobotResponse robotResponse = new RobotResponse();
            robotResponse.setResultType(ThirdResultType.BEST_MATCH);
            robotResponse.setQuestion(robotQuestion.getQuestion());
            robotResponse.setAnswer("最佳答案");
            robotResponse.setQuestionType(1);
            robotResponse.setRobotTransferKf("Robot");
            return robotResponse;
        }else if(atomicInteger.get()%4==2){
            log.info("go into best answer transfer kefu");
            // 转人工答案 环信默认技能组
            RobotResponse robotResponse = new RobotResponse();
            robotResponse.setResultType(ThirdResultType.BEST_MATCH);
            robotResponse.setQuestion(robotQuestion.getQuestion());
            robotResponse.setAnswer("");
            robotResponse.setQuestionType(1);
            robotResponse.setRobotTransferKf("TransferToKf");
            return robotResponse;
        }else if(atomicInteger.get()%4==3){
            log.info("go into best answer transfer kefu with special group");
            // 转人工答案 转到特定的技能组 集成环信客服
            Gson gson = new Gson();
            RobotResponse robotResponse = new RobotResponse();
            robotResponse.setResultType(ThirdResultType.BEST_MATCH);
            robotResponse.setQuestion(robotQuestion.getQuestion());
            Map<String,String> answers = new HashMap<>();
            answers.put("transferKFKey", "");
            answers.put("transferKFValue", "123123");
            robotResponse.setAnswer(gson.toJson(answers));
            robotResponse.setQuestionType(1);
            robotResponse.setRobotTransferKf("TransferToKf");
            return robotResponse;
        }
        log.info("go into recommend answer");
        RobotResponse robotResponse = new RobotResponse();
        robotResponse.setResultType(ThirdResultType.MULTI_ANSWERS);
        robotResponse.setQuestion(robotQuestion.getQuestion());
        List<String>  list = new ArrayList<>();
        list.add("菜单1");
        list.add("菜单2");
        robotResponse.setSimilarQuestions(list);
        robotResponse.setQuestionType(1);
        robotResponse.setRobotTransferKf("Robot");
        return robotResponse;
    }
}
