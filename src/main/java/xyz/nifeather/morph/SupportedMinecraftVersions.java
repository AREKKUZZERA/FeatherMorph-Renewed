package xyz.nifeather.morph;

import java.util.Set;

public final class SupportedMinecraftVersions
{
    public static final String PRIMARY = "26.1.2";

    public static final Set<String> RUNTIME_COMPATIBLE = Set.of(
            PRIMARY,
            "1.21.11",
            "26.1",
            "26.1.1"
    );

    private SupportedMinecraftVersions()
    {
    }

    public static boolean isRuntimeCompatible(String version)
    {
        return RUNTIME_COMPATIBLE.contains(version);
    }
}
