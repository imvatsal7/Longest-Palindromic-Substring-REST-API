/*
Business layer used to calculate the longest palindromic substring for a given string,
also returns palindrome for a user-inputted string
 */
package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.PalindromeRepo;
import com.example.demo.model.PalindromeMapping;
import com.example.demo.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    @Autowired
    private PalindromeRepo palindromeRepo;

    @Override
    public void savePalindrome(String _s_) {
        String palindrome=calculatePalindrome(_s_);
        PalindromeMapping palindromeMapping = new PalindromeMapping(_s_, palindrome);
        palindromeRepo.save(palindromeMapping);
    }

    @Override
    public PalindromeMapping getPalindrome(String _s_) {
        Optional<PalindromeMapping> mappingOptional = palindromeRepo.findById(_s_);
        if (!mappingOptional.isPresent()) {
            throw new ResourceNotFoundException("No such string!");
        }
        return mappingOptional.get();
    }

    private String calculatePalindrome(String _s_) {

        if(_s_.isEmpty()) {
            return "";
        }
        int n = _s_.length();
        int maxLength = 0, leftIndex = 0, rightIndex = 0;
        boolean[][] isPalindrome = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
            for(int j = 0; j < i; j++) {
                if(_s_.charAt(i) == _s_.charAt(j) && (i - j <= 2 || isPalindrome[j+1][i-1])) {
                    isPalindrome[j][i] = true;
                    if(i - j + 1 > maxLength) {
                        maxLength = i - j + 1;
                        leftIndex = j;
                        rightIndex = i;
                    }
                }
            }
        }
        return _s_.substring(leftIndex, rightIndex + 1);
    }
}
