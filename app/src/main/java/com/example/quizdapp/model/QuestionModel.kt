package com.example.quizdapp.model

data class QuestionModel(val statement:String, val options:ArrayList<String>, val correctIndex:Int)

/***
    class Question extends DynamicStruct {
    String statement;
    List<Utf8String> options;
    BigInteger correctIndex;
    public Question(Utf8String statement, DynamicArray<Utf8String> options, Uint correctIndex) {
    this.statement = statement.getValue();
    this.options = options.getValue();
    this.correctIndex = correctIndex.getValue();
    }
    }
 */