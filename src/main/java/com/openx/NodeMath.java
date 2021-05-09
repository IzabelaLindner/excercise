package com.openx;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeMath {

    public static int sum(Node node){
        if(node == null){
            return 0;
        }

        int leftSum = sum(node.getLeftChild());
        int rightSum = sum(node.getRightChild());

        int sum = node.getValue() + leftSum + rightSum;

        return sum;
    }

    public static double average(Node node){
        if(node == null){
            throw new IllegalArgumentException("node reference is null");
        }
        return new AverageHelper().average(node);
    }

    public static double median(Node node){
        if(node == null){
            throw new IllegalArgumentException("node reference is null");
        }
        return new MedianHelper().median(node);
    }


    private static class AverageHelper {

        private int count;

        public double average(Node node){
            double tmp = (double) averageHelper(node) / count;
            BigDecimal bigDecimal = new BigDecimal(tmp).setScale(2, RoundingMode.HALF_UP);
            return bigDecimal.doubleValue();
        }

        private int averageHelper(Node node){
            if(node == null){
                return 0;
            }

            count++;

            int leftSum = averageHelper(node.getLeftChild());
            int rightSum = averageHelper(node.getRightChild());

            int sum = node.getValue() + leftSum + rightSum;

            return sum;
        }
    }


    private static class MedianHelper {
        private List<Integer> values = new ArrayList<>();

        public double median(Node node){
            medianHelper(node);
            Collections.sort(values);

            int size = values.size();
            double result;

            if(size % 2 == 1){
                int index = size / 2;
                result = (double) values.get(index);
            }else {
                int index = size / 2;
                double first = values.get(index);
                double second = values.get(index - 1);

                result = (first + second) / 2;
            }

            BigDecimal bigDecimal = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);

            return bigDecimal.doubleValue();
        }


        private int medianHelper(Node node){
            if(node == null){
                return 0;
            }

            values.add(node.getValue());

            medianHelper(node.getLeftChild());
            medianHelper(node.getRightChild());

            return 1;
        }
    }
}
