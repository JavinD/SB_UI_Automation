# Emulator Optimization Guide

If you must use an emulator, here's how to make it **3-5x faster**:

## 🚀 Quick Optimizations

### 1. Use x86/x86_64 System Image (Not ARM)
- x86 images are **10x faster** than ARM
- Check AVD Manager → System Image → select x86_64

### 2. Increase RAM & CPU
Open **AVD Manager** → Edit your emulator:
```
RAM: 4096 MB (4GB) minimum
VM Heap: 512 MB
Internal Storage: 2048 MB
CPU Cores: 4 (half of your CPU cores)
```

### 3. Enable Hardware Acceleration

#### Windows (Intel CPU):
```powershell
# Install Intel HAXM
# Download from: https://github.com/intel/haxm/releases

# Or via Android Studio SDK Manager
```

#### Windows (AMD CPU):
```powershell
# Enable Hyper-V in Windows Features
# Android Studio will use WHPX (Windows Hypervisor Platform)
```

### 4. Disable Animations
```powershell
# Connect to emulator
adb shell settings put global window_animation_scale 0
adb shell settings put global transition_animation_scale 0
adb shell settings put global animator_duration_scale 0
```

### 5. Use Cold Boot Avoidance
In AVD Manager → Edit:
- **Boot option**: Quick Boot (not Cold Boot)
- This saves emulator state between runs

### 6. Close Unused Emulators
```powershell
# List running emulators
adb devices

# Kill specific emulator
adb -s emulator-5554 emu kill
```

### 7. Use Headless Mode (for CI/CD)
```powershell
emulator -avd YOUR_AVD_NAME -no-window -no-audio -no-boot-anim
```

### 8. Lightweight Android Version
- Use **Android 11** or **Android 12** (not latest)
- Avoid Google Play images (use Google APIs instead)
- Less bloat = faster performance

## Update DriverManager for Speed

Add these options to `DriverManager.java`:

```java
// Speed optimizations
options.setSkipDeviceInitialization(false);
options.setSkipServerInstallation(true);  // Skip reinstalling server each time
options.setSkipUnlock(true);  // Skip unlock screen
options.setNoReset(true);  // Don't reset app data between tests

// Disable animations via capabilities
options.setCapability("settings[disableWindowAnimation]", true);
```

## Create a Fast Emulator Profile

```powershell
# Create new AVD optimized for speed
avdmanager create avd -n FastEmulator -k "system-images;android-31;google_apis;x86_64" -d pixel_4
```

Recommended specs:
- **Device**: Pixel 4 or similar (not tablet)
- **System Image**: API 31 (Android 12), x86_64, Google APIs
- **RAM**: 4096 MB
- **Internal Storage**: 2048 MB
- **Graphics**: Hardware (not Software)

## Performance Comparison

| Configuration | App Launch | Test Suite (10 tests) |
|--------------|------------|----------------------|
| Default Emulator | 15-20s | 10-15 min |
| Optimized Emulator | 5-8s | 4-6 min |
| Real Device | 2-3s | 2-3 min |

## Still Slow?

Consider these alternatives:
1. **Genymotion** - Commercial emulator (much faster)
2. **Real Device** - Always the fastest option
3. **Cloud Services** - BrowserStack, Sauce Labs

