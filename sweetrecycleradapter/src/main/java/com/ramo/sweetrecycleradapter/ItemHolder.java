package com.ramo.sweetrecycleradapter;

public class ItemHolder<T> {
    private int resourceId;
    private int viewType;
    private ISetItemView<T> iSetItemView;
    private IOnRecyclerItemClickListener<T> iOnRecyclerItemClickListener;

    public ItemHolder(int resourceId, int viewType, ISetItemView<T> iSetItemView, IOnRecyclerItemClickListener<T> iOnRecyclerItemClickListener) {
        this.resourceId = resourceId;
        this.viewType = viewType;
        this.iSetItemView = iSetItemView;
        this.iOnRecyclerItemClickListener = iOnRecyclerItemClickListener;
    }

    public int getViewType() {
        return viewType;
    }

    public int getResourceId() {
        return resourceId;
    }

    public ISetItemView<T> getiSetItemView() {
        return iSetItemView;
    }

    public IOnRecyclerItemClickListener<T> getiOnRecyclerItemClickListener() {
        return iOnRecyclerItemClickListener;
    }
}
