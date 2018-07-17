[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [setMutableAutoSizeStepGranularity](./set-mutable-auto-size-step-granularity.md)

# setMutableAutoSizeStepGranularity

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.setMutableAutoSizeStepGranularity(granularity: MutableLiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies the auto-size step size (in pixels). Overwrites autoSizePresetSizes if set.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:mutableAutoSizeStepGranularity

### Parameters

`granularity` - the mutable auto-step size.

**See Also**

[TextView.setAutoSizeTextTypeUniformWithConfiguration](https://developer.android.com/reference/android/widget/TextView.html#setAutoSizeTextTypeUniformWithConfiguration(int, int, int, int))

