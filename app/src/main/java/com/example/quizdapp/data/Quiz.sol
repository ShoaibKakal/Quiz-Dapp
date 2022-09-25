// SPDX-License-Identifier: MIT
pragma solidity ^0.8.16;


contract Quiz{

struct Question{
    string statement;
    bool isTrue;
}

    Question[] questions;

    constructor() payable{
        addQuestions();
    }


    function addQuestions()public payable{
        questions.push(Question("Gen. Bajwa is the CEO of Pakistan?", true));
        questions.push(Question("Firebase was acquired by google in 2013",false));
        questions.push(Question("Bitcoin is an application of Blockchain", true));
        questions.push(Question("Smart contract removes intermediaries", true));
    }

    function getQuestions()public view returns(Question[] memory){
        return questions;
    }
}