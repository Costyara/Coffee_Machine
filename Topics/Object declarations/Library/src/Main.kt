import kotlin.math.abs

object Math {
    fun abs(value: Int): Int {
        return if (value < 0) {
            -value
        } else if (value == 0) {
            0
        } else {
            value
        }
    }

    fun abs(value: Double): Double {
        return if (value < 0.0) {
            -value
        } else if (value == 0.0) {
            0.0
        } else {
            value
        }
    }
}
