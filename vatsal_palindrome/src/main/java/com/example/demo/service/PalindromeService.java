/*
Abstraction layer for teh actual service class.
 */
package com.example.demo.service;

import com.example.demo.model.PalindromeMapping;

public interface PalindromeService {
    public void savePalindrome(String _s_);

    PalindromeMapping getPalindrome(String s_);
}
