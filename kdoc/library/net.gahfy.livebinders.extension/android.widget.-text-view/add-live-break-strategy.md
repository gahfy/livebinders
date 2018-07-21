[library](../../index.md) / [net.gahfy.livebinders.extension](../index.md) / [android.widget.TextView](index.md) / [addLiveBreakStrategy](./add-live-break-strategy.md)

# addLiveBreakStrategy

`fun `[`TextView`](https://developer.android.com/reference/android/widget/TextView.html)`.addLiveBreakStrategy(breakStrategy: LiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Adds a live break strategy for breaking paragraphs into lines.

The value must be one of [Layout.BREAK_STRATEGY_SIMPLE](https://developer.android.com/reference/android/text/Layout.html#BREAK_STRATEGY_SIMPLE), [Layout.BREAK_STRATEGY_HIGH_QUALITY](https://developer.android.com/reference/android/text/Layout.html#BREAK_STRATEGY_HIGH_QUALITY) or
[Layout.BREAK_STRATEGY_BALANCED](https://developer.android.com/reference/android/text/Layout.html#BREAK_STRATEGY_BALANCED).

**Related XML attribute:** app:liveBreakStrategy

### Parameters

`breakStrategy` - the live break strategy to apply on the [TextView](https://developer.android.com/reference/android/widget/TextView.html)