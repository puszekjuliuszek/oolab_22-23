import ooplab.IWorldMap
import ooplab.Vector2d

class RandomExtenstions {
    fun IWorldMap.randomPosition(size:Vector2d): Vector2d?{
        var emptyPos: ArrayList<Vector2d> = ArrayList<Vector2d>()
        for (i in 0 until (size.x)){
            for (j in 0 until (size.y))
            {
                if (!this.isOccupied(Vector2d(i,j))) {
                    emptyPos.add(Vector2d(i, j))
                }
            }
        }
        return emptyPos.randomOrNull()
    }

}