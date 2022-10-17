package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionsTest {
    @Test
    void MapDirectionNext_WhenMapDirectionEast_ShouldReturnSouth(){
        MapDirections mapDirection = MapDirections.EAST;
        assertEquals(MapDirections.SOUTH,mapDirection.next());
    }

    @Test
    void MapDirectionNext_WhenMapDirectionSouth_ShouldReturnWest(){
        MapDirections mapDirection = MapDirections.SOUTH;
        assertEquals(MapDirections.WEST,mapDirection.next());
    }

    @Test
    void MapDirectionNext_WhenMapDirectionWest_ShouldReturnNorth(){
        MapDirections mapDirection = MapDirections.WEST;
        assertEquals(MapDirections.NORTH,mapDirection.next());
    }

    @Test
    void MapDirectionNext_WhenMapDirectionNorth_ShouldReturnEast(){
        MapDirections mapDirection = MapDirections.NORTH;
        assertEquals(MapDirections.EAST,mapDirection.next());
    }

    @Test
    void MapDirectionPrevious_WhenMapDirectionEast_ShouldReturnNorth(){
        MapDirections mapDirection = MapDirections.EAST;
        assertEquals(MapDirections.NORTH,mapDirection.previous());
    }
    @Test
    void MapDirectionPrevious_WhenMapDirectionSouth_ShouldReturnEast(){
        MapDirections mapDirection = MapDirections.SOUTH;
        assertEquals(MapDirections.EAST,mapDirection.previous());
    }
    @Test
    void MapDirectionPrevious_WhenMapDirectionWest_ShouldReturnSouth(){
        MapDirections mapDirection = MapDirections.WEST;
        assertEquals(MapDirections.SOUTH,mapDirection.previous());
    }
    @Test
    void MapDirectionPrevious_WhenMapDirectionNorth_ShouldReturnWest(){
        MapDirections mapDirection = MapDirections.NORTH;
        assertEquals(MapDirections.WEST,mapDirection.previous());
    }
}