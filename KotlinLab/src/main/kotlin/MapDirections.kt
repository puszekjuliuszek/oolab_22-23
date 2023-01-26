package ooplab

enum class MapDirections {
    NORTH,
    SOUTH,
    WEST,
    EAST,
    NONE;

    override fun toString(): String {
        return when (this) {
            NORTH -> "Północ"
            SOUTH -> "Południe"
            WEST -> "Zachód"
            EAST -> "Wschód"
            else -> "Brak kieunku"
        }
    }

    operator fun next(): MapDirections {
        return when (this) {
            NORTH -> EAST
            SOUTH -> WEST
            WEST -> NORTH
            EAST -> SOUTH
            else -> NONE
        }
    }

    fun previous(): MapDirections {
        return when (this) {
            NORTH -> WEST
            SOUTH -> EAST
            WEST -> SOUTH
            EAST -> NORTH
            else -> NONE
        }
    }

    fun toUnitVector(): Vector2d {
        return when (this) {
            NORTH -> Vector2d(0, 1)
            SOUTH -> Vector2d(0, -1)
            WEST -> Vector2d(-1, 0)
            EAST -> Vector2d(1, 0)
            else -> Vector2d(0, 0)
        }
    }
}