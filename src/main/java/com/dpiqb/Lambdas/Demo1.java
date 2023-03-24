package com.dpiqb.Lambdas;

public class Demo1 {
    public static void main(String[] args) {
        int[] nums = new int[]{8,7,3,4,58,7,3,4,26,10,58,73,4,19,23,87};

        System.out.println("\nEqual 10");
        numTest(nums, new Filter() {
            @Override
            public boolean check(int n) {
                return n == 10;
            }
        });

        System.out.println("\nGrate than ten 10");
        numTest(nums, new GrateThanTen());

        System.out.println("\nLess than ten 10");
        numTest(nums, (int n) -> {
            return n < 10;
        });
        // same
        numTest(nums, n -> n < 10);
    }
    static void numTest(int[] nums, Filter filter){
        for (int n: nums){
            if(filter.check(n))
                System.out.println(n);
        }
    }
}

interface Filter{
    public boolean check(int n);
}

class GrateThanTen implements Filter{
    @Override
    public boolean check(int number) {
        return number > 10;
    }
}