package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.PalindromeMapping;
import com.example.demo.service.PalindromeService;
import com.example.demo.vo.GenericRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {

    @Autowired
    private PalindromeService palindromeService;

    // I use put mapping because PUT is idempotent. POST is not.
    @PutMapping(value = "/savePalindrome")
    public GenericRestResponse savePalindrome(@RequestParam String _s_){

        // validating to see if user gave correct input for the string
        validateIncomingString(_s_);

        try{
            palindromeService.savePalindrome(_s_);
            return new GenericRestResponse("Success","Palindrome saved successfully");
        }catch (Exception e) {
            System.out.println("Exception occurred while saving palindrome for string -> " + _s_ + " with error " + e);
        }

        return new GenericRestResponse("400","Some exception occurred, please contact the administrator");
    }

    @GetMapping(value = "/getPalindrome")
    public PalindromeMapping getPalindrome(@RequestParam String _s_){
        try{
            return palindromeService.getPalindrome(_s_);
        }catch (Exception e){
            System.out.println("Exception occurred while getting palindrome for string -> " +_s_ + " with error " + e);
        }
        return null;
    }

    private void validateIncomingString(String _s_) throws BadRequestException {
       if(_s_.length() == 0
               || _s_.length() > 1000
               || !_s_.matches("[a-zA-Z]+")) {
            throw new BadRequestException("Please enter a valid string!");
        }
    }
}
