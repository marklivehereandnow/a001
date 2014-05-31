package com.livehereandnow.ages.field;

/**
 *
 * @author mark
 */
public class Points {

    private String title = "---";

    public Points() {
    }

    public Points(String str) {
        title = str;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    private int points;

    public int getVal() {
        return points;
    }

    public void setVal(int points) {
        this.points = points;

    }

    public void addPoints(int k) {
        this.points += k;
    }

    @Override
    public String toString() {
        return "" + points;
    }
/**
 * max 2014-5-23 加上適當的全型空白
 * @param name
 * @return 
 */
    private String getSameSize(String name) {
        int times = 8 - name.length();
        String cnSpace = "\u3000";
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < times; k++) {
            sb.append("\u3000");
        }
        return  sb.toString()+name ;
//        return  name ;
    }

    public void show() {
//        System.out.print(title+" "+  toString()+"  ");
        System.out.printf("%s %3d ",getSameSize(title) , points);
    }
}
