[library](../index.md) / [net.gahfy.livebinders.databinding](./index.md)

## Package net.gahfy.livebinders.databinding

Contains `@DataBinder` methods to be used with DataBinding

### Functions

| Name | Summary |
|---|---|
| [setClickListener](set-click-listener.md) | `fun setClickListener(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`, l: `[`OnClickListener`](https://developer.android.com/reference/android/view/View/OnClickListener.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Call [View.setOnClickListener](https://developer.android.com/reference/android/view/View.html#setOnClickListener(android.view.View.OnClickListener)) |
| [setMutableAutoLinkMask](set-mutable-auto-link-mask.md) | `fun setMutableAutoLinkMask(textView: `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`, mask: MutableLiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Sets the mutable autolink mask of the text. See [Linkify.ALL](https://developer.android.com/reference/android/text/util/Linkify.html#ALL) and peers for possible values. |
| [setMutableAutoSizeMaxTextSize](set-mutable-auto-size-max-text-size.md) | `fun setMutableAutoSizeMaxTextSize(textView: `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`, size: MutableLiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Specifies the mutable max text size when sizing the text automatically using [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling. |
