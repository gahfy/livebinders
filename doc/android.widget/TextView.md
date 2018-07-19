# TextView

## Summary

### XML Attributes

| name | description | expected type |
|---|---|---|
| **app:mutableAutoLink** | Mutable version of [**android:autoLink**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:autoLink) | `MutableLiveData<Int>` |
| **app:mutableAutoSizeMaxTextSize** | Mutable version of [**android:autoSizeMaxTextSize**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:autoSizeMaxTextSize) | `MutableLiveData<Int>` |
| **app:mutableAutoSizeMinTextSize** | Mutable version of [**android:autoSizeMinTextSize**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:autoSizeMinTextSize) | `MutableLiveData<Int>` |
| **app:mutableAutoSizePresetSizes** | Mutable version of [**android:autoSizePresetSizes**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:autoSizePresetSizes) | `MutableLiveData<IntArray>` |
| **app:mutableAutoSizeStepGranularity** | Mutable version of [**android:autoSizeStepGranularity**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:autoSizeStepGranularity) | `MutableLiveData<Int>` |
| **app:mutableAutoSizeTextType** | Mutable version of [**android:autoSizeTextType**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:autoSizeTextType) | `MutableLiveData<Int>` |
| **app:mutableAutoText** | Mutable version of [**android:autoText**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:autoText) | `MutableLiveData<Boolean>` |
| **app:mutableBreakStrategy** | Mutable version of [**android:breakStrategy**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:breakStrategy) | `MutableLiveData<TextView.BufferType>` |
| **app:mutableBufferType** | Mutable version of [**android:bufferType**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:bufferType) | `MutableLiveData<Int>` |
| **app:mutableCapitalize** | Mutable version of [**android:capitalize**](https://developer.android.com/reference/android/widget/TextView.html#attr_android:capitalize) | `MutableLiveData<TextKeyListener.Capitalize>` |

### Extension Functions

| description |
|---|
| **setMutableAutoLinkMask(mask: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Sets the mutable autolink mask of the text. See [Linkify.ALL](https://developer.android.com/reference/android/text/util/Linkify.html#ALL) and peers for possible values. |
| **setMutableAutoSizeMinTextSize(size: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Specifies the mutable min text size when sizing the text automatically using [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling. |
| **setMutableAutoSizeMaxTextSize(size: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Specifies the mutable max text size when sizing the text automatically using [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling. |
| **setMutableAutoSizeTextTypeUniformWithPresetSizes(sizes: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Specifies the mutable preset sizes (in pixels) when sizing the text automatically using [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM) scaling. |
| **setMutableAutoSizeStepGranularity(granularity: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Specifies the auto-size step size (in pixels). Overwrites autoSizePresetSizes if set. |
| **setMutableAutoSizeTextTypeWithDefaults(autoSizeTextType: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Specifies a mutable text scaling type, `TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE` or `TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM` |
| **setMutableAutoText(autoText: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Specifies that this [TextView](https://developer.android.com/reference/android/widget/TextView.html) has a textual input method and whether it automatically corrects some common spelling errors. |
| **setMutableBreakStrategy(breakStrategy: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Sets the mutable break strategy for breaking paragraphs into lines. |
| **setMutableBufferType(bufferType: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[TextView.BufferType](https://developer.android.com/reference/android/widget/TextView.BufferType)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Sets the minimum mutable type that getText() will return. |
| **setMutableCapitalize(capitalize: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[TextKeyListener.Capitalize](https://developer.android.com/reference/android/text/method/TextKeyListener.Capitalize)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)**<br><br>Specifies that this [TextView](https://developer.android.com/reference/android/widget/TextView) has a textual input method and should automatically apply the value of the specified mutable capitalize method when the user types. |


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

### setMutableAutoSizeStepGranularity(granularity: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies the auto-size step size (in pixels). Overwrites autoSizePresetSizes if set.

By using this parameter, the scale type will be set to [TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM](https://developer.android.com/reference/android/widget/TextView.html#AUTO_SIZE_TEXT_TYPE_UNIFORM).

**Related XML attribute:** app:mutableAutoSizeStepGranularity

#### Parameters

`granularity` - the mutable auto-step size.

### setMutableAutoSizeTextTypeWithDefaults(autoSizeTextType: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies a mutable text scaling type, `TextViewCompat.AUTO_SIZE_TEXT_TYPE_NONE` or
`TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM`

**Related XML attribute:** app:mutableAutoSizeTextType

#### Parameters

`autoSizeTextType` - the mutable text type

### setMutableAutoText(autoText: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies that this [TextView](https://developer.android.com/reference/android/widget/TextView.html) has a textual input method and whether it automatically corrects
some common spelling errors.

**Related XML attribute:** app:mutableAutoText

#### Parameters

`autoText` - the mutable auto correct to apply on the [TextView](https://developer.android.com/reference/android/widget/TextView.html)

### setMutableBreakStrategy(breakStrategy: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets the mutable break strategy for breaking paragraphs into lines.

The value must be one of [Layout.BREAK_STRATEGY_SIMPLE](https://developer.android.com/reference/android/text/Layout.html#BREAK_STRATEGY_SIMPLE), [Layout.BREAK_STRATEGY_HIGH_QUALITY](https://developer.android.com/reference/android/text/Layout.html#BREAK_STRATEGY_HIGH_QUALITY) or
[Layout.BREAK_STRATEGY_BALANCED](https://developer.android.com/reference/android/text/Layout.html#BREAK_STRATEGY_BALANCED).

**Related XML attribute:** app:mutableBreakStrategy

#### Parameters

`breakStrategy` - the mutable break strategy to apply on the [TextView](https://developer.android.com/reference/android/widget/TextView.html)

### setMutableBufferType(bufferType: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[TextView.BufferType](https://developer.android.com/reference/android/widget/TextView.BufferType)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets the minimum mutable type that getText() will return.

**Related XML attribute:** app:mutableBufferType

#### Parameters

`bufferType` - the mutable type to set to the [TextView](https://developer.android.com/reference/android/widget/TextView.html)

### setMutableCapitalize(capitalize: [MutableLiveData](https://developer.android.com/reference/android/arch/lifecycle/MutableLiveData)&lt;[TextKeyListener.Capitalize](https://developer.android.com/reference/android/text/method/TextKeyListener.Capitalize)&gt;?) : [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Specifies that this [TextView](https://developer.android.com/reference/android/widget/TextView.html) has a textual input method and should automatically apply the
value of the specified mutable capitalize method when the user types.

**Related XML attribute:** app:mutableCapitalize

#### Parameters

`capitalize` - the mutable capitalize method to apply on the [TextView](https://developer.android.com/reference/android/widget/TextView.html)
