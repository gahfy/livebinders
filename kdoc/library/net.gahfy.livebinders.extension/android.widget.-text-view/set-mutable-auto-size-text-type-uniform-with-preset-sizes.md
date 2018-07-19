[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [setMutableAutoSizeTextTypeUniformWithPresetSizes](./set-mutable-auto-size-text-type-uniform-with-preset-sizes.md)

# setMutableAutoSizeTextTypeUniformWithPresetSizes

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.setMutableAutoSizeTextTypeUniformWithPresetSizes(sizes: MutableLiveData<`[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies the mutable preset sizes (in pixels) when sizing the text automatically using
[TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:mutableAutoSizePresetSizes

### Parameters

`sizes` - a mutable int array of sizes in pixels.