package xyz.nifeather.morph.backends.server.renderer.network.listeners;

import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;

/**
 * Listener used to override the metadata packet, so that the client won't panic when it received player's meta but the player is disguised as a mob.
 */
public class MetaPacketListener extends ProtocolListener
{
    @Override
    public String getIdentifier()
    {
        return "meta_listener";
    }

    @Override
    public void onPacketSend(PacketSendEvent event)
    {
        if (event.getPacketType() != PacketType.Play.Server.ENTITY_METADATA)
            return;

        var wrapper = new WrapperPlayServerEntityMetadata(event);
        this.onMetaPacket(wrapper, event);
    }

    private void onMetaPacket(WrapperPlayServerEntityMetadata packet, PacketSendEvent packetEvent)
    {
        var watcher = getWatcherFrom(packet.getEntityId());
        if (watcher == null)
            return;

        //获取此包的来源实体
        var sourcePlayer = watcher.getBindingPlayer();

        if (sourcePlayer.equals(packetEvent.getPlayer())) return;

        //然后获取此包要发送的目标玩家
        var targetPlayer = packetEvent.getPlayer();

        //只拦截其他人的Meta
        if (targetPlayer.equals(sourcePlayer))
            return;

        var wrapper = new WrapperPlayServerEntityMetadata(packetEvent);

        try
        {
            watcher.handleEntityMetadataPacket(wrapper);
        }
        catch (Exception e)
        {
            handleException(sourcePlayer, watcher, e);
        }
    }
}
