Android官方提供的Sample，是学习Android 非常好的帮手。
其中demo的文件结构以ADT的结构为准，保持不变，但会添加Gradle脚本来让它运行在AndroidStudio环境中。
会添加自己的一些注解和标记，可能还会添加一些中文的国际化。


admin:管理员相关，工作空间 工作模式，多用户：
	1.

system:动态权限申请：
	1.system/RuntimePermissions
	2.system/RuntimePermissionBasic



数据绑定：mvvm
	1.BindingDemo

弹出菜单：PopupMenu: 列表弹出菜单：悬浮菜单
	1.popup_menu\ActionBarCompat-ListPopupMenu


animation:动画
	1.BasicTransition ： 场景动画
		Scene 封装了属性动画，根据前后的状态，自动生成动画


other:其他小应用：
	1.Compass: 指南针
	2.BusinessCard : 选取联系人

jni-ndk:nji-ndk
	1.SimpleJNI ：简单demo
	2.

组件:widget 
	1.RecyclerView  recyclerView recyclerview
	2.DoneBar  :CardView 卡片视图。自定义ActionBar  implements "com.android.support:cardview-v7:26.1.0"
	3.CardView 卡片视图 动态设置 卡片视图的属性
	4.


security:安全
	1.FingerprintDialog ： 指纹、支付


App:应用
	1.AppShortcuts:快捷方式： 动态增加一些快捷方式，长按桌面icon弹出来的列表选项
	
fontFamily:字体相关的
	1.DownloadableFonts 切换字体，对指定的文字动态设置字体

game:一些游戏
	1.LunarLander 飞行游戏
	2.JetBoy 游戏

background:后台相关
	1.JobScheduler 

media：媒体相关
	1.BasicMediaRouter 多屏 双屏异显
	2.