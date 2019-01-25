package com.easemob.robot;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


public enum ThirdResultType {
	
    BEST_MATCH(1),	//最佳答案
    MULTI_ANSWERS(2), //相似的答案
    DEFAULT(3);   // 默认答案
    
    private int type;
    
    private ThirdResultType(int type) {
        this.type = type;
    }
    
    @JsonValue
    public int getType() {
        return type;
    }
    
    @JsonCreator
    public static ThirdResultType getFromType(int type) {
        if(1 == type){
            return BEST_MATCH;
        }else if(2 == type){
            return MULTI_ANSWERS;
        }else if(3 == type){
            return DEFAULT;
        }
        return DEFAULT; 
    }
}
