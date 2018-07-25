@file:JvmName("BufferBuilders")
@file:SideOnly(Side.CLIENT)

package net.cinnamon.client

import net.minecraft.client.renderer.BufferBuilder
import net.minecraft.client.renderer.vertex.VertexFormat
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

/**
 * Passes [x], [y], and [z] to [BufferBuilder.withTranslation], passing back the instance
 * All of the parameters are optional, defaulting to (x = 0.0, y = 0.0, z = 0.0)
 * @return The [BufferBuilder] this function is called against
 */
fun BufferBuilder.withTranslation(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0): BufferBuilder =
    apply { setTranslation(x, y, z) }

/**
 * Delegates to [BufferBuilder.begin], passing back the instance
 * @return The [BufferBuilder] this function is called against
 */
fun BufferBuilder.pushBuffer(glMode: Int, format: VertexFormat): BufferBuilder =
    apply { begin(glMode, format) }

/**
 * Delegates to [BufferBuilder.endVertex], passing back the instance
 * @return The [BufferBuilder] this function is called against
 */
fun BufferBuilder.putVertex(): BufferBuilder = apply { endVertex() }

/**
 * Delegates to [BufferBuilder.endVertex], passing back the instance
 * @return The [BufferBuilder] this function is called against
 */
fun BufferBuilder.resetTranslation(): BufferBuilder =
    apply { setTranslation(0.0, 0.0, 0.0) }
