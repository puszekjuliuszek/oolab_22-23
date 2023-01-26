import ooplab.Animal
import ooplab.IWorldMap
import ooplab.Vector2d

class BouncyMap(
    private val height: Int = 0,
    private val width: Int = 0
) : IWorldMap {
    private var animals: HashMap<Vector2d, Animal> = HashMap()


    override fun canMoveTo(position: Vector2d): Boolean {
        return position < Vector2d(width, height) && position > Vector2d(0, 0)
    }

    override fun place(animal: Animal): Boolean {
        if(animals.containsValue(animal)){
            for (pos in animals.keys){
                if (animals.get(pos)==animal){
                    animals.remove(pos)
                    break
                }
            }
        }
        if (!isOccupied(animal.position) && canMoveTo(animal.position)){
            animals.put(animal.position, animal)
        }else {
            val randomFree: Vector2d? = randomPosition(Vector2d(width,height))
        }
        return true
    }



    override fun isOccupied(position: Vector2d): Boolean {
        return animals.containsKey(position)
    }

    override fun objectAt(position: Vector2d): Any? {
        if (isOccupied(position)) {
            return animals[position]
        } else {
            return null
        }
    }
}