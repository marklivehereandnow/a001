/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.field;

import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author mark
 */
public class TokenTest1 {

    public static void main(String[] args) {
        final int 人力庫_黃 = 1;
        final int 工人區_黃 = 2;
        final int 資源庫_藍 = 3;

        Token yellowToken = new Token();
        Token blueToken = new Token();
        yellowToken.getMap().put(1010, 1);
        yellowToken.getMap().put(1007, 2);
        yellowToken.getMap().put(1032, 2);
        yellowToken.getMap().put(1018, 1);
        yellowToken.getMap().put(2, 1);
        yellowToken.getMap().put(1, 18);

        blueToken.getMap().put(3, 18);

        System.out.println("Yellow " + yellowToken.getMap().toString());
        System.out.println("Blue" + blueToken.getMap().toString());
        yellowToken.moveTokensFromAtoB(1,人力庫_黃, 工人區_黃);
        System.out.println("Yellow " + yellowToken.getMap().toString());
        System.out.println("Blue" + blueToken.getMap().toString());

        Iterator iterator = yellowToken.getMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Integer, Integer> entry = (Entry<Integer, Integer>) iterator.next();
            if (entry.getKey() > 1000) {
                System.out.println(" K:" + entry.getKey() + " V:" + entry.getValue());
                blueToken.moveTokensFromAtoB(entry.getValue(),資源庫_藍, entry.getKey());
            }
        }

        System.out.println("Yellow " + yellowToken.getMap().toString());
        System.out.println("Blue" + blueToken.getMap().toString());

    }
}
