[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [setMutableAutoSizeMaxTextSize](./set-mutable-auto-size-max-text-size.md)

# setMutableAutoSizeMaxTextSize

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.setMutableAutoSizeMaxTextSize(size: MutableLiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies the mutable max text size when sizing the text automatically using
[TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:mutableAutoSizeMaxTextSize

### Parameters

`size` - the mutable max scaling text size. If the value is null, then 2000 will be set.

### Exceptions

`IllegalArgumentException` - if the value of [size](set-mutable-auto-size-max-text-size.md#net.gahfy.livebinders.extension$setMutableAutoSizeMaxTextSize(android.widget.TextView, androidx.lifecycle.MutableLiveData((kotlin.Int)))/size) is equal or lower than 0

**See Also**

[TextView.setAutoSizeTextTypeUniformWithConfiguration](https://developer.android.com/reference/android/widget/TextView.html#setAutoSizeTextTypeUniformWithConfiguration(int, int, int, int))

