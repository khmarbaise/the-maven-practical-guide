package com.soebes.training.maven.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BitMaskTest {

    @Test
    void checkFirstBitTest() {
        BitMask bm = new BitMask(0x8000000000000000L);
      assertTrue(bm.isBitSet(63));
    }

    @Test
    void checkNumberBitTest() {
        for (int bitNumber = 0; bitNumber < 64; bitNumber++) {
            long bitMask = Long.rotateLeft(1, bitNumber);
            BitMask bm = new BitMask(bitMask);
          assertTrue(bm.isBitSet(bitNumber));
        }
    }

    @Test
    void setBitNumberTest() {
        BitMask bm = new BitMask();
        for (int bitNumber = 0; bitNumber < 64; bitNumber++) {
            bm.setBit(bitNumber);
          assertTrue(bm.isBitSet(bitNumber));
        }
    }

    @Test
    void unsetBitNumberTest() {
        BitMask bm = new BitMask();
        for (int bitNumber = 0; bitNumber < 64; bitNumber++) {
            bm.setBit(bitNumber);
        }
        for (int bitNumber = 0; bitNumber < 64; bitNumber++) {
            bm.unsetBit(bitNumber);
          assertFalse(bm.isBitSet(bitNumber));
        }
    }

    @Test
    void adhocBitTest() {
        BitMask bm = new BitMask(0xffffffffffffffffL);
        bm.unsetBit(10);
        bm.unsetBit(20);
        bm.unsetBit(30);
        bm.unsetBit(40);
        bm.unsetBit(50);
        bm.unsetBit(60);

      assertFalse(bm.isBitSet(10));
      assertFalse(bm.isBitSet(20));
      assertFalse(bm.isBitSet(30));
      assertFalse(bm.isBitSet(40));
      assertFalse(bm.isBitSet(50));
      assertFalse(bm.isBitSet(60));
    }
}
