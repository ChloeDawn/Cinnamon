package net.cinnamon.common.serializable.nbt

import net.minecraft.nbt.NBTBase
import javax.annotation.Nullable

/**
 * Iterable equivalent of the [Int] constants within [net.minecraftforge.common.util.Constants.NBT]
 * @deprecated This enum class is currently unused internally and will likely be removed or rewritten
 */
@Deprecated("Marked for removal or rewrite in near future")
enum class NBTTagType(val id: Int) {
    END(0),
    BYTE(1),
    SHORT(2),
    INT(3),
    LONG(4),
    FLOAT(5),
    DOUBLE(6),
    BYTE_ARRAY(7),
    STRING(8),
    LIST(9),
    COMPOUND(10),
    INT_ARRAY(11),
    LONG_ARRAY(12),
    ANY_NUMERIC(99);

    override fun toString() = "TagType{name=$name,id=$id}"

    companion object {
        /**
         * Iterates [NBTTagType.values] and matches the given [id] against [NBTTagType.id]
         * @return The matching [NBTTagType], or null if no [NBTTagType.id] matches
         */
        @JvmName("valueOf")
        @JvmStatic
        @Nullable
        operator fun invoke(id: Int) = values().find { id == it.id }

        /**
         * Delegates [NBTBase.getId] as an [Int] to [NBTTagType.invoke].
         * @return The [NBTTagType] matching the given [nbt]
         * @throws UnsupportedTagIdException if the given [nbt] has no match
         */
        @JvmName("valueOf")
        @JvmStatic
        operator fun invoke(nbt: NBTBase) = nbt.id.toInt().let {
            invoke(it) ?: throw UnsupportedTagIdException(it, nbt)
        }
    }
}
