package com.levik.hw3;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class HRLvivStar2Test {

    private static final String ENTER = "ENTER";
    private static final String LEAVE = "LEAVE";
    private static final String COUNT = "COUNT";

    @Test
    public void testCase1() {
        //given
        int[] baseStations = new int[]{2, 0, 2, 3, 1};
        List<Integer> expectedClients = new LinkedList<>();
        expectedClients.add(5);
        expectedClients.add(6);
        expectedClients.add(3);
        expectedClients.add(2);
        expectedClients.add(3);
        List<Integer> currentClients = new LinkedList<>();

        HRLvivStar2.Heap heap = new HRLvivStar2.Heap(baseStations);
        //when
        HRLvivStar2.handleCommand(baseStations, COUNT, new HRLvivStar2.Tuple(2, 4), currentClients, heap);
        HRLvivStar2.handleCommand(baseStations, ENTER, new HRLvivStar2.Tuple(2), currentClients, heap);
        HRLvivStar2.handleCommand(baseStations, LEAVE, new HRLvivStar2.Tuple(1), currentClients, heap);
        HRLvivStar2.handleCommand(baseStations, COUNT,new HRLvivStar2.Tuple(2, 4), currentClients, heap);
        HRLvivStar2.handleCommand(baseStations, LEAVE,new HRLvivStar2.Tuple(5), currentClients, heap);

        HRLvivStar2.handleCommand(baseStations, COUNT,new HRLvivStar2.Tuple(4, 5), currentClients, heap);
        HRLvivStar2.handleCommand(baseStations, COUNT,new HRLvivStar2.Tuple(1, 2), currentClients, heap);
        HRLvivStar2.handleCommand(baseStations, ENTER,new HRLvivStar2.Tuple(2), currentClients, heap);
        HRLvivStar2.handleCommand(baseStations, COUNT,new HRLvivStar2.Tuple(1, 2), currentClients, heap);

        //then
        assertEquals(expectedClients, currentClients);
    }

}