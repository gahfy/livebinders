[library](../index.md) / [net.gahfy.livebinders.databinding](index.md) / [setMutableAutoSizePresetSizes](./set-mutable-auto-size-preset-sizes.md)

# setMutableAutoSizePresetSizes

`fun setMutableAutoSizePresetSizes(textView: `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`, sizes: MutableLiveData<`[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies the mutable preset sizes (in pixels) when sizing the text automatically using
[TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:mutableAutoSizePresetSizes

### Parameters

`textView` - the TextView on which to apply the mutable preset sizes.

`sizes` - a mutable int array of sizes in pixels.

**See Also**

[TextView.setAutoSizeTextTypeUniformWithPresetSizes](https://developer.android.com/reference/android/widget/TextView.html#setAutoSizeTextTypeUniformWithPresetSizes(int[], int))

