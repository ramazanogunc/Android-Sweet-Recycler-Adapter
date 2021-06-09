# Android Sweet Recycler Adapter
[![](https://jitpack.io/v/ramazanogunc/Android-Sweet-Recycler-Adapter.svg)](https://jitpack.io/#ramazanogunc/Android-Sweet-Recycler-Adapter) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Android Sweet Recycler Adapter is a custom Recycler adapter. It provide convenience for create custom Recycler adapter and item on Click callback. 

# Usage
Add jitpack repository in the project build.gradle
```
allprojects {
 repositories {
   maven { url 'https://jitpack.io' }
  }
}
```
Add module dependecy 
```
implementation 'com.github.ramazanogunc:Android-Sweet-Recycler-Adapter:2.0.1'
```
Kotlin code
```
//params => context, item layout id, list

val sweetRecyclerAdapter = SweetRecyclerAdapter<ExampleModel>()
// Add view holder bind
sweetRecyclerAdapter.addHolder(R.layout.item1) { view, item ->
    val vb = Item1Binding.bind(view)
    vb.tw1.text = item.text
}
sweetRecyclerAdapter.addHolder(R.layout.item2) { view, item ->
    val vb = Item2Binding.bind(view)
    vb.l2tw1.text = item.text
}

// optional
sweetRecyclerAdapter.setOnItemClickListener { v, item ->
    Toast.makeText(this, "denemee", Toast.LENGTH_SHORT).show()
}

recyclerView.adapter = sweetRecyclerAdapter
```
Kotlin code
```
// ViewTypeListener return value match holder layout id
data class ExampleModel(val viewType: Int, val text: String) : ViewTypeListener {
    override fun getRecyclerItemLayoutId(): Int {
        return if (viewType == 0) R.layout.item1
        else R.layout.item2
    }
}
```

# License
[APACHE](http://www.apache.org/licenses/LICENSE-2.0)
