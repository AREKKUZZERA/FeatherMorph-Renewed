# Changelog

## 2.9.1

### Fixed
- Fixed Minecraft target metadata in generated jars so Modrinth can detect each uploaded file separately.
- Set `paper-plugin.yml` `api-version` from the selected `mc_target` instead of always using `1.21`.
- Added explicit jar manifest metadata for the selected Minecraft target, API version, and Paper dev bundle.
- Corrected Paper dev bundle selection for supported Minecraft targets.

### Changed
- Supported build targets are now `1.21.11`, `26.1`, `26.1.1`, and `26.1.2`.
- Updated the default `26.1.2` build to use `26.1.2.build.72-stable`.
- Removed unsupported older `1.21` targets from the build/runtime support list.

### Build Targets
- `1.21.11` uses Paper dev bundle `1.21.11-R0.1-SNAPSHOT`.
- `26.1` uses Paper dev bundle `26.1.1.build.29-alpha`.
- `26.1.1` uses Paper dev bundle `26.1.1.build.29-alpha`.
- `26.1.2` uses Paper dev bundle `26.1.2.build.72-stable`.
