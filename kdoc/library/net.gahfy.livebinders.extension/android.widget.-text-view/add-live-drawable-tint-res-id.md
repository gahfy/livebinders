[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [addLiveDrawableTintResId](./add-live-drawable-tint-res-id.md)

# addLiveDrawableTintResId

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.addLiveDrawableTintResId(tint: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Adds a live tint list to apply to the compound drawables of the TextView.

The expected value for the Live Data is the resource id of a Color resource.

**Related XML attribute:** app:liveDrawableTint

### Parameters

`tint` - the live tint list to apply to the compound drawables of the TextView