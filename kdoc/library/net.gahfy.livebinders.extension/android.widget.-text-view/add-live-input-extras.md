[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [addLiveInputExtras](./add-live-input-extras.md)

# addLiveInputExtras

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.addLiveInputExtras(xmlResId: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Adds the live extra input data of the text, which is the TextBoxAttribute.extras Bundle that will
be filled in when creating an input connection. The given integer value is the resource
identifier of an XML resource holding an &amp;lt;input-extras&amp;gt; XML tree.

### Parameters

`xmlResId` - the live XML resource id holding an &amp;lt;input-extras&amp;gt; XML tree