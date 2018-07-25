@file:JvmName("Properties")

package net.cinnamon.common.block.properties

import com.google.common.base.Optional
import net.cinnamon.common.base.Color
import net.minecraft.block.properties.IProperty
import net.minecraft.block.properties.PropertyBool
import net.minecraft.block.properties.PropertyDirection
import net.minecraft.block.properties.PropertyEnum
import net.minecraft.block.properties.PropertyHelper
import net.minecraft.item.EnumDyeColor
import net.minecraft.util.EnumFacing
import net.minecraft.util.IStringSerializable
import net.minecraftforge.common.model.IModelState
import net.minecraftforge.common.property.IUnlistedProperty
import java.util.Collections
import net.minecraftforge.common.property.Properties as ForgeProperties

@JvmField val ANIMATION_PROPERTY: IUnlistedProperty<IModelState> =
    ForgeProperties.AnimationProperty

@JvmField val STATIC_PROPERTY: PropertyBool =
    ForgeProperties.StaticProperty

fun <V : Comparable<V>> IProperty<V>.toUnlisted(): IUnlistedProperty<V> =
    ForgeProperties.toUnlisted(this)

val <V : Comparable<V>> IProperty<V>.isUnlisted
    get() = this is IUnlistedProperty<*>

inline fun <reified E : Comparable<E>> propertyOf(name: String, vararg values: E) =
    propertyOf(name, E::class.java, *values)

inline fun <reified E : Comparable<E>> propertyOf(name: String, values: Collection<E>) =
    propertyOf(name, E::class.java, values)

@JvmName("newProperty")
fun <E : Comparable<E>> propertyOf(name: String, type: Class<E>, vararg values: E): IProperty<E> {
    check(values.isNotEmpty()) { "Cannot create property \"$name\" with no allowed values" }
    return object : PropertyHelper<E>(name, type) {
        private val allowedValues = values.toSet()

        override fun getName(value: E?) = value.toString()

        override fun parseValue(value: String?) =
            Optional.fromNullable(allowedValues.firstOrNull {
                it.toString() == value
            })

        override fun getAllowedValues() = Collections.unmodifiableSet(allowedValues)
    }
}

@JvmName("newProperty")
fun <E : Comparable<E>> propertyOf(name: String, type: Class<E>, values: Collection<E>): IProperty<E> {
    check(values.isNotEmpty()) { "Cannot create property \"$name\" with no allowed values" }
    return object : PropertyHelper<E>(name, type) {
        private val allowedValues = values.toSet()

        override fun getName(value: E?) = value.toString()

        override fun parseValue(value: String?) =
            Optional.fromNullable(allowedValues.firstOrNull {
                it.toString() == value
            })

        override fun getAllowedValues() = Collections.unmodifiableSet(allowedValues)
    }
}

inline fun <reified E : Comparable<E>> propertyBuilderOf(name: String): PropertyBuilder<E> =
    propertyBuilderOf(name, E::class.java)

@JvmName("newPropertyBuilder")
fun <E : Comparable<E>> propertyBuilderOf(name: String, type: Class<E>): PropertyBuilder<E> =
    PropertyBuilder(name, type)

@JvmName("newIntProperty")
fun intPropertyOf(name: String, min: Int = 0, max: Int = 15): IProperty<Int> =
    IntProperty(name, min, max)

@JvmName("newIntProperty")
fun intPropertyOf(name: String): IProperty<Int> =
    IntProperty(name, 0, 15)

@JvmName("newFloatProperty")
fun floatPropertyOf(name: String, min: Float = 0.0F, max: Float = 1.0F): IProperty<Float> =
    FloatProperty(name, min, max)

@JvmName("newFloatProperty")
fun floatPropertyOf(name: String): IProperty<Float> =
    FloatProperty(name, 0.0F, 1.0F)

@JvmName("newDoubleProperty")
fun doublePropertyOf(name: String, min: Double = 0.0, max: Double = 1.0): IProperty<Double> =
    DoubleProperty(name, min, max)

@JvmName("newDoubleProperty")
fun doublePropertyOf(name: String): IProperty<Double> =
    DoubleProperty(name, 0.0, 1.0)

@JvmName("newBooleanProperty")
fun booleanPropertyOf(name: String): IProperty<Boolean> =
    PropertyBool.create(name)

inline fun <reified E> enumPropertyOf(name: String): PropertyEnum<E>
    where E : Enum<E>, E : IStringSerializable =
    enumPropertyOf(name, E::class.java)

inline fun <reified E> enumPropertyOf(name: String, noinline filter: (E) -> Boolean): PropertyEnum<E>
    where E : Enum<E>, E : IStringSerializable =
    enumPropertyOf(name, E::class.java, filter)

inline fun <reified E> enumPropertyOf(name: String, vararg values: E): PropertyEnum<E>
    where E : Enum<E>, E : IStringSerializable =
    enumPropertyOf(name, E::class.java, *values)

inline fun <reified E> enumPropertyOf(name: String, values: Collection<E>): PropertyEnum<E>
    where E : Enum<E>, E : IStringSerializable =
    enumPropertyOf(name, E::class.java, values)

@JvmName("newEnumProperty")
fun <E> enumPropertyOf(name: String, enumClass: Class<E>): PropertyEnum<E>
    where E : Enum<E>, E : IStringSerializable =
    PropertyEnum.create(name, enumClass)

