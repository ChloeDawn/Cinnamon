package net.cinnamon.common.block.properties


import com.google.common.base.Optional
import net.cinnamon.common.base.hashCodeOf
import net.minecraft.block.properties.PropertyHelper

// TODO FastUtil FloatSet?
class FloatProperty(name: String, min: Float, max: Float) : PropertyHelper<Float>(name, Float::class.java) {
    private val allowedValues: Set<Float>

    init {
        when {
            min < 0 -> throw IllegalArgumentException("Min value of $name must be 0.0F or greater")
            max <= min -> throw IllegalArgumentException("Max value of $name must be greater than min ($min)")
            else -> {
                val set = mutableSetOf<Float>()
                var curr = min
                do {
                    curr += 0.1F
                    set += curr
                } while(curr < max)
                allowedValues = set.toSet()
            }
        }
    }

    override fun getAllowedValues(): Collection<Float> {
        return allowedValues
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FloatProperty) return false
        return valueClass == other.valueClass
               && name == other.name
               && allowedValues == other.allowedValues
    }

    override fun parseValue(value: String?): Optional<Float> {
        return try {
            val i = value?.toFloat() ?: return Optional.absent()
            if (allowedValues.contains(i)) {
                Optional.of(i)
            } else Optional.absent()
        } catch (e: NumberFormatException) {
            Optional.absent()
        }
    }

    override fun getName(value: Float?) = value.toString()

    override fun hashCode() = hashCodeOf(valueClass, name, allowedValues)
}
