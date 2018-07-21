[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [addLiveAutoLinkMask](./add-live-auto-link-mask.md)

# addLiveAutoLinkMask

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.addLiveAutoLinkMask(mask: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Adds a live autolink mask of the text. See [Linkify.ALL](https://developer.android.com/reference/android/text/util/Linkify.html#ALL) and peers for possible
values.

Avoid using [Linkify.MAP_ADDRESSES](https://developer.android.com/reference/android/text/util/Linkify.html#MAP_ADDRESSES) as value as this value is deprecated.

**Related XML attribute:** app:liveAutoLink

### Parameters

`mask` - the live autolink mask. The value must be one of null, [Linkify.ALL](https://developer.android.com/reference/android/text/util/Linkify.html#ALL),
[Linkify.EMAIL_ADDRESSES](https://developer.android.com/reference/android/text/util/Linkify.html#EMAIL_ADDRESSES), [Linkify.MAP_ADDRESSES](https://developer.android.com/reference/android/text/util/Linkify.html#MAP_ADDRESSES), [Linkify.PHONE_NUMBERS](https://developer.android.com/reference/android/text/util/Linkify.html#PHONE_NUMBERS),
[Linkify.WEB_URLS](https://developer.android.com/reference/android/text/util/Linkify.html#WEB_URLS), or 0