@JvmName("newEnumProperty")
fun <E> enumPropertyOf(name: String, enumClass: Class<E>, filter: (E) -> Boolean): PropertyEnum<E>
    where E : Enum<E>, E : IStringSerializable =
    PropertyEnum.create(name, enumClass) { it != null && filter(it) }

@JvmName("newEnumProperty")
fun <E> enumPropertyOf(name: String, enumClass: Class<E>, vararg values: E): PropertyEnum<E>
    where E : Enum<E>, E : IStringSerializable {
    check(values.isNotEmpty()) { "Cannot create property \"$name\" with no allowed values" }
    return PropertyEnum.create(name, enumClass, *values)
}

@JvmName("newEnumProperty")
fun <E> enumPropertyOf(name: String, enumClass: Class<E>, values: Collection<E>): PropertyEnum<E>
    where E : Enum<E>, E : IStringSerializable {
    check(values.isNotEmpty()) { "Cannot create property \"$name\" with no allowed values" }
    return PropertyEnum.create(name, enumClass, values)
}

@JvmName("newDirectionProperty")
fun directionPropertyOf(name: String): IProperty<EnumFacing> =
    PropertyDirection.create(name)

@JvmName("newDirectionProperty")
fun directionPropertyOf(name: String, filter: (EnumFacing) -> Boolean): IProperty<EnumFacing> =
    PropertyDirection.create(name) { it != null && filter(it) }

@JvmName("newDirectionProperty")
fun directionPropertyOf(name: String, vararg values: EnumFacing): IProperty<EnumFacing> {
    check(values.isNotEmpty()) { "Cannot create property \"$name\" with no allowed values" }
    return PropertyDirection.create(name, values.toSet())
}

@JvmName("newDirectionProperty")
fun directionPropertyOf(name: String, values: Collection<EnumFacing>): IProperty<EnumFacing> {
    check(values.isNotEmpty()) { "Cannot create property \"$name\" with no allowed values" }
    return PropertyDirection.create(name, values)
}

@JvmName("newAxisProperty")
fun axisPropertyOf(name: String): IProperty<EnumFacing.Axis> =
    enumPropertyOf(name, EnumFacing.Axis::class.java)

@JvmName("newAxisProperty")
fun axisPropertyOf(name: String, filter: (EnumFacing.Axis) -> Boolean): IProperty<EnumFacing.Axis> =
    enumPropertyOf(name, EnumFacing.Axis::class.java, filter)

@JvmName("newAxisProperty")
fun axisPropertyOf(name: String, vararg values: EnumFacing.Axis): IProperty<EnumFacing.Axis> =
    enumPropertyOf(name, EnumFacing.Axis::class.java, values.toSet())

@JvmName("newAxisProperty")
fun axisPropertyOf(name: String, values: Collection<EnumFacing.Axis>): IProperty<EnumFacing.Axis> =
    enumPropertyOf(name, EnumFacing.Axis::class.java, values)

@JvmName("newColorProperty")
fun colorPropertyOf(name: String): IProperty<Color> =
    enumPropertyOf(name, Color::class.java)

@JvmName("newColorProperty")
fun colorPropertyOf(name: String, filter: (Color) -> Boolean): IProperty<Color> =
    enumPropertyOf(name, Color::class.java, filter)

@JvmName("newColorProperty")
fun colorPropertyOf(name: String, vararg values: Color): IProperty<Color> =
    enumPropertyOf(name, Color::class.java, values.toSet())

@JvmName("newColorProperty")
fun colorPropertyOf(name: String, values: Collection<Color>): IProperty<Color> =
    enumPropertyOf(name, Color::class.java, values)

@JvmName("newDyeColorProperty")
fun dyeColorPropertyOf(name: String): IProperty<EnumDyeColor> =
    enumPropertyOf(name, EnumDyeColor::class.java)

@JvmName("newDyeColorProperty")
fun dyeColorPropertyOf(name: String, filter: (EnumDyeColor) -> Boolean): IProperty<EnumDyeColor> =
    enumPropertyOf(name, EnumDyeColor::class.java, filter)

@JvmName("newDyeColorProperty")
fun dyeColorPropertyOf(name: String, vararg values: EnumDyeColor): IProperty<EnumDyeColor> =
    enumPropertyOf(name, EnumDyeColor::class.java, values.toSet())

@JvmName("newDyeColorProperty")
fun dyeColorPropertyOf(name: String, values: Collection<EnumDyeColor>): IProperty<EnumDyeColor> =
    enumPropertyOf(name, EnumDyeColor::class.java, values)

class PropertyBuilder<E : Comparable<E>>(private val name: String, private val type: Class<E>) {
    private val values = mutableSetOf<E>()

    fun add(value: E): PropertyBuilder<E> {
        this.values.add(value)
        return this
    }

    fun addAll(vararg values: E): PropertyBuilder<E> {
        this.values.addAll(values)
        return this
    }

    fun addAll(values: Collection<E>): PropertyBuilder<E> {
        this.values.addAll(values)
        return this
    }

    fun addAll(values: Iterable<E>): PropertyBuilder<E> {
        this.values.addAll(values)
        return this
    }

    fun addAll(values: Sequence<E>): PropertyBuilder<E> {
        this.values.addAll(values)
        return this
    }

    fun build() = propertyOf(name, type, values)
}
