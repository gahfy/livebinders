# TextView

## Summary

### XML Attributes

| name | description | expected type |
|---|---|---|
| **app:mutableAutoLink** | Mutable version of [**android:autoLink**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:autoLink) | `MutableLiveData<Int>` |
| **app:mutableAutoSizeMaxTextSize** | Mutable version of [**android:autoSizeMaxTextSize**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:autoSizeMaxTextSize) | `MutableLiveData<Int>` |
| **app:mutableAutoSizeMinTextSize** | Mutable version of [**android:autoSizeMinTextSize**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:autoSizeMinTextSize) | `MutableLiveData<Int>` |
| **app:mutableAutoSizePresetSizes** | Mutable version of [**android:autoSizePresetSizes**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:autoSizePresetSizes) | `MutableLiveData<Int>` |

### Extension Functions

| description |
|---|
| **setMutableAutoLinkMask(mask: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Sets the mutable autolink mask of the text. See [Linkify.ALL](https://developer.android.com/reference/android/text/util/Linkify.html#ALL) and peers for possible values. |
| **setMutableAutoSizeMinTextSize(size: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Specifies the mutable min text size when sizing the text automatically using [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling. |
| **setMutableAutoSizeMaxTextSize(size: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Specifies the mutable max text size when sizing the text automatically using [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling. |
| **setMutableAutoSizeTextTypeUniformWithPresetSizes(sizes: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Specifies the mutable preset sizes (in pixels) when sizing the text automatically using [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling. |

## Extension Functions

### setMutableAutoLinkMask(mask: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets the mutable autolink mask of the text. See [Linkify.ALL](https://developer.android.com/reference/android/text/util/Linkify.html#ALL) and peers for possible
values.

Avoid using [Linkify.MAP_ADDRESSES](https://developer.android.com/reference/android/text/util/Linkify.html#MAP_ADDRESSES) as value as this value is deprecated.

**Related XML attribute:** app:mutableAutoLink

#### Parameters

`mask` - the mutable autolink mask. The value must be one of `null`, [Linkify.ALL](https://developer.android.com/reference/android/text/util/Linkify.html#ALL),
[Linkify.EMAIL_ADDRESSES](https://developer.android.com/reference/android/text/util/Linkify.html#EMAIL_ADDRESSES), [Linkify.EMAIL_ADDRESSES](https://developer.android.com/reference/android/text/util/Linkify.html#EMAIL_ADDRESSES), [Linkify.PHONE_NUMBERS](https://developer.android.com/reference/android/text/util/Linkify.html#PHONE_NUMBERS), [Linkify.WEB_URLS](https://developer.android.com/reference/android/text/util/Linkify.html#WEB_URLS)

### setMutableAutoSizeMinTextSize(size: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies the mutable min text size when sizing the text automatically using
[TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:mutableAutoSizeMinTextSize

#### Parameters

`size` - the mutable min scaling text size. If the value is null, then 1 will be set.

#### Exceptions

`IllegalArgumentException` - if the value of size is equal or lower than 0

### setMutableAutoSizeMaxTextSize(size: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies the mutable max text size when sizing the text automatically using
[TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:mutableAutoSizeMaxTextSize

#### Parameters

`size` - the mutable max scaling text size. If the value is null, then 2000 will be set.

#### Exceptions

`IllegalArgumentException` - if the value of size is equal or lower than 0

### setMutableAutoSizeTextTypeUniformWithPresetSizes(sizes: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies the mutable preset sizes (in pixels) when sizing the text automatically using
[TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:mutableAutoSizePresetSizes

#### Parameters

`sizes` - a mutable int array of sizes in pixels.
