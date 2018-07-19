[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [setMutableCapitalize](./set-mutable-capitalize.md)

# setMutableCapitalize

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.setMutableCapitalize(capitalize: MutableLiveData<`[`Capitalize`](https://developer.android.com/reference/android/text/method/TextKeyListener/Capitalize.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies that this [TextView](https://developer.android.com/reference/android/widget/TextView.html) has a textual input method and should automatically apply the
value of the specified mutable capitalize method when the user types.

**Related XML attribute:** app:mutableCapitalize

### Parameters

`capitalize` - the mutable capitalize method to apply on the [TextView](https://developer.android.com/reference/android/widget/TextView.html)