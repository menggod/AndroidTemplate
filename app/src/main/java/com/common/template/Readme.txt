https://mubu.com/doc/i3ws1cNMo0  关联文件说明


app          主app项目
baselib     基础的组件 含(网络 沉浸式 net 基类 工具 图片选择器等 )

pluginlib    构想是后期引入???
scaffold   装载集成可被调用页面,集成页面基于baselib  ???

--------------------说明----------------------
功能性库:不以module的方式存在  而是以package的形式存在(例如:图片选择库).
集成页面:功能独立,以package的形式存在,m v p 存在同一个包下(例如:闪屏,引导页面,设置页面).
以上为后期项目工程文件增删提供清晰界线.


--------------------三方说明------------------
banner  https://github.com/bingoogolapple/BGABanner-Android
smartRefreshLayout  https://github.com/scwang90/SmartRefreshLayout


--------------------集成功能-------------------
权限  沉浸式  splash  guide  setting页面 rxjava retrofit  基于glide二次封装
