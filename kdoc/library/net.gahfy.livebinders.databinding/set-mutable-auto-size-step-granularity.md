[library](../index.md) / [net.gahfy.livebinders.databinding](index.md) / [setMutableAutoSizeStepGranularity](./set-mutable-auto-size-step-granularity.md)

# setMutableAutoSizeStepGranularity

`fun setMutableAutoSizeStepGranularity(textView: `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`, granularity: MutableLiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies the auto-size step size (in pixels). Overwrites autoSizePresetSizes if set.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:mutableAutoSizeStepGranularity

### Parameters

`textView` - the [TextView](https://developer.android.com/reference/android/widget/TextView.html) on which to apply the mutable preset sizes.

`granularity` - the mutable auto-step size to apply to the [TextView](https://developer.android.com/reference/android/widget/TextView.html)