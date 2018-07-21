[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [addLiveAutoSizeMinTextSize](./add-live-auto-size-min-text-size.md)

# addLiveAutoSizeMinTextSize

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.addLiveAutoSizeMinTextSize(size: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Adds a live min text size when sizing the text automatically using
[TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:liveAutoSizeMinTextSize

### Parameters

`size` - the live min scaling text size. If the value is null, then 1 will be set.