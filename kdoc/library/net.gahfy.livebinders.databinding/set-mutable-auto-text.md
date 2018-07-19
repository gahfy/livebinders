[library](../index.md) / [net.gahfy.livebinders.databinding](index.md) / [setMutableAutoText](./set-mutable-auto-text.md)

# setMutableAutoText

`fun setMutableAutoText(textView: `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`, autoText: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies that the specified [TextView](https://developer.android.com/reference/android/widget/TextView.html) has a textual input method and whether it automatically
corrects some common spelling errors.

**Related XML attribute:** app:mutableAutoText

### Parameters

`textView` - the [TextView](https://developer.android.com/reference/android/widget/TextView.html) on which to apply the mutable auo correct method.

`autoText` - the mutable auto correct to apply on the [TextView](https://developer.android.com/reference/android/widget/TextView.html)