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
implementation 'com.github.ramazanogunc:Android-Sweet-Recycler-Adapter:1.0.0'
```
Java code
```
//params => context, item layout id, list
SweetRecyclerAdapter<String> sweetRecyclerAdapter = new SweetRecyclerAdapter<>(this, R.layout.item, list);

//required method
sweetRecyclerAdapter.setItemView(new ISetItemView<String>() {
    @Override
    public void setItemView(View v, String item) {
        //set Item data
        
        //exmaple
        TextView textView = v.findViewById(R.id.tw);
        textView.setText(item);
    }
});

// not required
sweetRecyclerAdapter.setOnRecyclerItemClickListener(new IOnRecyclerItemClickListener<String>() {
    @Override
    public void onRecyclerItemListener(View v, String item) {
        //on item click mode
    }
});

recyclerView.setAdapter(sweetRecyclerAdapter);
```

# License
[APACHE](http://www.apache.org/licenses/LICENSE-2.0)
