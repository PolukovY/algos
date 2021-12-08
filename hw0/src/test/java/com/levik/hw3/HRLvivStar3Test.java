package com.levik.hw3;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HRLvivStar3Test {

    private static final String ENTER = "ENTER";
    private static final String LEAVE = "LEAVE";
    private static final String COUNT = "COUNT";

    @Test
    public void testCase1() {
        //given
        int[] baseStations = new int[]{2, 0, 2, 3, 1};
        List<Long> expectedClients = new LinkedList<>();
        expectedClients.add(5L);
        expectedClients.add(6L);
        expectedClients.add(3L);
        expectedClients.add(2L);
        expectedClients.add(3L);
        List<Long> currentClients = new LinkedList<>();

        HRLvivStar3.Heap heap = new HRLvivStar3.Heap(baseStations);
        //when
        HRLvivStar3.handleCommand(baseStations, COUNT, new HRLvivStar3.Tuple(2, 4), currentClients, heap);
        HRLvivStar3.handleCommand(baseStations, ENTER, new HRLvivStar3.Tuple(2), currentClients, heap);
        HRLvivStar3.handleCommand(baseStations, LEAVE, new HRLvivStar3.Tuple(1), currentClients, heap);
        HRLvivStar3.handleCommand(baseStations, COUNT,new HRLvivStar3.Tuple(2, 4), currentClients, heap);
        HRLvivStar3.handleCommand(baseStations, LEAVE,new HRLvivStar3.Tuple(5), currentClients, heap);

        HRLvivStar3.handleCommand(baseStations, COUNT,new HRLvivStar3.Tuple(4, 5), currentClients, heap);
        HRLvivStar3.handleCommand(baseStations, COUNT,new HRLvivStar3.Tuple(1, 2), currentClients, heap);
        HRLvivStar3.handleCommand(baseStations, ENTER,new HRLvivStar3.Tuple(2), currentClients, heap);
        HRLvivStar3.handleCommand(baseStations, COUNT,new HRLvivStar3.Tuple(1, 2), currentClients, heap);

        //then
        assertEquals(expectedClients, currentClients);
    }

}