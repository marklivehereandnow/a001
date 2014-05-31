/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livehereandnow.ages.field;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mark
 */
public class Score {
        private Map<String,Integer> map;

    public Map<String, Integer> getMap() {
        return map;
    }

    public Score() {
        map=new HashMap<>();
    }
    
}
