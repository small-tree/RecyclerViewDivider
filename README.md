# RecyclerViewDivider
recyclerview 添加分割线，支持 LinearlayoutManager，GridLayoutManager。 divider

### 引入
只需要复制 ListDivider、GridDivider 到项目中，不需要引入任何其他东西

### 使用
list 形式和 grid 形式，都是使用 build 形式构建，方便配置参数

#### ListDivider 使用
```
var listDivider = ListDivider.Builder()
    .setDividerHeight(10)   // 设置分割线的高度
    .setDividerColor(Color.parseColor("#66000000")) // 设置分割线的颜色
    .setLeftMargin(DensityUtil.dp2px(this, 10f))    // 设置线到左边的距离，默认 是0
    .setRightMargin(DensityUtil.dp2px(this, 10f))   // 设置线到右边的距离，默认 是0
    .setUnDrawLast(true)    // 设置最后一个条目不画底部分割线，默认是 false （会画）
    .build()
rv_recyclerview.addItemDecoration(listDivider)
```

#### GrudDivider 使用
```
val listDivider = GridDivider.Builder()
    .setDividerWidth(10)    // 设置分割线的高度
    .setDividerColor(Color.parseColor("#55000000")) // 设置分割线的颜色
    .build()
rv_recyclerview.addItemDecoration(listDivider)
```




## 效果图    

![img](https://github.com/small-tree/RecyclerViewDivider/blob/master/img/gridimg.png)
    
![img](https://github.com/small-tree/RecyclerViewDivider/blob/master/img/listImg.png)
