[library](../index.md) / [net.gahfy.livebinders.databinding](index.md) / [setMutableAutoLinkMask](./set-mutable-auto-link-mask.md)

# setMutableAutoLinkMask

`fun setMutableAutoLinkMask(textView: `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`, mask: MutableLiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets the mutable autolink mask of the text. See [Linkify.ALL](https://developer.android.com/reference/android/text/util/Linkify.html#ALL) and peers for possible
values.

Avoid using [Linkify.MAP_ADDRESSES](https://developer.android.com/reference/android/text/util/Linkify.html#MAP_ADDRESSES) as value as this value is deprecated.

**Related XML attribute:** app:mutableAutoLink

### Parameters

`textView` - the TextView on which to apply the mutable autolink mask

`mask` - the mutable autolink mask. The value must be one of [null](#), [Linkify.ALL](https://developer.android.com/reference/android/text/util/Linkify.html#ALL),
[Linkify.EMAIL_ADDRESSES](https://developer.android.com/reference/android/text/util/Linkify.html#EMAIL_ADDRESSES), [Linkify.EMAIL_ADDRESSES](https://developer.android.com/reference/android/text/util/Linkify.html#EMAIL_ADDRESSES), [Linkify.PHONE_NUMBERS](https://developer.android.com/reference/android/text/util/Linkify.html#PHONE_NUMBERS), [Linkify.WEB_URLS](https://developer.android.com/reference/android/text/util/Linkify.html#WEB_URLS)

**See Also**

[TextView.setAutoLinkMask](https://developer.android.com/reference/android/widget/TextView.html#setAutoLinkMask(int))

