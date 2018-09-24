【Android群英传】学习笔记（三·二）
---
> 上一节中，笔记记录了Android中的ListView的基本使用，这一节笔者将继续记录关于ListView使用的一些技巧

---
## 一、动态更新ListView的数据

> 当修改了传递给Adapter的映射List之后，只需要通过Adapter的`notifyDataSetChanged()`方法，通知ListView更改数据源即可完成对ListViw的动态修改

```Java
main_btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friendList.add(new Friend(R.mipmap.ic_launcher,"Android机器人","Android机器人前来报到"));
                friendsAdapter.notifyDataSetChanged();
                main_lv_friends.setSelection(friendList.size()-1);
            }
        });
```

## 二、遍历ListView中的所有Item

> ListView作为一个ViewGroup，为我们提供了操纵子View的各种方法，最常用的就是通过getChildAt()方法来获取第i个子View

```Java
        //遍历ListView中的所有Item
        for (int i =0;i<main_lv_friends.getChildCount();i++){
            View view = main_lv_friends.getChildAt(i);
        }

```

## 三、处理空ListView

> ListView用于展示列表数据，但当列表无数据时，ListView不会显示任何数据和提示，按照完善用户体验的需求，这里应该给以无数据的显示。幸好，ListView提供了一个方法 --  `setEmptyView()`

```Java
   main_lv_friends.setEmptyView(View emptyView);
```