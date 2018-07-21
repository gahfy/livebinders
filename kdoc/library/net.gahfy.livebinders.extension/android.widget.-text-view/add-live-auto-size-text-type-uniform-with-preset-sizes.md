[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [addLiveAutoSizeTextTypeUniformWithPresetSizes](./add-live-auto-size-text-type-uniform-with-preset-sizes.md)

# addLiveAutoSizeTextTypeUniformWithPresetSizes

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.addLiveAutoSizeTextTypeUniformWithPresetSizes(sizes: LiveData<`[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Adds a live preset sizes (in pixels) when sizing the text automatically using
[TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:liveAutoSizePresetSizes

### Parameters

`sizes` - a live int array of sizes in pixels.