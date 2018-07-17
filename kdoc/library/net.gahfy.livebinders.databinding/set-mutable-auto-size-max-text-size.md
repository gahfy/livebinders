[library](../index.md) / [net.gahfy.livebinders.databinding](index.md) / [setMutableAutoSizeMaxTextSize](./set-mutable-auto-size-max-text-size.md)

# setMutableAutoSizeMaxTextSize

`fun setMutableAutoSizeMaxTextSize(textView: `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`, size: MutableLiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies the mutable max text size (in pixels) when sizing the text automatically using
[TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:mutableAutoSizeMaxTextSize

### Parameters

`textView` - the TextView on which to apply the mutable max scaling text size.

`size` - the mutable max scaling text size. If the value is null, then 2000 will be set.

### Exceptions

`IllegalArgumentException` - if the value of size is equal or lower than 0

**See Also**

[TextView.setAutoSizeTextTypeUniformWithConfiguration](https://developer.android.com/reference/android/widget/TextView.html#setAutoSizeTextTypeUniformWithConfiguration(int, int, int, int))

