[library](../index.md) / [net.gahfy.livebinders.databinding](index.md) / [setMutableCapitalize](./set-mutable-capitalize.md)

# setMutableCapitalize

`fun setMutableCapitalize(textView: `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`, capitalize: MutableLiveData<`[`Capitalize`](https://developer.android.com/reference/android/text/method/TextKeyListener/Capitalize.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies that the specified [TextView](https://developer.android.com/reference/android/widget/TextView.html) has a textual input method and should automatically apply
the value of the specified mutable capitalize method when the user types.

**Related XML attribute:** app:mutableCapitalize

### Parameters

`textView` - the [TextView](https://developer.android.com/reference/android/widget/TextView.html) on which to apply the mutable capitalize method.

`capitalize` - the mutable capitalize method to apply on the [TextView](https://developer.android.com/reference/android/widget/TextView.html)