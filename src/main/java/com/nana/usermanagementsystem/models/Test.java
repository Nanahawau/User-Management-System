package com.nana.usermanagementsystem.models;

import io.lettuce.core.StrAlgoArgs;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
public class Test {
    public static void main(String[] args) {


        System.out.println(repeatedString("mrmacaroniwentabroad",  10));
//
//        int[] testNum = {6, 1, 4, 6, 3, 2, 7, 4};
//        int K = 2;
//        int L = 1;
//
//        int[] testNum = {10, 19, 15};
//        int K = 2;
//        int L = 2;

//        int[] testNum = {3, 3, 4, 5 , 6, 6};
//        int K = 2;
//        int L = 3;

        int[] testNum = {6, 1, 4, 6, 3, 2, 7, 4};
        int K = 3;
        int L = 2;

        fibonnaci(3);

//         int[] testNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int K = 2;
//        int L = 5;



//        solution(testNum, K, L);

//        sortAlgo(testNum);


    }


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
//    }
//


    /**
     * So the first iteration uses the current index
     * and value as smallest and smallestIndex
     * The second iteration is an index ahead
     * And checks if the value of the index ahead is less than
     * the variable smallest
     * If true, it reassigns smallest to a the value of the
     * current index in the second iteration,
     *The second if, those the swapping of indexes if the new value of
     * smallest is less than the value of the current index of the first iteration
     * @param Arr
     */


    // Selection Sort O(n2) (Not the best)
//    public static void sortAlgo (int [] Arr) {
//        System.out.println(Arrays.toString(Arr) + "IA");
//
//        for (int i = 0; i < Arr.length; i++) {
//
//            int smallest = Arr[i];
//            int smallestIndex = i;
//            for (int j = i + 1; j < Arr.length; j++) {
//
//                if (Arr[j] < smallest) {
//                    smallest = Arr[j];
//                    smallestIndex = j;
//                }
//            }
//
//            if (smallest < Arr[i]) {
//                int temp = Arr[i];
//                Arr[i] = smallest;
//                Arr[smallestIndex] = temp;
//            }
//
//        }
//
//
//        System.out.println(Arrays.toString(Arr) + "sorted");
//    }



//    private static byte [] createSalt () {
//        SecureRandom random = new SecureRandom();
//        byte [] salt = new byte[16];
//        random.nextBytes(salt);
//        return  salt;
//    }

//    public static int countItemsInAnArray (ArrayList <Integer> list) {
//        if (list.size() == 0 ) {
//            System.out.println("result is {}:" + 0);
//            return 0;
//        }


//        final Map<Object, List<Long>> nodePositions = new ConcurrentHashMap<>();
////        nodePositions.get(nodePositions,)
//        return (countItemsInAnArray(list) + 1);

//    }


    static long repeatedString(String s, long n) {
        char [] c = s.toCharArray();
        int noOfOccurence = 0;

        for (int i = 0; i <= n-1; i++) {
            if (c[i] == 'a') {
                noOfOccurence++;
            }
        }

        return noOfOccurence;
    }

    static void fibonnaci(int n) {
        int prev = 0;
        int additional = 1;
        ArrayList<Integer> series = new ArrayList<>();
        series.add(prev);
        series.add(additional);
        int next = 0;
        for (int i = 0; i < n -2; i++ ) {

            next = prev + additional;

            prev = additional;
            additional = next;
            series.add(next);

            System.out.println(series + "sequence");


        }


    }

}




