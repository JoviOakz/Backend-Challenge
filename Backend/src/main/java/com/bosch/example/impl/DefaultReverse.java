package com.bosch.example.impl;

import com.bosch.example.services.ReverseService;

public class DefaultReverse implements ReverseService {
    @Override
    public String reverse(String word) {
        if (word == null)
			return word;

		String reverseWord = "";

		for (int i = word.length() - 1; i >= 0; i--) {
			reverseWord = reverseWord + word.charAt(i);
		}

		return reverseWord;
    }

    @Override
    public Boolean palindrome(String word, String reverseWord) {
        if (word.equals(reverseWord)) {
            return true;
        } else {
            return false;
        }
    }
}