#### 🎄 **Christmas Lights Kata**

Implementing Christmas Lights Kata 

Instructions: https://kata-log.rocks/christmas-lights-kata


---

### 🚀 How to Run

```bash
./gradlew run
```

Or run the `Main` class in your IDE.

---

### ✅ What It Does

* Simulates a grid of lights (binary or brightness-based)
* Supports three operations: `turn on`, `turn off`, and `toggle`
* Measures either:

  * Total **number of lights on** (binary mode)
  * Total **brightness** of all lights (brightness mode)

---

### 🧪 Tests

Run tests with:

```bash
./gradlew test
```

All core functionality is tested, including:

* Edge cases
* Toggling logic
* Range validation
* Brightness underflow handling

---

## 💡 LightGrid Variants

This project provides two implementations of the `LightGrid` interface, each modeling a different behavior of the grid system:

### 🔘 `BinaryLightGrid`

* Lights can be either **on (1)** or **off (0)**.
* Repeated `turnOnLights` or `turnOffLights` calls have **no additional effect** if the light is already in that state.
* `toggleLights` flips the state: on becomes off, and off becomes on.
* `measureLights()` returns the **number of lights that are on**.

### 🔆 `BrightnessLightGrid`

* Each light has a **brightness level** (a non-negative integer).
* `turnOnLights` increases the brightness by 1.
* `turnOffLights` decreases the brightness by 1, **but not below 0**.
* `toggleLights` increases the brightness by 2.
* `measureLights()` returns the **total brightness across the grid**.

---

### 📘 Notes

* Designed for easy extension and reuse
* Follows SOLID principles
* `Point` is implemented as a Java record (immutable)
* `GridUtils` handles reusable validation and iteration logic
