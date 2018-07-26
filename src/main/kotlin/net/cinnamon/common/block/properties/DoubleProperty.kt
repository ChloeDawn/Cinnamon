package net.cinnamon.common.block.properties

import com.google.common.base.Optional
import net.cinnamon.common.base.hashCodeOf
import net.minecraft.block.properties.PropertyHelper

// TODO FastUtil DoubleSet?
class DoubleProperty(name: String, min: Double, max: Double) : PropertyHelper<Double>(name, Double::class.java) {
    private val allowedValues: Set<Double>

    init {
        when {
            min < 0 -> throw IllegalArgumentException("Min value of $name must be 0.0 or greater")
            max <= min -> throw IllegalArgumentException("Max value of $name must be greater than min ($min)")
            else -> {
                val set = mutableSetOf<Double>()
                var curr = min
                do {
                    curr += 0.1
                    set += curr
                } while (curr < max)
                allowedValues = set.toSet()
            }
        }
    }

    override fun getAllowedValues(): Collection<Double> {
        return allowedValues
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DoubleProperty) return false
        return valueClass == other.valueClass
               && name == other.name
               && allowedValues == other.allowedValues
    }

    override fun parseValue(value: String?): Optional<Double> {
        return try {
            val i = value?.toDouble() ?: return Optional.absent()
            if (allowedValues.contains(i)) {
                Optional.of(i)
            } else Optional.absent()
        } catch (e: NumberFormatException) {
            Optional.absent()
        }
    }

    override fun getName(value: Double?) = value.toString()

    override fun hashCode() = hashCodeOf(valueClass, name, allowedValues)
}
