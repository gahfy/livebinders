[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [addLiveDrawableTintMode](./add-live-drawable-tint-mode.md)

# addLiveDrawableTintMode

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.addLiveDrawableTintMode(colorTintMode: LiveData<`[`Mode`](https://developer.android.com/reference/android/graphics/PorterDuff/Mode.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies the live blending mode used to apply the tint specified by
TextView.setCompoundDrawableTintList() to the compound drawables.

**Related XML attribute:** app:liveDrawableTint

### Parameters

`colorTintMode` - the live blending mode used to apply the tint, value may be null to clear tint