[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [addLiveAutoSizeStepGranularity](./add-live-auto-size-step-granularity.md)

# addLiveAutoSizeStepGranularity

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.addLiveAutoSizeStepGranularity(granularity: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Adds a live auto-size step size (in pixels).

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:liveAutoSizeStepGranularity

### Parameters

`granularity` - the live auto-step size.