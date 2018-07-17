[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [setMutableAutoSizeMinTextSize](./set-mutable-auto-size-min-text-size.md)

# setMutableAutoSizeMinTextSize

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.setMutableAutoSizeMinTextSize(size: MutableLiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies the mutable min text size when sizing the text automatically using
[TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:mutableAutoSizeMinTextSize

### Parameters

`size` - the mutable min scaling text size. If the value is null, then 1 will be set.

### Exceptions

`IllegalArgumentException` - if the value of size is equal or lower than 0

**See Also**

[TextView.setAutoSizeTextTypeUniformWithConfiguration](https://developer.android.com/reference/android/widget/TextView.html#setAutoSizeTextTypeUniformWithConfiguration(int, int, int, int))

