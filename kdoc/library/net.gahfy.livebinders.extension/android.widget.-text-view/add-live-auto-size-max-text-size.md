[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [addLiveAutoSizeMaxTextSize](./add-live-auto-size-max-text-size.md)

# addLiveAutoSizeMaxTextSize

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.addLiveAutoSizeMaxTextSize(size: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Adds a live max text size when sizing the text automatically using
[TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:liveAutoSizeMaxTextSize

### Parameters

`size` - the live max scaling text size. If the value is null, then 2000 will be set.