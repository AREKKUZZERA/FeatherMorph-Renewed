package xyz.nifeather.morph;

import java.util.Set;

public final class SupportedMinecraftVersions
{
    public static final String PRIMARY = "26.1.2";

    public static final Set<String> RUNTIME_COMPATIBLE = Set.of(
            PRIMARY,
            "1.21",
            "1.21.1",
            "1.21.2",
            "1.21.3",
            "1.21.4",
            "1.21.5",
            "1.21.6",
            "1.21.7",
            "1.21.8",
            "1.21.9",
            "1.21.10",
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
