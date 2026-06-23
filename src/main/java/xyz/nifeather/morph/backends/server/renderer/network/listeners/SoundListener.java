package xyz.nifeather.morph.backends.server.renderer.network.listeners;

import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.sound.StaticSound;
import com.github.retrooper.packetevents.resources.ResourceLocation;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSoundEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import xiamomc.pluginbase.Annotations.Resolved;
import xyz.nifeather.morph.backends.server.renderer.network.registries.RenderRegistry;
import xyz.nifeather.morph.utilities.EntityTypeUtils;

public class SoundListener extends ProtocolListener
{
    @Override
    public String getIdentifier()
    {
        return "sound";
    }

    @Resolved(shouldSolveImmediately = true)
    private RenderRegistry registry;

    @Override
    public void onPacketSend(PacketSendEvent event)
    {
        if (event.getPacketType() != PacketType.Play.Server.SOUND_EFFECT)
            return;

        var targetPlayer = (Player) event.getPlayer();

        if (targetPlayer == null)
            return;

        var wrapper = new WrapperPlayServerSoundEffect(event);
        var effectPosition = wrapper.getEffectPosition();

        // Not accurate, but it's the only way we can find the hurt player
        // Because PacketType.Play.Server.ENTITY_SOUND_EFFECT is not triggered when someone hurt.
        var matchingWatcher = registry.findActiveWatcherAtSoundPosition(
                targetPlayer.getWorld(),
                effectPosition.x,
                effectPosition.y,
                effectPosition.z);

        if (matchingWatcher == null || matchingWatcher.getEntityType() == EntityType.PLAYER)
            return;

        event.markForReEncode(true);

        var sound = wrapper.getSound().getSoundId();
        var path = sound.toString();

        if (path.endsWith(".hurt")
                || path.endsWith(".hurt_on_fire")
                || path.endsWith(".hurt_drown")
                || path.endsWith(".hurt_freeze")
                || path.endsWith(".hurt_sweet_berry_bush"))
        {
            var soundId = EntityTypeUtils.getDamageSoundKey(matchingWatcher.getEntityType());
            if (soundId == null) return;

            ResourceLocation rL = new ResourceLocation(soundId);

            wrapper.setSound(new StaticSound(rL, wrapper.getVolume()));
        }
    }
}
