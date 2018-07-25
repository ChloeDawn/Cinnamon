package net.cinnamon.common.base

import net.minecraft.entity.Entity
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumFacing.Axis
import net.minecraft.util.IStringSerializable
import net.minecraft.util.Mirror
import net.minecraft.util.Rotation
import java.util.Locale

enum class OrdinalFacing(val cardinal: EnumFacing) : IStringSerializable {
    SOUTH      ( EnumFacing.SOUTH ),
    SOUTH_WEST ( EnumFacing.WEST  ),
    WEST       ( EnumFacing.WEST  ),
    NORTH_WEST ( EnumFacing.NORTH ),
    NORTH      ( EnumFacing.NORTH ),
    NORTH_EAST ( EnumFacing.EAST  ),
    EAST       ( EnumFacing.EAST  ),
    SOUTH_EAST ( EnumFacing.SOUTH );

    val angle = ordinal * 45
    val isCardinal = ordinal % 2 == 0

    @JvmName("rotate")
    operator fun invoke(rot: Rotation) = VALUES[(ordinal + (rot.ordinal * 2)) % VALUES.size]

    @JvmName("mirror")
    operator fun invoke(mirror: Mirror) =
        if (mirror == Mirror.LEFT_RIGHT && cardinal.axis == Axis.X ||
            mirror == Mirror.FRONT_BACK && cardinal.axis == Axis.Z) {
            invoke(Rotation.CLOCKWISE_180)
        } else this

    override fun getName() = name.toLowerCase(Locale.ROOT)

    companion object {
        private val VALUES = values()

        @JvmStatic
        @JvmName("fromEntity")
        operator fun get(entity: Entity) = this[(entity.rotationYawHead + 360.0F) % 360.0F]

        @JvmStatic
        @JvmName("fromAngle")
        operator fun get(angle: Float) = VALUES[((angle + 22.5) / 45).toInt() % 8]

        @JvmStatic
        @JvmName("valueOf")
        operator fun get(ordinal: Int) = VALUES[ordinal]

        @JvmStatic
        operator fun iterator() = VALUES.iterator()
    }
}
