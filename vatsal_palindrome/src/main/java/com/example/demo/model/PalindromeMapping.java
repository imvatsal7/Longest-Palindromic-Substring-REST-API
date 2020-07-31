/*
Model -> Palindrome mapping consisting of a string => input and a string => palindrome
that is computed inside the service class.
 */
package com.example.demo.model;

import org.springframework.data.annotation.Id;

public class PalindromeMapping{

    @Id
    private String input;

    private String palindrome;

    public PalindromeMapping(String input, String palindrome){
        this.input = input;
        this.palindrome = palindrome;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getPalindrome() {
        return palindrome;
    }

    public void setPalindrome(String palindrome) {
        this.palindrome = palindrome;
    }
}
