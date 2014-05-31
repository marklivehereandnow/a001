/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.card;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mark
 */
public class AgesCardArrayList extends ArrayList<AgesCard> {

    private String title = "---";

    public AgesCardArrayList() {
        title = "---";
    }

    public AgesCardArrayList(String str) {
        title = str;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // @Override
    public String toString(int k) {
        return title + " " + toString();
    }

    /**
     * 生產
     */
    public void produce() {
        for (int k = 0; k < size(); k++) {
//            get(k).produce();
        }
    }

    public AgesCard getCardByName(String str) {
        //   List<Card> list=new ArrayList<>();
        for (int k = 0; k < size(); k++) {
            if (get(k).getName().equals(str)) {
                return get(k);
            }
        }
        return null;
//        Card NOCARD = new Card();
//        NOCARD.setId(1000);
//        NOCARD.setName("NOCARD");
//        return NOCARD;
    }

    public AgesCard getCardById(int id) {
        //   List<Card> list=new ArrayList<>();
        for (int k = 0; k < size(); k++) {
            if (get(k).getId() == id) {
                return get(k);
            }
        }
        return null;
    }

    public AgesCardArrayList getList(int age, String cm) {
        int cnt=0;
        int cnt2=0;
        AgesCardArrayList list = new AgesCardArrayList();
        for (int k = 0; k < size(); k++) {
//            if ((age == 0) && (cm.equals("軍事"))) {
//                System.out.println(" k " + k + "  id " + get(k).getId() + " age=" + get(k).getAge() + " cm=" + get(k).getCivilMilitary());
//                cnt++;
//                System.out.println("0 軍事 "+cnt);
//            }
            if ((get(k).getAge() == age) && (get(k).getCivilMilitary().equals(cm))) {
                cnt2++;
                System.out.println("###0 軍事 "+cnt2);
                AgesCard a=remove(k);
                list.add(a);
            }
        }
        return list;
    }

    public void show(int style) {
        String[] ageStr = {"A", "I", "II", "III"};
        switch (style) {
            case 1:// for CardRow
                System.out.print("" + title + " (" + size() + ") ");
                for (int m = 0; m < size(); m++) {
                    System.out.print(m + get(m).toString(style) + " ");
                }
                break;

            case 2:// for 實驗室
            case 3:// for 政府區
                System.out.print("" + title + " ");
                for (int m = 0; m < size(); m++) {
                    System.out.print(get(m).toString(style) + " ");
                }
                break;

            default:
                for (int m = 0; m < size(); m++) {
                    System.out.print(get(m).toString());
                }

        }
        System.out.println("");

    }
}
