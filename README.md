# Bilibili HD
![Build](https://github.com/duzhaokun123/BilibiliHD/workflows/Build/badge.svg)
[![GitHub license](https://img.shields.io/github/license/duzhaokun123/BilibiliHD)](https://github.com/duzhaokun123/BilibiliHD/blob/dev/LICENSE)

非官方哔哩哔哩客户端

主要是为了解决官方客户端无法横屏和在大屏幕设备上的表现不好的问题

# 警告: 本应用仅供作者交流学习使用, 如被封号与作者无关, 怕被封号请不要使用

## 弃坑警告
该项目随时可能由于包括但不限于以下原因中的的一个或多个而终止
- 高考
- 电脑坏了
- 历史遗留问题太多，不想解决
- 官方封锁API


下载 https://pan.baidu.com/s/1usDwGbrNi9zAZ1AWU8G7dQ 密码: v9oa (随缘更新)

下载 https://wws.lanzous.com/b01tqmbej 密码: 233 (最新提交, 所有密码: 233)

- v0.1 https://wws.lanzous.com/b01tqpnaf 密码: 233

下载 https://github.com/duzhaokun123/BilibiliHD/releases (重要发布)

~~不再打包32位原生库, 有需求请自行编译~~不再存在原生库

建议配合[web端哔哩哔哩](https://www.bilibili.com)使用

暂且不建议屏幕较小或没有触摸屏的用户使用

### 将支持的功能
- [x] 多用户登录 (不完全, 无法通过验证, 不总是影响登录, 这因该是`bilibili-api`的问题, 多用户登录理论上实现)
- [x] 横屏
- [ ] 用户信息页 (可使用 WebView)
    - [ ] 主页
    - [ ] 动态
    - [ ] 投稿 (?)
    - [x] 收藏
- [x] 首页推荐
- [x] 动态 (WebView)
- [x] 专栏 (WebView)
- [ ] 视频
    - [ ] 播放
        - [x] 能播出来
        - [x] 控制清晰度
        - [x] 播放器控制换p
        - [x] 拖动时预览
        - [x] 倍速
        - [x] 精准空降
        - [ ] 屏幕滑动进度控制
        - [x] 远程播放 (仅在本机通过模拟辅助显示设备测试)
        - [ ] 4K (没大会员没法试)
    - [ ] 弹幕
        - [x] 显示普通弹幕
        - [x] 显示高级弹幕 (可能有部分无法显示)
        - [ ] 发送 (可能永远无法实现)
        - [x] 配置 (部分)
        - [ ] 历史弹幕
    - [x] 稍后再看
    - [ ] 三连相关
    - [x] TAG
    - [x] 历史进度
- [x] 评论
    - [x] 查看
    - [x] 评论
    - [x] 发布
    - [x] 楼层
    - [x] 举报
- [ ] 直播 (可使用 WebView)
    - [x] 能播出来
    - [x] 控制清晰度
    - [ ] 弹幕
        - [ ] 查看
        - [x] 发送
    - [ ] 状态
- [ ] 私信
- [ ] 视频下载
- [x] 视频封面下载, 用户头像下载
- [ ] 移动网络警告
- [ ] 历史记录
    - [x] 添加
    - [ ] 分类
- [ ] 广告
    - [ ] 普通广告
        - [ ] 显示 (部分)
        - [ ] 屏蔽
    - [x] 开屏广告
        - [x] 显示
        - [x] 屏蔽
- [x] 搜索 (简单实现)
- [ ] 键盘鼠标友好
- [x] 关注列表
- [ ] 全站广播

### 将***不***支持的功能
- 注册
- 直播弹幕发送
- ~~开屏广告~~
- 会员购相关
- 修改用户信息
- 游戏相关
- 互动视频
- 兼容电视和 Wear OS
- 高级弹幕发送
- 付费视频

明显还有为提及的，未提及的基本不会支持

### 已知 BUG
- 任何快速操作都有肯能导致崩溃
- 在极大屏幕设备上容易崩溃
- 试图播放某些视频时崩溃, 因为服务器返回与期望不同 (也可能不是, 它就是要崩)
- 至少在 2020年4月4日 首页无法加载封面 (返回`404`)
- 打开空的收藏夹可能崩溃
- 在 x86 设备上更容易崩溃
- 有时后台播放通知不会自动清除
- 即使使`minSdkVersion 25`也无法在[Anbox](https://anbox.io)下运行
- 评论快速滚动会闪烁
- 在`Chrome OS`上由于解码器问题(大)部分视频无法播放, 建议使用官方客户端
- 弹幕播放进度偏移, 具体视设备性能和播放时常而定
- 查看大图有时候按返回不返回
- [更多](https://github.com/duzhaokun123/BilibiliHD/issues?q=is%3Aissue+is%3Aopen+label%3Abug)
- 更多 BUG 等你发现

### TODO
- 重作界面
- 下载

### 从源代码构建注意
```shell script
git clone https://github.com/duzhaokun123/BilibiliHD.git
cd BilibiliHD
chmod +x script/sync_third_party.sh
script/sync_third_party.sh
```

### 鸣谢
[AOSP](https://source.android.com)

[BilibiliAPIDocs](https://github.com/fython/BilibiliAPIDocs)

[CircleImageView](https://github.com/hdodenhof/CircleImageView)

[DanmakuView](https://github.com/duzhoakun123/DanmakuView)

[ExoPlayer](https://exoplayer.dev/)

[Material](https://material.io)

[PhotoView](https://github.com/Baseflow/PhotoView)

[SmartRefreshLayout](https://github.com/scwang90/SmartRefreshLayout)

[StfalconImageViewer](https://github.com/stfalcon-studio/StfalconImageViewer)

[bilibili-API-collect](https://github.com/SocialSisterYi/bilibili-API-collect)

[bilibili-api](https://github.com/czp3009/bilibili-api)

[flexbox-layout](https://github.com/google/flexbox-layout)

[gRPC](https://grpc.io)

[glide](https://bumptech.github.io/glide/)

[gson](https://github.com/google/gson)

[html-textview](https://github.com/SufficientlySecure/html-textview)

[okttp](https://square.github.io/okhttp/)

[preferencex-android](https://github.com/takisoft/preferencex-android)
