Maintained fork of FeatherMorph by arekkuzzera.

![cover](./assets/cover.png)

<div align="center">

[Documents (WIP)](./docs)

</div>

---
![CI Status](https://github.com/AREKKUZZERA/FeatherMorph/actions/workflows/build.yml/badge.svg)
![Release](https://img.shields.io/github/release/AREKKUZZERA/FeatherMorph.svg)
[![Ask DeepWiki](https://deepwiki.com/badge.svg)](https://deepwiki.com/AREKKUZZERA/FeatherMorph)

### Features

This plugin allows you and your friends to disguise as various mobs and players in-game. Several disguise forms also have their corresponding skills and abilities in addition.

If also installed the Client integration mod, you can also have a GUI disguise selection screen and skill/actions hotkey.

We also support sending messages to players depending on their client language selection.

### Support
You can seek support on our issues page by opening a new bug report or feature request.

We may use NMS and new APIs introduced in various versions while developing FeatherMorph, making it hard to support all Minecraft versions at once.

Therefore, we can only support the latest one or two Minecraft releases, sorry!

### Dependencies

FeatherMorph requires these things to work:

- A Paper or Paper-based server.

To display disguise server-side, we also need these plugins, depending on which plugin version you're on.

#### 2.x
- [PacketEvents 2.8.0](https://modrinth.com/plugin/packetevents)

#### 1.x
- [ProtocolLib](https://ci.dmulloy2.net/job/ProtocolLib)

#### 0.x
- [ProtocolLib](https://ci.dmulloy2.net/job/ProtocolLib)
- [LibsDisguises](https://www.spigotmc.org/resources/libs-disguises-free.81/)

### Download

[![Available on GitHub](https://raw.githubusercontent.com/intergrav/devins-badges/v3/assets/cozy/available/github_vector.svg)](https://github.com/AREKKUZZERA/FeatherMorph/releases)

[GitHub Releases](https://github.com/AREKKUZZERA/FeatherMorph/releases)

---

### Getting started

See [Gameplay](./docs/Gameplay.md).

---
### Building
```bash
#!/usr/bin/env bash
git clone https://github.com/AREKKUZZERA/FeatherMorph
cd FeatherMorph

./gradlew build --no-daemon
```

The file located at `build/libs` that ends with `-final` is the file that you should use.

To build for a specific Minecraft target, pass `mc_target`:

```bash
./gradlew build --no-daemon -Pmc_target=26.1.2
```

Supported build targets are `1.21.11`, `26.1`, `26.1.1`, and `26.1.2`.

In PowerShell, quote the property to avoid splitting version numbers:

```powershell
./gradlew build --no-daemon "-Pmc_target=26.1.2"
```

### Credits
- Original FeatherMorph project by MATRIX-feather / NiFeather:
  [Modrinth project](https://modrinth.com/plugin/feathermorph),
  [MATRIX-feather on Modrinth](https://modrinth.com/user/MATRIX-feather),
  [original GitHub repository](https://github.com/NiFeather/FeatherMorph).
  This fork keeps the original license terms; see [LICENSE](./LICENSE).
- [LibsDisguises](https://github.com/libraryaddict/LibsDisguises): For making this project possible, and for reference about how to make the server renderer
- [VeinMiner](https://github.com/2008Choco/VeinMiner): For the reference about how to implement *Client <-> Server* communication.
- [ProtocolLib](https://github.com/dmulloy2/ProtocolLib): For making server renderer possible in 1.x releases
- [Paper docs](https://docs.papermc.io/): For how to make paper plugins
- [PacketEvents](https://github.com/retrooper/packetevents): For making server renderer possible
