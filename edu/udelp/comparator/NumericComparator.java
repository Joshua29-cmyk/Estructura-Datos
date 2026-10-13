package edu.udelp.comparator;

public class NumericComparator implements Comparable<Integer>{
    @Override
    public int compareTo(Integer o) {

        if(o > 10){
            return 1;
        }
        return -1;
    }

}
