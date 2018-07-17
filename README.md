[![Build Status](https://travis-ci.org/gahfy/livebinders.svg)](https://travis-ci.org/gahfy/livebinders)
[![Codecov](https://codecov.io/github/gahfy/livebinders/coverage.svg)](https://codecov.io/gh/gahfy/livebinders)

# LiveBinders Library

[Read Doc](doc/index.md)

[Read KDoc](kdoc/library/index.md)

*This library is currently in development*

The goal of this library is to provide `@BindingAdapter` methods, and extension methods, in order to allow setting:

* `MutableLiveData` to views, for example, being able to set a `MutableLiveData<String>()` as text of a `TextView`
* Variable to views directly in layout with DataBinding, for example: `<View app:clickListener="@{viewModel.clickListener}" />`

## Contributions

Feel free to contribute by sending pull requests.

* All code must have documentation and .md file must be generated with `./gradlew :library:dokka` command
* Code coverage must remain 100%. Check code coverage with `./gradlew :library:createDebugUnitTestCoverageReport :library:createReleaseUnitTestCoverageReport` command, then browse `/library/build/reports/jacoco` folder to check code coverage
