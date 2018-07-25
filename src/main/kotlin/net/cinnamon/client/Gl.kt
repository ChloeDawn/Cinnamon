package net.cinnamon.client

import net.minecraft.client.renderer.GlStateManager
import net.minecraft.util.math.Vec3d
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import org.lwjgl.util.vector.Quaternion
import org.lwjgl.util.vector.ReadableVector3f
import org.lwjgl.util.vector.ReadableVector4f
import java.util.function.Consumer

/**
 * Wrapper class for GLStateManager functions, providing fluent setters
 * Useful in Kotlin as a functional companion object (see: [run], [with], etc)
 */
@SideOnly(Side.CLIENT)
object Gl {
    /**
     *  A sub-class of [Gl] dedicated to handling matrix functions
     *  @return An immutable instance of the [Gl.Matrix] class
     */
    @JvmStatic
    fun matrix() = Matrix

    @JvmStatic
    fun alpha(state: Boolean) = if (state) {
        GlStateManager.enableAlpha()
    } else GlStateManager.disableAlpha()

    @JvmStatic
    fun lighting(state: Boolean) = if (state) {
        GlStateManager.enableLighting()
    } else GlStateManager.disableLighting()

    @JvmStatic
    fun colorMaterial(state: Boolean) = if (state) {
        GlStateManager.enableColorMaterial()
    } else GlStateManager.disableColorMaterial()

    @JvmStatic
    fun depthTest(state: Boolean) = if (state) {
        GlStateManager.enableDepth()
    } else GlStateManager.disableDepth()

    @JvmStatic
    fun blend(state: Boolean) = if (state) {
        GlStateManager.enableBlend()
    } else GlStateManager.disableBlend()

    @JvmStatic
    fun fog(state: Boolean) = if (state) {
        GlStateManager.enableFog()
    } else GlStateManager.disableFog()

    @JvmStatic
    fun cull(state: Boolean) = if (state) {
        GlStateManager.enableCull()
    } else GlStateManager.disableCull()

    @JvmStatic
    fun polygonOffset(state: Boolean) = if (state) {
        GlStateManager.enablePolygonOffset()
    } else GlStateManager.disablePolygonOffset()

    @JvmStatic
    fun colorLogic(state: Boolean) = if (state) {
        GlStateManager.enableColorLogic()
    } else GlStateManager.disableColorLogic()

    @JvmStatic
    fun texture2D(state: Boolean) = if (state) {
        GlStateManager.enableTexture2D()
    } else GlStateManager.disableTexture2D()

    @JvmStatic
    fun normalize(state: Boolean) = if (state) {
        GlStateManager.enableNormalize()
    } else GlStateManager.disableNormalize()

    fun light(light: Int, state: Boolean) = if (state) {
        GlStateManager.enableLight(light)
    } else GlStateManager.disableLight(light)

    object Matrix {
        fun push() = GlStateManager.pushMatrix()

        fun pop() = GlStateManager.popMatrix()

        fun scale(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0) =
            GlStateManager.scale(x, y, z)

        fun scale(x: Float = 0.0F, y: Float = 0.0F, z: Float = 0.0F) =
            GlStateManager.scale(x, y, z)

        fun translate(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0) =
            GlStateManager.translate(x, y, z)

        fun translate(x: Float = 0.0F, y: Float = 0.0F, z: Float = 0.0F) =
            GlStateManager.translate(x, y, z)

        fun translate(vec: ReadableVector3f) =
            GlStateManager.translate(vec.x, vec.y, vec.z)

        fun translate(vec: Vec3d) =
            GlStateManager.translate(vec.x, vec.y, vec.z)

        fun rotate(quaternion: Quaternion) =
            GlStateManager.rotate(quaternion)

        fun rotate(vector: ReadableVector4f) =
            GlStateManager.rotate(Quaternion(vector))

        fun rotate(angle: Float, x: Float = 0.0F, y: Float = 0.0F, z: Float = 0.0F) =
            GlStateManager.rotate(angle, x, y, z)

        fun rotate(angle: Double, x: Double = 0.0, y: Double = 0.0, z: Double = 0.0) =
            GlStateManager.rotate(angle.toFloat(), x.toFloat(), y.toFloat(), z.toFloat())

        fun rotate(angle: Float, vec: ReadableVector3f) =
            GlStateManager.rotate(angle, vec.x, vec.y, vec.z)

        @JvmSynthetic
        inline fun use(crossinline action: Matrix.() -> Unit) {
            push()
            action(this)
            pop()
        }

        // Kotlin: Use inlined function above
        fun use(action: Consumer<Matrix>) {
            push()
            action.accept(this)
            pop()
        }
    }
}
