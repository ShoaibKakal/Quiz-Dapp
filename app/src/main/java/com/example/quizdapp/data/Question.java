package com.example.quizdapp.data;

import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Utf8String;

public class Question extends DynamicStruct {

    private String question;
    private Boolean isTrue;

    public Question(String question, Boolean isTrue) {
        super(new Utf8String(question), new Bool(isTrue));
        this.question = question;
        this.isTrue = isTrue;
    }

    public Question(Utf8String question, Bool isTrue) {
        super(question, isTrue);
        this.question = question.getValue();
        this.isTrue = isTrue.getValue();
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getTrue() {
        return isTrue;
    }

    public void setTrue(Boolean aTrue) {
        isTrue = aTrue;
    }
}
