package ohouse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Item implements Comparable<Item> {
    int w;
    int h;
    int cost;
    int tot;

    public Item(int w, int h, int cost, int tot) {
        this.w = w;
        this.h = h;
        this.cost = cost;
        this.tot = tot;
    }

    @Override
    public String toString() {
        return "Item{" +
                "w=" + w +
                ", h=" + h +
                ", cost=" + cost +
                ", tot=" + tot +
                '}';
    }

    @Override
    public int compareTo(Item item) {
        int maxLine = Math.max(item.w, item.h);
        int minLine = Math.min(item.w, item.h);
        int maxLine2 = Math.max(this.w, this.h);
        int minLine2 = Math.min(this.w, this.h);

        if(item.tot == this.tot) {

        }
        return item.tot - this.cost;
    }
}

public class Test2 {

    public long solution(int[][] beds, int[][] tables, int cost) {
        long answer = Long.MAX_VALUE;
        /*
        List<Item> bedList = new ArrayList<>();
        List<Item> tableList = new ArrayList<>();

        for(int[] bed : beds) {
            int tot = bed[0] * bed[1] * cost + bed[2];
            bedList.add(new Item(bed[0], bed[1], bed[2], tot));
        }

        for(int[] table : tables) {
            int tot = table[0] * table[1] * cost + table[2];
            tableList.add(new Item(table[0], table[1], table[2], tot));
        }

        Collections.sort(bedList);
        Collections.sort(tableList);

        System.out.println("tableList[0] = " + bedList.get(0).toString());
        System.out.println("tableList[0] = " + tableList.get(0).toString());

        Item myBed = bedList.get(0);
        Item myTable = tableList.get(0);
        */

        for(int i=0; i<beds.length; i++) {
            int bW = beds[i][0];
            int bH = beds[i][1];
            int bCost = beds[i][2];

            for(int j=0; j<tables.length; j++) {
                int tW = tables[j][0];
                int tH = tables[j][1];
                int tCost = tables[j][2];

                int[] area = new int[4];
                area[0] = (bW + tW) * Math.max(bH, tH);
                area[1] = (bW + tH) * Math.max(bH, tW);
                area[2] = (bH + tW) * Math.max(bW, tH);
                area[3] = (bH + tH) * Math.max(bH, tH);

                int minArea = area[0];
                for(int k=1; k<4; k++) {
                    minArea = Math.min(minArea, area[k]);
                }
                long tot = minArea * (long)cost + (long)bCost + (long)tCost;
                answer = Math.min(answer, tot);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[][] beds = {{2,3,40000}, {2,5,20000}};
        int[][] tables = {{1,1,30000}};
        int cost = 10;

        System.out.println(test2.solution(beds, tables, cost));
    }
}
