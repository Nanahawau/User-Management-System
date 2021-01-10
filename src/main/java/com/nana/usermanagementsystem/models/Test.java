//package com.nana.usermanagementsystem.models;
//
//import java.util.*;
////Alice and Bob work in a beautiful orchard. There are N apple trees in the orchard.
////        The apple trees are arranged in a row, and they are numbered from 1 to N.
////        Alice is planning to collect all the apples from K consecutive trees, and Bob is planning
////        to collect all the apples from L consecutive trees. They want to choose two disjoint segments
////        (one consisting of K trees for Alice and the other consisting of L trees for Bob) so as not to
////        disturb each other. What is the maximum number of apples that they can collect? Write a function
////        that given an array A consisting of N integers denoting the number of apples on each apple tree in
////        the row, and integers K and L denoting, respectively, the number of trees that Alice and Bob can choose
////        when collecting, returns the maximum number of apples that can be collected by them, or -1 if there are
////        no such intervals. For example, given A =[6, 1,4,6,3,2,7,4], K=3, L=2, your function should return 24,
////        because Alice can choose trees 3 to 5 and collect 4 + 6 + 3 = 13 apples, and Bob can choose trees 7 to 8
////        and collect 7 + 4 = 11 apples. Thus, they will collect 13 + 11 = 24 apples in total, and that is the maximum
////        number that can be achieved. Given A = [10, 19, 15], K = 2, L = 2, your function should return -1, because it
////        is not possible for Alice and Bob to choose two disjoint intervals. Assume that: N is an integer within the range
////        [2..600]; K and L are integers within the range [1 .. N-1]; each element of array A is an integer within the range
////        [1..500].
//
//
//public class Test {
//    public static void main(String[] args) {
////
////        int[] testNum = {6, 1, 4, 6, 3, 2, 7, 4};
////        int K = 2;
////        int L = 1;
////
////        int[] testNum = {10, 19, 15};
////        int K = 2;
////        int L = 2;
//
////        int[] testNum = {3, 3, 4, 5 , 6, 6};
////        int K = 2;
////        int L = 3;
//
////        int[] testNum = {6, 1, 4, 6, 3, 2, 7, 4};
////        int K = 3;
////        int L = 2;
//
//         int[] testNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int K = 2;
//        int L = 5;
//
//
//
//        solution(testNum, K, L);
//
//
//    }
//
//
//    public static int solution(int[] A, int K, int L) {
//
//        System.out.println(Arrays.toString(A));
//
//        int maximum = 0;
//        int iterationLength = K + L;
//        List<Integer> intervals = new ArrayList<>();
//
//        if ((K+L + 1) <=  A.length) {
//
//            for (int i = 0; i < iterationLength; i++) {
//                for (int j = i; j <= iterationLength; j++) {
//
//                    if(iterationLength == A.length ){
//                        System.out.println(maximum + "maximu");
//                        return maximum;
//                    }
//
//                    if (j != K && j != A.length + 1) {
////                        System.out.println(i + "valueofI");
////                        System.out.println(j + "valueofJ");
//
//                        intervals.add(A[j]);
//
//                    }
//                }
//
//                System.out.println(intervals + "intervals");
//
//
//                if (intervals.size() > 0 ) {
//                    int intialMax = intervals.stream().reduce(0, Integer::sum);
//
//                    System.out.println(intialMax + "initial");
//                    System.out.println(maximum + "prevMax");
//
//                    if (intialMax > maximum && iterationLength != A.length - 1) {
//                        maximum = intialMax;
////                        iterationLength++;
//                        System.out.println(maximum + "newMax");
//                    } else {
//                        if (intialMax > maximum) {
//                            maximum = intialMax;
////                            iterationLength++;
//                        }
////                        break;
//                    }
//                }
//
//                intervals.clear();
//                K++;
//                iterationLength++;
//                System.out.println(iterationLength + "iterlength");
//            }
//
//        } else {
//            maximum = -1;
//        }
//
//        System.out.println(maximum + "max");
//        return maximum;
//
//    }
//}
//
//
//
//
