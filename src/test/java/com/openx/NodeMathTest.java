package com.openx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NodeMathTest {

    @Test
    void shouldCalculateSum(){
        //given
        Node left = new Node(2);
        Node right = new Node(5);
        Node root = new Node(1, left, right);

        //when
        int result = NodeMath.sum(root);

        //then
        assertEquals(8, result);
    }

    @Test
    void shouldCalculateSumForNull(){
        //given
        Node empty = null;

        //when
        int result = NodeMath.sum(empty);

        //then
        assertEquals(0, result);
    }

    @Test
    void shouldCalculateSumForNodeWithOneChild(){
        //given
        Node root = new Node(1, null, new Node(2));

        //when
        int result = NodeMath.sum(root);

        //then
        assertEquals(3, result);
    }

    @Test
    void shouldCalculateSumForSubTree(){
        //given
        Node left = new Node(2);
        Node right = new Node(5);
        Node root = new Node(1, left, right);

        //when
        int result = NodeMath.sum(left);

        //then
        assertEquals(2, result);
    }

    @Test
    void shouldCalculateSumForBiggerTree(){
        //given
        Node root = createTree();

        //when
        int result = NodeMath.sum(root);

        //then
        assertEquals(38, result);
    }

    @Test
    void shouldCalculateSumForNegativeNumber(){
        //given
        Node left = new Node(-2);
        Node right = new Node(-3);
        Node root = new Node(8, left, right);

        //when
        int result = NodeMath.sum(root);

        //then
        assertEquals(3,result);
    }

    @Test
    void shouldCalculateAverage(){
        //given
        Node left = new Node(2);
        Node right = new Node(5);
        Node root = new Node(1, left, right);

        //when
        double result = NodeMath.average(root);

        //then
        assertEquals(2.67, result);
    }

    @Test
    void shouldCalculateAverageForBiggerTree(){
        //given
        Node root = createTree();

        //when
        double result = NodeMath.average(root);

        //then
        assertEquals(3.8, result);
    }

    @Test
    void shouldCalculateAverageForZeros(){
        //given
        Node left = new Node(0);
        Node right = new Node(0);
        Node root = new Node(0, left, right);

        //when
        double result = NodeMath.average(root);

        //then
        assertEquals(0, result);
    }

    @Test
    void shouldThrowExceptionWhenCalculateAverageForNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            NodeMath.average(null);
        });
    }

    @Test
    void shouldCalculateMedianForOdd(){
        //given
        Node left = new Node(2);
        Node right = new Node(5);
        Node root = new Node(1, left, right);

        //when
        double result = NodeMath.median(root);

        //then
        assertEquals(2, result);
    }

    @Test
    void shouldCalculateMedianForZeros(){
        //given
        Node left = new Node(0);
        Node right = new Node(0);
        Node root = new Node(0, left, right);

        //when
        double result = NodeMath.median(root);

        //then
        assertEquals(0, result);
    }

    @Test
    void shouldThrowExceptionWhenCalculateMedianForNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            NodeMath.median(null);
        });
    }

    @Test
    void shouldCalculateMedianForEven(){
        //given
        Node left = new Node(2, new Node(8), null);
        Node right = new Node(5);
        Node root = new Node(1, left, right);

        //when
        double result = NodeMath.median(root);

        //then
        assertEquals(3.5, result);
    }

    @Test
    void shouldCalculateMedianForBiggerTree(){
        Node root = createTree();

        //when
        double result = NodeMath.median(root);

        //then
        assertEquals(4, result);
    }

    private Node createTree(){
        Node rightOfRight = new Node(0, new Node(2), new Node(8, null, new Node(5)));
        Node left = new Node(3, new Node(2), new Node(5));
        Node right = new Node (7, new Node(1), rightOfRight);
        Node root = new Node(5, left, right);

        return root;
    }
}