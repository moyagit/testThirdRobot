package com.easemob.robot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RobotResponse {
    @JsonProperty("result_type")
    ThirdResultType resultType;
    String question;
    String answer;
    @JsonProperty("question_type")
    int questionType;
    @JsonProperty("robot_transferKf")
    String robotTransferKf;
    @JsonProperty("similar_questions")
    List<String> similarQuestions;
}
