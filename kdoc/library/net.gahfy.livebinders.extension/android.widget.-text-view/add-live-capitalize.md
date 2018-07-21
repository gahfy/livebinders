[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [addLiveCapitalize](./add-live-capitalize.md)

# addLiveCapitalize

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.addLiveCapitalize(capitalize: LiveData<`[`Capitalize`](https://developer.android.com/reference/android/text/method/TextKeyListener/Capitalize.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies that this [TextView](https://developer.android.com/reference/android/widget/TextView.html) has a textual input method and should automatically apply the
value of the specified live capitalize method when the user types.

**Related XML attribute:** app:liveCapitalize

### Parameters

`capitalize` - the live capitalize method to apply on the [TextView](https://developer.android.com/reference/android/widget/TextView.html)