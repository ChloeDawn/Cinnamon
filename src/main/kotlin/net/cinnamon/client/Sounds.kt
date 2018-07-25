@file:JvmName("Sounds")
@file:SideOnly(Side.CLIENT)

package net.cinnamon.client

import net.minecraft.client.audio.PositionedSoundRecord
import net.minecraft.client.audio.SoundHandler
import net.minecraft.util.SoundCategory
import net.minecraft.util.SoundEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@JvmOverloads
fun SoundEvent.getRecord(
    pitch: Float = 1.0F,
    volume: Float = 1.0F,
    x: Float,
    y: Float,
    z: Float
): PositionedSoundRecord = PositionedSoundRecord(this, SoundCategory.MASTER, pitch, volume, x, y, z)

@JvmOverloads
fun SoundEvent.getMusicRecord(
    pitch: Float = 1.0F,
    volume: Float = 1.0F,
    x: Float,
    y: Float,
    z: Float
): PositionedSoundRecord = PositionedSoundRecord(this, SoundCategory.MUSIC, pitch, volume, x, y, z)

@JvmOverloads
fun SoundEvent.getRecord(
    category: SoundCategory,
    pitch: Float = 1.0F,
    volume: Float = 1.0F,
    x: Float,
    y: Float,
    z: Float
): PositionedSoundRecord = PositionedSoundRecord(this, category, pitch, volume, x, y, z)

@JvmOverloads
fun SoundEvent.getRecord(
    pitch: Float = 1.0F,
    volume: Float = 1.0F
): PositionedSoundRecord = PositionedSoundRecord(this, SoundCategory.MASTER, pitch, volume, 0.0F, 0.0F, 0.0F)

@JvmOverloads
fun SoundEvent.getMusicRecord(
    pitch: Float = 1.0F,
    volume: Float = 1.0F
): PositionedSoundRecord = PositionedSoundRecord(this, SoundCategory.MUSIC, pitch, volume, 0.0F, 0.0F, 0.0F)

@JvmOverloads
fun SoundEvent.getRecord(
    category: SoundCategory,
    pitch: Float = 1.0F,
    volume: Float = 1.0F
): PositionedSoundRecord = PositionedSoundRecord(this, category, pitch, volume, 0.0F, 0.0F, 0.0F)

@JvmOverloads
fun SoundHandler.playSound(
    sound: SoundEvent,
    pitch: Float = 1.0F,
    volume: Float = 1.0F,
    x: Float,
    y: Float,
    z: Float
) = playSound(sound.getRecord(pitch, volume, x, y, z))

@JvmOverloads
fun SoundHandler.playSound(
    sound: SoundEvent,
    category: SoundCategory,
    pitch: Float = 1.0F,
    volume: Float = 1.0F,
    x: Float,
    y: Float,
    z: Float
) = playSound(sound.getRecord(category, pitch, volume, x, y, z))

@JvmOverloads
fun SoundHandler.playSound(
    sound: SoundEvent,
    pitch: Float = 1.0F,
    volume: Float = 1.0F
) = playSound(sound.getRecord(pitch, volume, 0.0F, 0.0F, 0.0F))

@JvmOverloads
fun SoundHandler.playSound(
    sound: SoundEvent,
    category: SoundCategory,
    pitch: Float = 1.0F,
    volume: Float = 1.0F
) = playSound(sound.getRecord(category, pitch, volume, 0.0F, 0.0F, 0.0F))
