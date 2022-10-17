package agh.ics.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    Vector2d testVector;
    @BeforeEach
    void setUp(){
        testVector = new Vector2d(1,0);
    }

    @Test
    void testEquals_Whenx1y0x1y0_ShouldReturn_True() {
        assertEquals(testVector, new Vector2d(1, 0));
    }

    @Test
    void testEquals_Whenx1y0x1y1_ShouldReturn_False() {
        assertNotEquals(testVector, new Vector2d(1, 1));
    }

    @Test
    void testEquals_WhenOtherIsNotAnObject_ShouldReturn_False() {
        assertNotEquals(testVector, 1);
    }

    @Test
    void testEquals_WhenOtherIsAnAnotherObject_ShouldReturn_False() {
        assertNotEquals(testVector, "testString");
    }

    @Test
    void testEquals_WhenOtherIsNotAnArray_ShouldReturn_False() {
        assertNotEquals(testVector, new Vector2d[5]);
    }

    @Test
    void VectorToString_Whenx1y1_ShouldReturn1_1InBrackets(){
        assertEquals("(1,0)",testVector.toString());
    }

    @Test
    void VectorProcedes_Whenx1y0x1y0_ShouldReturnTrue(){
        assertTrue(testVector.precedes(new Vector2d(1,0)));
    }

    @Test
    void VectorProcedes_Whenx1y0x0y0_ShouldReturnFalse(){
        assertFalse(testVector.precedes(new Vector2d(0,0)));
    }

    @Test
    void VectorProcedes_Whenx1y0x0y2_ShouldReturnFalse(){
        assertFalse(testVector.precedes(new Vector2d(0,2)));
    }

    @Test
    void VectorProcedes_Whenx1y0x1y2_ShouldReturnTrue(){
        assertTrue(testVector.precedes(new Vector2d(1,2)));
    }

    @Test
    void VectorProcedes_Whenx1y0x11y22_ShouldReturnTrue(){
        assertTrue(testVector.precedes(new Vector2d(11,22)));
    }

    @Test
    void VectorFollows_Whenx1y0x1y0_ShouldReturnTrue(){
        assertTrue(testVector.follows(new Vector2d(1,0)));
    }

    @Test
    void VectorFollows_Whenx1y0x0y0_ShouldReturnTrue(){
        assertTrue(testVector.follows(new Vector2d(0,0)));
    }

    @Test
    void VectorFollows_Whenx1y0x0y2_ShouldReturnTrue(){
        assertTrue(testVector.follows(new Vector2d(0,-1)));
    }

    @Test
    void VectorFollows_Whenx1y0x1y2_ShouldReturnFalse(){
        assertFalse(testVector.follows(new Vector2d(1,2)));
    }

    @Test
    void VectorFollows_Whenx1y0x11y22_ShouldReturnFalse(){
        assertFalse(testVector.follows(new Vector2d(11,22)));
    }

    @Test
    void VectorAdd_Whenx1y0x0y0_ShouldReturnx1y1(){
        assertEquals(new Vector2d(1,0),testVector.add(new Vector2d(0,0)));
    }

    @Test
    void VectorAdd_Whenx1y0x_1y0_ShouldReturnx1y1(){
        assertEquals(new Vector2d(-1,0),testVector.add(new Vector2d(-2,0)));
    }

    @Test
    void VectorAdd_Whenx1y0x1y_5_ShouldReturnx1y_5(){
        assertEquals(new Vector2d(1,-5),testVector.add(new Vector2d(0,-5)));
    }

    @Test
    void VectorSubstract_Whenx1y0x0y0_ShouldReturnx1y0(){
        assertEquals(new Vector2d(1,0),testVector.subtract(new Vector2d(0,0)));
    }

    @Test
    void VectorSubstract_Whenx1y0x0y_5_ShouldReturnx1y5(){
        assertEquals(new Vector2d(1,5),testVector.subtract(new Vector2d(0,-5)));
    }

    @Test
    void VectorSubstract_Whenx1y0x0y5_ShouldReturnx1y_5(){
        assertEquals(new Vector2d(1,-5),testVector.subtract(new Vector2d(0,5)));
    }

    @Test
    void VectorSubstract_Whenx1y0x_4y0_ShouldReturnx5y0(){
        assertEquals(new Vector2d(5,0),testVector.subtract(new Vector2d(-4,0)));
    }

    @Test
    void VectorSubstract_Whenx1y0x1y0_ShouldReturnx0y0(){
        assertEquals(new Vector2d(0,0),testVector.subtract(new Vector2d(1,0)));
    }

    @Test
    void VectorUpperRight_Whenx1y0x0y2_ShouldReturnx1y2(){
        assertEquals(new Vector2d(1,2),testVector.upperRight(new Vector2d(0,2)));
    }

    @Test
    void VectorUpperRight_Whenx1y0x2y1_ShouldReturnx2y1(){
        assertEquals(new Vector2d(2,1),testVector.upperRight(new Vector2d(2,1)));
    }

    @Test
    void VectorUpperRight_Whenx1y0x1y1_ShouldReturnx1y1(){
        assertEquals(new Vector2d(1,1),testVector.upperRight(new Vector2d(1,1)));
    }

    @Test
    void VectorUpperRight_Whenx1y0x_1y_1_ShouldReturnx1y1(){
        assertEquals(new Vector2d(1,0),testVector.upperRight(new Vector2d(-1,-1)));
    }

    @Test
    void VectorLowerLeft_Whenx1y0x_10y0_ShouldReturnx_10y0(){
        assertEquals(new Vector2d(-10,0),testVector.lowerLeft(new Vector2d(-10,0)));
    }

    @Test
    void VectorLowerLeft_Whenx1y0x0y2_ShouldReturnx0y1(){
        assertEquals(new Vector2d(0,0),testVector.lowerLeft(new Vector2d(0,2)));
    }

    @Test
    void VectorLowerLeft_Whenx1y0x10y_2ShouldReturnx1y_2(){
        assertEquals(new Vector2d(1,-2),testVector.lowerLeft(new Vector2d(10,-2)));
    }

    @Test
    void VectorLowerLeft_Whenx1y0x1y1_ShouldReturnx1y1(){
        assertEquals(new Vector2d(1,0),testVector.lowerLeft(new Vector2d(1,1)));
    }
    @Test
    void VectorLowerLeft_Whenx1y0x3y5_ShouldReturnx1y1(){
        assertEquals(new Vector2d(1,0),testVector.lowerLeft(new Vector2d(3,5)));
    }

    @Test
    void VectorOpposite_WhenPositive_ShouldReturnNegative(){
        assertEquals(new Vector2d(-1,-1),new Vector2d(1,1).opposite());
    }

    @Test
    void VectorOpposite_WhenNegative_ShouldReturnPositive(){
        assertEquals(new Vector2d(1,1),new Vector2d(-1,-1).opposite());
    }

    @Test
    void VectorOpposite_WhenZero_ShouldReturnZero(){
        assertEquals(new Vector2d(0,0),new Vector2d(0,0).opposite());
    }


}