### Used FancyShowCaseView version

### Screenshot if there is something wrong with ui

### How you show/hide FancyShowCaseView (in Activity or Fragment, in which method)

Example:
In Activity onCreate() method I use the code below to show:
```kotlin
btn_simple.setOnClickListener {
    FancyShowCaseView.Builder(this)
            .title("No Focus")
            .build()
            .show()
}
```

### Your layout.xml file if the focus is wrong
