【Android群英传】学习笔记（三·一）
---
> 本篇笔记中，笔者将记录在ListView的使用的技巧
> 虽然5.X时代，RecyclerView在很多地方都在逐渐取代ListView，但ListView的使用范围还是很广泛的，它这万年老大哥的地位也不是轻易就能撼动的

---
### 一、使用ViewHolder模式提高效率

> ViewHolder模式充分利用ListView的视图缓存机制，避免了每次在调用getView()的时候都去通过findViewById()实例化控件，据测试，使用ViewHolder模式将提高50%以上的效率

```JAVA

/**
 * Created by monsterLin on 2016/9/2.
 */

public class FriendsAdapter extends BaseAdapter {
    private List<Friend> friendList ;
    private Context mContext ;
    private LayoutInflater mInflater ;

    public FriendsAdapter(List<Friend> friendList, Context mContext) {
        this.friendList = friendList;
        this.mContext = mContext;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return friendList.size();
    }

    @Override
    public Object getItem(int position) {
        return friendList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FriendVHolder friendVHolder = null;
        //判断是否缓存
        if (convertView==null){
            friendVHolder=new FriendVHolder();
            //实例化布局
            convertView=mInflater.inflate(R.layout.item_friend,null);
            friendVHolder.item_friend_civ_photo= (CircleImageView) convertView.findViewById(R.id.item_friend_civ_photo);
            friendVHolder.item_friend_tv_nick= (TextView) convertView.findViewById(R.id.item_friend_tv_nick);
            friendVHolder.item_friend_tv_motto= (TextView) convertView.findViewById(R.id.item_friend_tv_motto);
            convertView.setTag(friendVHolder);

        }else {
            //通过tag找到缓存的布局
            friendVHolder= (FriendVHolder) convertView.getTag();
        }

        //设置布局中控件要显示的视图
        friendVHolder.item_friend_civ_photo.setImageResource(friendList.get(position).getResId());
        friendVHolder.item_friend_tv_nick.setText(friendList.get(position).getNick());
        friendVHolder.item_friend_tv_motto.setText(friendList.get(position).getMotto());

        return convertView;
    }

    public final class FriendVHolder{
        public CircleImageView item_friend_civ_photo;
        public TextView item_friend_tv_nick , item_friend_tv_motto;
    }
}

```

### 二、设置项目间的分割线

> 系统提供了`dividerHeight`和`divider`这两个属性帮助我们实现这一功能

```XML
        android:divider="@color/colorAccent"
        android:dividerHeight="8dp"
```

> 特殊情况下，当设置分割线为如下代码时，就可以把分割线设置为透明了

```XML
        android:divider="@null"
```

### 三、隐藏ListView的滚动条

> 可以通过设置scrollbars进行设置

```XML
        android:scrollbars="none"
```

### 四、取消ListView的点击效果

> 在Android 5.X以上是一个水滴反馈的效果
> 在Android 5.X以下则是一个改变背景色的效果，但可以通过listSelector属性来取消掉点击后的回馈效果

```XML
        android:listSelector="#00000000"
```

> 当然，也可以直接使用Android自带的透明色来实现这个效果

```XML
        android:listSelector="@android:color/transparent"
```



### 五、设置ListView要显示在第几项

> ListView以Item为单位进行显示，默认显示在第一个Item，当需要指定显示的Item时，可以通过下面代码实现

```Java
        listview.setSection(N);  //N就是需要显示的第N个Item
```

> 当然类似方法还有scrollTo ,是瞬间完成的移动。除此之前，还可以使用如下代码实现平滑移动

```Java
        listview.smoothScrollBy( distance,  duration);
        listview.smoothScrollByOffset(offset);
        listview.smoothScrollToPosition(index);
```
